package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Student;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.AuthorizationDataRepository;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.AuthorizationData;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.StudentRepository;

public class AuthorizationService {
    private static final AuthorizationService AUTHORIZATION_SERVICE = new AuthorizationService();

    private AuthorizationService() {
    }

    public static AuthorizationService getInstance() {
        return AUTHORIZATION_SERVICE;
    }

    private final AuthorizationDataRepository authorizationDataRepository = AuthorizationDataRepository.getInstance();
    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final ClientWorkspaceService clientWorkspaceService = ClientWorkspaceService.getInstance();
    private final StudentWorkspaceService studentWorkspaceService = StudentWorkspaceService.getInstance();

    public String authorization(String login, String password) {
        if (login.equals(""))
            return "login is empty";
        if (login.length() < 3)
            return "short login";
        if (password.equals(""))
            return "password is empty";
        if (password.length() < 3)
            return "short password";

        try {
            AuthorizationData responseAuthorizationData = authorizationDataRepository.authorization(login, password);
            if (responseAuthorizationData.getType().equals("student")) {
                Student student = studentRepository.findStudent(responseAuthorizationData.getUserId());
                if (student.getNumberTreaty() != null) {
                    studentWorkspaceService.setStudent(student);
                    return "student";
                } else {
                    clientWorkspaceService.setStudent(student);
                    return "client";
                }
            }
            return "administrator";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }
}
