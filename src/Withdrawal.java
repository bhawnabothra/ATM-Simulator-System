import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener
{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;

    Withdrawal(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setTitle("WITHDRAWAL");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel text =new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(135, 250, 400, 20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD, 22));
        amount.setBounds(150, 290, 250, 30);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(285, 410 , 140, 20);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if(ae.getSource()==withdraw)
        {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawal");
            }
            else{
                
                try {
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+number+"')";
                    conn.s.execute(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawal Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[])
    {
        new Withdrawal("");
    }
}
