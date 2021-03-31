package templateMethod;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public abstract class BaseFigure<T> {

    protected boolean isInAnimationArea;

    @Setter
    protected double animationAreaWidth, animationAreaHeight;

    protected double deltaX, deltaY;

    @Getter
    protected T figure;

    protected FigureAnimationTimer timer;

    protected BaseFigure(double width, double height) {

        animationAreaWidth = width;
        animationAreaHeight = height;

        deltaX = - ((Math.random() * 3) + 1);
        deltaY = - ((Math.random() * 3) + 1);

        isInAnimationArea = false;
    }

    protected abstract void animate();

    protected void destroy() {
        timer.stop();
    }

    protected static Color getRandomColor() {
        Random rand = new Random();
        return Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
    }

    protected abstract static class FigureAnimationTimer extends AnimationTimer {

    }
}
