package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.*;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.AdministratorWorkspaceService;

public class AdministratorWorkspaceController extends Controller {
    @FXML
    private Button bossButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button inspectorButton;

    @FXML
    private Button instructorButton;

    @FXML
    private Button schoolButton;

    @FXML
    private Button studentButton;

    @FXML
    private TableView<Teacher> teacherTableView;
    @FXML
    private TableView<Inspector> inspectorTableView;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableView<DrivingSchool> drivingSchoolTableView;
    @FXML
    private TableView<Instructor> instructorTableView;
    @FXML
    private TableView<AuthorizationData> authorizationDataTableView;
    @FXML
    private TableView<Boss> bossTableView;

    @FXML
    private Button teacherButton;

    @FXML
    private Button userButton;


    @FXML
    private TableColumn<DrivingSchool, String> addressTableColumn;

    @FXML
    private TableColumn<Instructor, String> categoryInstructorTableColumn;

    @FXML
    private TableColumn<Boss, String> codeBossTableColumn;

    @FXML
    private TableColumn<DrivingSchool, String> codeSchoolTableColumn;

    @FXML
    private TableColumn<Teacher, String> codeTeacherTableColumn;

    @FXML
    private TableColumn<Instructor, String> contractInstructorTableColumn;

    @FXML
    private TableColumn<Boss, String> experienceBossTableColumn;

    @FXML
    private TableColumn<Instructor, String> experienceInstructorTableColumn;

    @FXML
    private TableColumn<Boss, String> fullNameBossTableColumn;

    @FXML
    private TableColumn<Instructor, String> fullNameInstructorTableColumn;

    @FXML
    private TableColumn<AuthorizationData, String> idAuthorizationDataTableColumn;

    @FXML
    private TableColumn<Boss, String> idBossTableColumn;

    @FXML
    private TableColumn<Inspector, String> idInspectorTableColumn;

    @FXML
    private TableColumn<Instructor, String> idInstructorTableColumn;

    @FXML
    private TableColumn<Student, String> idStudentTableColumn;

    @FXML
    private TableColumn<Inspector, String> inspectorFullNameTableColumn;

    @FXML
    private TableColumn<Inspector, String> inspectorJobTitleTableColumn;

    @FXML
    private TableColumn<AuthorizationData, String> loginAuthorizationDataTableColumn;

    @FXML
    private TableColumn<DrivingSchool, String> nameTableColumn;

    @FXML
    private TableColumn<AuthorizationData, String> passwordAuthorizationDataTableColumn;

    @FXML
    private TableColumn<Boss, String> phoneBossTableColumn;

    @FXML
    private TableColumn<Instructor, String> phoneInstructorTableColumn;

    @FXML
    private TableColumn<DrivingSchool, String> priceTableColumn;

    @FXML
    private TableColumn<DrivingSchool, String> servicesTableColumn;

    @FXML
    private TableColumn<Inspector, String> studentCodeInspectorTableColumn;

    @FXML
    private TableColumn<Instructor, String> studentCodeInstructorTableColumn;

    @FXML
    private TableColumn<DrivingSchool, String> studentCodeSchoolTableColumn1;

    @FXML
    private TableColumn<Teacher, String> studentCodeTeacherTableColumn;

    @FXML
    private TableColumn<Student, String> studentFullNameTableColumn;

    @FXML
    private TableColumn<Student, String> studentMedInfoTableColumn;

    @FXML
    private TableColumn<Student, String> studentNumberTreatyTableColumn;

    @FXML
    private TableColumn<Inspector, String> inspectorPhoneTableColumn;

    @FXML
    private TableColumn<Student, String> studentPhoneTableColumn;

    @FXML
    private TableColumn<Teacher, String> teacherContractTableColumn;

    @FXML
    private TableColumn<Teacher, String> teacherExperienceTableColumn;

    @FXML
    private TableColumn<Teacher, String> teacherFullNameTableColumn;

    @FXML
    private TableColumn<Teacher, String> teacherPhoneTableColumn;

    @FXML
    private TableColumn<AuthorizationData, String> typeAuthorizationDataTableColumn;

    @FXML
    private TableColumn<AuthorizationData, String> userIdAuthorizationDataTableColumn;


    private final AdministratorWorkspaceService service = AdministratorWorkspaceService.getInstance();

