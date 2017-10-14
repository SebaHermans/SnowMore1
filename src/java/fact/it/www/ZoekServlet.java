/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www;

import fact.it.www.beans.Aanbod;
import fact.it.www.beans.Hotel;
import fact.it.www.dataaccess.DAAanbod;
import fact.it.www.dataaccess.DAHotel;
import fact.it.www.dataaccess.DASkigebied;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastiaan
 */
@WebServlet(name = "ZoekServlet", urlPatterns = {"/ZoekServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:XE")
    , @WebInitParam(name = "login", value = "admin")
    , @WebInitParam(name = "password", value = "sql")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ZoekServlet extends HttpServlet {


    private DAHotel dahotel = null;
    private DASkigebied daskigebied = null;
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
        if (request.getParameter("sterrenKiezen") != null) {
            ArrayList<Hotel> sterren = dahotel.getHotelperster(request.getParameter("sterren"));
            request.setAttribute("hotelLijst", sterren);
            rd = request.getRequestDispatcher("overzichtHotels.jsp");
        }
        else if(request.getParameter("hotelzoeken") != null){
            ArrayList<Hotel> hotelzoek = dahotel.getHotelnaam(request.getParameter("hotelnaam"));
            request.setAttribute("hotelLijst", hotelzoek);
            rd = request.getRequestDispatcher("overzichtHotels.jsp");
        }
        else if(request.getParameter("prijslijst") != null){
            ArrayList<Aanbod> prijszoek = daaanbod.getPrijsPerReis(request.getParameter("prijs"));
            request.setAttribute("zoekprijs", prijszoek);
            rd = request.getRequestDispatcher("zoekuitgebreid.jsp");
        }
    
         rd.forward(request, response);
    }

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
