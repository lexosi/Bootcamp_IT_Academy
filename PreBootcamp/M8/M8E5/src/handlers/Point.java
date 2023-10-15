package handlers;

public class Point {
    private double positionX;
    private double positionY;

    public Point(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double getPositionX() {
        return this.positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return this.positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public boolean equals(Point point) {
        return this.positionX == point.positionX 
            && this.positionY == point.positionY;
    }

    public double squaredDistance(Point point) {
        return Math.sqrt(
            Math.pow(point.positionX-this.positionX, 2) + 
            Math.pow(point.positionY-this.positionY, 2)
        );
    }

    public double absoluteDistance(Point point) {
        return Math.abs(this.squaredDistance(point));
    }
}
