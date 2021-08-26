import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MenuExtraCredit extends Application {
    public static void main(String[] args) {

        //launch the application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        //constants for the scene dimensions
        final double WIDTH = 300.0, HEIGHT = 200.0;

        //create the label control
        Label outputLabel = new Label("I am making menus!");

        //create the menu bar
        MenuBar menuBar = new MenuBar();

        //create the file menu
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().add(exitItem);

        //create Edit menu
        Menu editMenu = new Menu("Edit");
        RadioMenuItem blackFont = new RadioMenuItem("Black");
        RadioMenuItem greenFont = new RadioMenuItem("Green");
        RadioMenuItem blueFont = new RadioMenuItem("Blue");
        editMenu.getItems().add(blackFont);
        editMenu.getItems().add(greenFont);
        editMenu.getItems().add(blueFont);

        //setting black as default
        blackFont.setSelected(true);

        //set the toggle group
        ToggleGroup fontToggleGroup = new ToggleGroup();
        blackFont.setToggleGroup(fontToggleGroup);
        greenFont.setToggleGroup(fontToggleGroup);
        blueFont.setToggleGroup(fontToggleGroup);


        //register event handlers for the menu items
        blackFont.setOnAction(event -> {
            outputLabel.setStyle("-fx-text-fill: black");
        });

        greenFont.setOnAction(event -> {
            outputLabel.setStyle("-fx-text-fill: green");
        });

        blueFont.setOnAction(event -> {
            outputLabel.setStyle("-fx-text-fill: blue");
        });


        //register an event handler for the exit item
        exitItem.setOnAction(event -> {
            primaryStage.close();
        });

        //add the file menu to the menu bar
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(editMenu);

        //add the menu bar to a borderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        //add label to HBox
        HBox hbox = new HBox(outputLabel);
        VBox vbox = new VBox(borderPane, hbox);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.TOP_RIGHT);

        //create a scene and display it
        Scene scene = new Scene(vbox, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
