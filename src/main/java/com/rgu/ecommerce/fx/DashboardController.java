
package com.rgu.ecommerce.fx;

import com.jfoenix.controls.JFXTabPane;
import com.sdigitizers.fx.utils.FXUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Nikit Khakholia
 */
public class DashboardController implements Initializable {

    @FXML
    private JFXTabPane tabPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabPane.getTabs().get(0).setContent(FXUtils.loadScene(Fxml.PRODUCT_MANAGER));
        tabPane.getTabs().get(1).setContent(FXUtils.loadScene(Fxml.STOCK_MANAGER));
        tabPane.getTabs().get(2).setContent(FXUtils.loadScene(Fxml.PROMOCODE_MANAGER));
        tabPane.getTabs().get(3).setContent(FXUtils.loadScene(Fxml.USER_MANAGER));
        tabPane.getTabs().get(4).setContent(FXUtils.loadScene(Fxml.ORDER_MANAGER));
        tabPane.getTabs().get(5).setContent(FXUtils.loadScene(Fxml.DELIVERY_TIME_MANAGER));
        
    }    
    
}
