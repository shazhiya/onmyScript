import java.awt.*;

public class Pixel {
    public int x,y;
    public Color color;

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
}
