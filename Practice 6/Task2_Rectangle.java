class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    // Проверка, что обе точки имеют одинаковую скорость
    private boolean isSpeedSame() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public void moveUp() {
        if (isSpeedSame()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        } else {
            System.out.println("Ошибка: скорости точек разные!");
        }
    }

    @Override
    public void moveDown() {
        if (isSpeedSame()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        if (isSpeedSame()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        if (isSpeedSame()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }

    @Override
    public String toString() {
        return "MovableRectangle(topLeft=" + topLeft + ", bottomRight=" + bottomRight + ")";
    }
}

public class Task2_Rectangle {
    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(0, 0, 10, 10, 2, 2);
        System.out.println("До: " + rect);
        rect.moveRight();
        rect.moveDown();
        System.out.println("После: " + rect);
    }
}