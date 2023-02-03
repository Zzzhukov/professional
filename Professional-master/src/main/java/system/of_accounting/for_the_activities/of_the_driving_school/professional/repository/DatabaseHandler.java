package system.of_accounting.for_the_activities.of_the_driving_school.professional.repository;

import java.sql.*;

public class DatabaseHandler {
    DatabaseHandler() {
        String connectionString = "jdbc:postgresql://localhost:5432/professional";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbConnection = DriverManager.getConnection(connectionString, "postgres", "890123890123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    final Connection dbConnection;

    long generateNewId(String table, String id) throws SQLException {
        String request = "select " + id + " from " + table;
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        ResultSet resultSet = preparedStatement.executeQuery();
        long newId = 0;
        try {
            while (resultSet.next()) {
                long thisId = Long.parseLong(resultSet.getString(id));
                if (newId < thisId) {
                    newId = thisId;
                }
            }
        } catch (Exception ignored) {
        }
        return ++newId;
    }
}
