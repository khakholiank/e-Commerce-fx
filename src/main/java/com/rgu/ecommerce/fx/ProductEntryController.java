
package com.rgu.ecommerce.fx;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.rgu.ecommerce.model.Product;
import com.rgu.ecommerce.rest.NetworkService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author Nikit Khakholia
 */
public class ProductEntryController implements Initializable {

    @FXML private JFXTextField id;
    @FXML private JFXTextField name;
    @FXML private JFXTextField tags;
    @FXML private JFXTextArea description;
    @FXML private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        id.setEditable(false);

    }    


    private boolean validateFields(){
       
        if(name.getText()==""){
            
            return false;
        }
        if(tags.getText()==""){
            
            return false;
        }
        if(description.getText()==""){
            
            return false;
        }
        return true;
    }
    
    private Product getValueFromFields(){
        Product p = new Product();
        if(validateFields()){
//            p.setId(1);
            p.setNameOfItem(name.getText());
            p.setDescription(description.getText());
            p.setTags(tags.getText());
            p.setImgMediaId(1111);
        }
        return p;
    }
    
    
    @FXML
    private void saveAction(ActionEvent event) {
        Product p = getValueFromFields();
        if(p!=null){
            NetworkService.getInstance().getJSONApi().addProduct(p).enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> rspns) {
                    if(rspns.isSuccessful()){
                        Platform.runLater(()-> System.out.println("SUCCESS"));
                    }
                }

                @Override
                public void onFailure(Call<Product> call, Throwable thrwbl) {
                        Platform.runLater(()-> System.out.println("FAILURE... "+thrwbl.toString()));
                }
            });
        }
        
    }

    @FXML
    private void uploadImage(ActionEvent event) {
    }

    
}
