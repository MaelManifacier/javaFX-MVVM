package view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import modele.Lapin;

public class CelluleListe extends ListCell<Lapin> {
    @Override
    protected void updateItem(Lapin item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            CheckBox checkBox = new CheckBox();
            checkBox.selectedProperty().bindBidirectional(item.isLapinGarouProperty());
            textProperty().bind(item.nomProperty());
            setGraphic(checkBox);
        } else {
            textProperty().unbind();
            setText("");
            setGraphic(null);
        }
    }
}
