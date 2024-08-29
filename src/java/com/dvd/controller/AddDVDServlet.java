/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hajarismail
 */
package com.dvd.controller;

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

public class AddDVDServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
   protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException,
    IOException {
       
    List errorMsgs = new LinkedList(); 
    try {
    String title = request.getParameter("title");
    String year = request.getParameter("year"); 
    String genre = request.getParameter("newGenre");
    
    if((genre == null || (genre.trim().length() == 0))){
    genre = request.getParameter("genre");
    }
        if(title == null || title.trim().length() == 0){
        errorMsgs.add("Enter a valid DVD title");
    }
        if(year == null || year.trim().length() == 0){
        errorMsgs.add("Enter a valid  year of the release for the DVD");
    }else 
        if(!year.trim().matches("\\d\\d\\d\\d")){
    errorMsgs.add("Enter a valid year");
    }
        //Form Verification
        if (title == null || title.trim().length() == 0) {
        errorMsgs.add("Please enter the DVD title");
        }
        if (year == null || year.trim().length() == 0) {
        errorMsgs.add("Enter the DVD year");
        } else if (!year.trim().matches("\\d\\d\\d\\d")) {
        errorMsgs.add("Enter valid year");
        }
        
        if(!errorMsgs.isEmpty()){
        request.setAttribute("errorMsgs", errorMsgs);
        RequestDispatcher view =
        request.getRequestDispatcher("/error.jsp");
        view.forward(request, response);
        return;
    }
    DVDitem item = new DVDitem(title,year,genre);
    
        request.setAttribute("dvdItem", item);
        RequestDispatcher view =
        request.getRequestDispatcher("/success.jsp");
        view.forward(request,response);
    }
    catch(RuntimeException e){ errorMsgs.add("An unexpecterd error: " + e.getMessage());
        request.setAttribute("errorMsgs", errorMsgs);
        RequestDispatcher view =
        request.getRequestDispatcher("/error.jsp");
        view.forward(request, response);
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
