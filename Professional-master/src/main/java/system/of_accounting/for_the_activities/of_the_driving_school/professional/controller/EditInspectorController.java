package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditInspectorService;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditInstructorService;

public class EditInspectorController extends Controller{
    @FXML
    private Button backButton;

    @FXML
    private Button enterButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField idInspectorTextField;

    @FXML
    private TextField jobTitleTextField;

    @FXML
    private TextField phoneTextField;

    private final EditInspectorService service = EditInspectorService.getInstance();

    @FXML
    void initialize(){
        idInspectorTextField.setText(service.getInspector().getIdInspector().toString());
        fullNameTextField.setText(service.getInspector().getFullName());
        phoneTextField.setText(service.getInspector().getPhone());
        jobTitleTextField.setText(service.getInspector().getJobTitle());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteInspector();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateInspector(
                    idInspectorTextField.getText(), fullNameTextField.getText(),
                    phoneTextField.getText(), jobTitleTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
