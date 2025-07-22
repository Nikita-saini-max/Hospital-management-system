package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame
{
    Choice choice;
    JTable table;
    SearchRoom()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setFont(new Font("Tahoma", Font.BOLD, 18));
        For.setForeground(Color.white);
        panel.add(For);

        JLabel status = new JLabel("Status : ");
        status.setBounds(50,73,120,20);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        status.setForeground(Color.white);
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,73,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);

        try
        {
            Conn c = new Conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(15,162,150,20);
        Roomno.setForeground(Color.white);
        Roomno.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(Roomno);

        JLabel Status = new JLabel("Availability");
        Status.setBounds(175,162,150,20);
        Status.setForeground(Color.white);
        Status.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(Status);

        JLabel price = new JLabel("Price");
        price.setBounds(350,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(520,162,150,20);
        bed.setForeground(Color.white);
        bed.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,25);
        Search.setBackground(Color.black);
        Search.setForeground(Color.white);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try
                {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,25);
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
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
