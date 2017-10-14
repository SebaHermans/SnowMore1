/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.dataaccess;

import fact.it.www.beans.Aanbod;
import fact.it.www.beans.Hotel;
import fact.it.www.beans.Periode;
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
 * @author Gebruiker
 */
public class DAAanbod {
    private Connection connection = null;
    
    public DAAanbod (String url, String login, String password, String driver)   throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }
    
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }  
    }
    
    public Aanbod getAanbod(){
        Aanbod aanbod = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM aanbod where id=1");
        
            if(resultSet.next()){
                aanbod = new Aanbod();
                aanbod.setId(resultSet.getInt("id"));
                aanbod.setPeriode_id(resultSet.getInt("Periode_id"));
                aanbod.setHotel_id(resultSet.getInt("hotel_id"));
                aanbod.setPrijs(resultSet.getInt("prijs"));
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
        return aanbod;
    }
    public ArrayList<Aanbod> getReisoverzicht(){
        ArrayList<Aanbod> overzicht = new ArrayList<>();
        Periode periode;
        Hotel hotel; 
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from aanbod a join hotel h on h.id = a.hotel_ID join periode p on p.id = a.periode_id join skigebied s on s.id = h.skigebied_id order by p.periode asc, h.hotelnaam");
            
            while (resultSet.next()){
                hotel = new Hotel();
                periode = new Periode();
                Skigebied gebied = new Skigebied();
                Aanbod reisoverzicht = new Aanbod();
                reisoverzicht.setId(resultSet.getInt("id"));
                reisoverzicht.setHotel_id(resultSet.getInt("hotel_id"));
                reisoverzicht.setPeriode_id(resultSet.getInt("periode_id"));
                reisoverzicht.setPrijs(resultSet.getInt("prijs"));
                reisoverzicht.setPeriode(periode);
                periode.setPeriode(resultSet.getString("periode"));
                reisoverzicht.setHotel(hotel);
                hotel.setHotelnaam(resultSet.getString("hotelnaam"));
                hotel.setAantalSterren(resultSet.getInt("aantalsterren"));
                gebied.setSkigebied(resultSet.getString("skigebied"));
                hotel.setSkigebied(gebied);
                
                overzicht.add(reisoverzicht);
                
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
        return overzicht;
    }
    
    
    
    
    public ArrayList<Aanbod> getReisoverzichtperiode(String reisoverzicht){
        ArrayList<Aanbod> overzichtperiode = new ArrayList<>();
        Periode periode;
        Hotel hotel; 
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            
            statement = connection.prepareStatement("select * from aanbod a join hotel h on h.id = a.hotel_ID join periode p on p.id = a.periode_id where p.Periode = ?");
            statement.setString(1,reisoverzicht);
            resultSet = statement.executeQuery();
            
            
            
            while (resultSet.next()){
                hotel = new Hotel();
                periode = new Periode();
                Aanbod reisoverzichtperiode = new Aanbod();
                reisoverzichtperiode.setId(resultSet.getInt("id"));
                reisoverzichtperiode.setHotel_id(resultSet.getInt("hotel_id"));
                reisoverzichtperiode.setPeriode_id(resultSet.getInt("periode_id"));
                reisoverzichtperiode.setPrijs(resultSet.getInt("prijs"));
                reisoverzichtperiode.setPeriode(periode);
                periode.setPeriode(resultSet.getString("periode"));
                reisoverzichtperiode.setHotel(hotel);
                hotel.setHotelnaam(resultSet.getString("hotelnaam"));
                
                overzichtperiode.add(reisoverzichtperiode);
                
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
        return overzichtperiode;
    }
    
    public ArrayList<Aanbod> getPrijsPerReis(String Prijs){
        ArrayList<Aanbod> Prijsperperiode = new ArrayList<>();
        Periode periode;
        Hotel hotel; 
        Skigebied gebied;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            
            statement = connection.prepareStatement("select * from aanbod a join hotel h on h.id = a.hotel_ID join periode p on p.id = a.periode_id join skigebied s on s.id = h.skigebied_id where a.prijs <= ? order by a.prijs");
            statement.setString(1,Prijs);
            resultSet = statement.executeQuery();
            
            
            
            while (resultSet.next()){
                hotel = new Hotel();
                periode = new Periode();
                gebied = new Skigebied();
                Aanbod zoekprijs = new Aanbod();
                zoekprijs.setId(resultSet.getInt("id"));
                zoekprijs.setHotel_id(resultSet.getInt("hotel_id"));
                zoekprijs.setPeriode_id(resultSet.getInt("periode_id"));
                zoekprijs.setPrijs(resultSet.getInt("prijs"));
                zoekprijs.setPeriode(periode);
                periode.setPeriode(resultSet.getString("periode"));
                zoekprijs.setHotel(hotel);
                hotel.setHotelnaam(resultSet.getString("hotelnaam"));
                hotel.setSkigebied(gebied);
                gebied.setSkigebied(resultSet.getString("skigebied"));
                
                Prijsperperiode.add(zoekprijs);
                
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
        return Prijsperperiode;
    }
    
    public boolean insertPeriode(String periodeId, String hotelId, String bedrag){
        boolean resultaat = true;
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("insert into aanbod (id,periode_id,hotel_id,prijs) values (aanbod_seq.nextval, ?, ?, ?)");
            statement.setString(1, periodeId);
            statement.setString(2, hotelId);
            statement.setString(3, bedrag);
            statement.executeUpdate();
        } catch (Exception e){
            resultaat = false;
            e.printStackTrace();
        } finally{
            try{
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e){
            }
        }
        return resultaat;
    }
    
    
    
    public ArrayList<Aanbod> getAanbodPerHotel(String hotelid){
        ArrayList<Aanbod> hotelaanbod = new ArrayList<>();
        Periode periode;
        Hotel hotel; 
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.prepareStatement("select * from aanbod a join hotel h on h.id = a.hotel_ID join periode p on p.id = a.periode_id join skigebied s on s.id = h.skigebied_id where hotel_id = ?");
            statement.setString(1,hotelid);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                hotel = new Hotel();
                periode = new Periode();
                Skigebied gebied = new Skigebied();
                Aanbod reisoverzicht = new Aanbod();
                reisoverzicht.setId(resultSet.getInt("id"));
                reisoverzicht.setHotel_id(resultSet.getInt("hotel_id"));
                reisoverzicht.setPeriode_id(resultSet.getInt("periode_id"));
                reisoverzicht.setPrijs(resultSet.getInt("prijs"));
                reisoverzicht.setPeriode(periode);
                periode.setPeriode(resultSet.getString("periode"));
                reisoverzicht.setHotel(hotel);
                hotel.setHotelnaam(resultSet.getString("hotelnaam"));
                hotel.setAantalSterren(resultSet.getInt("aantalsterren"));
                gebied.setSkigebied(resultSet.getString("skigebied"));
                hotel.setSkigebied(gebied);
                
                hotelaanbod.add(reisoverzicht);
                
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
        return hotelaanbod;
    }
    
}
