
package com.rgu.ecommerce.fx;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.rgu.ecommerce.model.Product;
import com.rgu.ecommerce.model.Stock;
import com.rgu.ecommerce.model.User;
import com.rgu.ecommerce.model.config.UnitType;
import com.rgu.ecommerce.rest.NetworkService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author Nikit Khakholia
 */
public class StockEntryController implements Initializable {

    @FXML private JFXComboBox<User> seller;
    @FXML private JFXComboBox<Product> product;
    @FXML private JFXComboBox<String> hub;
    @FXML private JFXTextField quantity;
    @FXML private JFXTextField rate;
    @FXML private JFXComboBox<UnitType> units;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hub.getItems().add("1234567890");
        units.getItems().setAll(UnitType.values());
    }    

    private boolean validateFieds(){
        if(seller.getValue()==null){
            return false;
        }
        if(product.getValue()==null){
            return false;
        }
        if(hub.getValue()==null){
            return false;
        }
        if(quantity.getText()==""){
            return false;
        }
        if(rate.getText()==""){
            return false;
        }
        if(units.getValue()==null){
            return false;
        }
        return true;
    }
    
    private Stock getValeFromFields(){
        Stock s = new Stock();
        if(validateFieds()){
            s.setHubId(Integer.parseInt(hub.getValue()));
            s.setProductId(product.getValue());
            s.setQty(Integer.parseInt(quantity.getText()));
            s.setRate(Double.parseDouble(rate.getText()));
            s.setSellerId(seller.getValue());
            s.setUnits(units.getValue());
        }
        return s;
    }
    
    
    @FXML
    private void saveAction(ActionEvent event) {
        Stock s = getValeFromFields();
        if(s!=null){
            NetworkService.getInstance().getJSONApi().addStocks(s).enqueue(new Callback<Stock>() {
                @Override
                public void onResponse(Call<Stock> call, Response<Stock> rspns) {
                    if(rspns.isSuccessful()){
                        Platform.runLater(()-> System.out.println("SUCCESS"));
                    }
                }

                @Override
                public void onFailure(Call<Stock> call, Throwable thrwbl) {
                    Platform.runLater(()-> System.out.println("FAILURE"+thrwbl.toString()));
                }
            });
        }
        
    }
    
    private void loadProducts(){
        NetworkService.getInstance().getJSONApi().getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> product.getItems().setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable thrwbl) {
                Platform.runLater(()-> System.err.println("FAILURE... "+thrwbl.toString()));
            }
        });
    }
    
    private void loadSellers(){
        NetworkService.getInstance().getJSONApi().getAllUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> seller.getItems().setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable thrwbl) {
                Platform.runLater(()-> System.err.println("FAILURE... "+thrwbl.toString()));
            }
        });
    }
    
}
