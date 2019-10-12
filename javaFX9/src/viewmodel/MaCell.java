package viewmodel;


import javafx.scene.control.ListCell;

public class MaCell extends ListCell<SourisVM> {
    @Override
    protected void updateItem(SourisVM item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.nomProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
