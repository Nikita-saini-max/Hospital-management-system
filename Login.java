package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener
{
    JTextField textField;
    JPasswordField jpasswordField;
    JButton b1,b2;




    Login()
    {
//       add name in login page
        JLabel namelable = new JLabel("UserName");
        namelable.setBounds(40,20,100,30);
        namelable.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelable.setForeground(Color.BLACK);
        add(namelable);

        JLabel password = new JLabel("PassWord");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);


//add text filed for enter text
        textField = new JTextField();
        textField.setBounds(150,20,150,25);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBackground(new Color(178, 218, 229));
        add(textField);

        jpasswordField = new JPasswordField();
        jpasswordField.setBounds(150,70,150,25);
        jpasswordField.setFont(new Font("Tahoma", Font.BOLD, 15));
        jpasswordField.setBackground(new Color(178, 218, 229));
        add(jpasswordField );


//        add logo
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/hospital.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-17,400,300);
        add(label);


//        add login and cancel button
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif", Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(170,140,120,30);
        b2.setFont(new Font("serif", Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);





        getContentPane().setBackground(new Color(109,164,170));
        setSize(750, 300);
        setLocation(400,260);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[]args)
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Conn c = new Conn();
                String user = textField.getText();
                String pass = jpasswordField.getText();

                String q = "select * from login where ID = '"+user+"' and PW = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next())
                {
                    new Reception();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }



            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else
        {
            System.exit(10);

        }


    }
}
