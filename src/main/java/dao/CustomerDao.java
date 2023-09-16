package dao;

import entity.CustomerEntity;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class CustomerDao {
    public void saveCustomer(CustomerEntity entity) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Register");
        alert.setContentText("Do you want to Register here ?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Transaction transaction = null;
            try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
                transaction = session.beginTransaction();
                session.save(entity);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    private javax.swing.JOptionPane JOptionPane;

    public CustomerEntity deleteCustomer(int id) {
        Transaction transaction = null;
        CustomerEntity entity = null;
        try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            entity = session.get(CustomerEntity.class, id);
            session.delete(entity);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Delete Success !");
        } catch (Exception e) {
            if (transaction != null) {
                JOptionPane.showMessageDialog(null, "Cancel by Delete !");
                transaction.rollback();
            }
        }
        return entity;
    }

    public CustomerEntity searchCustomer(int id) {
        Transaction transaction = null;
        CustomerEntity entity = null;

        try (Session session = SessionFactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            entity = session.get(CustomerEntity.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return entity;
    }

    public void updateCustomer1(CustomerEntity entity) {
        Transaction transaction=null;
        try (Session session=SessionFactoryConfiguration.getInstance().getSession()){
            transaction= session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }catch (Exception e){
                transaction.rollback();
        }
    }
}
////////////////////////// gahanna thiyeno  ////////////

