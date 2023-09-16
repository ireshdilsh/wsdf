package controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dao.UserDao;
import entity.CarCategoriEntity;
import entity.CustomerEntity;
import entity.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    public AnchorPane pane;
    public TextField nameText;
    public TextField usernameText;
    public TextField addressText;
    public PasswordField passwordText;
    public TextField IdTEXT;
    public JFXTextField gmailText;
    public JFXRadioButton agreeandRadio;

    UserDao dao=new UserDao();

    public void userRegisterMethod(ActionEvent event) throws IOException {
        UserEntity entity=new UserEntity(nameText.getText(), addressText.getText(), gmailText.getText(), usernameText.getText(), passwordText.getText());
        dao.userRegisterMethod(entity);
      new Alert(Alert.AlertType.CONFIRMATION,"Success Added").show();
      Clear();
    }
public void Clear(){
        nameText.setText("");
        addressText.setText("");
        gmailText.setText("");
        usernameText.setText("");
        passwordText.setText("");
}
    public void backToLoginFormMethod(ActionEvent event) throws IOException {
        new Alert(Alert.AlertType.CONFIRMATION,"Do You Want goto Log in page ?").show();

            Parent root= FXMLLoader.load(getClass().getResource("/view/Login-View.fxml"));
            Stage stage= (Stage) this.pane.getScene().getWindow();
            stage.setTitle("Log in");
            stage.setScene(new Scene(root));
            stage.show();

    }
}
