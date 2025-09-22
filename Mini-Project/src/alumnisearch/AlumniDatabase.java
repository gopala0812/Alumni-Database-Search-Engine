package alumnisearch;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlumniDatabase implements Searchable {
    private List<Alumni> alumniList;

    public AlumniDatabase() {
        alumniList = new ArrayList<>();
    }

    public void addAlumni(Alumni alumni) {
        alumniList.add(alumni);
    }

    public void displayAll() {
        if (alumniList.isEmpty()) {
            System.out.println("No alumni records found.");
            return;
        }
        for (Alumni a : alumniList) {
            System.out.println(a);
        }
    }

    // 🔹 Update alumni by name
    public boolean updateAlumni(String name, Alumni updatedData) {
        for (int i = 0; i < alumniList.size(); i++) {
            if (alumniList.get(i).getName().equalsIgnoreCase(name)) {
                alumniList.set(i, updatedData);
                return true;
            }
        }
        return false;
    }

    // 🔹 Delete alumni by name
    public boolean deleteAlumni(String name) {
        return alumniList.removeIf(a -> a.getName().equalsIgnoreCase(name));
    }

    // 🔹 Statistics: alumni count by branch
    public void alumniCountByBranch() {
        if (alumniList.isEmpty()) {
            System.out.println("No alumni records available.");
            return;
        }
        System.out.println("\n--- Alumni Count by Branch ---");
        alumniList.stream()
                .map(Alumni::getBranch)
                .distinct()
                .forEach(branch -> {
                    long count = alumniList.stream()
                            .filter(a -> a.getBranch().equalsIgnoreCase(branch))
                            .count();
                    System.out.println(branch + " : " + count);
                });
    }

    // 🔹 Statistics: alumni count by graduation year
    public void alumniCountByYear() {
        if (alumniList.isEmpty()) {
            System.out.println("No alumni records available.");
            return;
        }
        System.out.println("\n--- Alumni Count by Graduation Year ---");
        alumniList.stream()
                .map(Alumni::getGraduationYear)
                .distinct()
                .sorted()
                .forEach(year -> {
                    long count = alumniList.stream()
                            .filter(a -> a.getGraduationYear() == year)
                            .count();
                    System.out.println(year + " : " + count);
                });
    }

    // 🔹 Export alumni data to CSV file
    public void exportToCSV(String filename) {
        if (alumniList.isEmpty()) {
            System.out.println("No alumni records available to export.");
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {
            // Write header
            writer.write("Name,GraduationYear,Branch,Email,Company\n");

            // Write records
            for (Alumni a : alumniList) {
                writer.write(a.getName() + "," +
                        a.getGraduationYear() + "," +
                        a.getBranch() + "," +
                        a.getEmail() + "," +
                        a.getCompany() + "\n");
            }

            System.out.println("Data exported successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error while exporting data: " + e.getMessage());
        }
    }

    @Override
    public List<Alumni> searchByName(String name) {
        List<Alumni> result = new ArrayList<>();
        for (Alumni a : alumniList) {
            if (a.getName().equalsIgnoreCase(name)) {
                result.add(a);
            }
        }
        return result;
    }

    @Override
    public List<Alumni> searchByYear(int year) {
        List<Alumni> result = new ArrayList<>();
        for (Alumni a : alumniList) {
            if (a.getGraduationYear() == year) {
                result.add(a);
            }
        }
        return result;
    }

    @Override
    public List<Alumni> searchByBranch(String branch) {
        List<Alumni> result = new ArrayList<>();
        for (Alumni a : alumniList) {
            if (a.getBranch().equalsIgnoreCase(branch)) {
                result.add(a);
            }
        }
        return result;
    }
}

