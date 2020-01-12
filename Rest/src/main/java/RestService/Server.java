
package RestService;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.List;
import java.sql.Connection;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Server {
    
    public static void main(String[] args){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            connectToAndQueryDatabase("root", "Hinsaringen39");
        }
        catch(Exception p){
            p.printStackTrace();
            System.out.println("Some thing whent wrong!");
        }
         
         
    }
    
    public static void connectToAndQueryDatabase(String username, String password) throws SQLException{
        
        float temp = 0;
        float el = 0;
        float elkostnad = 0;
        
        
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restuppgift?serverTimezone=UTC", username, password);){
            Statment stmt = (Statment) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Temperatur, Elförbrukning, Elkostnad(kr/kwh) FROM serverhall ");
            
            
             while(rs.next()){
                temp = rs.getFloat("Temperatur");
                el = rs.getFloat("Elförbrukning");
                elkostnad = rs.getFloat("Elkostnad(kr/kwh)");
            
            }
        }
        
        catch(Exception e){
             e.printStackTrace();
            System.out.println("Cant Connect SomeThing Whent Wrong");
        }
    }
    
    
    

    private static class Statment {

        public Statment() {
        }

        private ResultSet executeQuery(String select_Temperatur_Elförbrukning_Elkostnad) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class rs {

        private static boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static float getFloat(String temperatur) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public rs() {
        }
    }
}
