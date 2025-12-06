package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class ACCcontroller {
    @javafx.fxml.FXML
    private Label labelasAcccountant;
    Stage stg;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonLogoutAsAccountant(ActionEvent actionEvent) {
//        Parent sceneParent = FXMLLoader.load(getClass().getResource(".fxml"));

//        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

//        Stage stg=new Stage();

//        stg.setScene(scene2);
//        stg.setScene(scene2);
//        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonOutstandingbalance(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Outstanding_balance.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonRecordPayment(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Record_payment.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttongenerateBill(ActionEvent actionEvent)throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Generate_billing.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonGenereateReceipt(ActionEvent actionEvent) throws IOException{
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Generate_receipt.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonRecordexpense(ActionEvent actionEvent)throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Expense_record.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonAccountantMenu(ActionEvent actionEvent) {

    }


    @javafx.fxml.FXML
    public void buttonCommission(ActionEvent actionEvent)throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Commission_calculate.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonFinancialReport(ActionEvent actionEvent)throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Financial_report.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }

    @javafx.fxml.FXML
    public void buttonCashFlowForecast(ActionEvent actionEvent)throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Accountant/Acc_Cash_flow_forecast.fxml"));

        Scene scene2=new Scene(sceneParent);


//        stg= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stg = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Stage stg=new Stage();

        stg.setScene(scene2);
//        stg.setScene(scene2);
        stg.show();
    }
}