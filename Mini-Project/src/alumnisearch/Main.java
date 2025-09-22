package alumnisearch;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlumniDatabase db = new AlumniDatabase();

        while (true) {
            System.out.println("\n===== Alumni Database Search Engine =====");
            System.out.println("1. Add Alumni");
            System.out.println("2. Display All Alumni");
            System.out.println("3. Search by Name");
            System.out.println("4. Search by Year");
            System.out.println("5. Search by Branch");
            System.out.println("6. Update Alumni");
            System.out.println("7. Delete Alumni");
            System.out.println("8. Statistics/Reports");
            System.out.println("9. Export to CSV");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    db.addAlumni(getAlumniDetails(sc));
                    System.out.println("Alumni added successfully!");
                    break;

                case 2:
                    db.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Name to search: ");
                    displayResults(db.searchByName(sc.nextLine()));
                    break;

                case 4:
                    System.out.print("Enter Year to search: ");
                    displayResults(db.searchByYear(sc.nextInt()));
                    break;

                case 5:
                    System.out.print("Enter Branch to search: ");
                    displayResults(db.searchByBranch(sc.nextLine()));
                    break;

                case 6:
                    System.out.print("Enter Name of alumni to update: ");
                    String oldName = sc.nextLine();
                    Alumni updated = getAlumniDetails(sc);
                    if (db.updateAlumni(oldName, updated)) {
                        System.out.println("Record updated successfully!");
                    } else {
                        System.out.println("Alumni not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Name of alumni to delete: ");
                    if (db.deleteAlumni(sc.nextLine())) {
                        System.out.println("Record deleted successfully!");
                    } else {
                        System.out.println("Alumni not found.");
                    }
                    break;

                case 8:
                    db.alumniCountByBranch();
                    db.alumniCountByYear();
                    break;

                case 9:
                    System.out.print("Enter filename to export (e.g., alumni.csv): ");
                    String filename = sc.nextLine();
                    db.exportToCSV(filename);
                    break;

                case 10:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static Alumni getAlumniDetails(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Graduation Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Company: ");
        String company = sc.nextLine();

        return new Alumni(name, year, branch, email, company);
    }

    private static void displayResults(List<Alumni> results) {
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Alumni a : results) {
                System.out.println(a);
            }
        }
    }
}

