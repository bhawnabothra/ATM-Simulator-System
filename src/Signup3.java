import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;  

public class Signup3 extends JFrame implements ActionListener
{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    public Signup3(String formno)
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 3");
        setLayout(null);

        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Arial", Font.BOLD, 22));
        l1.setBounds(250, 60, 400, 30);
        add(l1);

        //account type
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Arial", Font.BOLD, 20));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Arial", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 200, 20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Arial", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 180, 20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Arial", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        //Card Number
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Arial", Font.BOLD, 20));
        card.setBounds(100, 280, 200, 30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Arial", Font.BOLD, 20));
        number.setBounds(330, 280, 300, 30);
        add(number);

        JLabel carddetail=new JLabel("Your 16 digit Card Number");
        carddetail.setFont(new Font("Arial", Font.BOLD, 12));
        carddetail.setBounds(100, 310, 300, 20);
        add(carddetail);

        //Pin number
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        pin.setBounds(100, 350, 200, 30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Arial", Font.BOLD, 20));
        pnumber.setBounds(330, 350, 300, 30);
        add(pnumber);

        JLabel pindetail=new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Arial", Font.BOLD, 12));
        pindetail.setBounds(100, 380, 300, 20);
        add(pindetail);

        //Services
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Arial", Font.BOLD, 20));
        services.setBounds(100, 440, 200, 30);
        add(services);

        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Arial", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100, 480, 250, 20);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Arial", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350, 480, 250, 20);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Arial", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100, 520, 250, 20);
        add(c3);

        c4=new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Arial", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350, 520, 250, 20);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Arial", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100, 560, 250, 20);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Arial", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350, 560, 250, 20);
        add(c6);

        //Declaration
        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Arial", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 620, 600, 20);
        add(c7);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(400, 650, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(500, 650, 80, 20);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        setSize(750, 800);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        
        String accountType=null;
        if(r1.isSelected())
        {
            accountType="Saving Account";
        }
        else if(r2.isSelected())
        {
            accountType="Fixed Deposit Account";
        }
        else if(r3.isSelected())
        {
            accountType="Current Account";
        }
        else if(r4.isSelected())
        {
            accountType="Recurring Deposit Account";
        }
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;      //Generating 16 digit random Card number
        String cardnumber = "" + Math.abs(first7);
    
        long first3 = (ran.nextLong() % 9000L) + 1000L;                   
        String pinnumber = "" + Math.abs(first3);                            //Generation 4 digit pin number

        String facilities="";               //facilities can be more than one
        if(c1.isSelected())
        {
            facilities=facilities+" ATM Card ";
        }
        if(c2.isSelected())
        {
            facilities=facilities+" Internet Banking ";
        }
        if(c3.isSelected())
        {
            facilities=facilities+" Mobile Banking ";
        }
        if(c4.isSelected())
        {
            facilities=facilities+" Email and SMS Alerts ";
        }
        if(c5.isSelected())
        {
            facilities=facilities+" Cheque Book ";
        }
        if(c6.isSelected())
        {
            facilities=facilities+" E-statement";
        }
        
        try
        {
            if(ae.getSource()==submit)
            {    
                if(!c7.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Declaration is required");
                }
                else
                {
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facilities+"')";  
                    String q2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card number: "+cardnumber+"\n Pin: "+pinnumber); //showing cardnumber and pinnumber
                    
                    setVisible(false);
                    new login().setVisible(true);
                }
            }
            else if(ae.getSource()==cancel){
                setVisible(false);
                new login().setVisible(true);
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Signup3("");
    }
}
