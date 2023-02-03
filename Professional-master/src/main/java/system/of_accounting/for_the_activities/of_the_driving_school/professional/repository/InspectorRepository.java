package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Inspector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InspectorRepository extends DatabaseHandler {
    private static final InspectorRepository INSPECTOR_REPOSITORY = new InspectorRepository();

    public InspectorRepository() {
        super();
    }

    public static InspectorRepository getInstance() {
        return INSPECTOR_REPOSITORY;
    }

    public ObservableList<Inspector> findAllInspector() {
        ObservableList<Inspector> inspectors = FXCollections.observableArrayList();
        try {
            String request = "select * from inspector";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Inspector inspector = new Inspector();
                inspector.setIdInspector(resultSet.getLong("id_inspector"));
                inspector.setFullName(resultSet.getString("full_name"));
                inspector.setPhone(resultSet.getString("phone"));
                inspector.setJobTitle(resultSet.getString("job_title"));

                inspectors.add(inspector);
            }
        } catch (Exception ignored) {
        }
        return inspectors;
    }

    public void insertInspector(Inspector inspector) {
        try {
            String request = "insert into inspector (id_inspector, full_name, phone, job_title) values (?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("inspector", "id_inspector"));
            preparedStatement.setString(2, inspector.getFullName());
            preparedStatement.setString(3, inspector.getPhone());
            preparedStatement.setString(4, inspector.getJobTitle());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateInspector(Inspector inspector) {
        try {
            String request = "update inspector set full_name = ?, phone = ?, job_title = ? where id_inspector = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, inspector.getFullName());
            preparedStatement.setString(2, inspector.getPhone());
            preparedStatement.setString(3, inspector.getJobTitle());
            preparedStatement.setLong(4, inspector.getIdInspector());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteInspector(Long idInspector) {
        try {
            String request = "delete from inspector where id_inspector = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, idInspector);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
