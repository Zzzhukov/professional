package system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.service.StudentWorkspaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentWorkspaceController extends Controller {
    @FXML
    private Button exitButton;
    @FXML
    private Button userButton;
    @FXML
    private ImageView logoImageView;
    @FXML
    private Button mondayButton;
    @FXML
    private Button tuesdayButton;
    @FXML
    private Button wednesdayButton;
    @FXML
    private Button thursdayButton;
    @FXML
    private Button fridayButton;
    @FXML
    private Button saturdayButton;
    @FXML
    private Button sundayButton;

    private final StudentWorkspaceService service = StudentWorkspaceService.getInstance();

    private final List<Button> buttonList = new ArrayList<>();

    @FXML
    void initialize() {
        buttonList.add(mondayButton);
        buttonList.add(tuesdayButton);
        buttonList.add(wednesdayButton);
        buttonList.add(thursdayButton);
        buttonList.add(fridayButton);
        buttonList.add(saturdayButton);
        buttonList.add(sundayButton);

        setDays();

        exitButton.setOnMouseClicked(mouseEvent -> {
            setWeek();
            openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/authorization.fxml", exitButton);
        });
        userButton.setOnMouseClicked(mouseEvent -> {
            setWeek();
            service.sendStudent();
            openOtherWindow("/system/of_accounting/for_the_activities/of_the_driving_school/professional/layout/student_account.fxml", userButton);
        });
        logoImageView.setOnMouseClicked(mouseEvent -> setWeek());
        for (Button button : buttonList) {
            button.setOnMouseClicked(mouseEvent -> {
                if (button.getStyle().equals("-fx-background-color: #a3addd; -fx-border-color: #535353;")) {
                    button.setStyle("-fx-background-color:  #8ebf9c; -fx-border-color: #535353;");
                }
                else {
                    button.setStyle("-fx-background-color: #a3addd; -fx-border-color: #535353;");
                }
            });
        }
    }

    private void setWeek(){
        StringBuilder code = new StringBuilder();
        for (Button button : buttonList) {
            if (button.getStyle().equals("-fx-background-color:  #8ebf9c; -fx-border-color: #535353;"))
                code.append(1);
            else
                code.append(0);
        }
        service.setCode(code.toString());
    }

    private void setDays(){
        String code = service.getCode();
        String[] codeArray = code.split("");
        for (int i = 0; i < 7; i++) {
            if (Objects.equals(codeArray[i], "1"))
                buttonList.get(i).setStyle("-fx-background-color:  #8ebf9c; -fx-border-color: #535353;");
            else
                buttonList.get(i).setStyle("-fx-background-color: #a3addd; -fx-border-color: #535353;");
        }
    }
}
