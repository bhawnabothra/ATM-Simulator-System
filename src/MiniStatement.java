import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame
{
    String pinnumber;
    MiniStatement(String pinnumber)
    {
        setLayout(null);

        setTitle("MINI STATEMENT");
        this.pinnumber=pinnumber;

        JLabel bank=new JLabel("Indian bank");
        bank.setBounds(160, 20, 100, 20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(100, 60, 300, 20);
        add(card);
        try 
        {
            Conn conn=new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+rs.getString("cardno").substring(0, 4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
            }
        } 
        catch (Exception e) 
        {
            System.out.print(e);
        }

        JLabel text=new JLabel();
        text.setBounds(20, 100, 400, 200);
        add(text);

        JLabel balance=new JLabel();
        balance.setBounds(20, 320, 300, 20);
        add(balance);

        try 
        {
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                text.setText(text.getText()+"<html>"+rs.getString("date")+ "&emsp;|&emsp;"+rs.getString("type")+"&emsp;|&emsp;"+rs.getString("amount")+"<br><br>");
                if(rs.getString("type").equals("Deposit"))
                {
                    bal +=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("Your current account balance is Rs "+bal);
            }
        } 
        catch (Exception e) 
        {
            System.out.print(e);
        }

        setSize(400 ,   400);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public static void main(String args[]) 
    {
        new MiniStatement("");   
    }
}
