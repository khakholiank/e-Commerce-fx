
package com.rgu.ecommerce.fx;

import com.sdigitizers.fx.utils.FxmlView;
import javafx.stage.StageStyle;

/**
 *
 * @author Nikit Khakholia
 */
public enum Fxml implements FxmlView{
    
    DASHBOARD{
        @Override
        public String getTitle() {
            return "DASHBOARD";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.DECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/dashboard.fxml";
        }

        @Override
        public String getCssFile() {
            return "";
        }
        
    },
    PRODUCT_MANAGER{
        @Override
        public String getTitle() {
            return "PRODUCT MANAGER";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.UNDECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/ProductManager.fxml";
        }
        
        @Override
        public String getCssFile() {
            return "";
        }
        
    },
    PRODUCT_ENTRY{
        @Override
        public String getTitle() {
            return "PRODUCT ENTRY";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.DECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/ProductEntry.fxml";
        }
        
        
        @Override
        public String getCssFile() {
            return "";
        }
    },
    PROMOCODE_MANAGER{
        @Override
        public String getTitle() {
            return "PROMOCODE MANAGER";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.UNDECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/PromoCodeManager.fxml";
        }
        
        
        @Override
        public String getCssFile() {
            return "";
        }
        
    },
    PROMOCODE_ENTRY{
        @Override
        public String getTitle() {
            return "PROMOCODE ENTRY";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.DECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/PromoCodeEntry.fxml";
        }

       
        @Override
        public String getCssFile() {
            return "";
        }
        
    },
    STOCK_MANAGER{
        @Override
        public String getTitle() {
            return "STOCK MANAGER";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.UNDECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/StockManager.fxml";
        }
        
        @Override
        public String getCssFile() {
            return "";
        }
    },
    STOCK_ENTRY{
        @Override
        public String getTitle() {
            return "STOCK ENTRY";
        }

        @Override
        public StageStyle getStageStyle() {
            return StageStyle.DECORATED;
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/StockEntry.fxml";
        }
        
        @Override
        public String getCssFile() {
            return "";
        }
    }
    
}
