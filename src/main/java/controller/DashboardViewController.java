package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardViewController {
    public BorderPane borderpane;

    public void gotoCustomerView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customer-View.fxml"));
        borderpane.setCenter(root);
    }

    public void gotoUserView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/User-View.fxml"));
        borderpane.setCenter(root);
    }

    public void gotoCarView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Car-View.fxml"));
        borderpane.setCenter(root);
    }

    public void gotoRentView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Rent-View.fxml"));
        borderpane.setCenter(root);
    }

    public void gotoCarCategoryView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Car-Category-View.fxml"));
        borderpane.setCenter(root);
    }

    public void gotoLogin(ActionEvent event) throws IOException {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setContentText("Do You Want Log out Your Account ?");

        if (alert.showAndWait().get()== ButtonType.OK){

        Parent root = FXMLLoader.load(getClass().getResource("/view/Login-View.fxml"));
        Stage stage = (Stage) this.borderpane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Log in");
        stage.show();
        }
    }
}
