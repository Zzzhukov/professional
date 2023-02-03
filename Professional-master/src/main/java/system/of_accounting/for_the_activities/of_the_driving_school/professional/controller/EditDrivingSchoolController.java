package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditDrivingSchoolService;

public class EditDrivingSchoolController extends Controller {
    @FXML
    private TextField addressTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField codeBossTextField;

    @FXML
    private TextField codeSchoolTextField;

    @FXML
    private Button enterButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField servicesTextField;

    private final EditDrivingSchoolService service = EditDrivingSchoolService.getInstance();

    @FXML
    void initialize(){
        codeSchoolTextField.setText(service.getDrivingSchool().getCodeSchool().toString());
        nameTextField.setText(service.getDrivingSchool().getName());
        priceTextField.setText(service.getDrivingSchool().getPrice().toString());
        servicesTextField.setText(service.getDrivingSchool().getServices());
        addressTextField.setText(service.getDrivingSchool().getAddress());
        codeBossTextField.setText(service.getDrivingSchool().getCodeBoss().toString());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteDrivingSchool();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateDrivingSchool(
                    codeSchoolTextField.getText(), nameTextField.getText(), priceTextField.getText(),
                    servicesTextField.getText(), addressTextField.getText(), codeBossTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
