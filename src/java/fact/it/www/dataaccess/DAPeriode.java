/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.dataaccess;


import fact.it.www.beans.Periode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gebruiker
 */
public class DAPeriode {
    private Connection connection = null;
    
    public DAPeriode (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    
    public Periode getPeriode(){
        Periode periode = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM periode where id=1");
        
            if(resultSet.next()){
                periode = new Periode();
                periode.setId(resultSet.getInt("id"));
                periode.setPeriode(resultSet.getString("periode"));
            }
        
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
            }
        }
        return periode;
    }
}
