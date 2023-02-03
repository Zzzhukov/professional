package system.of_accounting.for_the_activities.of_the_driving_school.professional.entity;

public class Instructor {
    private Long idInstructor;
    private String fullName;
    private String phone;
    private String experience;
    private String category;
    private String contract;

    public Long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
