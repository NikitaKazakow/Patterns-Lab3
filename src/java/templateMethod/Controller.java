package templateMethod;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import templateMethod.figure.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Getter
@Setter
public class Controller implements Initializable {

    //region FXML fields
    @FXML
    private Pane animationArea;

    @FXML
    private ComboBox<Figures> figureComboBox;
    //endregion

    @SuppressWarnings("rawtypes")
    private List<BaseFigure> figures;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        figures = new ArrayList<>();

        figureComboBox.getItems().setAll(Figures.values());
        figureComboBox.getSelectionModel().select(0);

        animationArea.widthProperty().addListener((obs, oldVal, newVal) -> {
            for (@SuppressWarnings("rawtypes") BaseFigure figure : figures) {
                figure.setAnimationAreaWidth(newVal.doubleValue());
            }
        });

        animationArea.heightProperty().addListener((obs, oldVal, newVal) -> {
            for (@SuppressWarnings("rawtypes") BaseFigure figure : figures) {
                figure.setAnimationAreaHeight(newVal.doubleValue());
            }
        });
    }

    @FXML
    public void addFigure() {
        switch (figureComboBox.getSelectionModel().getSelectedItem()) {
            case CIRCLE -> {
                Circle circle = new Circle(animationArea.getWidth(), animationArea.getHeight());
                circle.animate();
                figures.add(circle);
                animationArea.getChildren().add(circle.getFigure());
            }
            case SQUARE -> {
                Square square = new Square(animationArea.getWidth(), animationArea.getHeight());
                square.animate();
                figures.add(square);
                animationArea.getChildren().add(square.getFigure());
            }
            case STAR -> {
                Star star = new Star(animationArea.getWidth(), animationArea.getHeight());
                star.animate();
                figures.add(star);
                animationArea.getChildren().add(star.getFigure());

            }
        }
    }

    @FXML
    public void closeApplication() {
        for (var figure : figures) {
            figure.destroy();
        }
        Platform.exit();
    }
}
