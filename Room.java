package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room  extends JFrame
{

    JTable tabel;

    Room()
    {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.gif"));
        Image image = imageIcon.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        tabel = new JTable();
        tabel.setBounds(10,40,500,300);
        tabel.setBackground(new Color(90,156,163));
        panel.add(tabel);

        try
        {
            Conn c = new Conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            tabel.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(120,15,80,15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(250,15,80,15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(380,15,80,15);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(200,400,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,500);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);

    }

    public static void main(String[] args)
    {
        new Room();
    }
}
