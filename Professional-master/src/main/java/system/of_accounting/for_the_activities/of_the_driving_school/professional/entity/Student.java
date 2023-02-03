package system.of_accounting.for_the_activities.of_the_driving_school.professional.entity;

public class Student {
    private Long idStudent;
    private String fullName;
    private String medInfo;
    private String numberTreaty;
    private String phone;
    private Long codeTeacher;
    private Long codeInspector;
    private Long codeInstructor;
    private Long codeSchool;

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMedInfo() {
        return medInfo;
    }

    public void setMedInfo(String medInfo) {
        this.medInfo = medInfo;
    }

    public String getNumberTreaty() {
        return numberTreaty;
    }

    public void setNumberTreaty(String numberTreaty) {
        this.numberTreaty = numberTreaty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(Long codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    public Long getCodeInspector() {
        return codeInspector;
    }

    public void setCodeInspector(Long codeInspector) {
        this.codeInspector = codeInspector;
    }

    public Long getCodeInstructor() {
        return codeInstructor;
    }

    public void setCodeInstructor(Long codeInstructor) {
        this.codeInstructor = codeInstructor;
    }

    public Long getCodeSchool() {
        return codeSchool;
    }

    public void setCodeSchool(Long codeSchool) {
        this.codeSchool = codeSchool;
    }
}
