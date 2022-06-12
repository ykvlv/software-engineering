package ykvlv.lab3.beans.mbeans;

public class Area implements AreaMBean {
    private double area;

    @Override
    public void calcArea(double r) {
        this.area = r * r + Math.PI * (r / 2) * (r / 2) + r * r / 4;
    }

    @Override
    public double getArea() {
        return this.area;
    }
}
