package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.ClientWorkspaceService;

public class ClientWorkspaceController extends Controller {
    @FXML
    private Button acceptButton;

    @FXML
    private Button exitButton;

    @FXML
    private ComboBox<String> inspectorChoiceComboBox;

    @FXML
    private ComboBox<String> instructorChoiceComboBox;

    @FXML
    private ComboBox<String> schoolChoiceComboBox;

    @FXML
    private ComboBox<String> teacherChoiceComboBox;

    ClientWorkspaceService service = ClientWorkspaceService.getInstance();

    @FXML
    void initialize() {
        schoolChoiceComboBox.setItems(service.getSchools());
        teacherChoiceComboBox.setItems(service.getTeachers());
        instructorChoiceComboBox.setItems(service.getInstructor());
        inspectorChoiceComboBox.setItems(service.getInspector());

        exitButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/authorization.fxml", exitButton));
        schoolChoiceComboBox.setOnAction(actionEvent -> teacherChoiceComboBox.setVisible(true));
        teacherChoiceComboBox.setOnAction(actionEvent -> instructorChoiceComboBox.setVisible(true));
        instructorChoiceComboBox.setOnAction(actionEvent -> inspectorChoiceComboBox.setVisible(true));
        inspectorChoiceComboBox.setOnAction(actionEvent -> acceptButton.setVisible(true));
        acceptButton.setOnMouseClicked(mouseEvent -> {
            try {
                service.complementStudentInfo(
                        schoolChoiceComboBox.getValue(),
                        teacherChoiceComboBox.getValue(),
                        instructorChoiceComboBox.getValue(),
                        inspectorChoiceComboBox.getValue()
                );
                openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/authorization.fxml", acceptButton);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
