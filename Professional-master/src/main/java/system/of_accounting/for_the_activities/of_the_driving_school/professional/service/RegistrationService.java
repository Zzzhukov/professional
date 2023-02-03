package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.AuthorizationDataRepository;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.StudentRepository;

public class RegistrationService {
    private static final RegistrationService REGISTRATION_SERVICE = new RegistrationService();

    private RegistrationService() {
    }

    public static RegistrationService getInstance() {
        return REGISTRATION_SERVICE;
    }

    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final AuthorizationDataRepository authorizationDataRepository = AuthorizationDataRepository.getInstance();

    public String registration(String fullName, String medInfo, String phone,
                               String login, String password, String confirmationPassword) {
        if (!confirmationPassword.equals(password))
            return "passwords don't match";
        if (fullName.equals(""))
            return "name is empty";
        if (medInfo.equals(""))
            return "med info is empty";
        if (phone.equals(""))
            return "phone is empty";
        if (phone.length() < 11)
            return "short phone";
        if (phone.length() > 11)
            return "long phone";
        if (login.equals(""))
            return "login is empty";
        if (password.equals(""))
            return "password is empty";
        if (login.length() < 3)
            return "short login";
        if (password.length() < 3)
            return "short password";

        try {
            Long studentId = studentRepository.insertStudent(fullName, medInfo, phone);
            authorizationDataRepository.insertAuthorizationData(login, password, "student", studentId);
            return "success";
        } catch (Exception exception) {
            return "error";
        }
    }
}
