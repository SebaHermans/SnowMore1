/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

import java.time.LocalDate;
import javafx.beans.binding.Bindings;

/**
 *
 * @author Sebastiaan
 */
public class Beoordeling {
    
    private int score;
    private LocalDate datum;
    private String hotel;

    public Beoordeling() {
        datum = LocalDate.now();
    }

    public Beoordeling(int score, String hotel) {
        this.score = score;
        this.hotel = hotel;
        datum = LocalDate.now();
    }
    

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    public boolean isGoed(){
        if (score > 6){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        String tekst = getDatum() + ": " + getHotel() + " - " + getScore() + "/10";
        
        return tekst;
    }
    
}
