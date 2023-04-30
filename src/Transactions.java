import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener
{
    JButton deposit,withdrawal,fastcash,balanceenquiry,ministatement,pinchange,exit;
    String pinnumber;

    Transactions(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setTitle("Automatic Teller Machine");
        setLayout(null);

        //putting the ATM image on the frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(0, 0, 750 , 750);
        add(i4);

        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(165, 250, 700, 30);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setForeground(Color.white);
        i4.add(text);
    
        //Deposit button
        deposit =new JButton("Deposit");
        deposit.setBounds(135,350, 140, 20);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        i4.add(deposit);

        //Withdrawal button
        withdrawal =new JButton("Cash Withdrawal");
        withdrawal.setBounds(285,350, 140, 20);
        withdrawal.setBackground(Color.white);
        withdrawal.setForeground(Color.black);
        withdrawal.addActionListener(this);
        i4.add(withdrawal);

        //Fast Cash button
        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(135,380, 140, 20);
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        i4.add(fastcash);

        //Mini statement button
        ministatement =new JButton("Mini Statement");
        ministatement.setBounds(285,380, 140, 20);
        ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.black);
        ministatement.addActionListener(this);
        i4.add(ministatement);

        //Pin change button
        pinchange =new JButton("Pin Change");
        pinchange.setBounds(135,410, 140, 20);
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        i4.add(pinchange);

        //Balance Enquiry button
        balanceenquiry =new JButton("Balance Enquiry");
        balanceenquiry.setBounds(285,410, 140, 20);
        balanceenquiry.setBackground(Color.white);
        balanceenquiry.setForeground(Color.black);
        balanceenquiry.addActionListener(this);
        i4.add(balanceenquiry);

        //Exit button
        exit =new JButton("Exit");
        exit.setBounds(200,440, 140, 20);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        i4.add(exit);

        setSize(750, 750);
        setLocation(300,0);
        setUndecorated(true);       //to remove white line from the top
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }

        //Opening the class of the button that is clicked 
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawal)
        {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) 
    {
        new Transactions("");
    }
}
