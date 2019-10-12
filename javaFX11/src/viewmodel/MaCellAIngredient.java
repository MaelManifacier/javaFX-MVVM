package viewmodel;

import javafx.scene.control.ListCell;

public class MaCellAIngredient extends ListCell<IngredientVM> {

    @Override
    protected void updateItem(IngredientVM item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            textProperty().bind(item.nomProperty());
        } else {
            textProperty().unbind();
            setText("");
        }
    }
}
