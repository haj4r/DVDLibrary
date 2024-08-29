/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dvd.view;

import com.dvd.model.DVDitem;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hajarismail
 */
public class AddDVDFormServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add DVD Servlet</title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Add DVD</h1>");
        out.println("<form action='add_dvd.do' method='POST'>");

        String title = request.getParameter("title");
        out.print(" Title: <input type='text' name='title'");

        if (title == null) {
            title = "";
        }
        out.println("value = '" + title + "' /> <br/><br/>");

        String year = request.getParameter("year");
        // Display the year field
        out.print(" Year: <input type='text' name='year' ");
        if (year == null) {
            year = "";
        }
        out.println("value = '" + year + "' /> <br/><br/>");

        String genre = request.getParameter("genre");
        String genre_list = "Sci-Fi,Drama,Comedy";
        String[] genres = null;
        genres = genre_list.split(",");

        //Repopulate the Genre drop-down menu
        out.println(" Genre: <select name='genre'>");
        for (int i = 0; i < genres.length; i++) {
            out.print("<option value='" + genres[i] + "'");

            if (genre.equals(genres[i])) {
                out.print(" selected");
            }
            out.println("> " + genres[i] + "</option>");
        }
        out.println("</select>");
        String newGenre = request.getParameter("newGenre");
        out.println("Others: <input type='text' name='newGenre' ");
        if (newGenre == null) {
            newGenre = "";

        }
        out.println("value = '" + newGenre + "'/> <br/><br/>");
        out.println("<input type=\"submit\" name=\"submit\">");
        out.println(" </form>");
        out.println("</body>");
        out.println("</html>");
        List errorMsgs = new LinkedList();
        try {
            if (genre == null || genre.trim().length() == 0) {
                genre = request.getParameter("genre");
            }
            if (title == null || title.trim().length() == 0) {
                errorMsgs.add("Enter The DVD Title");
            }
            if (year == null || year.trim().length() == 0) {
                errorMsgs.add("Please Enter The Year Of The Release For The DVD");
            } else if (!year.trim().matches("\\d\\d\\d\\d")) {
                errorMsgs.add(" Enter a Valid Year");
            }

            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errorMsgs", errorMsgs);
                out.println("<br><font color='red'>Error:");
                out.println("<ul>");

                Iterator items = errorMsgs.iterator();
                while (items.hasNext()) {
                    String message = (String) items.next();
                    out.println(" <li> " + message + "</li>");
                }
                out.println("</ul>");
                out.println("Try again");
                return;
            }

            DVDitem item = new DVDitem(title, year, genre);

            request.setAttribute("dvdItem", item);
            RequestDispatcher view = request.getRequestDispatcher("/success.view");
            view.forward(request, response);
        } catch (RuntimeException e) {
            errorMsgs.add("An unexpecterd error: " + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/add_dvd.view");
            view.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
