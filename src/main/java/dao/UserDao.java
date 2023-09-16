package dao;

import com.jfoenix.controls.JFXRadioButton;
import entity.CustomerEntity;
import entity.UserEntity;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class UserDao {
    public JFXRadioButton agreeandRadio;
    public void userRegisterMethod(UserEntity entity) {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign up");
        alert.setContentText("Do youwant to Register ?");

        if (alert.showAndWait().get()== ButtonType.OK){
            Transaction transaction=null;
            try(Session session= SessionFactoryConfiguration.getInstance().getSession()){
                transaction= session.beginTransaction();
                session.save(entity);
                transaction.commit();
            }catch (Exception e){
                if (transaction!=null){
                    transaction.rollback();
                }
            }
        }
    }

}
