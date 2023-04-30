import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener
{
    String pinnumber;
    JPasswordField pin,repin;
    JButton change,back;

    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setTitle("PIN CHANGE");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);

        JLabel text =new JLabel("Change your PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setBounds(210, 250, 400, 20);
        image.add(text);

        JLabel pintext =new JLabel("New PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("Arial", Font.BOLD, 16));
        pintext.setBounds(160, 290, 100, 20);
        image.add(pintext);

        pin=new JPasswordField();
        pin.setForeground(Color.black);
        pin.setFont(new Font("Arial", Font.BOLD, 16));
        pin.setBounds(280, 290, 100, 20);
        image.add(pin);

        JLabel repintext =new JLabel("Re-enter PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("Arial", Font.BOLD, 16));
        repintext.setBounds(160, 330, 120, 20);
        image.add(repintext);

        repin=new JPasswordField();
        repin.setForeground(Color.black);
        repin.setFont(new Font("Arial", Font.BOLD, 16));
        repin.setBounds(280, 330, 100, 20);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(280, 410 , 100, 20);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(280, 435 , 100, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(750, 750);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==change)
        {
            try{
                String npin=pin.getText();
                String rpin=repin.getText();
                if(npin.equals(""))         //if new pin pin is not entered
                {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if(rpin.equals(""))         //if re-new pin is not entered
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                if(!npin.equals(rpin))              //if new pin is not equal to re new pin
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                Conn conn=new Conn();
                //updating the tables where pin column is present
                String query1="update bank set pin='"+npin+"' where pin='"+pinnumber+"'";
                String query2="update login set pin='"+npin+"' where pin='"+pinnumber+"'";
                String query3="update signup3 set pin='"+npin+"' where pin='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }   
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
        else 
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new PinChange("");
        
    }
}
