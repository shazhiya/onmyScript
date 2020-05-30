package com.script;

import java.awt.*;
import java.util.Objects;

public class Pixel {
    public int x,y;
    public Color color;

    public Pixel(int x, int y, Color rgb) {
        this.x = x;
        this.y = y;
        this.color = rgb;
    }

    public Pixel(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = new Color(color);
    }



    @Override
    public String toString() {
        return "Pixel{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pixel pixel = (Pixel) o;
        return x == pixel.x &&
                y == pixel.y &&
                Objects.equals(color, pixel.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
