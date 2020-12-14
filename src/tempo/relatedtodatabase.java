package tempo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vsvnimish
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class relatedtodatabase {
    /*public static String[] list() throws SQLException{
        
        
     Connection con = null;
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datatable","root","nimishraja");
        } catch (SQLException ex) {
            Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        
       PreparedStatement statement;
       //PreparedStatement statement;
            statement=con.prepareStatement("select * from accounttypes");
            // statement.setString(1,userid);
            //con=v.prepareStatement("select * from salary");
            ResultSet rs=statement.executeQuery();
            //rs.next();
            //System.out.println(rs.getR);
            ResultSet sr=rs;
            System.out.println("fsgfqe1");
            rs.next();
             //System.out.println(rs.getString(1));
             //sr.next();
              System.out.println("fsgfqe2");
             int i=0,norows;
             while(sr.next()==true){
                 i++;
             }
             i++;
             norows=i;
             System.out.println(norows);
            String[] str=new String[5*i];
            i=0;
            int j=0;
            while(i!=norows){
             for(j=1;j<=5;j++){
                  System.out.println("fsgfqe31");
                 // rs.next();
              str[0]=rs.getString(j);
               System.out.println("fsgfqe3");
             }
             rs.next();
             //System.out.println(string[j][i]);
             i++;
            }
             System.out.println("fsgfqe");
            return string;
    }
    public static void main(String args[]) throws SQLException {
        
    }
       
     /*public static void find(String s){
       
    }*/
  
    public static void add(String s,String listofchars[]) throws ClassNotFoundException{
       //System.out.println("in");
        Connection con = null;
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datatable","root","nimishraja");
        } catch (SQLException ex) {
            Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        
       PreparedStatement statement;
       if(s=="accounttypes"){
       
            try {
                statement=con.prepareStatement("insert into accounttypes(accounttype,Isaccounttyperelatedtodeposits,Isaccounttyperelatedtoloans,intersetratepermonth) values(?,?,?,?)");
                statement.setString(1,listofchars[0]);
                statement.setString(2,listofchars[1]);
                statement.setString(3,listofchars[2]);
                  statement.setInt(4,Integer.parseInt(listofchars[3]));
                   statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
      
       }
       else{
            try {
                int i;
               statement=con.prepareStatement("insert into userdetails(username,password,accounttype,isitrelatedtodeposits,isitrelatedtoloans,intersetratepermonth,durationinmonths,amountuserwilltakefrombank,amountuserwilldeposittobank,totalinterset,totalamountuserwillhaveafterduration)values(?,?,?,?,?,?,?,?,?,?,?)");
               for(i=1;i<=5;i++)
               statement.setString(i,listofchars[i-1]);
               for(i=6;i<12;i++){
                    statement.setInt(i,Integer.parseInt(listofchars[i-1]));
           }
                 statement.execute();   
            } catch (SQLException ex) {
                Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       }
           
       }
      public static void update(String s,int r) throws ClassNotFoundException{
          Connection con = null;
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datatable","root","nimishraja");
        } catch (SQLException ex) {
            Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
          PreparedStatement statement;
          PreparedStatement statement1;
        try {
           // System.out.println("entered");
            statement=con.prepareStatement("update accounttypes set intersetratepermonth=?  where accounttype=? ");
           statement.setInt(1,r);
           statement.setString(2,s);
           /*statement1=con.prepareStatement("update userdetails set intersetratepermonth=?  where accounttype=? ");
            statement1.setInt(1,r);
             statement1.setString(2,s);*/
              statement.executeUpdate();
              //statement1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public static String[] userdetails(String s,String userid,String type){
        
      
            Connection con = null;
        try {
          
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datatable","root","nimishraja");
        } catch (SQLException ex) {
            Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
          PreparedStatement statement;
        if(s=="userdetails"){
            String[] arr=new String[12];
            
                try {
                    statement=con.prepareStatement("select * from userdetails where username=?");
                      statement.setString(1,userid);
                   //con=v.prepareStatement("select * from salary");
                ResultSet rs=statement.executeQuery();
                 rs.next();
                //ResultSetMetaData rss=rs.getMetaData();
                   // System.out.print(a[0]);
                 
                  // String si=rs.getString("name");
                  // System.out.println(si);
                  //1 to 5
                  int i;
                  for(i=1;i<=12;i++){
                        arr[i-1]=rs.getString(i);
                        //System.out.println(arr[i-1]);
                  }
                       
                    
                } catch (SQLException ex) {
                    Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
                 return arr; 
        }
        else{
            String[] arr=new String[5];
            
                try {
                    statement=con.prepareStatement("select * from accounttypes where accounttype=?");
                      statement.setString(1,type);
                   //con=v.prepareStatement("select * from salary");
                ResultSet rs=statement.executeQuery();
                 rs.next();
                //ResultSetMetaData rss=rs.getMetaData();
                   // System.out.print(a[0]);
                 
                  // String si=rs.getString("name");
                  // System.out.println(si);
                  //1 to 5
                  int i;
                  for(i=1;i<=5;i++){
                        arr[i-1]=rs.getString(i);
                        //System.out.println(arr[i-1]);
                  }
                       
                    
                } catch (SQLException ex) {
                    Logger.getLogger(relatedtodatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
                 return arr; 
        }

        //return null;
      }

    /**
     *
     * @param string
     * @return
     */
    
         
    public static int find(String Username){
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datatable","root","nimishraja"); 
        PreparedStatement statement;
        statement=con.prepareStatement("select * from userdetails");
         ResultSet rs=statement.executeQuery();
         boolean b=rs.next();
         while(b==true){
             if(Username.equals(rs.getString(2)))
                 return 1;
             b=rs.next();
         }
       return 0;
    }
    public static String getp(String s){
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datatable","root","nimishraja"); 
        PreparedStatement statement;
        statement=con.prepareStatement("select * from userdetails where username=? ");
        statement.setString(1, s); 
         ResultSet rs=statement.executeQuery();
         rs.next();
        return rs.getString(2);
    }
   
} 








 




