package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Student;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.StudentRepository;

public class StudentWorkspaceService {
    private static final StudentWorkspaceService STUDENT_WORKSPACE_SERVICE = new StudentWorkspaceService();

    private StudentWorkspaceService() {
    }

    public static StudentWorkspaceService getInstance() {
        return STUDENT_WORKSPACE_SERVICE;
    }

    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();

    private Student student;

    public String getCode() {
        return student.getNumberTreaty();
    }

    public void setCode(String code) {
        student.setNumberTreaty(code);
        studentRepository.updateNumberTreaty(code, student.getIdStudent());
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void sendStudent() {
        studentAccountService.setStudent(student);
    }
}
