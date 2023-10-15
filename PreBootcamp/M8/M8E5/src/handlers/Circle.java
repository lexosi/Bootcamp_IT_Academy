package handlers;

public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean equals(Circle circle) {
        return this.center.equals(circle.center)
            && this.radius == circle.radius; 
    }

    public double distanceBetweenCenter(Circle circle) {
        return this.center.absoluteDistance(circle.center);
    }

    public boolean isConcentric(Circle circle) {
        return this.center.equals(circle.center);
    }

    public boolean hasSameRadius(Circle circle) {
        return this.radius == circle.radius;
    }

    public boolean isTangent(Circle circle) {
        final double DISTANCE = this.center.squaredDistance(circle.center);
        return DISTANCE == this.radius + circle.radius 
            || DISTANCE == this.radius - circle.radius 
            || DISTANCE == circle.radius - this.radius;
    }

    public boolean isIntersecting(Circle circle) {
        final double DISTANCE = this.center.squaredDistance(circle.center);
        return this.radius > circle.radius
            && this.radius - circle.radius < DISTANCE
            && DISTANCE < this.radius + circle.radius;        
    }

    public boolean isOuter(Circle circle) {
        final double DISTANCE = this.center.squaredDistance(circle.center);
        return DISTANCE > this.radius + circle.radius;
    }
}