package Pages;

public enum MyJobSearchPages {
    BROWSEJOBS("Browse Jobs"),
    RESUMES("Resumes"),
    COVERLETTERS("Cover Letters"),
    DOCUMENTS("Documents"),
    APPLIEDJOBS("Applied Jobs"),
    SAVEDJOBS("Saved Jobs"),
    JOBALERTS("Job Alerts");


    private final String label;   // in kilograms
    MyJobSearchPages(String label ) {
        this.label = label;
    }
    public String label() { return label; }
}
