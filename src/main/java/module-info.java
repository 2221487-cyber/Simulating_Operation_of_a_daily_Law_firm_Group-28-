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

    // Open Firm Owner packages to JavaFX
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

    // Open Court Clerk Client packages to JavaFX
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.controllers to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.controllers;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.models to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.models;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.utils to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.utils;

    // Open Lawyer Legal Researcher packages to JavaFX
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.lawyer to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.lawyer;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models;
    opens com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils to javafx.fxml;
    exports com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils;
}