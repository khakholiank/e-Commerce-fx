/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgu.ecommerce.fx;

import com.rgu.ecommerce.model.User;
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
public class UserManagerController implements Initializable {

    @FXML private TableView<User> userTable;
    @FXML private TableColumn<User, String> clm1;
    @FXML private TableColumn<User, String> clm2;
    @FXML private TableColumn<User, String> clm3;
    @FXML private TableColumn<User, String> clm4;
    @FXML private TableColumn<User, String> clm5;
    @FXML private TableColumn<User, String> clm6;
    @FXML private TableColumn<User, String> clm7;
    
    ObservableList<User> DATA = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTable.setItems(DATA);
        clm1.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getId()+""));
        clm2.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getName()));
        clm3.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getBirthDate()+""));
        clm4.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getUserType()+""));
        clm5.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getOccupation()));
        clm6.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getPassword()));
//        clm7.setCellValueFactory((d)-> new SimpleStringProperty(d.getValue().getDefaultAddress().getLocality().));
        
        refreshAction();
        
    }    

    @FXML
    private void refreshAction() {
        NetworkService.getInstance().getJSONApi().getAllUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> rspns) {
                if(rspns.isSuccessful()){
                    Platform.runLater(()-> DATA.setAll(rspns.body()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable thrwbl) {
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
