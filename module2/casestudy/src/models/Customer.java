package models;

public class Customer implements Comparable<Customer> {
    private String id;
    private String name;
    private String birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String customerType;
    private String address;
    private String useService;

    public Customer() {
    }

    public Customer(String id, String name, String birthday, String gender, String idCard, String phone, String email, String customerType, String address, String useService) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.useService = useService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUseService() {
        return useService;
    }

    public void setUseService(String useService) {
        this.useService = useService;
    }

    @Override
    public String toString() {
        return  id +"," + name +"," + birthday +","+ gender + ","+ idCard +
                "," + phone  +","+ email + "," + customerType + "," + address + "," +
                 useService;
    }

    public String showInfor(){
        return "id: " + this.getId()
                + "\t name: " + this.getName()
                + "\t birthday: " + this.getBirthday()
                + "\t gender: " + this.getGender()
                + "\t idCard: " + this.getIdCard()
                + "\t phone: " + this.getPhone()
                + "\t email: " + this.getEmail()
                + "\t customer type: " + this.getCustomerType()
                + "\t address: " + this.getAddress()
                + "\t use service: " + this.getUseService();
    }

    public int getYearBirthday() {
        String temp = "";
        for (int i = birthday.length() - 4; i < birthday.length(); i++) {
            temp += birthday.charAt(i);
        }
        return Integer.valueOf(temp);
    }

    @Override
    public int compareTo(Customer o) {
        int result=this.name.compareTo(o.getName());
        if (result==0){
            int yearCustomer=Integer.parseInt(this.birthday.split("/")[2]);
            int yearCustomer2=Integer.parseInt(o.birthday.split("/")[2]);
            result=yearCustomer-yearCustomer2;

        }
        return result;
    }
}
