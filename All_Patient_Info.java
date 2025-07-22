package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame
{
    All_Patient_Info()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable tabel = new JTable();
        tabel.setBounds(10,60,1000,450);
        tabel.setBackground(new Color(90,156,163));
        tabel.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(tabel);

        try
        {
            Conn c = new Conn();
            String q = "select * from patient1_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            tabel.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Aadhar Number");
        label1.setBounds(10,10,200,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(160,10,150,25);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(300,10,150,25);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(440,10,150,25);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);

        JLabel label6 = new JLabel("Room No");
        label6.setBounds(590,10,150,25);
        label6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(725,10,150,25);
        label7.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(870,10,150,25);
        label8.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label8);

        JButton button = new JButton("BACK");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBounds(800,510,120,30);
        panel.add(button);
        button.addActionListener(new ActionListener() {
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
       new  All_Patient_Info();
    }
}
