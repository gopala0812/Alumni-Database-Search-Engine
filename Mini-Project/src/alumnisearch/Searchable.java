package alumnisearch;

import java.util.List;

public interface Searchable {
    List<Alumni> searchByName(String name);
    List<Alumni> searchByYear(int year);
    List<Alumni> searchByBranch(String branch);
}
