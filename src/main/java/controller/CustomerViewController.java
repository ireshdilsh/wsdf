package controller;

import com.jfoenix.controls.JFXTextField;
import dao.CustomerDao;
import entity.CustomerEntity;
import entity.RentEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CustomerViewController {
    public JFXTextField nicText;
    public JFXTextField nameText;
    public JFXTextField mobileText;
    public JFXTextField addessText;
    public AnchorPane pane;

    CustomerDao dao=new CustomerDao();
    public void saveCustomer(ActionEvent event) {
        CustomerEntity entity=new CustomerEntity(Double.parseDouble(nicText.getText()),nameText.getText(), addessText.getText(),Double.parseDouble(mobileText.getText()));
        dao.saveCustomer(entity);
       new  Alert(Alert.AlertType.CONFIRMATION,"Customer added Success").show();
       Clear();
    }
    public void Clear(){
        nameText.setText("");
        nicText.setText("");
        mobileText.setText("");
        addessText.setText("");
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/Dashboard-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void updateCustomer(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/update/Customer-Update-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Customer Update");
        stage.show();
    }

    public void deleteCustomer(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("/view/delete/Customer-Delete-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setTitle("Delete Customer");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
