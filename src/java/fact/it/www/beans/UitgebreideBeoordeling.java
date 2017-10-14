/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

/**
 *
 * @author Sebastiaan
 */
public class UitgebreideBeoordeling extends Beoordeling{
    private String naam, beoordeling;

    public UitgebreideBeoordeling() {
    }

    public UitgebreideBeoordeling(String naam, String beoordeling, int score, String hotel) {
        super(score, hotel);
        this.naam = naam;
        this.beoordeling = beoordeling;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(String beoordeling) {
        this.beoordeling = beoordeling;
    }

    @Override
    public String toString(){
        return super.toString() + "</br> Beoordeling van " + getNaam() + ": " + getBeoordeling();
    }
}