    @FXML
    void initialize() {
        userIdAuthorizationDataTableColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        typeAuthorizationDataTableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        passwordAuthorizationDataTableColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        loginAuthorizationDataTableColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        idAuthorizationDataTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        teacherPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        teacherFullNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        teacherExperienceTableColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));
        teacherContractTableColumn.setCellValueFactory(new PropertyValueFactory<>("contract"));
        codeTeacherTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));

        studentPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        studentNumberTreatyTableColumn.setCellValueFactory(new PropertyValueFactory<>("numberTreaty"));
        studentMedInfoTableColumn.setCellValueFactory(new PropertyValueFactory<>("medInfo"));
        studentFullNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        studentCodeTeacherTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
        studentCodeSchoolTableColumn1.setCellValueFactory(new PropertyValueFactory<>("codeSchool"));
        studentCodeInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeInstructor"));
        studentCodeInspectorTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeInspector"));
        idStudentTableColumn.setCellValueFactory(new PropertyValueFactory<>("idStudent"));

        servicesTableColumn.setCellValueFactory(new PropertyValueFactory<>("services"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeSchoolTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeSchool"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        phoneInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        idInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("idInstructor"));
        fullNameInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        experienceInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));
        contractInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("contract"));
        categoryInstructorTableColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        phoneBossTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        idBossTableColumn.setCellValueFactory(new PropertyValueFactory<>("idBoss"));
        fullNameBossTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        experienceBossTableColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));
        codeBossTableColumn.setCellValueFactory(new PropertyValueFactory<>("codeBoss"));

        inspectorJobTitleTableColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        inspectorFullNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        idInspectorTableColumn.setCellValueFactory(new PropertyValueFactory<>("idInspector"));
        inspectorPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));


        disableAllTableView();
        showTableView(drivingSchoolTableView);

        schoolButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(drivingSchoolTableView);
        });
        teacherButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(teacherTableView);
        });
        studentButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(studentTableView);
        });
        instructorButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(instructorTableView);
        });
        inspectorButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(inspectorTableView);
        });
        bossButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(bossTableView);
        });
        userButton.setOnMouseClicked(mouseEvent -> {
            disableAllTableView();
            showTableView(authorizationDataTableView);
        });

        teacherTableView.setItems(service.getTeacherObservableList());
        inspectorTableView.setItems(service.getInspectorObservableList());
        authorizationDataTableView.setItems(service.getAuthorizationDataObservableList());
        bossTableView.setItems(service.getBossObservableList());
        studentTableView.setItems(service.getStudentObservableList());
        drivingSchoolTableView.setItems(service.getDrivingSchoolObservableList());
        instructorTableView.setItems(service.getInstructorObservableList());

        teacherTableView.setOnMouseClicked(mouseEvent -> {
            Teacher teacher = teacherTableView.getSelectionModel().getSelectedItem();
            if(teacher != null){
                service.injectTeacher(teacher);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_teacher.fxml", teacherButton);
            }
        });
        authorizationDataTableView.setOnMouseClicked(mouseEvent -> {
            AuthorizationData authorizationData = authorizationDataTableView.getSelectionModel().getSelectedItem();
            if(authorizationData != null){
                service.injectAuthorizationData(authorizationData);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_authorization_data.fxml", userButton);
            }
        });
        instructorTableView.setOnMouseClicked(mouseEvent -> {
            Instructor instructor = instructorTableView.getSelectionModel().getSelectedItem();
            if(instructor != null){
                service.injectInstructor(instructor);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_instructor.fxml", instructorButton);
            }
        });
        inspectorTableView.setOnMouseClicked(mouseEvent -> {
            Inspector inspector = inspectorTableView.getSelectionModel().getSelectedItem();
            if(inspector != null){
                service.injectInspector(inspector);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_inspector.fxml", inspectorButton);
            }
        });
        drivingSchoolTableView.setOnMouseClicked(mouseEvent -> {
            DrivingSchool drivingSchool = drivingSchoolTableView.getSelectionModel().getSelectedItem();
            if(drivingSchool != null){
                service.injectDrivingSchool(drivingSchool);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_driving_school.fxml", schoolButton);
            }
        });
        bossTableView.setOnMouseClicked(mouseEvent -> {
            Boss boss = bossTableView.getSelectionModel().getSelectedItem();
            if(boss != null){
                service.injectBoss(boss);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_boss.fxml", bossButton);
            }
        });
        studentTableView.setOnMouseClicked(mouseEvent -> {
            Student student = studentTableView.getSelectionModel().getSelectedItem();
            if(student != null){
                service.injectStudent(student);
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/edit_student.fxml", studentButton);
            }
        });

        exitButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/authorization.fxml", exitButton));
    }

    private void showTableView(TableView<?> tableView) {
        tableView.setVisible(true);
    }

    private void disableAllTableView() {
        drivingSchoolTableView.setVisible(false);
        teacherTableView.setVisible(false);
        inspectorTableView.setVisible(false);
        studentTableView.setVisible(false);
        instructorTableView.setVisible(false);
        authorizationDataTableView.setVisible(false);
        bossTableView.setVisible(false);
    }
}
