package observer.dto;

import javafx.scene.image.Image;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class FaceDto {

    private EyeState leftEyeState;

    private EyeState rightEyeState;

    private MouthState mouthState;

    private final Map<Enum<EyeState>, Image> eyesImagesMap;
    private final Map<Enum<MouthState>, Image> mouthImagesMap;

    @Getter
    private Image leftEyeImage, rightEyeImage, mouthImage;

    public FaceDto() {

        eyesImagesMap = new HashMap<>();

        eyesImagesMap.put(EyeState.OPENED, new Image("observer/img/eyes/opened.png"));
        eyesImagesMap.put(EyeState.CLOSED, new Image("observer/img/eyes/closed.png"));

        mouthImagesMap = new HashMap<>();
        mouthImagesMap.put(MouthState.SMILE, new Image("observer/img/smile.png"));
        mouthImagesMap.put(MouthState.SAD, new Image("observer/img/sad.png"));

        leftEyeState = rightEyeState = EyeState.OPENED;
        mouthState = MouthState.SMILE;

        leftEyeImage = eyesImagesMap.get(leftEyeState);
        rightEyeImage = eyesImagesMap.get(rightEyeState);
        mouthImage = mouthImagesMap.get(mouthState);
    }

    private enum EyeState {
        OPENED,
        CLOSED
    }

    private enum MouthState {
        SMILE,
        SAD
    }

    public void switchLeftEyeState() {
        leftEyeState = leftEyeState != EyeState.OPENED ? EyeState.OPENED : EyeState.CLOSED;
        leftEyeImage = eyesImagesMap.get(leftEyeState);
    }

    public void switchRightEyeState() {
        rightEyeState = rightEyeState != EyeState.OPENED ? EyeState.OPENED : EyeState.CLOSED;
        rightEyeImage = eyesImagesMap.get(rightEyeState);
    }

    public void switchMouthState() {
        mouthState = mouthState != MouthState.SAD ? MouthState.SAD : MouthState.SMILE;
        mouthImage = mouthImagesMap.get(mouthState);
    }
}
