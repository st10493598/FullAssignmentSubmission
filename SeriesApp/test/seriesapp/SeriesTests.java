package seriesapp;

import java.util.ArrayList;

public class SeriesTests {

    public void testSearchSeries() {
        ArrayList<Series> list = new ArrayList<>();
        Series s = new Series("101", "Extreme Sports", 12, 10);
        list.add(s);

        Series found = null;
        for (Series ser : list) {
            if (ser.getSeriesId().equals("101")) {
                found = ser;
                break;
            }
        }

        if (found == null) {
            System.out.println("Test failed: series should be found");
        } else {
            System.out.println("Test passed: series found");
        }
    }

    public void testUpdateSeries() {
        Series s = new Series("101", "Extreme Sports", 12, 10);
        s.setSeriesName("Extreme Sports 2025");
        s.setAgeRestriction(15);
        s.setNumberOfEpisodes(20);

        if (!s.getSeriesName().equals("Extreme Sports 2025")) {
            System.out.println("Test failed: name not updated");
        } else if (s.getAgeRestriction() != 15) {
            System.out.println("Test failed: age not updated");
        } else if (s.getNumberOfEpisodes() != 20) {
            System.out.println("Test failed: episodes not updated");
        } else {
            System.out.println("Test passed: update works");
        }
    }

    public void testDeleteSeries() {
        ArrayList<Series> list = new ArrayList<>();
        Series s = new Series("101", "Extreme Sports", 12, 10);
        list.add(s);

        boolean removed = list.remove(s);
        if (removed && list.isEmpty()) {
            System.out.println("Test passed: series deleted");
        } else {
            System.out.println("Test failed: delete did not work");
        }
    }
}

