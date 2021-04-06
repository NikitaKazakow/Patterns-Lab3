package templateMethod.figure;

import javafx.scene.shape.Rectangle;

public class Square extends BaseFigure<Rectangle> {

    public Square(double width, double height) {

        super(width, height);

        figure = new Rectangle();
        figure.setHeight(50);
        figure.setWidth(50);
        figure.setX(animationAreaWidth - 50);
        figure.setY(animationAreaHeight - 50);
        figure.setFill(getRandomColor());
    }

    @Override
    public void animate() {
        timer = new FigureAnimationTimer() {
            @Override
            public void handle(long l) {
                double x = figure.getX();
                double y = figure.getY();
                double size = figure.getHeight();
                if (!isInAnimationArea) {
                    figure.setX(x + deltaX);
                    figure.setY(y + deltaY);
                    if (x + deltaX < animationAreaWidth
                            && y + deltaY < animationAreaHeight)
                        isInAnimationArea = true;
                }
                else {
                    if (x + size + deltaX > animationAreaWidth || x + deltaX < 0) {
                        deltaX = -deltaX;
                    }
                    if (y + size + deltaY > animationAreaHeight || y + deltaY < 0) {
                        deltaY = -deltaY;
                    }
                    figure.setX(x + deltaX);
                    figure.setY(y + deltaY);
                }
            }
        };
        timer.start();
    }
}
