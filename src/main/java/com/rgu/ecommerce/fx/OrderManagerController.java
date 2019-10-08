
package com.rgu.ecommerce.fx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.rgu.ecommerce.model.Order;
import com.rgu.ecommerce.model.OrderItem;
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
public class OrderManagerController implements Initializable {

    @FXML private TableView<OrderItem> orerItemTable;
    @FXML private TableColumn<OrderItem, String> clm1;
    @FXML private TableColumn<OrderItem, String> clm2;
    @FXML private TableColumn<OrderItem, String> clm3;
    @FXML private TableColumn<OrderItem, String> clm4;
    @FXML private TableColumn<OrderItem, String> clm5;
    @FXML private TableColumn<OrderItem, String> clm6;
    @FXML private TableColumn<OrderItem, String> clm7;
    @FXML private TableColumn<OrderItem, String> clm8;
    @FXML private TableColumn<OrderItem, String> clm9;
    @FXML private TableColumn<OrderItem, String> clm10;
    @FXML private TableColumn<OrderItem, String> clm11;
    @FXML private TableColumn<OrderItem, String> clm12;
    @FXML private TableColumn<OrderItem, String> clm13;
    @FXML private JFXTextField orderId;
    
    ObservableList<OrderItem> DATA_ORDERITEMS = FXCollections.observableArrayList();
    
    
    @FXML private JFXTextField buyerId;
    @FXML private TableView<Order> ordersTable;
    @FXML private TableColumn<Order, String> oclm1;
    @FXML private TableColumn<Order, String> oclm2;
    @FXML private TableColumn<Order, String> oclm3;
    @FXML private TableColumn<Order, String> oclm4;
    @FXML private TableColumn<Order, String> oclm5;
    @FXML private TableColumn<Order, String> oclm6;
    @FXML private TableColumn<Order, String> oclm7;
    @FXML private TableColumn<Order, String> oclm8;
    @FXML private TableColumn<Order, String> oclm9;
    @FXML private TableColumn<Order, String> oclm10;
    @FXML private TableColumn<Order, String> oclm11;
    @FXML private TableColumn<Order, String> oclm12;
    @FXML private TableColumn<Order, String> oclm13;
    @FXML private TableColumn<Order, String> oclm14;
    @FXML private TableColumn<Order, String> oclm15;
    
    ObservableList<Order> DATA_ORDERS = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        orerItemTable.setItems(DATA_ORDERITEMS);
        clm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getOrderId()+""));
        clm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getSellerId()+""));
        clm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryAddress().getLine1()+"     "+ d.getValue().getDeliveryAddress().getLine2()));
        clm4.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryAddress().getLocality().getLocalityName()));
        clm5.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryAddress().getCity().getCityName()+""));
        clm6.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryAddress().getState().getStateName()+""));
        clm7.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryAddress().getCountry().getCountryName()+""));
        clm8.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryAddress().getPhone()+""));
        clm9.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getProduct().getNameOfItem()));
        clm10.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getProduct().getDescription()));
        clm11.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getQty()+""));
        clm12.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getTrackingId()));
        clm13.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getEstDeliveryTime()+""));
        
        
        ordersTable.setItems(DATA_ORDERS);
        oclm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getId()+""));
        oclm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getCustId()+""));
        oclm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getTimeOfOrder()+""));
        oclm4.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBillingAddress().getLine1()+"     "+d.getValue().getBillingAddress().getLine2()));
        oclm5.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBillingAddress().getLocality().getLocalityName()));
        oclm6.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBillingAddress().getCity().getCityName()+""));
        oclm7.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBillingAddress().getState().getStateName()+""));
        oclm8.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBillingAddress().getCountry().getCountryName()+""));
        oclm9.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBillingAddress().getPhone()+""));
        oclm10.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getPromoCode()));
        oclm11.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getGrossAmount()+""));
        oclm12.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDiscApplied()+""));
        oclm13.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDeliveryFee()+""));
        oclm14.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getNetAmount()+""));
        oclm15.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getOrderStatus()+""));
        
        
        

        
        
    }    


    @FXML
    private void editAction(ActionEvent event) {
    }
    
    
    

    @FXML
    private void loadItems(ActionEvent event) {
        if(orderId!=null){
            int id = Integer.parseInt(orderId.getText());
            NetworkService.getInstance().getJSONApi().getOrderItemsByOrderId(id).enqueue(new Callback<List<OrderItem>>() {
                @Override
                public void onResponse(Call<List<OrderItem>> call, Response<List<OrderItem>> rspns) {
                    if(rspns.isSuccessful()){
                        Platform.runLater(()-> DATA_ORDERITEMS.setAll(rspns.body()));
                    }
                }

                @Override
                public void onFailure(Call<List<OrderItem>> call, Throwable thrwbl) {
                    Platform.runLater(()-> System.err.println(thrwbl.toString()));
                }
            });
        }
        
    }

    @FXML
    private void loadOrders(ActionEvent event) {
        if(buyerId.getText()!=null){
            int id = Integer.parseInt(buyerId.getText());
            NetworkService.getInstance().getJSONApi().getOrdersByBuyerId(id).enqueue(new Callback<List<Order>>() {
                @Override
                public void onResponse(Call<List<Order>> call, Response<List<Order>> rspns) {
                    if(rspns.isSuccessful()){
                        Platform.runLater(()-> DATA_ORDERS.setAll(rspns.body()));
                    }
                }

                @Override
                public void onFailure(Call<List<Order>> call, Throwable thrwbl) {
                    Platform.runLater(()-> System.err.println("FAILURE... "+thrwbl.toString()));
                }
            });
        }
    }
    
}
