module system.of_accounting.for_the_activities.of_the_driving_school.professional {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens system.of_accounting.for_the_activities.of_the_driving_school.professional to javafx.fxml;
    exports system.of_accounting.for_the_activities.of_the_driving_school.professional;
    opens system.of_accounting.for_the_activities.of_the_driving_school.professional.controller to javafx.fxml;
    exports system.of_accounting.for_the_activities.of_the_driving_school.professional.controller;
    opens system.of_accounting.for_the_activities.of_the_driving_school.professional.entity to javafx.fxml;
    exports system.of_accounting.for_the_activities.of_the_driving_school.professional.entity;
}
