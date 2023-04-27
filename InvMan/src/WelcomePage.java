import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WelcomePage implements KeyListener{
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    JFrame frame = new JFrame();
    JLabel inventoryLabel = new JLabel("1. INVENTORY MAINTENANCE");
    JLabel inVoiceLabel = new JLabel("2. INVOICE MAINTENANCE");
    JLabel countBatchLabel = new JLabel("3. COUNT BATCHES");
    JLabel exitProgramLabel = new JLabel("4. EXIT");
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






    WelcomePage(){
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

        inventoryLabel.setBounds(0,50,400,11);
        frame.add(inventoryLabel);
        inventoryLabel.setForeground(Color.white);

        inVoiceLabel.setBounds(0,75,400,11);
        frame.add(inVoiceLabel);
        inVoiceLabel.setForeground(Color.white);

        countBatchLabel.setBounds(0,100,400,11);
        frame.add(countBatchLabel);
        countBatchLabel.setForeground(Color.white);

        exitProgramLabel.setBounds(0,125,400,11);
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
    }


    @Override
    public void keyTyped(KeyEvent e) {;// invoked when key is typed
        switch(e.getKeyChar()){
            case '1': InventoryPage invPage = new InventoryPage();
                frame.dispose();
                    break;
            case '2': InvoicePage invoicePage = new InvoicePage();
                frame.dispose();
                    break;
            case '3': CountBatches countPage = new CountBatches();
                frame.dispose();
                    break;
            case '4':
                frame.dispose();
                System.exit(0);
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) { // invoked when physical key is pressed down
        switch (e.getKeyChar()){
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { // called whenever a button is released
    }
}
