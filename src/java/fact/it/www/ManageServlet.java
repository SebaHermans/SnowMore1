/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www;

import fact.it.www.beans.Aanbod;
import fact.it.www.beans.Hotel;
import fact.it.www.beans.Skigebied;
import fact.it.www.dataaccess.DAAanbod;
import fact.it.www.dataaccess.DAHotel;
import fact.it.www.dataaccess.DASkigebied;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastiaan
 */
@WebServlet(name = "ManageServlet", urlPatterns = {"/ManageServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:XE")
    , @WebInitParam(name = "login", value = "admin")
    , @WebInitParam(name = "password", value = "sql")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ManageServlet extends HttpServlet {


    
    private DASkigebied daskigebied = null;
    private DAHotel dahotel = null;
    private DAAanbod daaanbod = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (daskigebied == null) {
                daskigebied = new DASkigebied(url, login, password, driver);
            }
            if (dahotel == null){
                dahotel = new DAHotel(url,login,password,driver);
            }
            if (daaanbod == null){
                daaanbod = new DAAanbod(url,login,password,driver);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }





    @Override
    public void destroy() {
        try {
            if (daskigebied != null) {
                daskigebied.close();
            }
            if (dahotel != null){
                dahotel.close();
            }
            if (daaanbod != null){
                daaanbod.close();
            }
        } catch (SQLException ex) {
            
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        if (request.getParameter("skigebied") !=null){ 
            if(request.getParameter("ski") != ""){
            String skinaam = request.getParameter("ski");
            Skigebied ski = daskigebied.getSkiegebied(skinaam);
                if (ski != null){
                    request.setAttribute("skigebied", ski);
                    rd = request.getRequestDispatcher("skigebied.jsp");
                    }
             else{
                String foutboodschap = "Er is iets mis gelopen";
                request.setAttribute("foutboodschap", foutboodschap);
                rd = request.getRequestDispatcher("fout.jsp");
            }
            }
            else{
                String foutboodschap = "Er is iets mis gelopen";
                request.setAttribute("foutboodschap", foutboodschap);
                rd = request.getRequestDispatcher("fout.jsp");}
        }else if(request.getParameter("hotel") !=null){
            Hotel hotel = dahotel.getHotel();
            request.setAttribute("hotel", hotel);
            rd = request.getRequestDispatcher("hotel.jsp");
        } 
        else if(request.getParameter("toonhotel") != null) {
            ArrayList<Hotel> hotel = dahotel.getOverzicht();
            request.setAttribute("hotelLijst", hotel);
            rd = request.getRequestDispatcher("overzichtHotels.jsp");
        }
        else if(request.getParameter("details") != null){
            Hotel hotel = dahotel.getDetails(request.getParameter("details"));
            request.setAttribute("detailsalles", hotel);
            rd = request.getRequestDispatcher("hoteldetails.jsp");
        }
        else if(request.getParameter("aanbod") != null){
            ArrayList<Aanbod> aanbod = daaanbod.getReisoverzicht();
            request.setAttribute("aanbod", aanbod);
            rd = request.getRequestDispatcher("aanbod.jsp");
        }
        else if(request.getParameter("dropdownaanbod") != null){
            ArrayList<Aanbod> overzichtperiode = daaanbod.getReisoverzichtperiode(request.getParameter("dropdown"));
            request.setAttribute("aanbod", overzichtperiode);
            rd = request.getRequestDispatcher("aanbod.jsp");
        }
        rd.forward(request, response);
    }
        
        /*else if (request.getParameter("hotel") !=null){
            Hotel hotel = dahotel.getHotel();
            request.setAttribute("hotel", hotel);
            rd = request.getRequestDispatcher("hotel.jsp");
        }
        rd.forward(request, response);*/
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
