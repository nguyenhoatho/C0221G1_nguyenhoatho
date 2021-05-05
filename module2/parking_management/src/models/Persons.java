package models;

public  class Persons {
    private String id;
    private String name;
    private int age;
    private String address;
    private String males;
    private int birthOfYear;

    public Persons(String id, String name, int age, String address, String males, int birthOfYear) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.males = males;
        this.birthOfYear = birthOfYear;
    }

    public Persons() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMales() {
        return males;
    }

    public void setMales(String males) {
        this.males = males;
    }

    public int getBirthOfYear() {
        return birthOfYear;
    }

    public void setBirthOfYear(int birthOfYear) {
        this.birthOfYear = birthOfYear;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", males='" + males + '\'' +
                ", birthOfYear=" + birthOfYear
                ;
    }
}
