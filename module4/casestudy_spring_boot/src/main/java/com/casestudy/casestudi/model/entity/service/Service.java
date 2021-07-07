package com.casestudy.casestudi.model.entity.service;



import com.casestudy.casestudi.model.entity.contract.Contract;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    @Column(name = "service_code", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceCode;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceName;

    @Column(name = "service_area", columnDefinition = "int NOT NULL", nullable = false)
    private String serviceArea;

    @Column(name = "service_cost", columnDefinition = "DOUBLE NOT NULL" , nullable = false)
    private String serviceCost;

    @Column(name = "service_max_people", columnDefinition = "int NOT NULL" , nullable = false)
    private String serviceMaxPeople;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    private String standardRoom;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "pool_area", columnDefinition = "DOUBLE NOT NULL")
    private String poolArea;

    @Column(name = "number_of_floor", columnDefinition = "int NOT NULL")
    private String numberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private List<Contract> contractList;

    private Integer flag = 1;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Service() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}