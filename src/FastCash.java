import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,exit;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setTitle("FAST CASH");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(0, 0, 750 , 750);
        add(i4);

        JLabel text=new JLabel("Select withdrawal amount");
        text.setBounds(180, 250, 700, 30);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setForeground(Color.white);
        i4.add(text);
    
        hundred =new JButton("Rs 100");
        hundred.setBounds(135,350, 140, 20);
        hundred.setBackground(Color.white);
        hundred.setForeground(Color.black);
        hundred.addActionListener(this);
        i4.add(hundred);

        fivehundred =new JButton("Rs 500");
        fivehundred.setBounds(285,350, 140, 20);
        fivehundred.setBackground(Color.white);
        fivehundred.setForeground(Color.black);
        fivehundred.addActionListener(this);
        i4.add(fivehundred);

        thousand =new JButton("Rs 1000");
        thousand.setBounds(135,380, 140, 20);
        thousand.setBackground(Color.white);
        thousand.setForeground(Color.black);
        thousand.addActionListener(this);
        i4.add(thousand);

        twothousand =new JButton("Rs 2000");
        twothousand.setBounds(285,380, 140, 20);
        twothousand.setBackground(Color.white);
        twothousand.setForeground(Color.black);
        twothousand.addActionListener(this);
        i4.add(twothousand);

        fivethousand =new JButton("Rs 5000");
        fivethousand.setBounds(135,410, 140, 20);
        fivethousand.setBackground(Color.white);
        fivethousand.setForeground(Color.black);
        fivethousand.addActionListener(this);
        i4.add(fivethousand);

        tenthousand =new JButton("Rs 10000");
        tenthousand.setBounds(285,410, 140, 20);
        tenthousand.setBackground(Color.white);
        tenthousand.setForeground(Color.black);
        tenthousand.addActionListener(this);
        i4.add(tenthousand);

        exit =new JButton("Back");
        exit.setBounds(200,440, 140, 20);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        i4.add(exit);

        setSize(750, 750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else 
        {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            try
            {
                Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                //calculating the balance
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                //checking whether there is a sufficient balance to withdraw the selected amount
                if(ae.getSource() != exit && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                //updating the bank table 
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
    }

    public static void main(String args[]) 
    {
        new FastCash("");
    }
}
