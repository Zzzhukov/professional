package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherRepository extends DatabaseHandler {
    private static final TeacherRepository TEACHER_REPOSITORY = new TeacherRepository();

    public TeacherRepository() {
        super();
    }

    public static TeacherRepository getInstance() {
        return TEACHER_REPOSITORY;
    }

    public ObservableList<Teacher> findAllTeacher() {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        try {
            String request = "select * from teacher";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setCodeTeacher(resultSet.getLong("code_teacher"));
                teacher.setFullName(resultSet.getString("full_name"));
                teacher.setExperience(resultSet.getString("experience"));
                teacher.setContract(resultSet.getString("contract"));
                teacher.setPhone(resultSet.getString("phone"));

                teachers.add(teacher);
            }
        } catch (Exception ignored) {
        }
        return teachers;
    }

    public void insertTeacher(Teacher teacher) {
        try {
            String request = "insert into teacher (code_teacher, full_name, phone, contract, experience) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("teacher", "code_teacher"));
            preparedStatement.setString(2, teacher.getFullName());
            preparedStatement.setString(3, teacher.getPhone());
            preparedStatement.setString(4, teacher.getContract());
            preparedStatement.setString(5, teacher.getExperience());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateTeacher(Teacher teacher) {
        try {
            String request = "update teacher set full_name = ?, phone = ?, contract = ?, experience = ? where code_teacher = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, teacher.getFullName());
            preparedStatement.setString(2, teacher.getPhone());
            preparedStatement.setString(3, teacher.getContract());
            preparedStatement.setString(4, teacher.getExperience());
            preparedStatement.setLong(5, teacher.getCodeTeacher());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteTeacher(Long codeTeacher) {
        try {
            String request = "delete from teacher where code_teacher = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, codeTeacher);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
