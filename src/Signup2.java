//creating a signup page 2 frame 
import javax.swing.*;
import java.awt.*;       //used for the functions like set font,etc..
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener
{
    //declaring variables globally so that variable can be used in actionPerformed function
    JTextField pannumbertextfield,aadharnumbertextfield;
    JRadioButton syes,sno,yes,no;
    JComboBox religionfield,categoryfield,incomefield,educationfield,occupationfield;    //for dropdown using jcombobox
    JButton next;
    String formno;

    public Signup2(String formno)
    {
        this.formno=formno;

        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        setLayout(null);

        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Arial", Font.BOLD, 22));
        additionaldetails.setBounds(250, 80, 400, 30);
        add(additionaldetails);

        //Religion
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Arial", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valreligion[]={"Hindu","Muslim","Sikh","Christian","Other"}; //values that will be shown in dropdown
        religionfield=new JComboBox<>(valreligion);
        religionfield.setFont(new Font("Arial", Font.BOLD, 14));
        religionfield.setBounds(320, 140, 300, 30);
        religionfield.setBackground(Color.WHITE);
        add(religionfield);

        //Category
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Arial", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valcategory[]={"General","SC","ST","OBC","Other"};
        categoryfield=new JComboBox<>(valcategory);
        categoryfield.setFont(new Font("Arial", Font.BOLD, 14));
        categoryfield.setBounds(320, 190, 300, 30);
        categoryfield.setBackground(Color.WHITE);
        add(categoryfield);

        //Income
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Arial", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valincome[]={"Null","< 150000","<250000","<500000","Upto 1000000"};
        incomefield=new JComboBox<>(valincome);
        incomefield.setFont(new Font("Arial", Font.BOLD, 14));
        incomefield.setBounds(320, 240, 300, 30);
        incomefield.setBackground(Color.WHITE);
        add(incomefield);

        //Educational
        JLabel educational=new JLabel("Educational");
        educational.setFont(new Font("Arial", Font.BOLD, 20));
        educational.setBounds(100, 290, 300, 30);
        add(educational);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Arial", Font.BOLD, 20));
        qualification.setBounds(100, 310, 300, 30);
        add(qualification);

        String valeducation[]={"Non Graduation","Graduate","Post Graduation","Doctorate","Other"};
        educationfield=new JComboBox<>(valeducation);
        educationfield.setFont(new Font("Arial", Font.BOLD, 14));
        educationfield.setBounds(320, 290, 300, 30);
        educationfield.setBackground(Color.WHITE);
        add(educationfield);

        //Occupation
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Arial", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        String valoccupation[]={"Salaried","Self Employed","Business","Student","Retired","Other"};
        occupationfield=new JComboBox<>(valoccupation);
        occupationfield.setFont(new Font("Arial", Font.BOLD, 14));
        occupationfield.setBounds(320, 340, 300, 30);
        occupationfield.setBackground(Color.WHITE);
        add(occupationfield);

        //Pan number
        JLabel pannumber=new JLabel("PAN Number:");
        pannumber.setFont(new Font("Arial", Font.BOLD, 20));
        pannumber.setBounds(100, 390, 200, 30);
        add(pannumber);

        pannumbertextfield =new JTextField();
        pannumbertextfield.setFont(new Font("Arial", Font.BOLD, 14));
        pannumbertextfield.setBounds(320, 390, 300, 30);
        add(pannumbertextfield);

        //Aadhaar number
        JLabel aadharnumber=new JLabel("Aadhar Number:");
        aadharnumber.setFont(new Font("Arial", Font.BOLD, 20));
        aadharnumber.setBounds(100, 440, 200, 30);
        add(aadharnumber);

        aadharnumbertextfield =new JTextField();
        aadharnumbertextfield.setFont(new Font("Arial", Font.BOLD, 14));
        aadharnumbertextfield.setBounds(320, 440, 300, 30);
        add(aadharnumbertextfield);

        //Senior citizen
        JLabel seniorcitizen=new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Arial", Font.BOLD, 20));
        seniorcitizen.setBounds(100, 490, 200, 30);
        add(seniorcitizen);

        //Yes radio button
        syes=new JRadioButton("Yes");
        syes.setBounds(320, 490, 100, 30);
        syes.setFont(new Font("Arial", Font.BOLD, 15));
        syes.setBackground(Color.WHITE);
        add(syes);

        //No radio button
        sno = new JRadioButton("No");
        sno.setBounds(420, 490, 100, 30);
        sno.setFont(new Font("Arial", Font.BOLD, 15));
        sno.setBackground(Color.WHITE);
        add(sno);

        //Grouping them together
        ButtonGroup seniorcitizengroup=new ButtonGroup();
        seniorcitizengroup.add(syes);
        seniorcitizengroup.add(sno);

        //Existing account
        JLabel existingaccount=new JLabel("Existing Account:");
        existingaccount.setFont(new Font("Arial", Font.BOLD, 20));
        existingaccount.setBounds(100, 540, 200, 30);
        add(existingaccount);

        //yes radio button
        yes=new JRadioButton("Yes");
        yes.setBounds(320, 540, 100, 30);
        yes.setFont(new Font("Arial", Font.BOLD, 15));
        yes.setBackground(Color.WHITE);
        add(yes);

        //No radio button
        no = new JRadioButton("No");
        no.setBounds(420, 540, 100, 30);
        no.setFont(new Font("Arial", Font.BOLD, 15));
        no.setBackground(Color.WHITE);
        add(no);

        //Grouping them together
        ButtonGroup existingaccountgroup=new ButtonGroup();
        existingaccountgroup.add(yes);
        existingaccountgroup.add(no);

        //Next button for proceeding to next page
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
        String sreligion=(String) religionfield.getSelectedItem();    //to get the value chosen in the religion dropdown field
        String scategory=(String) categoryfield.getSelectedItem();
        String sincome=(String) incomefield.getSelectedItem();
        String seducation=(String) educationfield.getSelectedItem();
        String soccupation=(String) occupationfield.getSelectedItem();
        String sseniorcitizen=null;
        if(syes.isSelected())
        {
            sseniorcitizen="Yes";
        }
        else if(sno.isSelected())
        {
            sseniorcitizen="No";
        }
        
        String sexistingaccount=null;
        if(yes.isSelected())
        {
            sexistingaccount="Yes";
        }
        else if(no.isSelected())
        {
            sexistingaccount="No";
        }
        String span=pannumbertextfield.getText();
        String saadhar=aadharnumbertextfield.getText();
        try
        {
            Conn c=new Conn();    //object of conn class is created
            //executing the query that is insertion step 4
            String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexistingaccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new Signup3(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public static void main(String args[])
    {
        new Signup2("");
    }
}