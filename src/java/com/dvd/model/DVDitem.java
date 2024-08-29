/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hajarismail
 */
package com.dvd.model;

import java.io.Serializable;

import java.io.Serializable;

public class DVDitem implements Serializable {
    String title, year, genre;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public DVDitem() {
    }
    
    public DVDitem(String title, String year, String genre){
        this.genre=genre;
        this.title=title;
        this.year=year;
    }
    
}
