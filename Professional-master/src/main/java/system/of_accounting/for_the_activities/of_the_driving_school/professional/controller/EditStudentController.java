package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditStudentService;

public class EditStudentController extends Controller {
    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField codeInspectorTextField;

    @FXML
    private TextField codeInstructorTextField;

    @FXML
    private TextField codeSchoolTextField;

    @FXML
    private TextField codeTeacherTextField;

    @FXML
    private TextField medInfoTextField;

    @FXML
    private Button enterButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField idStudentTextField;

    @FXML
    private TextField numberTreatyTextField;

    @FXML
    private TextField phoneTextField;


    private final EditStudentService service = EditStudentService.getInstance();

    @FXML
    void initialize(){
        idStudentTextField.setText(service.getStudent().getIdStudent().toString());
        fullNameTextField.setText(service.getStudent().getFullName());
        phoneTextField.setText(service.getStudent().getPhone());
        numberTreatyTextField.setText(service.getStudent().getNumberTreaty());
        medInfoTextField.setText(service.getStudent().getMedInfo());
        codeTeacherTextField.setText(service.getStudent().getCodeTeacher().toString());
        codeInspectorTextField.setText(service.getStudent().getCodeInspector().toString());
        codeInstructorTextField.setText(service.getStudent().getCodeInstructor().toString());
        codeSchoolTextField.setText(service.getStudent().getCodeSchool().toString());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteStudent();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateStudent(
                    idStudentTextField.getText(), fullNameTextField.getText(), phoneTextField.getText(),
                    numberTreatyTextField.getText(), medInfoTextField.getText(), codeTeacherTextField.getText(),
                    codeInspectorTextField.getText(), codeInstructorTextField.getText(), codeSchoolTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
