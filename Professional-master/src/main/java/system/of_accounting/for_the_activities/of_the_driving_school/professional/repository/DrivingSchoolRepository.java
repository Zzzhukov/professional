package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.DrivingSchool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DrivingSchoolRepository extends DatabaseHandler {
    private static final DrivingSchoolRepository DRIVING_SCHOOL_REPOSITORY = new DrivingSchoolRepository();

    public DrivingSchoolRepository() {
        super();
    }

    public static DrivingSchoolRepository getInstance() {
        return DRIVING_SCHOOL_REPOSITORY;
    }

    public ObservableList<DrivingSchool> findAllDrivingSchool() {
        ObservableList<DrivingSchool> schools = FXCollections.observableArrayList();
        try {
            String request = "select * from driving_school";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DrivingSchool school = new DrivingSchool();
                school.setCodeSchool(resultSet.getLong("code_school"));
                school.setName(resultSet.getString("name"));
                school.setPrice(resultSet.getDouble("price"));
                school.setServices(resultSet.getString("services"));
                school.setAddress(resultSet.getString("address"));
                school.setCodeBoss(resultSet.getLong("code_boss"));

                schools.add(school);
            }
        } catch (Exception ignored) {
        }
        return schools;
    }

    public void insertDrivingSchool(DrivingSchool drivingSchool) {
        try {
            String request = "insert into driving_school (code_school, name, price, services, address, code_boss) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("driving_school", "code_school"));
            preparedStatement.setString(2, drivingSchool.getName());
            preparedStatement.setDouble(3, drivingSchool.getPrice());
            preparedStatement.setString(4, drivingSchool.getServices());
            preparedStatement.setString(5, drivingSchool.getAddress());
            preparedStatement.setLong(6, drivingSchool.getCodeBoss());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateDrivingSchool(DrivingSchool drivingSchool) {
        try {
            String request = "update driving_school set name = ?, price = ?, services = ?, address = ?, code_boss = ? where code_school = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, drivingSchool.getName());
            preparedStatement.setDouble(2, drivingSchool.getPrice());
            preparedStatement.setString(3, drivingSchool.getServices());
            preparedStatement.setString(4, drivingSchool.getAddress());
            preparedStatement.setLong(5, drivingSchool.getCodeBoss());
            preparedStatement.setLong(6, drivingSchool.getCodeSchool());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteDrivingSchool(Long codeSchool) {
        try {
            String request = "delete from driving_school where code_school = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, codeSchool);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
