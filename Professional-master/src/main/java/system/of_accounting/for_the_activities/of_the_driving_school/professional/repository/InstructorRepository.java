package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Instructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InstructorRepository extends DatabaseHandler {
    private static final InstructorRepository INSTRUCTOR_REPOSITORY = new InstructorRepository();

    public InstructorRepository() {
        super();
    }

    public static InstructorRepository getInstance() {
        return INSTRUCTOR_REPOSITORY;
    }

    public ObservableList<Instructor> findAllInstructor() {
        ObservableList<Instructor> instructors = FXCollections.observableArrayList();
        try {
            String request = "select * from instructor";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Instructor instructor = new Instructor();
                instructor.setIdInstructor(resultSet.getLong("id_instructor"));
                instructor.setFullName(resultSet.getString("full_name"));
                instructor.setExperience(resultSet.getString("experience"));
                instructor.setCategory(resultSet.getString("category"));
                instructor.setContract(resultSet.getString("contract"));
                instructor.setPhone(resultSet.getString("phone"));

                instructors.add(instructor);
            }
        } catch (Exception ignored) {
        }
        return instructors;
    }

    public void insertInstructor(Instructor instructor) {
        try {
            String request = "insert into instructor (id_instructor, full_name, phone, contract, category, experience) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("instructor", "id_instructor"));
            preparedStatement.setString(2, instructor.getFullName());
            preparedStatement.setString(3, instructor.getPhone());
            preparedStatement.setString(4, instructor.getContract());
            preparedStatement.setString(5, instructor.getCategory());
            preparedStatement.setString(6, instructor.getExperience());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateInstructor(Instructor instructor) {
        try {
            String request = "update instructor set full_name = ?, phone = ?, contract = ?, experience = ?, category = ? where id_instructor = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, instructor.getFullName());
            preparedStatement.setString(2, instructor.getPhone());
            preparedStatement.setString(3, instructor.getContract());
            preparedStatement.setString(4, instructor.getExperience());
            preparedStatement.setString(5, instructor.getCategory());
            preparedStatement.setLong(6, instructor.getIdInstructor());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteInstructor(Long idInstructor) {
        try {
            String request = "delete from instructor where id_instructor = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, idInstructor);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
