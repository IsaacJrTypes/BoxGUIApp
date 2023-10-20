import javax.swing.*;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box() {
            this.length = 0.0;
            this.width = 0.0;
            this.height = 0.0;

    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
    public void setLength(double length) {
        if(length > 0.0) {
            this.length = length;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public void setWidth(double width) {
        if(width > 0.0) {
            this.width = width;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public void setHeight(double height) {
        if(height > 0.0) {
            this.height = height;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public double getVolume() {
        return this.length * this.width * this.height;
    }

    public double getSurfaceArea() {
        //2lw+2lh+2hw
        return (2*this.length *this.width) + (2*this.length*this.height) + (2*this.height*this.width);
    }

}