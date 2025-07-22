package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame
{
    update_patient_details()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon0 = new ImageIcon(ClassLoader.getSystemResource("icon/up.gif"));
        Image image1 = imageIcon0.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2= new ImageIcon(image1);
        JLabel label0 = new JLabel(imageIcon2);
        label0.setBounds(500,10,300,300);
        panel.add(label0);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,150,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(100,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(25,88,100,25);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try
        {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery(" select * from patient1_info");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(25,129,150,25);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);


        JLabel label4 = new JLabel("In-Time");
        label4.setBounds(25,174,150,25);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldINTIme = new JTextField();
        textFieldINTIme.setBounds(248,174,140,20);
        panel.add(textFieldINTIme);

        JLabel label5 = new JLabel("Amount Paid (Rs)");
        label5.setBounds(25,216,150,25);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);


        JLabel label6 = new JLabel("Pending Amount (Rs)");
        label6.setBounds(25,261,170,25);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient1_info where Name = '"+id+"'";
                try
                {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next())
                    {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTIme.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));

                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next())
                    {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                } catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton upadte = new JButton("UPDATE");
        upadte.setBackground(Color.black);
        upadte.setForeground(Color.white);
        upadte.setBounds(56,378,89,23);
        panel.add(upadte);
        upadte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Conn c = new Conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTIme.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update Patient1_info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updates Successfully");
                    setVisible(false);
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(168,378,89,23);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }





    public static void main(String[] args) {
        new update_patient_details();

    }
}
