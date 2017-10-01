/*
 *  PROYECTO SEGUNDO CORTE
 *      Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
 */
package Conexion;


import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class dataBase extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) 
        {
            String name = request.getParameter("t1");
            String pass = request.getParameter("t2");
            out.println("Welcome: " + name);
            out.println("<br></br>");
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                out.println("driver loaded");
                out.println("<br></br>");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/VLC_ltda", "root", "root");
                out.println("Connection Sucess");
                out.println("<br></br>");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("insert into login values('"+name+"', '"+pass+"');");
                out.println("value inserted");
                con.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(dataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            throws ServletException, IOException 
    {
        try 
        {
            processRequest(request, response);
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
1
2
3
4
5
6
7
8
9
10



