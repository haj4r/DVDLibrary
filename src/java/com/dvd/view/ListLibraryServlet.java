package com.dvd.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.dvd.model.DVDitem;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hajarismail
 */
public class ListLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List dvds = new ArrayList();
        dvds.add(new DVDitem("Aquaman", "2019", "Sci-Fi"));
        dvds.add(new DVDitem("Robin Hood", "2018", "Action"));
        dvds.add(new DVDitem("The Grinch", "2018", "Comedy"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>ListLibraryServlet</title>");
        out.println("<body bgcolor='white'>");
        out.println("YOU CURRENTLY HAVE <b>" + dvds.size()
                + "</b> DVDs IN YOUR COLLECTION:<br>");
        out.println("<table border='1' cellspacing='1' cellpadding='6'>");
        out.println("<tr>");
        out.println("<th>TITLE</th>");
        out.println("<th>YEAR</th>");
        out.println(" <th>GENRE</th>");
        out.println("</tr>");

        Iterator it = dvds.iterator();
        while (it.hasNext()) {

            DVDitem item = (DVDitem) it.next();
            out.println("<tr>");
            out.println(" <td>" + item.getTitle() + "</td>");
            out.println(" <td>" + item.getYear() + "</td>");
            out.println(" <td>" + item.getGenre() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br>END OF LIST...");
        out.println("</body>");
        out.println("</html>");
        out.close();
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
