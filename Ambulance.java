package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance()
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
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            tabel.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(20,10,50,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(200,10,150,25);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 = new JLabel("Car Name");
        label3.setBounds(400,10,150,25);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setBounds(610,10,150,25);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(810,10,150,25);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);



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
    public static void main(String[] args) {
        new Ambulance();

    }
}
