package observer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import observer.dto.FaceDto;
import observer.model.FaceObservable;

import java.net.URL;
import java.util.ResourceBundle;

public class FaceController implements Observer<FaceDto>, Initializable {

    private FaceObservable faceObservable;

    @FXML
    private ImageView background;

    @FXML
    private ImageView leftEye;

    @FXML
    private ImageView rightEye;

    @FXML
    private ImageView mouth;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        faceObservable = new FaceObservable(this);

        background.setImage(new Image("observer/img/background.png"));
        leftEye.setImage(faceObservable.data.getLeftEyeImage());
        rightEye.setImage(faceObservable.data.getRightEyeImage());
        mouth.setImage(faceObservable.data.getMouthImage());

        leftEye.setOnMouseClicked(mouseEvent -> {
            faceObservable.switchLeftEyeState();
        });

        rightEye.setOnMouseClicked(mouseEvent -> {
            faceObservable.switchRightEyeState();
        });

        mouth.setOnMouseClicked(mouseEvent -> {
            faceObservable.switchMouthState();
        });
    }

    @Override
    public void update(FaceDto updateData) {
        leftEye.setImage(updateData.getLeftEyeImage());
        rightEye.setImage(updateData.getRightEyeImage());
        mouth.setImage(updateData.getMouthImage());

    }
}
