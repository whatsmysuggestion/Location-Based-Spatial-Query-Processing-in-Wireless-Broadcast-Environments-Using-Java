//package joe_project;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.sql.*;


class Jdbc 
{
		// insert Client Method Calls
    public String insertClient(String query)
	{
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Mobile");
            Statement st = con.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Connection Not Found"+e);
        }
        return "";
	}


        // insert Server Method Calls
    public String insertServer(String query)
	{
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Connection Not Found"+e);
        }
        return "";
	}
        

	// retrive Method Calls
        public String retrive(String query)
	{
           String values = "";
              
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            while(rs.next())
            {
                values +=   rs.getString("Portno")+"%"+ rs.getString("Direction")+"%"+rs.getString("Distance")+"&";
             }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
	}


		// retriveResults Method Calls
        
        public String retriveResults(String query)
	{
              String rsts = "";
              
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            while(rs.next())
            {
                rsts +=   rs.getString("Portno")+"%"+ rs.getString("Location")+"%"+rs.getString("Criteria")+"%"+rs.getString("Results")+"&";
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return rsts;
	}


		// retrive Method Calls
       public String retriveFinalrst(String query)
	{
              String finalrst = "";
              
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Mobile");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
			while(rs.next())
			{
				finalrst += rs.getString(1);
			}
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return finalrst;
	}  


	  	// Search Method Calls

        public int search(String query)
	{
            int searchResults=0;
	try {
           
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                searchResults=rs.getInt(1);
            }
            System.out.println(searchResults);
                   
           JOptionPane jp=new JOptionPane();
           jp.showMessageDialog(jp,"Min Distance : "+searchResults);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResults;
	}
        
        // retrivePort Method Calls

        public int retrivePort(String query)
	{
       int port =0;
              
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            if(rs.next()==true)
            {
                port+=  rs.getInt(1); 
                JOptionPane jp=new JOptionPane();
                jp.showMessageDialog(jp,"Port Number : "+port);
                        
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
	}
        
        
        // retriveMH2db Method Calls

        public String retriveMH2db(String query)
	{
             String rst1 = "";
              
	try {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Mobile");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            while(rs.next())
            {
               rst1 +=   rs.getString("Results");
               JOptionPane jp=new JOptionPane();
               jp.showConfirmDialog(jp,"Do You Want Send Query To Nearest MobileHost"); 
    
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rst1;
	}
        
        
        public String gettingResults(String query)
	{
            String onlyServer="";
	try {
           
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                onlyServer=rs.getString("Results");
            }
            System.out.println(onlyServer);
                   
           JOptionPane jp=new JOptionPane();
           jp.showMessageDialog(jp,"Getting From Server : "+onlyServer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return onlyServer;
	}
        


 public String neighbourSearch(String query)
	{
            String rtnport="";
	try {
           
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:MobileServer");
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                rtnport=rs.getString("Portno");
            }
            System.out.println(rtnport);
                   
           JOptionPane jp=new JOptionPane();
           jp.showMessageDialog(jp,"Neighbour Port : "+rtnport);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtnport;
	}


	public static void main(String[] args) 
	{
            new Jdbc();
	}

}
