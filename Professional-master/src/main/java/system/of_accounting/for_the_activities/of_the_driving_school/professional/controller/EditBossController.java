package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.EditBossService;

public class EditBossController extends Controller{
    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button enterButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField idBossTextField;

    @FXML
    private TextField experienceTextField;

    @FXML
    private TextField phoneTextField;

    private final EditBossService service = EditBossService.getInstance();

    @FXML
    void initialize(){
        idBossTextField.setText(service.getBoss().getIdBoss().toString());
        fullNameTextField.setText(service.getBoss().getFullName());
        phoneTextField.setText(service.getBoss().getPhone());
        experienceTextField.setText(service.getBoss().getExperience());

        deleteButton.setOnMouseClicked(mouseEvent -> {
            service.deleteBoss();
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", deleteButton);
        });
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", backButton));
        enterButton.setOnMouseClicked(mouseEvent -> {
            service.updateBoss(
                    idBossTextField.getText(), fullNameTextField.getText(),
                    phoneTextField.getText(), experienceTextField.getText());
            openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", enterButton);
        });
    }
}
