package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditAuthorizationDataService;

public class EditAuthorizationDataController extends Controller {
    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button enterButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField userIdTextField;

    private final EditAuthorizationDataService service = EditAuthorizationDataService.getInstance();

    @FXML
    void initialize(){
        idTextField.setText(service.getAuthorizationData().getId().toString());
        loginTextField.setText(service.getAuthorizationData().getLogin());
        passwordTextField.setText(service.getAuthorizationData().getPassword());
        typeTextField.setText(service.getAuthorizationData().getType());
        userIdTextField.setText(service.getAuthorizationData().getUserId().toString());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteAuthorizationData();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateAuthorizationData(
                    idTextField.getText(), loginTextField.getText(), passwordTextField.getText(),
                    typeTextField.getText(), userIdTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
