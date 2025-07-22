package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame
{

    Employee_info()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable tabel = new JTable();
        tabel.setBounds(10,34,980,450);
        tabel.setBackground(new Color(109,164,170));
        tabel.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(tabel);

        try
        {
            Conn c = new Conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            tabel.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(15,6,60,25);
        label1.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(180,6,60,25);
        label2.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(335,6,150,25);
        label3.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(500,6,100,25);
        label4.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail ID");
        label5.setBounds(690,6,150,25);
        label5.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar Number");
        label6.setBounds(825,6,200,25);
        label6.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(label6);

        JButton b1 = new JButton("BACK");
        b1.setBounds(800,480,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(1000,600);
       setLayout(null);
       setLocation(300,200);
       setVisible(true);
    }
    public static void main(String[] args)
    {
        new Employee_info();
    }
}
