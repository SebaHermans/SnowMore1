/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.dataaccess;

import fact.it.www.beans.Hotel;
import fact.it.www.beans.Skigebied;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastiaan
 */
public class DAHotel {
    private Connection connection = null;

public DAHotel (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    
    public Hotel getHotel() {
        Hotel hotel = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hotel where id = 1");

            if (resultSet.next()) {
                hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setHotelnaam(resultSet.getString("hotelnaam"));
                hotel.setAantalSterren(resultSet.getInt("aantalSterren"));
                
                
      
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
        return hotel;
    }
    
    public ArrayList<Hotel> getOverzicht(){
        ArrayList<Hotel> hotel = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hotel join skigebied on hotel.skigebied_id = skigebied.id order by hotel.hotelnaam asc");
            while (resultSet.next()){
                Hotel hotelLijst = new Hotel();
                Skigebied gebied = new Skigebied();
                hotelLijst.setId(resultSet.getInt("id"));
                hotelLijst.setHotelnaam(resultSet.getString("hotelnaam"));
                hotelLijst.setAantalSterren(resultSet.getInt("aantalSterren"));
                gebied.setSkigebied(resultSet.getString("skigebied"));
                hotelLijst.setSkigebied(gebied);
                
                hotel.add(hotelLijst);
            }
    
    
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try{
                    statement.close();
                    if (resultSet != null){
                        resultSet.close();
                    }
                } catch (SQLException e){
                }
            }
            return hotel;
    }
    public Hotel getDetails(String naamhotel) {
        Hotel details = null;               
        Skigebied gebied = new Skigebied();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM hotel h join skigebied s on s.ID = h.SKIGEBIED_ID where hotelnaam = ?");
                statement.setString(1,naamhotel);
                resultSet = statement.executeQuery();
            if (resultSet.next()) {
                details = new Hotel();
                details.setId(resultSet.getInt("id"));
                details.setHotelnaam(resultSet.getString("hotelnaam"));
                details.setAantalSterren(resultSet.getInt("aantalSterren"));
                details.setFoto(resultSet.getString("foto"));
                details.setSkigebied(gebied);
                gebied.setSkigebied(resultSet.getString("skigebied"));
                
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
        return details;
    }
    
    public ArrayList<Hotel> getHotelperster(String aantalsterren){
        ArrayList<Hotel> sterren = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.prepareStatement("select * from hotel join skigebied on hotel.skigebied_id = skigebied.id where aantalsterren = ?");
            statement.setString(1,aantalsterren);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                Hotel aantalster = new Hotel();
                Skigebied gebied = new Skigebied();
                aantalster.setId(resultSet.getInt("id"));
                aantalster.setHotelnaam(resultSet.getString("hotelnaam"));
                aantalster.setAantalSterren(resultSet.getInt("aantalsterren"));
                gebied.setSkigebied(resultSet.getString("skigebied"));
                aantalster.setSkigebied(gebied);
                
                
                sterren.add(aantalster);
                
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
        return sterren;
    }
    
        public ArrayList<Hotel> getHotelnaam(String naam){
        String hotelnaam = naam + '%';
        hotelnaam = hotelnaam.toLowerCase();
        ArrayList<Hotel> hotelZoek = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.prepareStatement("select * from hotel join skigebied on hotel.skigebied_id = skigebied.id where lower(hotel.hotelnaam) like ? order by hotel.hotelnaam");
            statement.setString(1,hotelnaam);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                Hotel zoekhotel = new Hotel();
                Skigebied gebied = new Skigebied();
                zoekhotel.setId(resultSet.getInt("id"));
                zoekhotel.setHotelnaam(resultSet.getString("hotelnaam"));
                zoekhotel.setAantalSterren(resultSet.getInt("aantalsterren"));
                gebied.setSkigebied(resultSet.getString("skigebied"));
                zoekhotel.setSkigebied(gebied);
                hotelZoek.add(zoekhotel);
                
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
        return hotelZoek;
    }
    

}
