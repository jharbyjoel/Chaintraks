import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.jar.JarEntry;

public class AssignSku implements KeyListener, ActionListener {

    HashMap<String, Integer> productsSku = new HashMap<String, Integer>();
    JFrame frame = new JFrame();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    JLabel appInfoLabel = new JLabel((dtf.format(now)));
    JButton returnButton = new JButton("Return");
    JButton saveButton = new JButton("Save");
    JLabel enterProductLabel = new JLabel("Product: ");
    JLabel enterSkuNumLabel = new JLabel("SKU: ");
    JTextField productField = new JTextField();
    JTextField skuField = new JTextField();
    JLabel menuLabel = new JLabel("MENU");
    JLabel printLabel = new JLabel("PRINT");
    JLabel helpLabel = new JLabel("HELP");
    JLabel aboutLabel = new JLabel("ABOUT");
    JLabel selectLabel = new JLabel("SELECT");
    JLabel aLabel = new JLabel("MENU=A");
    JLabel bLabel = new JLabel("PRINT=B");
    JLabel cLabel = new JLabel("HELP=C");
    JLabel dLabel = new JLabel("ABOUT=D");
    JLabel eLabel = new JLabel("SELECT=E");
    JLabel messageLabel = new JLabel();
    AssignSku() {

    }

    public HashMap<String, Integer> getProductsSku() {
        return productsSku;
    }

    public void setProductsSku(HashMap<String, Integer> productsSku) {
        this.productsSku = productsSku;
    }

    AssignSku(HashMap<String, Integer> productsSkuOrg) {

        productsSku = productsSkuOrg;

        saveButton.setBounds(275, 45, 100, 25);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        frame.add(saveButton);

        returnButton.setBounds(275, 95, 100, 25);
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        frame.add(returnButton);

        enterProductLabel.setBounds(0, 50, 300, 11);
        enterProductLabel.setForeground(Color.white);
        productField.setBounds(50, 45, 200, 25);
        frame.add(productField);

        enterSkuNumLabel.setBounds(0, 100, 300, 11);
        enterSkuNumLabel.setForeground(Color.white);
        skuField.setBounds(50, 95, 200, 25);
        frame.add(skuField);

        frame.add(enterProductLabel);
        frame.add(enterSkuNumLabel);

        aLabel.setBounds(0, 175, 400, 11);
        frame.add(aLabel);
        aLabel.setForeground(Color.white);

        bLabel.setBounds(50, 175, 400, 11);
        frame.add(bLabel);
        bLabel.setForeground(Color.white);

        cLabel.setBounds(0, 200, 400, 11);
        frame.add(cLabel);
        cLabel.setForeground(Color.white);

        dLabel.setBounds(50, 200, 400, 11);
        frame.add(dLabel);
        dLabel.setForeground(Color.white);

        eLabel.setBounds(0, 225, 400, 11);
        frame.add(eLabel);
        eLabel.setForeground(Color.white);

        menuLabel.setBounds(0, 0, 400, 11);
        frame.add(menuLabel);
        menuLabel.setForeground(Color.white);

        printLabel.setBounds(50, 0, 400, 11);
        frame.add(printLabel);
        printLabel.setForeground(Color.white);

        helpLabel.setBounds(100, 0, 400, 11);
        frame.add(helpLabel);
        helpLabel.setForeground(Color.white);

        aboutLabel.setBounds(150, 0, 400, 11);
        frame.add(aboutLabel);
        aboutLabel.setForeground(Color.white);

        selectLabel.setBounds(200, 0, 400, 11);
        frame.add(selectLabel);
        selectLabel.setForeground(Color.white);

        frame.add(messageLabel);
        messageLabel.setBounds(100, 125, 250, 11);
        messageLabel.setForeground(Color.white);

        appInfoLabel.setBounds(0, 350, 400, 20);
        appInfoLabel.setFont(new Font(null, Font.BOLD, 12));
        frame.add(appInfoLabel);
        appInfoLabel.setForeground(Color.white);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.addKeyListener(this);

    }
        @Override
        public void keyTyped (KeyEvent e){

        }

        @Override
        public void keyPressed (KeyEvent e){

        }

        @Override
        public void keyReleased (KeyEvent e){

        }

        @Override
        public void actionPerformed (ActionEvent e){
            try {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaintrak", "root",
                            "6138385");
                    Statement statement = connection.createStatement();
                    if (e.getSource() == saveButton) {
                        if (productField.getText().equals("") && productField.getText().equals("")) {
                            throw new Exception("Invalid input");
                        } else if (e.getSource() == saveButton) {
                            String SQL = "INSERT INTO plants(sku,name)" + "VALUES(?,?)";
                            String productName = productField.getText();
                            int sku = Integer.parseInt(skuField.getText());
                            try (PreparedStatement pstmt = connection.prepareStatement(SQL,
                                    Statement.RETURN_GENERATED_KEYS)){
                                pstmt.setString(1, String.valueOf(sku));
                                pstmt.setString(2,productName);
                                pstmt.executeUpdate();
                            }try {
                                Statement stmt = connection.createStatement();
                                String query = "SELECT * FROM plants";
                                ResultSet rs = stmt.executeQuery(query);
                                while (rs.next()) {
                                    String stringSku = rs.getObject(1).toString();
                                    String stringName = rs.getObject(2).toString();
                                    System.out.println("Plant name: " + stringName + " SKU number: " + stringSku);
                                }
                                System.out.println("Product has been added to the database...");
                                messageLabel.setText("Product removed");
                                productsSku.put(productName, sku);
                                messageLabel.setText("Product added");
                            }catch (Exception et){
                                et.printStackTrace();
                            }
                        }
                    }
                } catch (Exception ex) {
                    messageLabel.setText("Invalid input");
                }
                if (e.getSource() == returnButton) {
                    WelcomePage welcomePage = new WelcomePage();
                }
            }catch (Exception ea){
                ea.printStackTrace();
            }
    }
}
