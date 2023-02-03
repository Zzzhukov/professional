package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditTeacherService;

public class EditTeacherController extends Controller {
    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;
    @FXML
    private TextField codeTeacherTextField;

    @FXML
    private TextField contractTextField;

    @FXML
    private TextField experienceTextField;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Button enterButton;

    private final EditTeacherService service = EditTeacherService.getInstance();

    @FXML
    void initialize(){
        codeTeacherTextField.setText(service.getTeacher().getCodeTeacher().toString());
        fullNameTextField.setText(service.getTeacher().getFullName());
        phoneTextField.setText(service.getTeacher().getPhone());
        experienceTextField.setText(service.getTeacher().getExperience());
        contractTextField.setText(service.getTeacher().getContract());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteTeacher();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateTeacher(
                    codeTeacherTextField.getText(), fullNameTextField.getText(), phoneTextField.getText(),
                    experienceTextField.getText(), contractTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
