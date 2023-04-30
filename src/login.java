//create a frame using swing .there is a jframe class inside swing package
//swing package is inside extended java so javax
//setsize set the length and breadth of the frame.
//package bankingapp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
//import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class login extends JFrame implements ActionListener
{
    JButton login,clear,signup;    //globally declared so that it can be used by another function i.e actionPerformed
    JTextField cardTextField;
    JPasswordField pinTextField;  //to hide the content of pin using JPassword field

    //actionlistener is an interface used to give actions to the buttons
    public login()         //constructor
    {
        setTitle("AUTOMATED TELLER MACHINE");   //to set the title of the frame
        setLayout(null);   //to make the default layout null and use the custom layout
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    //scale the i1 image
        ImageIcon i3=new ImageIcon(i2);        //in jlabel we can pass only imageicon so converted the image into imageicon
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);   //to change the position of the icon 
        add(label);                                   //to add the image above the frame
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno=new JLabel("Card No.");
        cardno.setFont(new Font("Arial", Font.BOLD, 22));
        cardno.setBounds(120, 150, 100, 40);
        add(cardno);

        //for cardno textfield
        cardTextField = new JTextField();
        cardTextField.setBounds(240, 150, 300, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Arial", Font.BOLD, 22));
        pin.setBounds(120, 220, 100, 40);
        add(pin);

        //for password field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(240, 220, 300, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        //to add buttons
        login=new JButton("SIGN IN");
        login.setBounds(260, 300, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);       //this line is written so that when login button is clicked some action is performed 
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(400, 300, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);      //this line is written so that when clear button is clicked some action is performed 
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(260, 350, 260, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);       //this line is written so that when signup button is clicked some action is performed 
        add(signup);

        getContentPane().setBackground(Color.WHITE);    //to set the background color of the frame
        
        setSize(800,480);
        setVisible(true);                           // to make the frame visible
        setLocation(350,200);                     //to open the frame not from origin
        
    }

    //action is defined in this function (which is present in the interface ActionListener) for each button 
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)  //if the clear button is clicked the text field is cleared
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login)   //if the login button is clicked
        {
            Conn conn=new Conn();    //making connection with mysql database
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardno= '"+cardnumber+"' and pin = '"+pinnumber+"'"; //checking the data enetered is correct or not from the database
            try{
                ResultSet rs=conn.s.executeQuery(query);            //storing the result after executing the query
                if(rs.next())                                      //if there is any value execute further lines
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup)   //if the signup button is clicked
        {
            setVisible(false);           //making this frame invisible
            new Signup1().setVisible(true);      //and signup form visible
        }
    }

    public static void main(String args[])
    {
        new login();         //creating an anonymous object to create a frame which calls the constructor
    } 
}
