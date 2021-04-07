package observer.model;

import observer.BaseObservable;
import observer.Observer;
import observer.dto.FaceDto;

public class FaceObservable extends BaseObservable<FaceDto> {

    public FaceObservable(Observer<FaceDto> observer) {
        super(observer);
        data = new FaceDto();
    }

    public void switchLeftEyeState() {
        data.switchLeftEyeState();
        notifyObservers();
    }

    public void switchRightEyeState() {
        data.switchRightEyeState();
        notifyObservers();
    }

    public void switchMouthState() {
        data.switchMouthState();
        notifyObservers();
    }
}
