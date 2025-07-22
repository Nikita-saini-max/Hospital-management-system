package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class patient_discharge extends JFrame
{
    patient_discharge()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,120,20);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30,80,120,20);
        label2.setFont(new Font("Tahoma", Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try
        {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient1_info");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,120,20);
        label3.setFont(new Font("Tahoma", Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma", Font.BOLD,14));
        RNo.setForeground(Color.white);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,250,20);
        label4.setFont(new Font("Tahoma", Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma", Font.BOLD,14));
        INTime.setForeground(Color.white);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,220,120,20);
        label5.setFont(new Font("Tahoma", Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();

        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(200,220,250,20);
        OutTime.setFont(new Font("Tahoma", Font.BOLD,14));
        OutTime.setForeground(Color.white);
        panel.add(OutTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try
                {
                    c.statement.executeUpdate("delete from patient1_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null ,"Done");
                    setVisible(false);


                }catch (Exception E)
                {
                    E.printStackTrace();
                }


            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170,300,120,30);
        Check.setBackground(Color.black);
        Check.setForeground(Color.white);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try
                {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient1_info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(300,300,120,30);
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
        setSize(800,400);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args)
    {
        new patient_discharge();
    }
}
