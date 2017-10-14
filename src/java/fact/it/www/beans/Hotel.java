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
public class Hotel {
    private int id;
    private String hotelnaam;
    private int skigebeid_id;
    private int aantalSterren;
    private String ligging;
    private String accomodatie;
    private String kamers;
    private String maaltijden;
    private String pistes;
    private String foto;
    private Skigebied skigebied;

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelnaam() {
        return hotelnaam;
    }

    public void setHotelnaam(String hotelnaam) {
        this.hotelnaam = hotelnaam;
    }

    public int getSkigebeid_id() {
        return skigebeid_id;
    }

    public void setSkigebeid_id(int skigebeid_id) {
        this.skigebeid_id = skigebeid_id;
    }

    public int getAantalSterren() {
        return aantalSterren;
    }

    public void setAantalSterren(int aantalSterren) {
        this.aantalSterren = aantalSterren;
    }

    public String getLigging() {
        return ligging;
    }

    public void setLigging(String ligging) {
        this.ligging = ligging;
    }

    public String getAccomodatie() {
        return accomodatie;
    }

    public void setAccomodatie(String accomodatie) {
        this.accomodatie = accomodatie;
    }

    public String getKamers() {
        return kamers;
    }

    public void setKamers(String kamers) {
        this.kamers = kamers;
    }

    public String getMaaltijden() {
        return maaltijden;
    }

    public void setMaaltijden(String maaltijden) {
        this.maaltijden = maaltijden;
    }

    public String getPistes() {
        return pistes;
    }

    public void setPistes(String pistes) {
        this.pistes = pistes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Skigebied getSkigebied() {
        return skigebied;
    }

    public void setSkigebied(Skigebied skigebied) {
        this.skigebied = skigebied;
    }
    
    
}
