package controller.delete;

import com.jfoenix.controls.JFXTextField;
import dao.CustomerDao;
import entity.CustomerEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.Alert.*;

public class CustomerDeleteViewController {
    public JFXTextField idText;
    public AnchorPane pane;

    public void deleteCustomer(ActionEvent event) {
        Alert alert=new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Do You want Delete Customer");
        alert.setTitle("Delete Customer");
        if (alert.showAndWait().get()==ButtonType.OK){
        CustomerDao dao=new CustomerDao();
        int id= Integer.parseInt(idText.getText());
       CustomerEntity entity= dao.deleteCustomer(id);
       idText.setText("");
       }
    }

    public void gotoCustomerView(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/Dashboard-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setTitle("Customer");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
