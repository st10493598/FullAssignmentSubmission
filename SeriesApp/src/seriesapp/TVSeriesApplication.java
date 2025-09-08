package seriesapp;

import java.util.ArrayList;
import java.util.Scanner;

public class TVSeriesApplication {
    private static final ArrayList<Series> seriesList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("-----------------------------");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        String choice = sc.nextLine();
        if (!choice.equals("1")) {
            System.out.println("Exiting application...");
            return;
        }

        boolean running = true;
        while (running) {
            printMenu();
            String option = sc.nextLine();

            switch (option) {
                case "1" -> captureSeries();
                case "2" -> searchSeries();
                case "3" -> updateSeries();
                case "4" -> deleteSeries();
                case "5" -> printReport();
                case "6" -> {
                    running = false;
                    System.out.println("Exiting application...");
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nPlease select one of the following:");
        System.out.println("(1) Capture a new series");
        System.out.println("(2) Search for a series");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series");
        System.out.println("(5) Print series report");
        System.out.println("(6) Exit");
    }

    private static void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("-----------------------------");

        System.out.print("Enter series id: ");
        String id = sc.nextLine();

        System.out.print("Enter series name: ");
        String name = sc.nextLine();

        System.out.print("Enter age restriction: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter number of episodes: ");
        int episodes = Integer.parseInt(sc.nextLine());

        Series s = new Series(id, name, age, episodes);
        seriesList.add(s);

        System.out.println("Series added successfully.");
    }

    private static void searchSeries() {
        System.out.print("Enter the series id to search: ");
        String searchId = sc.nextLine();

        boolean found = false;
        for (Series ser : seriesList) {
            if (ser.getSeriesId().equals(searchId)) {
                System.out.println("-----------------------------");
                System.out.println(ser);
                System.out.println("-----------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series with ID " + searchId + " not found.");
        }
    }

    private static void updateSeries() {
        System.out.print("Enter the series id to update: ");
        String updateId = sc.nextLine();

        for (Series ser : seriesList) {
            if (ser.getSeriesId().equals(updateId)) {
                System.out.println("Series found:");
                System.out.println("-----------------------------");
                System.out.println(ser);
                System.out.println("-----------------------------");

                System.out.print("Enter new series name: ");
                ser.setSeriesName(sc.nextLine());

                System.out.print("Enter new age restriction: ");
                int newAge = Integer.parseInt(sc.nextLine());
                ser.setAgeRestriction(newAge);

                System.out.print("Enter new number of episodes: ");
                ser.setNumberOfEpisodes(Integer.parseInt(sc.nextLine()));

                System.out.println("Series updated successfully.");
                return;
            }
        }

        System.out.println("Series with ID " + updateId + " not found.");
    }

    private static void deleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String deleteId = sc.nextLine();

        Series toDelete = null;
        for (Series ser : seriesList) {
            if (ser.getSeriesId().equals(deleteId)) {
                toDelete = ser;
                break;
            }
        }

        if (toDelete != null) {
            System.out.println("Series found:");
            System.out.println("-----------------------------");
            System.out.println(toDelete);
            System.out.println("-----------------------------");

            System.out.print("Are you sure you want to delete this series? (Y/N): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                seriesList.remove(toDelete);
                System.out.println("Series deleted.");
            } else {
                System.out.println("Delete cancelled.");
            }
        } else {
            System.out.println("Series with ID " + deleteId + " not found.");
        }
    }

    private static void printReport() {
        System.out.println("\n*** SERIES REPORT ***");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (Series ser : seriesList) {
                System.out.println("-----------------------------");
                System.out.println(ser);
                System.out.println("-----------------------------");
            }
        }
    }
}


