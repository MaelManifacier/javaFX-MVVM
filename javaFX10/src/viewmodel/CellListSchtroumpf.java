package viewmodel;

import javafx.scene.control.ListCell;

public class CellListSchtroumpf extends ListCell<SchtroumpfVM> {

    @Override
    protected void updateItem(SchtroumpfVM item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.caractereProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
