package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Student;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.StudentRepository;

public class EditStudentService {
    private static final EditStudentService EDIT_STUDENT_SERVICE = new EditStudentService();

    private EditStudentService() {
    }

    public static EditStudentService getInstance() {
        return EDIT_STUDENT_SERVICE;
    }

    private final StudentRepository studentRepository = StudentRepository.getInstance();

    private Student student;

    public void updateStudent(String id, String fullName, String phone, String numberTreaty,
                              String medInfo, String codeTeacher, String codeInspector,
                              String codeInstructor, String codeSchool) {
        student.setIdStudent(Long.parseLong(id));
        student.setFullName(fullName);
        student.setPhone(phone);
        student.setNumberTreaty(numberTreaty);
        student.setMedInfo(medInfo);
        student.setCodeTeacher(Long.parseLong(codeTeacher));
        student.setCodeInspector(Long.parseLong(codeInspector));
        student.setCodeInstructor(Long.parseLong(codeInstructor));
        student.setCodeSchool(Long.parseLong(codeSchool));

        if (id.equals("0")){
            studentRepository.insertStudent(student);
        }
        else {
            studentRepository.updateStudentOnAdmin(student);
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void deleteStudent() {
        studentRepository.deleteStudent(student.getIdStudent());
    }
}
