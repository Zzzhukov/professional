package system.of_accounting.for_the_activities.of_the_driving_school.professional.entity;

public class Teacher {
    private Long codeTeacher;
    private String fullName;
    private String phone;
    private String experience;
    private String contract;

    public Long getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(Long codeTeacher) {
        this.codeTeacher = codeTeacher;
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

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
