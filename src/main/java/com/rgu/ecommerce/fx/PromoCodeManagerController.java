
package com.rgu.ecommerce.fx;

import com.rgu.ecommerce.model.PromoCode;
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
public class PromoCodeManagerController implements Initializable {

    @FXML
    private TableView<PromoCode> promoCodeTable;
    @FXML
    private TableColumn<PromoCode, String> clm1;
    @FXML
    private TableColumn<PromoCode, String> clm2;
    @FXML
    private TableColumn<PromoCode, String> clm3;
    
    private final ObservableList<PromoCode> DATA = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        promoCodeTable.setItems(DATA);
        clm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getCode()));
        clm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getType()+""));
        clm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getAmount()+""));
        refreshAction();
    }    

    @FXML
    private void refreshAction() {
        NetworkService.getInstance().getJSONApi().getAllPromoCodes().enqueue(new Callback<List<PromoCode>>() {
            @Override
            public void onResponse(Call<List<PromoCode>> call, Response<List<PromoCode>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> DATA.setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<PromoCode>> call, Throwable thrwbl) {
                Platform.runLater(()-> System.err.println("FAILURE... "+thrwbl.toString()));
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
