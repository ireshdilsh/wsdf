package controller;

import com.jfoenix.controls.JFXTextField;
import dao.CarCategoryDao;
import entity.CarCategoriEntity;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class CarCategoryViewConbtroller {
    public JFXTextField categoryText;

    public void addCategory(ActionEvent event) {
        CarCategoryDao dao=new CarCategoryDao();
        if (categoryText.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Category Name").show();
        }else {
           new Alert(Alert.AlertType.CONFIRMATION,"Do you want add new Car Category ?").show();
            CarCategoriEntity entity = new CarCategoriEntity(categoryText.getText());
            dao.addCategory(entity);
        }
    }
}
