import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
public class InventoryPage extends WelcomePage implements KeyListener {
    Products product = new Products();
    JFrame frame = new JFrame();
    JLabel assignSku = new JLabel("1. ASSIGN SKU");
    JLabel removeSku = new JLabel("2. REMOVE SKU");
    JLabel disposeItemLabel = new JLabel("3. DISPOSE ITEM");
    JLabel changePrice = new JLabel("4. CHANGE ITEM");
    JLabel exitProgramLabel = new JLabel("0. RETURN");
    JLabel appInfoLabel = new JLabel((dtf.format(now)));
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



    InventoryPage(){
        menuLabel.setBounds(0,0,400,11);
        frame.add(menuLabel);
        menuLabel.setForeground(Color.white);

        printLabel.setBounds(50,0,400,11);
        frame.add(printLabel);
        printLabel.setForeground(Color.white);

        helpLabel.setBounds(100,0,400,11);
        frame.add(helpLabel);
        helpLabel.setForeground(Color.white);

        aboutLabel.setBounds(150,0,400,11);
        frame.add(aboutLabel);
        aboutLabel.setForeground(Color.white);

        selectLabel.setBounds(200,0,400,11);
        frame.add(selectLabel);
        selectLabel.setForeground(Color.white);

        assignSku.setBounds(0,50,400,11);
        frame.add(assignSku);
        assignSku.setForeground(Color.white);

        removeSku.setBounds(0,75,400,11);
        frame.add(removeSku);
        removeSku.setForeground(Color.white);

        disposeItemLabel.setBounds(0,100,400,11);
        frame.add(disposeItemLabel);
        disposeItemLabel.setForeground(Color.white);

        changePrice.setBounds(0,125,400,11);
        frame.add(changePrice);
        changePrice.setForeground(Color.white);

        exitProgramLabel.setBounds(0,150,400,11);
        frame.add(exitProgramLabel);
        exitProgramLabel.setForeground(Color.white);

        appInfoLabel.setBounds(0,350,400,11);
        frame.add(appInfoLabel);
        appInfoLabel.setForeground(Color.white);

        aLabel.setBounds(0,175,400,11);
        frame.add(aLabel);
        aLabel.setForeground(Color.white);

        bLabel.setBounds(50,175,400,11);
        frame.add(bLabel);
        bLabel.setForeground(Color.white);

        cLabel.setBounds(0,200,400,11);
        frame.add(cLabel);
        cLabel.setForeground(Color.white);

        dLabel.setBounds(50,200,400,11);
        frame.add(dLabel);
        dLabel.setForeground(Color.white);

        eLabel.setBounds(0,225,400,11);
        frame.add(eLabel);
        eLabel.setForeground(Color.white);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.addKeyListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
            case '0': WelcomePage welcomePage = new WelcomePage();
            frame.dispose();
            break;
            case '1': AssignSku assignSku = new AssignSku(product.getProducts());
            frame.dispose();
            break;
            case '2': RemoveSku removeSku = new RemoveSku(product.getProducts());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
