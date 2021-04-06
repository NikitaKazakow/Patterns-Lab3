package templateMethod.figure;

import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Star extends BaseFigure<Polygon> {

    public Star(double width, double height) {

        super(width, height);

        figure = new Polygon();

            figure.getPoints().addAll(getPoints());
            figure.setTranslateX(animationAreaWidth);
            figure.setTranslateY(animationAreaHeight);
            figure.setFill(getRandomColor());
    }

    private List<Double> getPoints() {
        List<Double> points = new ArrayList<>();
        double a = 0, b = Math.PI / 5, k = 0.3;
        double x1 = 50 * Math.cos(a), x2, y1 = 50 * Math.sin(a), y2;

        for (int i = 0; i < 5; i++) {
            a += b;
            points.add(x1);
            points.add(y1);
            y2 = k * 50 * Math.sin(a);
            x2 = k * 50 * Math.cos(a);
            points.add(x2);
            points.add(y2);
            a += b;
            x1 = 50 * Math.cos(a);
            y1 = 50 * Math.sin(a);
        }
        return points;
    }


    @Override
    public void animate() {
        timer = new FigureAnimationTimer() {
            @Override
            public void handle(long l) {
                double x = figure.getTranslateX();
                double y = figure.getTranslateY();
                double radius = 50;
                if (!isInAnimationArea) {
                    figure.setTranslateX(x + deltaX);
                    figure.setTranslateY(y + deltaY);
                    if (x + radius + deltaX < animationAreaWidth
                            && y + radius + deltaY < animationAreaHeight)
                        isInAnimationArea = true;
                } else {
                    if (x + deltaX > animationAreaWidth - radius || x + deltaX < radius) {
                        deltaX = -deltaX;
                    }
                    if (y + deltaY > animationAreaHeight - radius || y + deltaY < radius) {
                        deltaY = -deltaY;
                    }
                    figure.setTranslateX(x + deltaX);
                    figure.setTranslateY(y + deltaY);
                }
            }
        };
        timer.start();
    }
}
