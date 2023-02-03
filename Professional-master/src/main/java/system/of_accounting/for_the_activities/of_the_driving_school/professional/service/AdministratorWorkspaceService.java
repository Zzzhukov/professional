package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.*;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.*;

public class AdministratorWorkspaceService {
    private static final AdministratorWorkspaceService ADMINISTRATOR_WORKSPACE_SERVICE = new AdministratorWorkspaceService();

    private AdministratorWorkspaceService() {
    }

    public static AdministratorWorkspaceService getInstance() {
        return ADMINISTRATOR_WORKSPACE_SERVICE;
    }

    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private final InspectorRepository inspectorRepository = InspectorRepository.getInstance();
    private final InstructorRepository instructorRepository = InstructorRepository.getInstance();
    private final AuthorizationDataRepository authorizationDataRepository = AuthorizationDataRepository.getInstance();
    private final BossRepository bossRepository = BossRepository.getInstance();
    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final DrivingSchoolRepository drivingSchoolRepository = DrivingSchoolRepository.getInstance();

    private final EditTeacherService editTeacherService = EditTeacherService.getInstance();
    private final EditInstructorService editInstructorService = EditInstructorService.getInstance();
    private final EditAuthorizationDataService editAuthorizationDataService = EditAuthorizationDataService.getInstance();
    private final EditInspectorService editInspectorService = EditInspectorService.getInstance();
    private final EditDrivingSchoolService editDrivingSchoolService = EditDrivingSchoolService.getInstance();
    private final EditBossService editBossService = EditBossService.getInstance();
    private final EditStudentService editStudentService = EditStudentService.getInstance();


    public ObservableList<Teacher> getTeacherObservableList() {
        return teacherRepository.findAllTeacher();
    }

    public ObservableList<Inspector> getInspectorObservableList() {
        return inspectorRepository.findAllInspector();
    }

    public ObservableList<Instructor> getInstructorObservableList() {
        return instructorRepository.findAllInstructor();
    }

    public ObservableList<AuthorizationData> getAuthorizationDataObservableList() {
        return authorizationDataRepository.findAllAuthorizationData();
    }

    public ObservableList<Boss> getBossObservableList() {
        return bossRepository.findAllBoss();
    }

    public ObservableList<Student> getStudentObservableList() {
        return studentRepository.findAllStudent();
    }

    public ObservableList<DrivingSchool> getDrivingSchoolObservableList() {
        return drivingSchoolRepository.findAllDrivingSchool();
    }

    public void injectTeacher(Teacher teacher) {
        editTeacherService.setTeacher(teacher);
    }

    public void injectAuthorizationData(AuthorizationData authorizationData) {
        editAuthorizationDataService.setAuthorizationData(authorizationData);
    }

    public void injectInstructor(Instructor instructor) {
        editInstructorService.setInstructor(instructor);
    }

    public void injectInspector(Inspector inspector) {
        editInspectorService.setInspector(inspector);
    }

    public void injectDrivingSchool(DrivingSchool drivingSchool) {
        editDrivingSchoolService.setDrivingSchool(drivingSchool);
    }

    public void injectBoss(Boss boss) {
        editBossService.setBoss(boss);
    }

    public void injectStudent(Student student) {
        editStudentService.setStudent(student);
    }
}
