package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.StudentAccountService;

public class StudentAccountController extends Controller {
    @FXML
    private Button acceptButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private ComboBox<String> inspectorChoiceComboBox;

    @FXML
    private ComboBox<String> instructorChoiceComboBox;

    @FXML
    private TextField medInfoTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ComboBox<String> schoolChoiceComboBox;

    @FXML
    private ComboBox<String> teacherChoiceComboBox;

    private final StudentAccountService service = StudentAccountService.getInstance();

    @FXML
    void initialize() {
        idTextField.setText(service.getStudent().getIdStudent().toString());
        fullNameTextField.setText(service.getStudent().getFullName());
        medInfoTextField.setText(service.getStudent().getMedInfo());
        phoneTextField.setText(service.getStudent().getPhone());

        schoolChoiceComboBox.setItems(service.getSchools());
        teacherChoiceComboBox.setItems(service.getTeachers());
        instructorChoiceComboBox.setItems(service.getInstructors());
        inspectorChoiceComboBox.setItems(service.getInspectors());

        schoolChoiceComboBox.setValue(service.getThisSchool());
        teacherChoiceComboBox.setValue(service.getThisTeacher());
        instructorChoiceComboBox.setValue(service.getThisInstructor());
        inspectorChoiceComboBox.setValue(service.getThisInspector());

        exitButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/student_workspace.fxml", exitButton));
        acceptButton.setOnMouseClicked(mouseEvent -> updateStudent());
    }

    private void updateStudent() {
        String response = service.updateStudent(
                fullNameTextField.getText(),
                medInfoTextField.getText(),
                phoneTextField.getText(),
                schoolChoiceComboBox.getValue(),
                teacherChoiceComboBox.getValue(),
                instructorChoiceComboBox.getValue(),
                inspectorChoiceComboBox.getValue()
        );

        switch (response) {
            case "short fullName" -> idTextField.setText("Короткое ФИО");
            case "short medInfo" -> idTextField.setText("Короткая мед.информация");
            case "short phone" -> idTextField.setText("Короткий телефон");
            case "long phone" -> idTextField.setText("Длинный телефон");
            case "success" -> openOtherWindow(
                    "/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/student_workspace.fxml", exitButton);
            default -> idTextField.setText("Ошибка");
        }
    }
}
