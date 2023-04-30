import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;;

public class Deposit extends JFrame implements ActionListener
{
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setTitle("DEPOSIT");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel text =new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(140, 250, 400, 20);
        image.add(text);

        //Amount
        amount=new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD, 22));
        amount.setBounds(150, 290, 250, 30);
        image.add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(285, 410 , 140, 20);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(285, 435 , 140, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(750, 750);
        setLocation(300, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
        
            String number=amount.getText();
            Date date=new Date();
            if(ae.getSource()==deposit)
            {
                if(number.equals(""))        //if amount is not entered
                {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                }
                else
                {
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    conn.s.execute(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } 
                    
            }
        
            else if(ae.getSource()==back)
            {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[])
    {
        new Deposit("");
    }
}
