package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public ImageView pane;
    public Pane pane1;
    public JFXTextField usernameText;
    public JFXPasswordField passwordText;

    public void signupMethod(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/Signup-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setTitle("Register");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void LoginMethod(ActionEvent event) throws IOException {

        if (usernameText.getText().isEmpty() && passwordText.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please Fill username and password Field").show();
        }else if (usernameText.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter Your Username").show();
        } else if (passwordText.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Please enter Your Password").show();
        } else{
    //////////////    add validation part     ////////////////////
        Parent root= FXMLLoader.load(getClass().getResource("/view/Dashboard-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root));
        stage.show();}
    }
}
