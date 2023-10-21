/**
 * Description: The Box class represents a box with dimensions for length, width, and height.
 * It provides methods to set and retrieve dimensions, calculate volume, and surface area.
 */
public class Box {
    private double length; // The length of the box.
    private double width;  // The width of the box.
    private double height; // The height of the box.

    /**
     * Constructs a new Box for length, width, and height.
     */
    public Box() {
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
    }

    /**
     * Get the length of the box.
     *
     * @return The length of the box.
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Get the width of the box.
     *
     * @return The width of the box.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Get the height of the box.
     *
     * @return The height of the box.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Set the length of the box.
     *
     * @param length The length of the box.
     * @throws IllegalArgumentException if the length is not greater than 0.0.
     */
    public void setLength(double length) {
        if (length > 0.0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be greater than 0.0");
        }
    }

    /**
     * Set the width of the box.
     *
     * @param width The width of the box.
     * @throws IllegalArgumentException if the width is not greater than 0.0.
     */
    public void setWidth(double width) {
        if (width > 0.0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be greater than 0.0");
        }
    }

    /**
     * Set the height of the box.
     *
     * @param height The height of the box.
     * @throws IllegalArgumentException if the height is not greater than 0.0.
     */
    public void setHeight(double height) {
        if (height > 0.0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be greater than 0.0");
        }
    }

    /**
     * Calculate the volume of the box.
     *
     * @return The volume of the box, rounded to two decimal places.
     */
    public double getVolume() {
        return roundToHundreds(this.length * this.width * this.height);
    }

    /**
     * Calculate the surface area of the box.
     *
     * @return The surface area of the box, rounded to two decimal places.
     */
    public double getSurfaceArea() {
        return roundToHundreds((2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.height * this.width));
    }

    /**
     * Rounds a double value to two decimal places.
     *
     * @param value The value to be rounded.
     * @return The rounded value.
     */
    public double roundToHundreds(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}