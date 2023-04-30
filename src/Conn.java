//JDBC Connectivity is done in this class
//Connection of JAVA with database MySQL using JDBC
//5 steps are:
//1. Register the driver
//2. Create connection
// 3. Create statement
// 4. Execute query
// 5. Close connection

import java.sql.*;
public class Conn 
{
    Connection c;
    Statement s;
    public Conn()
    {
        //using exception handling bcoz mysql is an external entity so there is a chance of an runtime error   
        try
        {
            //Class.forName(com.mysql.jdbc.Driver);     //step 1
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bhawna");    //step 2
            s=c.createStatement();   //step 3
            //step 4 is done in the other files where execution is required
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }
    }
}
