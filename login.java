
package officeinvantoryapps;



import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login  {

    Font fc;

    public static void main(String[] args) {

        Font fc;
        JFrame j = new JFrame("Login");

        fc = new Font("Arial", Font.CENTER_BASELINE, 14);
        JLabel un = new JLabel(" User Name");
        JLabel ps = new JLabel("Password");

        JTextField texf1 = new JTextField();
        JPasswordField texf2 = new JPasswordField();

        JButton login = new JButton("Loging");
        JButton clear = new JButton("Clear");

        un.setBounds(10, 30, 150, 30);
        ps.setBounds(10, 70, 150, 30);

        texf1.setBounds(150, 30, 220, 30);
        texf2.setBounds(150, 70, 220, 30);

        login.setBounds(100, 130, 80, 30);
        clear.setBounds(300, 130, 80, 30);

        un.setFont(fc);
        ps.setFont(fc);

        j.add(un);
        j.add(ps);

        j.add(texf1);
        j.add(texf2);

        j.add(login);
        j.add(clear);

        j.setBounds(400, 200, 400, 200);
    
        j.setLayout(null);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        login.addActionListener((ActionEvent ae) -> {
            String un1 = texf1.getText();
            String ps1 = texf2.getText();
            if (un1.equalsIgnoreCase("hasan") && (ps1.equalsIgnoreCase("1234"))) {
               
                JOptionPane.showMessageDialog(null, "Succesfully login");
                
                
                Mynewframe g = new Mynewframe();
              
                g.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Try again");
            }
        });

        clear.addActionListener((ActionEvent ae) -> {
            texf1.setText("");
            texf2.setText("");
        });

    }
}
