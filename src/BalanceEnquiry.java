import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setTitle("BALANCE ENQUIRY");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        back =new JButton("BACK");
        back.setForeground(Color.black);
        back.setBounds(280, 410, 100, 20);
        back.addActionListener(this);
        image.add(back);

        int balance=0;
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
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
        }
        catch(Exception e)
        {
            System.out.print(e);
        }

        //printing the balance
        JLabel text =new JLabel("Your Current account Balance is Rs "+ balance);
        text.setForeground(Color.white);
        text.setBounds(150, 250, 400, 20);
        image.add(text);

        setSize(750, 750);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]) 
    {
        new BalanceEnquiry("");
        
    }
}
