package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepository extends DatabaseHandler {
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();

    public StudentRepository() {
        super();
    }

    public static StudentRepository getInstance() {
        return STUDENT_REPOSITORY;
    }

    public Student findStudent(Long id) {
        Student student = new Student();
        try {
            String request = "select * from student where id_student = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            student.setIdStudent(id);
            student.setFullName(resultSet.getString("full_name"));
            student.setMedInfo(resultSet.getString("med_info"));
            student.setNumberTreaty(resultSet.getString("number_treaty"));
            student.setPhone(resultSet.getString("phone"));
            student.setCodeTeacher(resultSet.getLong("code_teacher"));
            student.setCodeInspector(resultSet.getLong("code_inspector"));
            student.setCodeInstructor(resultSet.getLong("code_instructor"));
            student.setCodeSchool(resultSet.getLong("code_school"));
        } catch (Exception ignored) {
        }
        return student;
    }

    public Long insertStudent(String fullName, String medInfo, String phone) throws SQLException {
        long id = generateNewId("student", "id_student");
        String request = "insert into student (id_student, full_name, med_info, phone) values (?,?,?,?)";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, fullName);
        preparedStatement.setString(3, medInfo);
        preparedStatement.setString(4, phone);
        preparedStatement.executeUpdate();
        return id;
    }

    public void insertStudent(Student student) {
        try {
            String request = "insert into student" +
                    "(id_student, full_name, med_info, phone, number_treaty," +
                    "code_teacher, code_inspector, code_instructor, code_school)" +
                    "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("student", "id_student"));
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getMedInfo());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getNumberTreaty());
            preparedStatement.setLong(6, student.getCodeTeacher());
            preparedStatement.setLong(7, student.getCodeInspector());
            preparedStatement.setLong(8, student.getCodeInstructor());
            preparedStatement.setLong(9, student.getCodeSchool());
            preparedStatement.executeUpdate();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void updateStudent(Long code_school, Long code_teacher, Long code_instructor, Long code_inspector, Long id_student) throws SQLException {
        String request = "update student set code_school = ?, code_teacher = ?, code_instructor = ?, " +
                            "code_inspector = ?, number_treaty = ? where id_student = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        preparedStatement.setLong(1, code_school);
        preparedStatement.setLong(2, code_teacher);
        preparedStatement.setLong(3, code_instructor);
        preparedStatement.setLong(4, code_inspector);
        preparedStatement.setString(5, "0000000");
        preparedStatement.setLong(6, id_student);
        preparedStatement.executeUpdate();
    }

    public void updateStudent(Student student) {
        try {
            String request = "update student set " +
                    "full_name = ?, med_info = ?, phone = ?, " +
                    "code_school = ?, code_teacher = ?, code_instructor = ?, code_inspector = ? " +
                    "where id_student = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getMedInfo());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setLong(4, student.getCodeSchool());
            preparedStatement.setLong(5, student.getCodeTeacher());
            preparedStatement.setLong(6, student.getCodeInstructor());
            preparedStatement.setLong(7, student.getCodeInspector());
            preparedStatement.setLong(8, student.getIdStudent());
            preparedStatement.executeUpdate();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void updateStudentOnAdmin(Student student) {
        try {
            String request = "update student set " +
                    "full_name = ?, med_info = ?, phone = ?, number_treaty = ?, " +
                    "code_school = ?, code_teacher = ?, code_instructor = ?, code_inspector = ? " +
                    "where id_student = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getMedInfo());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getNumberTreaty());
            preparedStatement.setLong(5, student.getCodeSchool());
            preparedStatement.setLong(6, student.getCodeTeacher());
            preparedStatement.setLong(7, student.getCodeInstructor());
            preparedStatement.setLong(8, student.getCodeInspector());
            preparedStatement.setLong(9, student.getIdStudent());
            preparedStatement.executeUpdate();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void updateNumberTreaty(String code, Long id) {
        try {
            String request = "update student set number_treaty = ? where id_student = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, code);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ObservableList<Student> findAllStudent() {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            String request = "select * from student";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setIdStudent(resultSet.getLong("id_student"));
                student.setFullName(resultSet.getString("full_name"));
                student.setMedInfo(resultSet.getString("med_info"));
                student.setNumberTreaty(resultSet.getString("number_treaty"));
                student.setPhone(resultSet.getString("phone"));
                student.setCodeTeacher(resultSet.getLong("code_teacher"));
                student.setCodeInspector(resultSet.getLong("code_inspector"));
                student.setCodeInstructor(resultSet.getLong("code_instructor"));
                student.setCodeSchool(resultSet.getLong("code_school"));

                students.add(student);
            }
        } catch (Exception ignored) {
        }
        return students;
    }

    public void deleteStudent(Long idStudent) {
        try {
            String request = "delete from student where id_student = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, idStudent);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
