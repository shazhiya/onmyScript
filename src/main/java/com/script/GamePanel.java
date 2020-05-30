package com.script;

import com.sun.jna.platform.win32.GDI32Util;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel {
    final static User32 win = User32.INSTANCE;
    WinDef.HWND hwnd = null;
    WinDef.RECT size = new  WinDef.RECT();
    WinDef.RECT position = new  WinDef.RECT();

    public static final int WM_LBUTTONUP = 514;
    public static final int WM_LBUTTONDOWN = 513;
    public static final int WM_LBUTTONDBLCLK = 0x203;
    static int WM_CLOSE = 0x10;

    public GamePanel(String _class, String title) {
        this.hwnd = win.FindWindow(_class, title);
        win.GetWindowRect(hwnd,size);
    }

    private WinDef.LPARAM MAKLPARAM(int mx, int my) {
        return new WinDef.LPARAM(mx + my * 65536);
    }

    private BufferedImage getImg() {
        return GDI32Util.getScreenshot(hwnd);
    }

    public Pixel getPixel(int x, int y) {
        return new Pixel(x, y, getImg().getRGB(x, y));
    }

    public boolean comparePixel(Pixel pixel) {
        return pixel.equals(loadPixel(pixel));
    }

    public Pixel loadPixel(Pixel pixel) {
        return getPixel(pixel.x, pixel.y);
    }

    public void click(int x, int y) {
        win.PostMessage(hwnd, WM_LBUTTONDOWN, new WinDef.WPARAM(1), MAKLPARAM(x, y));
        win.PostMessage(hwnd, WM_LBUTTONUP, new WinDef.WPARAM(0), MAKLPARAM(x, y));
    }

    public void clickInRect(int x, int y, int width, int height) {
        click(x + (int) (Math.random() * width), y + (int) (Math.random() * height));
    }

    public void sleep(int duration, int fluctuation) throws InterruptedException {
        Thread.sleep(duration + (int) (Math.random() * fluctuation * 2) - fluctuation);
    }

    public void printScreen(String path) throws IOException {
        BufferedImage a = GDI32Util.getScreenshot(hwnd);
        File outputfile = new File(path+".png");
        ImageIO.write(a, "png", outputfile);
        outputfile.exists();
    }

    public void showPanel() {
        win.MoveWindow(hwnd,100,100,size.right-size.left,size.bottom-size.top,true);
        win.ShowWindow(hwnd,1);
    }

    public void hidePanel() {
        win.MoveWindow(hwnd,-13000,0,size.right-size.left,size.bottom-size.top,true);
        win.ShowWindow(hwnd,1);
    }


}
