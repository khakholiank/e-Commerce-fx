
package com.rgu.ecommerce.fx;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.rgu.ecommerce.model.DeliveryTime;
import com.rgu.ecommerce.model.config.UnitType;
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
public class DeliveryTimeManagerController implements Initializable {

    @FXML private TableView<DeliveryTime> deliveryTimeTable;
    @FXML private TableColumn<DeliveryTime, String> clm1;
    @FXML private TableColumn<DeliveryTime, String> clm2;
    @FXML private TableColumn<DeliveryTime, String> clm3;
    @FXML private TableColumn<DeliveryTime, String> clm4;
    @FXML private TableColumn<DeliveryTime, String> clm5;
    @FXML private JFXTextField fromPin;
    @FXML private JFXTextField toPin;
    @FXML private JFXTextField timeReqd;
    @FXML private JFXTextField fee;
    @FXML private JFXComboBox<UnitType> units;
    
    ObservableList<DeliveryTime> DATA = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deliveryTimeTable.setItems(DATA);
        clm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getFromPincode()+""));
        clm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getToPincode()+""));
        clm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getTimeRequired()+""));
        clm4.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getUnits()+""));
        clm5.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getFee()+""));
        
        units.getItems().setAll(UnitType.values());
        
        
        refreshAction();
        
    }    

    
    private boolean validateFields(){
        if(fromPin.getText()==null){
            return false;
        }
        if(toPin.getText()==null){
            return false;
        }
        if(timeReqd.getText()==null){
            return false;
        }
        if(fee.getText()==null){
            return false;
        }
        if(units.getValue()==null){
            return false;
        }
        return true;
    }
    
    private DeliveryTime getValueFromFields(){
        DeliveryTime dt = new DeliveryTime();
        if(validateFields()){
            
            dt.setFromPincode(Integer.parseInt(fromPin.getText()));
            dt.setToPincode(Integer.parseInt(toPin.getText()));
            dt.setTimeRequired(Double.parseDouble(timeReqd.getText()));
            dt.setFee(Double.parseDouble(fee.getText()));
            dt.setUnits(units.getValue());
        }
        return dt;
    }
    
    
    

    
    
    @FXML
    private void saveAction(ActionEvent event) {
        DeliveryTime dt = getValueFromFields();
        if(dt!=null){
            NetworkService.getInstance().getJSONApi().addDeliveryTime(dt).enqueue(new Callback<DeliveryTime>() {
                @Override
                public void onResponse(Call<DeliveryTime> call, Response<DeliveryTime> rspns) {
                    if(rspns.isSuccessful()){
                        Platform.runLater(()-> System.out.println("SUCCESS"));
                    }
                }

                @Override
                public void onFailure(Call<DeliveryTime> call, Throwable thrwbl) {
                    Platform.runLater(()-> System.err.println("FAILURE... "+thrwbl.toString()));
                }
            });
        }
        
    }

    @FXML
    private void refreshAction() {
        NetworkService.getInstance().getJSONApi().getAllDeliveryTime().enqueue(new Callback<List<DeliveryTime>>() {
            @Override
            public void onResponse(Call<List<DeliveryTime>> call, Response<List<DeliveryTime>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> DATA.setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<DeliveryTime>> call, Throwable thrwbl) {
                Platform.runLater(()-> System.err.println("FAILURE... "+thrwbl.toString()));
            }
        });
        
    }
    

    @FXML
    private void editAction(ActionEvent event) {
    }

    @FXML
    private void deleteAction(ActionEvent event) {
    }
    
}
