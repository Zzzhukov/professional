package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.AuthorizationService;

public class AuthorizationController extends Controller {
    AuthorizationService service = AuthorizationService.getInstance();
    @FXML
    private Label errorLabel;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button registrationButton;

    @FXML
    void initialize() {
        registrationButton.setOnAction(actionEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/registration.fxml", registrationButton));
        passwordTextField.setOnAction(actionEvent -> authorization());
        errorLabel.setOnMouseClicked(mouseEvent -> authorization());
        logoImageView.setOnMouseClicked(mouseEvent -> authorization());
    }

    private void authorization() {
        String response = service.authorization(loginTextField.getText(), passwordTextField.getText());
        switch (response) {
            case "login is empty" -> errorLabel.setText("Поле логина пустое");
            case "short login" -> errorLabel.setText("Короткий логин");
            case "password is empty" -> errorLabel.setText("Поле пароля пустое");
            case "short password" -> errorLabel.setText("Короткий пароль");
            case "user not found" -> errorLabel.setText("Пользователь не найден");
            case "incorrect password" -> errorLabel.setText("Неверный пароль");
            case "client" -> openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/client_workspace.fxml", passwordTextField);
            case "student" -> openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/student_workspace.fxml", passwordTextField);
            case "administrator" -> openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/administrator_workspace.fxml", passwordTextField);
            default -> errorLabel.setText("Ошибка");
        }
    }
}
