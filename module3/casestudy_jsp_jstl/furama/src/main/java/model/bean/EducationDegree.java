package model.bean;

public class EducationDegree {
    private int educationDegreeID;
    private String educationDegreeName;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeID, String educationDegreeName) {
        this.educationDegreeID = educationDegreeID;
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public int getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(int educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
