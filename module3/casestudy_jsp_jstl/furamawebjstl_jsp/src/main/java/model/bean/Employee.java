package model.bean;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIDCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private int positionID;
    private int educationDegreeID;
    private int divisionID;
    private String userName;

    public Employee() {
    }

    public Employee(int employeeID, String employeeName, String employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int positionID, int educationDegreeID, int divisionID) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionID = positionID;
        this.educationDegreeID = educationDegreeID;
        this.divisionID = divisionID;
    }

    public Employee(int employeeID, String employeeName, String employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int positionID, int educationDegreeID, int divisionID, String userName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionID = positionID;
        this.educationDegreeID = educationDegreeID;
        this.divisionID = divisionID;
        this.userName = userName;
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, int positionID, int educationDegreeID, int divisionID) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionID = positionID;
        this.educationDegreeID = educationDegreeID;
        this.divisionID = divisionID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIDCard() {
        return employeeIDCard;
    }

    public void setEmployeeIDCard(String employeeIDCard) {
        this.employeeIDCard = employeeIDCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public int getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(int educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
