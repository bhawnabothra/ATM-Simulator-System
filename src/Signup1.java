//creating a signup frame 

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;       //used for the functions like set font,etc..
import java.util.Random;       //to generate random number for application number
import com.toedter.calendar.JDateChooser;          //to get calendar to choose the date for dob
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener
{
    //declaring variables globally so that variable can be used in actionPerformed function
    JTextField nametextfield,fnametextfield,dobtextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JDateChooser datechooser;
    JRadioButton male,female,single,married,other;
    JButton next;

    Random ran =new Random();
    long random = (Math.abs(ran.nextLong()%9000L)+1000L);        // for generating 4 digit random application number
    public Signup1()
    {
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 1");
        setLayout(null);
        
        //Application form number
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Arial", Font.BOLD, 30));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Arial", Font.BOLD, 22));
        personaldetails.setBounds(250, 80, 400, 30);
        add(personaldetails);

        //Name
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nametextfield =new JTextField();
        nametextfield.setFont(new Font("Arial", Font.BOLD, 14));
        nametextfield.setBounds(320, 140, 300, 30);
        add(nametextfield);

        //Father's name
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnametextfield =new JTextField();
        fnametextfield.setFont(new Font("Arial", Font.BOLD, 14));
        fnametextfield.setBounds(320, 190, 300, 30);
        add(fnametextfield);

        //Date of birth
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        //calendar field for date of birth
        datechooser=new JDateChooser();
        datechooser.setBounds(320,240,300,30);
        datechooser.setForeground(Color.red);
        add(datechooser);

        //Gender
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        //Male radio button
        male=new JRadioButton("Male");
        male.setBounds(320, 290, 100, 30);
        male.setFont(new Font("Arial", Font.BOLD, 15));
        male.setBackground(Color.WHITE);
        add(male);
        
        //Female radio button
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setFont(new Font("Arial", Font.BOLD, 15));
        female.setBackground(Color.WHITE);
        add(female);

        //to select only one radio button we group them
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //Email id
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailtextfield =new JTextField();
        emailtextfield.setFont(new Font("Arial", Font.BOLD, 14));
        emailtextfield.setBounds(320, 340, 300, 30);
        add(emailtextfield);

        //Marital status
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Arial", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        //Single radio button
        single=new JRadioButton("Single");
        single.setBounds(320, 390, 80, 30);
        single.setFont(new Font("Arial", Font.BOLD, 15));
        single.setBackground(Color.WHITE);
        add(single);

        //Married radio button
         married = new JRadioButton("Married");
        married.setBounds(420, 390, 80, 30);
        married.setFont(new Font("Arial", Font.BOLD, 15));
        married.setBackground(Color.WHITE);
        add(married);

        //Other radio button
         other = new JRadioButton("Other");
        other.setBounds(520, 390, 80, 30);
        other.setFont(new Font("Arial", Font.BOLD, 15));
        other.setBackground(Color.WHITE);
        add(other);
        
        //Grouping them together
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);
        maritalGroup.add(other);

        //Address
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addresstextfield =new JTextField();
        addresstextfield.setFont(new Font("Arial", Font.BOLD, 14));
        addresstextfield.setBounds(320, 440, 300, 30);
        add(addresstextfield);

        //City
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Arial", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        citytextfield =new JTextField();
        citytextfield.setFont(new Font("Arial", Font.BOLD, 14));
        citytextfield.setBounds(320, 490, 300, 30);
        add(citytextfield);

        //State
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Arial", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        statetextfield =new JTextField();
        statetextfield.setFont(new Font("Arial", Font.BOLD, 14));
        statetextfield.setBounds(320, 540, 300, 30);
        add(statetextfield);

        //PIN code
        JLabel pincode=new JLabel("PIN Code:");
        pincode.setFont(new Font("Arial", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pintextfield =new JTextField();
        pintextfield.setFont(new Font("Arial", Font.BOLD, 14));
        pintextfield.setBounds(320, 590, 300, 30);
        add(pintextfield);

        //button for proceeding to next page
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        next.setBounds(540, 640, 80, 30);
        next.addActionListener(this);        //some action must be performed while clicking on next button
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(750,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+random;   // by concating a long value with double quotes it gets converted to string
        String name=nametextfield.getText();    //to get the value typed in the nametextfield
        String fname=fnametextfield.getText();

        //getuicomponent return the textfield so it is converted to jtextfield first then get text is done bcoz it can be performed only on jtextfield
        String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();      
        String gender=null;  //for radio buttons input
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        String email=emailtextfield.getText();
        String marital=null;
        if(single.isSelected())
        {
            marital="Single";
        }
        else if(married.isSelected())
        {
            marital="Married";
        }
        if(other.isSelected())
        {
            marital="Other";
        }
        String address=addresstextfield.getText();
        String city=citytextfield.getText();
        String state=statetextfield.getText();
        String pin=pintextfield.getText();
    
        try{
            if(name.equals(""))    //for validation if name is null it will show the message 
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c=new Conn();    //object of conn class is created
                //executing the query that is insertion step 4
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup2(formno).setVisible(true);  //making the next page visible
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public static void main(String args[])
    {
        new Signup1();
    }
}