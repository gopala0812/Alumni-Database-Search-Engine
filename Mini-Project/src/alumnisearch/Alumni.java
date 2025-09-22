package alumnisearch;

public class Alumni {
    private String name;
    private int graduationYear;
    private String branch;
    private String email;
    private String company;

    public Alumni(String name, int graduationYear, String branch, String email, String company) {
        this.name = name;
        this.graduationYear = graduationYear;
        this.branch = branch;
        this.email = email;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nGraduation Year: " + graduationYear +
                "\nBranch: " + branch +
                "\nEmail: " + email +
                "\nCompany: " + company +
                "\n------------------";
    }
}

