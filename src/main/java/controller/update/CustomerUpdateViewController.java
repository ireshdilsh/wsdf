package controller.update;

import com.jfoenix.controls.JFXTextField;
import dao.CustomerDao;
import dao.UserDao;
import entity.CustomerEntity;
import entity.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerUpdateViewController {
    public JFXTextField addessText;
    public JFXTextField mobileText;
    public JFXTextField nameText;
    public JFXTextField nicText;
    public AnchorPane pane;
    public JFXTextField idText;

    public void updateCustomer(ActionEvent event) {
         Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Update Customer");
         alert.setContentText("Do You Want to Update Customer Details ?");

         if (alert.showAndWait().get()==ButtonType.OK){
          /*int id= Integer.parseInt(idText.getText());
            CustomerDao dao=new CustomerDao();
            CustomerEntity entity=new CustomerEntity(Double.parseDouble(nicText.getText()), nameText.getText(), addessText.getText(), Double.parseDouble(mobileText.getText()));
             String resp= String.valueOf(dao.updateCustomer(id));
        */
         CustomerDao dao=new CustomerDao();
         CustomerEntity entity=new CustomerEntity(Double.parseDouble(nicText.getText()), nameText.getText(), addessText.getText(), Double.parseDouble(mobileText.getText()));
         dao.updateCustomer1(entity);
         }
    }
    private javax.swing.JOptionPane JOptionPane;
    public void backButton(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/Dashboard-View.fxml"));
        Stage stage= (Stage) this.pane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Dashboard");
        stage.show();
    }

    public void searchCustomer(ActionEvent event) {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Customer Search");
        alert.setContentText("Do you want to search Customer ?");

        if (alert.showAndWait().get()== ButtonType.OK){

        CustomerDao dao=new CustomerDao();
        int id= Integer.parseInt(idText.getText());
        CustomerEntity entity=dao.searchCustomer(id);
        if (entity!=null){
            nameText.setText(entity.getName());
            addessText.setText(entity.getAddress());
            mobileText.setText(String.valueOf(entity.getMobileno()));
            nicText.setText(String.valueOf(entity.getNic()));
        }}else {
            JOptionPane.showMessageDialog(null,"Customer not Found");
        }
    }
    public void clear(){
        nameText.setText("");
        addessText.setText("");
        mobileText.setText("");
        nicText.setText("");
    }
}
