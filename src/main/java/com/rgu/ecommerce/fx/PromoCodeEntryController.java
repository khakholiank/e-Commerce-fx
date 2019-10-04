
package com.rgu.ecommerce.fx;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.rgu.ecommerce.model.PromoCode;
import com.rgu.ecommerce.model.config.PromoType;
import com.rgu.ecommerce.rest.NetworkService;
import java.net.URL;
import java.util.ResourceBundle;
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
public class PromoCodeEntryController implements Initializable {

    @FXML private JFXTextField code;
    @FXML private JFXTextField amount;
    @FXML private JFXComboBox<PromoType> type;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.getItems().setAll(PromoType.values());
    }    
    
    
    private boolean validateFields(){
        if(code.getText()==null){
            return false;
        }
        if(amount.getText()==null){
            return false;
        }
        if(type.getValue()==null){
            return false;
        }
        return true;
    }
    
    private PromoCode getValueFromFields(){
        PromoCode pc = new PromoCode();
        if(validateFields()){
            pc.setCode(code.getText());
            pc.setAmount(Double.parseDouble(code.getText()));
            pc.setType(type.getValue());
        }
        return pc;
    }
    

    @FXML
    private void saveAction(ActionEvent event) {
        PromoCode pc = new PromoCode();
        if(pc!=null){
            NetworkService.getInstance().getJSONApi().addPromoCode(pc).enqueue(new Callback<PromoCode>() {
                @Override
                public void onResponse(Call<PromoCode> call, Response<PromoCode> rspns) {
                    if(rspns.isSuccessful()){
                        System.out.println("SUCCESS");
                    }
                }

                @Override
                public void onFailure(Call<PromoCode> call, Throwable thrwbl) {
                    System.out.println("FAILURE... "+thrwbl.toString());
                }
            });
        }
    }
    
}
