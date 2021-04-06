package templateMethod.figure;

public class Circle extends BaseFigure<javafx.scene.shape.Circle> {

    public Circle(double width, double height) {

        super(width, height);

        figure = new javafx.scene.shape.Circle();
        figure.setRadius(25);
        figure.setCenterX(animationAreaWidth);
        figure.setCenterY(animationAreaHeight);
        figure.setFill(getRandomColor());
    }

    @Override
    public void animate() {
        timer = new FigureAnimationTimer() {
            @Override
            public void handle(long l) {
                double x = figure.getCenterX();
                double y = figure.getCenterY();
                double radius = figure.getRadius();
                if (!isInAnimationArea) {
                    figure.setCenterX(x + deltaX);
                    figure.setCenterY(y + deltaY);
                    if (x + radius + deltaX < animationAreaWidth
                            && y + radius + deltaY < animationAreaHeight)
                        isInAnimationArea = true;
                }
                else {
                    if (x + deltaX > animationAreaWidth - radius || x + deltaX < radius) {
                        deltaX = -deltaX;
                    }
                    if (y + deltaY > animationAreaHeight - radius || y + deltaY < radius) {
                        deltaY = -deltaY;
                    }
                    figure.setCenterX(x + deltaX);
                    figure.setCenterY(y + deltaY);
                }
            }
        };
        timer.start();
    }
}
