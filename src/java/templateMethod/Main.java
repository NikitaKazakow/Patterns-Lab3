package templateMethod;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private Pane rootLayout;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        this.primaryStage = stage;
        this.primaryStage.setTitle("Template method");

        initRootLayout();
    }

    private void initRootLayout() {
        try {

            rootLayout = FXMLLoader.load(getClass().getResource("Main.fxml"));
            rootLayout.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}