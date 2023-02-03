package system.of_accounting.for_the_activities.of_the_driving_school.professional.entity;

public class DrivingSchool {
    private Long codeSchool;
    private String name;
    private Double price;
    private String services;
    private String address;
    private Long codeBoss;

    public Long getCodeSchool() {
        return codeSchool;
    }

    public void setCodeSchool(Long codeSchool) {
        this.codeSchool = codeSchool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCodeBoss() {
        return codeBoss;
    }

    public void setCodeBoss(Long codeBoss) {
        this.codeBoss = codeBoss;
    }
}
