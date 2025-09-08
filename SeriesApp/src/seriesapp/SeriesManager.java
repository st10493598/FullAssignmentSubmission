package seriesapp;

import java.util.ArrayList;
import java.util.Scanner;

public class SeriesManager {
    private final ArrayList<Series> seriesList = new ArrayList<>();

    public void captureSeries(Scanner sc) {
        System.out.print("Enter series ID: ");
        String id = sc.nextLine();

        System.out.print("Enter series name: ");
        String name = sc.nextLine();

        System.out.print("Enter age restriction: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter number of episodes: ");
        int episodes = Integer.parseInt(sc.nextLine());

        seriesList.add(new Series(id, name, age, episodes));
        System.out.println("Series added.\n");
    }

    public void searchSeries(Scanner sc) {
        System.out.print("Enter series ID to search: ");
        String id = sc.nextLine();

        for (Series s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Series not found.\n");
    }

    public void updateSeries(Scanner sc) {
        System.out.print("Enter series ID to update: ");
        String id = sc.nextLine();

        for (Series s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                System.out.print("Enter new age restriction: ");
                int newAge = Integer.parseInt(sc.nextLine());
                s.setAgeRestriction(newAge);
                System.out.println("Age restriction updated.\n");
                return;
            }
        }
        System.out.println("Series not found.\n");
    }

    public void deleteSeries(Scanner sc) {
        System.out.print("Enter series ID to delete: ");
        String id = sc.nextLine();

        Series toDelete = null;
        for (Series s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                toDelete = s;
                break;
            }
        }

        if (toDelete != null) {
            System.out.print("Are you sure you want to delete " + toDelete.getSeriesName() + "? (Y/N): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                seriesList.remove(toDelete);
                System.out.println("Series deleted.\n");
            } else {
                System.out.println("Delete cancelled.\n");
            }
        } else {
            System.out.println("Series not found.\n");
        }
    }

    public void seriesReport() {
        System.out.println("SERIES REPORT");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.\n");
        } else {
            for (Series s : seriesList) {
                System.out.println(s);
                System.out.println("---------------------");
            }
        }
    }
}

