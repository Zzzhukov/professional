package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.*;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.*;

import java.sql.SQLException;

public class ClientWorkspaceService {
    private static final ClientWorkspaceService CLIENT_WORKSPACE_SERVICE = new ClientWorkspaceService();

    private ClientWorkspaceService() {
    }

    public static ClientWorkspaceService getInstance() {
        return CLIENT_WORKSPACE_SERVICE;
    }

    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final DrivingSchoolRepository drivingSchoolRepository = DrivingSchoolRepository.getInstance();
    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private final InspectorRepository inspectorRepository = InspectorRepository.getInstance();
    private final InstructorRepository instructorRepository = InstructorRepository.getInstance();

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void complementStudentInfo(String school, String teacher, String instructor, String inspector) throws SQLException {
        studentRepository.updateStudent(
                Long.parseLong(school.split(" ")[0]),
                Long.parseLong(teacher.split(" ")[0]),
                Long.parseLong(instructor.split(" ")[0]),
                Long.parseLong(inspector.split(" ")[0]),
                student.getIdStudent());
    }

    public ObservableList<String> getSchools() {
        ObservableList<String> stringSchools = FXCollections.observableArrayList();
        ObservableList<DrivingSchool> schools = drivingSchoolRepository.findAllDrivingSchool();
        for (DrivingSchool school : schools){
            String stringSchool = "";
            stringSchool += school.getCodeSchool();
            stringSchool += " ";
            stringSchool += school.getName();

            stringSchools.add(stringSchool);
        }
        return stringSchools;
    }

    public ObservableList<String> getTeachers() {
        ObservableList<String> stringTeachers = FXCollections.observableArrayList();
        ObservableList<Teacher> teachers = teacherRepository.findAllTeacher();
        for (Teacher teacher : teachers){
            String stringTeacher = "";
            stringTeacher += teacher.getCodeTeacher();
            stringTeacher += " ";
            stringTeacher += teacher.getFullName();

            stringTeachers.add(stringTeacher);
        }

        return stringTeachers;
    }

    public ObservableList<String> getInstructor() {
        ObservableList<String> stringInstructors = FXCollections.observableArrayList();
        ObservableList<Instructor> instructors = instructorRepository.findAllInstructor();
        for (Instructor instructor : instructors){
            String stringInstructor = "";
            stringInstructor += instructor.getIdInstructor();
            stringInstructor += " ";
            stringInstructor += instructor.getFullName();

            stringInstructors.add(stringInstructor);
        }
        return stringInstructors;
    }

    public ObservableList<String> getInspector() {
        ObservableList<String> stringInspectors = FXCollections.observableArrayList();
        ObservableList<Inspector> inspectors = inspectorRepository.findAllInspector();
        for (Inspector inspector : inspectors){
            String stringInspector = "";
            stringInspector += inspector.getIdInspector();
            stringInspector += " ";
            stringInspector += inspector.getFullName();

            stringInspectors.add(stringInspector);
        }

        return stringInspectors;
    }
}
