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
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private String userName;

    public Employee() {
    }

    public Employee(int employeeID, String employeeName, String employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public Employee(int employeeID, String employeeName, String employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress,  Position position, EducationDegree educationDegree, Division division, String userName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIDCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
