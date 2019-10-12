package viewmodel;

import javafx.scene.control.ListCell;

public class MaCellACookie extends ListCell<CookieVM> {

    @Override
    protected void updateItem(CookieVM item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.typeProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
