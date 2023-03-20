
package Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
    String sql="select * from registers where email=? and password=?";
    String url="jdbc:derby://localhost:1527/pc";
    String username="abc";
    String password="abc";
    public boolean check(String email,String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,username,password);
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,email);
            st.setString(2,pass);
            
            ResultSet rs=st.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
}
