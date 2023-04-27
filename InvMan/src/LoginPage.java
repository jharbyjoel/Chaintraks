import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JLabel appName = new JLabel("SupplyChain v1.1");
    JLabel instructionsLabel= new JLabel("Enter username and password and click login to continue. Press ESC " +
            "to quit. ");

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    LoginPage() {

    }

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal; // this is a copy of the login info so other methods can use

        appName.setBounds(160, 50, 100, 25);
        appName.setForeground(Color.white);
        userIDLabel.setBounds(50, 100, 75, 25); // sets the message label in the frame for user id
        userPasswordLabel.setBounds(50, 150, 75, 25);
        userIDLabel.setForeground(Color.WHITE);
        userPasswordLabel.setForeground(Color.WHITE);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.BOLD, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        instructionsLabel.setBounds(50,300,500,25);
        instructionsLabel.setForeground(Color.white);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false); // takes away little box that surrounds text
        resetButton.addActionListener(this);

        frame.add(appName);
        frame.add(userIDLabel); // adds userid label to the frame
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(instructionsLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // creates the frame
        frame.setSize(550, 380);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLUE); // change background color


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {
            String userId = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword()); // using jfield instead of text field

            if (loginInfo.containsKey(userId)) {
                if (loginInfo.get(userId).equals(password)) {
                    messageLabel.setForeground(Color.white);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
        }
    }
}