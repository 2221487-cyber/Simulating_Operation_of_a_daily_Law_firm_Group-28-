package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.LawyerProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CCR_View_Lawyer_Profilecontroller
{
    @javafx.fxml.FXML
    private TableColumn<LawyerProfile, String> TClawyerlistAvailable;
    @javafx.fxml.FXML
    private TableColumn<LawyerProfile, String> TClawyerlistExpertise;
    @javafx.fxml.FXML
    private TableColumn<LawyerProfile, String> TCLawyerlistname;
    @javafx.fxml.FXML
    private TableView<LawyerProfile> TVLawyerList;
    @javafx.fxml.FXML
    private TableColumn<LawyerProfile, String> TCLawyerid;

    private ObservableList<LawyerProfile> lawyerList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        TCLawyerid.setCellValueFactory(new PropertyValueFactory<>("lawyerId"));
        TCLawyerlistname.setCellValueFactory(new PropertyValueFactory<>("name"));
        TClawyerlistExpertise.setCellValueFactory(new PropertyValueFactory<>("expertise"));
        TClawyerlistAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));

        // Load sample lawyer data
        loadLawyerData();
    }

    private void loadLawyerData() {
        lawyerList.add(new LawyerProfile("LAW001", "John Smith", "Criminal Law", "Available"));
        lawyerList.add(new LawyerProfile("LAW002", "Sarah Johnson", "Civil Law", "Available"));
        lawyerList.add(new LawyerProfile("LAW003", "Michael Brown", "Family Law", "Busy"));
        lawyerList.add(new LawyerProfile("LAW004", "Emily Davis", "Corporate Law", "Available"));
        lawyerList.add(new LawyerProfile("LAW005", "David Wilson", "Tax Law", "Available"));

        TVLawyerList.setItems(lawyerList);
    }

    @javafx.fxml.FXML
    public void buttonViewLawyersBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TVLawyerList.getScene().getWindow();
        stage.close();
    }
}