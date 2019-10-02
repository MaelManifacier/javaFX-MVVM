javaFX3 : juste un view/model -> problème: le modèle n'est pas sérializable. Il faut donc séparer la vue du modèle.

Pour cela, on va utiliser le pattern MVVM : Modele ViewModel View.

Les deux tp suivants utilisent ce pattern.


(créé avec Intellij Idea,

  dans les configurations, ajout de javafx-sdk-11.0.2 en VM options : --module-path /chemin/sdk/lib --add-modules javafx.controls,javafx.fxml
  
  dans Module Settings du projet : add library /chemin/sdk/lib

)
