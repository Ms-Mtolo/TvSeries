/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10479540;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//import st10479540.TvSeries.main.SeriesModel;
//import st10479540.TvSeries.main.SeriesModel;

/**
 *
 * @author DOD
 */
public class TvSeries {

     Scanner scanner = new Scanner(System.in);
    ArrayList<Series> seriesList = new ArrayList<>();

    public static void main(String[] args) {
        TvSeries tv = new TvSeries();
        Scanner input = new Scanner(System.in);

        System.out.println("""
                           TV SERIES 2K25
                           ******************************************************************
                           Enter (1) to launch menu or any key to exit
                           """);

        String menu = input.nextLine();

        if (menu.equals("1")) {
            while (true) {
                tv.menu();
            }
        } else {
            System.out.println("Application closed.");
        }
    }
// This is the menu
    public void menu() {
        System.out.println("""
                           ==============================
                           MENU OPTIONS
                           (1) Capture a new series
                           (2) Search for a series
                           (3) Update series details
                           (4) Delete a series
                           (5) Print series report - 2k25
                           (6) Exit Application
                           ==============================
                           """);
// used a switch case 
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                captureSeries();
                break;
            case "2":
                searchSeries();
                break;
            case "3":
                updateSeries();
                break;
            case "4":
                deleteSeries();
                break;
            case "5":
                seriesReport();
                break;
            case "6":
                exitApplication();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
// Captures details about the series that will be captured
    public void captureSeries() {
    System.out.print("How many series do you want to capture? ");
    int count = scanner.nextInt();
    scanner.nextLine(); 

    for (int i = 0; i < count; i++) {
        System.out.println("\nEnter details for Series " + (i + 1));

        // check for unique id
        String id;
        while (true) {
            System.out.print("Enter Series ID: ");
            id = scanner.nextLine();

            boolean exists = false;
            for (Series s : seriesList) {
                if (s.SeriesId.equalsIgnoreCase(id)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("❌ ID already exists! Please enter a unique ID.");
            } else {
                break; // valid unique ID
            }
        }

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter Series Age Restriction (2–18): ");
            String ageStr = scanner.nextLine();
            if (ageStr.matches("\\d+")) {
                age = Integer.parseInt(ageStr);
                if (age >= 2 && age <= 18) {
                    break;
                } else {
                    System.out.println("Invalid age. Must be between 2 and 18.");
                }
            } else {
                System.out.println("Invalid input. Numbers only.");
            }
        }

        int episodes;
        while (true) {
            System.out.print("Enter Number of Episodes: ");
            String epStr = scanner.nextLine();
            if (epStr.matches("\\d+")) {
                episodes = Integer.parseInt(epStr);
                break; 
            } else {
                System.out.println("Invalid input. Numbers only.");
            }
        }

        // series object
        Series series = new Series(id, name, String.valueOf(age), String.valueOf(episodes));
        seriesList.add(series);
        System.out.println(" Series Successfully Captured!\n");
    }
}
   // searches for thecaptured series that was 
    public void searchSeries() {
         System.out.print("Enter Series ID or Name to search: ");
        String searchKey = scanner.nextLine();

    for (Series series : seriesList) {
        if (series.SeriesId.equalsIgnoreCase(searchKey) ||
            series.SeriesName.equalsIgnoreCase(searchKey)) {
            System.out.println(series);
            return;
        }
    }
    System.out.println("Series NOT FOUND.\n");
    }
//updated series
    public void updateSeries() {
        System.out.print("Enter Series ID to update: ");
        String seriesId = scanner.nextLine();

        for (Series series : seriesList) {
            if (series.SeriesId.equals(seriesId)) {
                System.out.print("Enter new Series Name: ");
                series.SeriesName = scanner.nextLine();

                int episodes;
                while (true) {
                System.out.print("Enter Number of Episodes: ");
                String epStr = scanner.nextLine();
                if (epStr.matches("\\d+")) {
                        episodes = Integer.parseInt(epStr);
                        break; 
                } else {
                  System.out.println("Invalid input. Numbers only.");
                }
            }

                System.out.println("Series successfully updated!\n");
                return;
            }
        }
        System.out.println("Series NOT FOUND.\n");
    }
//deletes series
    public void deleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String seriesId = scanner.nextLine();

        Iterator<Series> iterator = seriesList.iterator();
        while (iterator.hasNext()) {
            Series series = iterator.next();
            if (series.SeriesId.equals(seriesId)) {
                System.out.print("Confirm delete? (yes/no): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    iterator.remove();
                    System.out.println("Series Successfully Deleted!\n");
                } else {
                    System.out.println("Request Cancelled.\n");
                }
                return;
            }
        }
        System.out.println("Series NOT FOUND.\n");
    }
//series report
    public void seriesReport() {
        System.out.println("\n========== SERIES REPORT ==========");
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.\n");
        } else {
            for (Series series : seriesList) {
                System.out.println(series);
            }
            System.out.println("===================================\n");
        }
    }
// system exist
    public void exitApplication() {
        System.out.println("Thank you for using TV Series 2K25!");
        System.exit(0);
    }
}
    

                           
                       

           
                   
                           
                   
               
    
                           
    

    

    
    



 

   

     
   
      

      




    

 
                 
          
        
        
    
   
    
    

