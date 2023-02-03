package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.*;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.*;

import java.util.Objects;

public class StudentAccountService {
    private static final StudentAccountService STUDENT_ACCOUNT_SERVICE = new StudentAccountService();

    private StudentAccountService() {
    }

    public static StudentAccountService getInstance() {
        return STUDENT_ACCOUNT_SERVICE;
    }

    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final DrivingSchoolRepository drivingSchoolRepository = DrivingSchoolRepository.getInstance();
    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private final InspectorRepository inspectorRepository = InspectorRepository.getInstance();
    private final InstructorRepository instructorRepository = InstructorRepository.getInstance();
    private Student student;
    private String thisSchool;
    private String thisTeacher;
    private String thisInspector;
    private String thisInstructor;

    public String updateStudent(String fullName, String medInfo, String phone,
                                String school, String teacher, String instructor, String inspector) {
        try {
            if (fullName.length() < 3)
                return "short fullName";
            if (medInfo.length() < 3)
                return "short medInfo";
            if (phone.length() < 11)
                return "short phone";
            if (phone.length() > 11)
                return "long phone";

            student.setFullName(fullName);
            student.setMedInfo(medInfo);
            student.setPhone(phone);
            student.setCodeSchool(Long.parseLong(school.split(" ")[0]));
            student.setCodeTeacher(Long.parseLong(teacher.split(" ")[0]));
            student.setCodeInspector(Long.parseLong(inspector.split(" ")[0]));
            student.setCodeInstructor(Long.parseLong(instructor.split(" ")[0]));
            studentRepository.updateStudent(student);
            return "success";
        } catch (Exception exception) {
            return "error";
        }
    }

    public ObservableList<String> getSchools() {
        ObservableList<String> stringSchools = FXCollections.observableArrayList();
        ObservableList<DrivingSchool> schools = drivingSchoolRepository.findAllDrivingSchool();
        for (DrivingSchool school : schools) {
            String stringSchool = "";
            stringSchool += school.getCodeSchool();
            stringSchool += " ";
            stringSchool += school.getName();

            if (Objects.equals(school.getCodeSchool(), student.getCodeSchool())) {
                thisSchool = stringSchool;
            }

            stringSchools.add(stringSchool);
        }
        return stringSchools;
    }

    public ObservableList<String> getTeachers() {
        ObservableList<String> stringTeachers = FXCollections.observableArrayList();
        ObservableList<Teacher> teachers = teacherRepository.findAllTeacher();
        for (Teacher teacher : teachers) {
            String stringTeacher = "";
            stringTeacher += teacher.getCodeTeacher();
            stringTeacher += " ";
            stringTeacher += teacher.getFullName();

            if (Objects.equals(teacher.getCodeTeacher(), student.getCodeTeacher())) {
                thisTeacher = stringTeacher;
            }

            stringTeachers.add(stringTeacher);
        }

        return stringTeachers;
    }

    public ObservableList<String> getInstructors() {
        ObservableList<String> stringInstructors = FXCollections.observableArrayList();
        ObservableList<Instructor> instructors = instructorRepository.findAllInstructor();
        for (Instructor instructor : instructors) {
            String stringInstructor = "";
            stringInstructor += instructor.getIdInstructor();
            stringInstructor += " ";
            stringInstructor += instructor.getFullName();

            if (Objects.equals(instructor.getIdInstructor(), student.getCodeInstructor())) {
                thisInstructor = stringInstructor;
            }

            stringInstructors.add(stringInstructor);
        }
        return stringInstructors;
    }

    public ObservableList<String> getInspectors() {
        ObservableList<String> stringInspectors = FXCollections.observableArrayList();
        ObservableList<Inspector> inspectors = inspectorRepository.findAllInspector();
        for (Inspector inspector : inspectors) {
            String stringInspector = "";
            stringInspector += inspector.getIdInspector();
            stringInspector += " ";
            stringInspector += inspector.getFullName();

            if (Objects.equals(inspector.getIdInspector(), student.getCodeInspector())) {
                thisInspector = stringInspector;
            }

            stringInspectors.add(stringInspector);
        }

        return stringInspectors;
    }

    public String getThisSchool() {
        return thisSchool;
    }

    public String getThisTeacher() {
        return thisTeacher;
    }

    public String getThisInspector() {
        return thisInspector;
    }

    public String getThisInstructor() {
        return thisInstructor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
