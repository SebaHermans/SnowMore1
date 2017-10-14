/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.dataaccess;

import fact.it.www.beans.Skigebied;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sebastiaan
 */
public class DASkigebied {
    private Connection connection = null;

public DASkigebied (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }

    
    public Skigebied getSkiegebied(String skinaam) {
        String skigebiednaam = skinaam + '%';
        Skigebied skigebied = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement
            ("SELECT * FROM skigebied where skigebied like ?");
            statement.setString(1,skigebiednaam);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                skigebied = new Skigebied();
                skigebied.setId(resultSet.getInt("id"));
                skigebied.setSkigebied(resultSet.getString("skigebied"));
      
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
        return skigebied;
    }

}
