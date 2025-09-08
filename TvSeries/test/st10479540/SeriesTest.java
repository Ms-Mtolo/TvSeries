/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package st10479540;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
/**
 *
 * @author DOD
 */

    
  public class SeriesTest {
   
   private TvSeries tv;

    @Before
    public void setUp() {
        tv = new TvSeries();

        // Preload with some sample data
        Series s1 = new Series("101", "One Piece", "13", "1000");
        Series s2 = new Series("102", "Naruto", "12", "720");
        tv.seriesList.add(s1);
        tv.seriesList.add(s2);
    }

    @Test
    public void testSeriesCreation() {
        Series s = new Series("103", "Bleach", "16", "366");
        assertEquals("103", s.SeriesId);
        assertEquals("Bleach", s.SeriesName);
        assertEquals("16", s.SeriesAgeRestriction);
        assertEquals("366", s.SeriesNumberOfEpisodes);
    }

    @Test
    public void testUniqueIdValidation() {
        // Check if duplicate ID exists
        boolean exists = false;
        for (Series s : tv.seriesList) {
            if (s.SeriesId.equals("101")) {
                exists = true;
                break;
            }
        }
        assertTrue("ID 101 should already exist", exists);

        // Check if new ID is unique
        exists = false;
        for (Series s : tv.seriesList) {
            if (s.SeriesId.equals("200")) {
                exists = true;
                break;
            }
        }
        assertFalse("ID 200 should NOT exist", exists);
    }

    @Test
    public void testSearchSeries() {
        // Look for "One Piece"
        Series found = null;
        for (Series s : tv.seriesList) {
            if (s.SeriesName.equalsIgnoreCase("One Piece")) {
                found = s;
                break;
            }
        }
        assertNotNull("Series should be found", found);
        assertEquals("101", found.SeriesId);
    }

    @Test
    public void testDeleteSeries() {
        // Delete "Naruto"
        Series toDelete = null;
        for (Series s : tv.seriesList) {
            if (s.SeriesId.equals("102")) {
                toDelete = s;
                break;
            }
        }
        tv.seriesList.remove(toDelete);

        boolean exists = false;
        for (Series s : tv.seriesList) {
            if (s.SeriesId.equals("102")) {
                exists = true;
                break;
            }
        }
        assertFalse("Series ID 102 should have been deleted", exists);
    }
   
}

