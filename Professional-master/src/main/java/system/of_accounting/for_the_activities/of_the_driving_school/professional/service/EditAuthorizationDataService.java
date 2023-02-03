package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.AuthorizationData;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.AuthorizationDataRepository;

import java.sql.SQLException;

public class EditAuthorizationDataService {
    private static final EditAuthorizationDataService EDIT_AUTHORIZATION_DATA_SERVICE = new EditAuthorizationDataService();

    private EditAuthorizationDataService() {
    }

    public static EditAuthorizationDataService getInstance() {
        return EDIT_AUTHORIZATION_DATA_SERVICE;
    }

    private final AuthorizationDataRepository authorizationDataRepository = AuthorizationDataRepository.getInstance();

    private AuthorizationData authorizationData;

    public void updateAuthorizationData(String id, String login, String password, String type, String userId) {
        authorizationData.setId(Long.parseLong(id));
        authorizationData.setLogin(login);
        authorizationData.setPassword(password);
        authorizationData.setType(type);
        authorizationData.setUserId(Long.parseLong(userId));
        try {
            if (id.equals("0")) {
                authorizationDataRepository.insertAuthorizationData(
                        authorizationData.getLogin(), authorizationData.getPassword(),
                        authorizationData.getType(), authorizationData.getUserId());
            } else {
                authorizationDataRepository.updateAuthorizationData(authorizationData);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public AuthorizationData getAuthorizationData() {
        return authorizationData;
    }

    public void setAuthorizationData(AuthorizationData authorizationData) {
        this.authorizationData = authorizationData;
    }

    public void deleteAuthorizationData() {
        authorizationDataRepository.deleteAuthorizationData(authorizationData.getId());
    }
}
