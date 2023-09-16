package dao;

import entity.CarCategoriEntity;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class CarCategoryDao {
    public void addCategory(CarCategoriEntity entity) {
        Transaction transaction=null;
        try (Session session= SessionFactoryConfiguration.getInstance().getSession()){
            transaction=session.beginTransaction();
            session.save(entity);
            transaction.commit();
            new Alert(Alert.AlertType.INFORMATION,"Category Add Successful").show();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }
}
