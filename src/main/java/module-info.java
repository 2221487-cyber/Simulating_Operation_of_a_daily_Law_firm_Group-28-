module com.example.simulating_operation_of_a_daily_law_firm_group28 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    // Open main package to JavaFX
    opens com.example.simulating_operation_of_a_daily_law_firm_group28 to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28;

    // Open Customer Care Representative packages to JavaFX
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

    // Open Accountant packages to JavaFX
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

    // Export Storage package
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.Storage;
}