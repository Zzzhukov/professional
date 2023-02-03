package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Boss;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BossRepository extends DatabaseHandler {
    private static final BossRepository BOSS_REPOSITORY = new BossRepository();

    public BossRepository() {
        super();
    }

    public static BossRepository getInstance() {
        return BOSS_REPOSITORY;
    }

    public ObservableList<Boss> findAllBoss() {
        ObservableList<Boss> bosses = FXCollections.observableArrayList();
        try {
            String request = "select * from boss";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Boss boss = new Boss();
                boss.setIdBoss(resultSet.getLong("code_boss"));
                boss.setFullName(resultSet.getString("full_name"));
                boss.setExperience(resultSet.getString("experience"));
                boss.setPhone(resultSet.getString("phone"));

                bosses.add(boss);
            }
        } catch (Exception ignored) {
        }
        return bosses;
    }

    public void insertBoss(Boss boss) {
        try {
            String request = "insert into boss (code_boss, full_name, phone, experience) values (?,?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("boss", "code_boss"));
            preparedStatement.setString(2, boss.getFullName());
            preparedStatement.setString(3, boss.getPhone());
            preparedStatement.setString(4, boss.getExperience());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateBoss(Boss boss) {
        try {
            String request = "update boss set full_name = ?, phone = ?, experience = ? where code_boss = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setString(1, boss.getFullName());
            preparedStatement.setString(2, boss.getPhone());
            preparedStatement.setString(3, boss.getExperience());
            preparedStatement.setLong(4, boss.getIdBoss());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteBoss(Long codeBoss) {
        try {
            String request = "delete from boss where code_boss = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, codeBoss);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
