package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditInstructorService;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditTeacherService;

public class EditInstructorController extends Controller {
    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField categoryTextField;

    @FXML
    private TextField contractTextField;

    @FXML
    private Button enterButton;

    @FXML
    private TextField experienceTextField;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField idInstructorTextField;

    @FXML
    private TextField phoneTextField;

    private final EditInstructorService service = EditInstructorService.getInstance();

    @FXML
    void initialize(){
        idInstructorTextField.setText(service.getInstructor().getIdInstructor().toString());
        fullNameTextField.setText(service.getInstructor().getFullName());
        phoneTextField.setText(service.getInstructor().getPhone());
        experienceTextField.setText(service.getInstructor().getExperience());
        categoryTextField.setText(service.getInstructor().getCategory());
        contractTextField.setText(service.getInstructor().getContract());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteInstructor();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateInstructor(
                    idInstructorTextField.getText(), fullNameTextField.getText(), phoneTextField.getText(),
                    experienceTextField.getText(), categoryTextField.getText(), contractTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
