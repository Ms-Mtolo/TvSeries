/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10479540;

/**
 *
 * @author DOD
 */
public class Series {
   //declaring string variables that will be used
    public String SeriesId;
    public String SeriesName;
    public String SeriesAgeRestriction;
    public String SeriesNumberOfEpisodes;
//initializing 
    public Series(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAgeRestriction = age;
        this.SeriesNumberOfEpisodes = episodes;
    }
// method overriding
    @Override
    public String toString() {
        return "Series Details:\n" +
               "ID: " + SeriesId + "\n" +
               "Name: " + SeriesName + "\n" +
               "Age Restriction: " + SeriesAgeRestriction + "\n" +
               "Number of Episodes: " + SeriesNumberOfEpisodes + "\n";
    }
   
}

