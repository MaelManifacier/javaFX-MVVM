package viewmodel;

import javafx.scene.control.ListCell;

public class CellListAventure extends ListCell<AventureVM> {

    @Override
    protected void updateItem(AventureVM item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.themeProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
