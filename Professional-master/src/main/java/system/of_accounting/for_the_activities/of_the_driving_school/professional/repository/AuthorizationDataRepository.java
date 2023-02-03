package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.AuthorizationData;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.exception.IncorrectPasswordException;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.exception.UserNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationDataRepository extends DatabaseHandler{
    private static final AuthorizationDataRepository AUTHORIZATION_DATA_REPOSITORY = new AuthorizationDataRepository();

    public static AuthorizationDataRepository getInstance() {
        return AUTHORIZATION_DATA_REPOSITORY;
    }
    public AuthorizationDataRepository() {
        super();
    }

    public AuthorizationData authorization(String login, String password) throws Exception {
        String request = "select * from authorization_data where login = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            throw new UserNotFoundException();
        }
        String request2 = "select * from authorization_data where login = ? and password = ?";
        preparedStatement = dbConnection.prepareStatement(request2);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            throw new IncorrectPasswordException();
        }
        AuthorizationData authorizationData = new AuthorizationData();
        authorizationData.setId(resultSet.getLong("id"));
        authorizationData.setType(resultSet.getString("type"));
        authorizationData.setUserId(resultSet.getLong("user_id"));
        return authorizationData;
    }

    public void insertAuthorizationData(String login, String password, String type, Long userId) throws SQLException {
        long id = generateNewId("authorization_data", "id");
        String request = "insert into authorization_data (id, login, password, type, user_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, login);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, type);
        preparedStatement.setLong(5, userId);
        preparedStatement.executeUpdate();
    }

    public ObservableList<AuthorizationData> findAllAuthorizationData() {
        ObservableList<AuthorizationData> teachers = FXCollections.observableArrayList();
        try {
            String request = "select * from authorization_data";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AuthorizationData authorizationData = new AuthorizationData();
                authorizationData.setId(resultSet.getLong("id"));
                authorizationData.setLogin(resultSet.getString("login"));
                authorizationData.setPassword(resultSet.getString("password"));
                authorizationData.setType(resultSet.getString("type"));
                authorizationData.setUserId(resultSet.getLong("user_id"));

                teachers.add(authorizationData);
            }
        } catch (Exception ignored) {
        }
        return teachers;
    }

    public void updateAuthorizationData(AuthorizationData authorizationData) {
        try {
            String request = "update authorization_data set login = ?, password = ?, type = ?, user_id = ? where id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, authorizationData.getLogin());
            preparedStatement.setString(2, authorizationData.getPassword());
            preparedStatement.setString(3, authorizationData.getType());
            preparedStatement.setLong(4, authorizationData.getUserId());
            preparedStatement.setLong(5, authorizationData.getId());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteAuthorizationData(Long id) {
        try {
            String request = "delete from authorization_data where id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
