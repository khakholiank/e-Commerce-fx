
package com.rgu.ecommerce.fx;

import com.rgu.ecommerce.model.Product;
import com.rgu.ecommerce.rest.NetworkService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author Nikit Khakholia
 */
public class ProductManagerController implements Initializable {

    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, String> clm1;
    @FXML private TableColumn<Product, String> clm2;
    @FXML private TableColumn<Product, String> clm3;
    @FXML private TableColumn<Product, String> clm4;
    @FXML private TableColumn<Product, String> clm5;
    
    
    private final ObservableList<Product> DATA = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productTable.setItems(DATA);
        
        clm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getId()+""));
        clm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getNameOfItem()));
        clm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDescription()));
        clm4.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getTags()));
        clm5.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getImgMediaId()+""));
        
    }    
    
    
    @FXML private void refreshAction(){
        NetworkService.getInstance().getJSONApi().getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> DATA.setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable thrwbl) {
                Platform.runLater(()-> System.err.println(thrwbl.toString()));
            }
        });
    }

    @FXML
    private void addAction(ActionEvent event) {
    }

    @FXML
    private void editAction(ActionEvent event) {
    }

    @FXML
    private void deleteAction(ActionEvent event) {
    }
    
}
