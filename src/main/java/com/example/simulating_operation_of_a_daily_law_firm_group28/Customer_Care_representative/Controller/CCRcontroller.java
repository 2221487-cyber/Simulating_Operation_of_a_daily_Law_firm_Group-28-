package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CCRcontroller
{
    @javafx.fxml.FXML
    private Label labelasCCR;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonScheduleAppoinment(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_Appoinment_schedule.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonLogoutasCCR(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void buttonRecordIunquiry(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_Inquiry_record.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonUpdateCase(ActionEvent actionEvent) throws IOException{
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_Case_update.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonViewFeedback(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_Client_feedback.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonCustomerCareMenu(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void buttonGenerateReport(ActionEvent actionEvent)  {

    }

    @javafx.fxml.FXML
    public void buttonViewLawyer(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_View_Lawyer_Profile.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonRegNewClient(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_Client_register.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonSearchClient(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR_Client_search.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }
}