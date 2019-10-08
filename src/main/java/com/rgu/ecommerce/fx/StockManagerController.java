
package com.rgu.ecommerce.fx;

import com.rgu.ecommerce.model.Stock;
import com.rgu.ecommerce.rest.NetworkService;
import com.sdigitizers.fx.utils.FXUtils;
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
public class StockManagerController implements Initializable {

    @FXML private TableView<Stock> stockTable;
    @FXML private TableColumn<Stock, String> clm1;
    @FXML private TableColumn<Stock, String> clm2;
    @FXML private TableColumn<Stock, String> clm3;
    @FXML private TableColumn<Stock, String> clm4;
    @FXML private TableColumn<Stock, String> clm5;
    @FXML private TableColumn<Stock, String> clm6;
    
    
    private final ObservableList<Stock> DATA = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stockTable.setItems(DATA);
        clm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getHubId()+""));
        clm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getProductId().getNameOfItem()));
        clm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getSellerId().getName()));
        clm4.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getQty()+""));
        clm5.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getRate()+""));
        clm6.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getUnits()+""));
        
        
        refreshAction();
    }    

    @FXML
    private void refreshAction() {
        NetworkService.getInstance().getJSONApi().getAllStocks().enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> DATA.setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable thrwbl) {
                Platform.runLater(()-> System.out.println("FAILURE..."+thrwbl.toString()));
            }
        });
    }

    @FXML
    private void addAction(ActionEvent event) {
        FXUtils.openStageWithFadeAnimation(Fxml.STOCK_ENTRY);
        refreshAction();
    }

    @FXML
    private void editAction(ActionEvent event) {
    }

    @FXML
    private void deleteAction(ActionEvent event) {
    }
    
}
