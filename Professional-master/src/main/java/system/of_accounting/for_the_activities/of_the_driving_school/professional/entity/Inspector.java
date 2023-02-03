package system.of_accounting.for_the_activities.of_the_driving_school.professional.entity;

public class Inspector {
    private Long idInspector;
    private String fullName;
    private String phone;
    private String jobTitle;

    public Long getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(Long idInspector) {
        this.idInspector = idInspector;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
