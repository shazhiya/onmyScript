import com.sun.jna.platform.win32.GDI32Util;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.image.BufferedImage;

public class GamePanel {
    User32 win = User32.INSTANCE;
    WinDef.HWND hwnd = null;

    public static final int WM_LBUTTONUP = 514;
    public static final int WM_LBUTTONDOWN = 513;
    public static final int WM_LBUTTONDBLCLK = 0x203;
    static int WM_CLOSE = 0x10;

    public GamePanel(String _class,String title) {
        this.hwnd = win.FindWindow(_class, title);
    }

    private WinDef.LPARAM MAKLPARAM(int mx, int my){
        return new WinDef.LPARAM(mx+my*65536);
    }
    private BufferedImage getImg(){
        return GDI32Util.getScreenshot(hwnd);
    }

    public Pixel getPixel(int x,int y){
        return new Pixel(x,y,getImg().getRGB(x, y));
    }

    public boolean comparePixel(Pixel pixel){
        return pixel.equals(loadPixel(pixel));
    }

    public Pixel loadPixel(Pixel pixel) {
        return getPixel(pixel.x,pixel.y);
    }

    public void click(int x,int y){
        win.PostMessage(hwnd,WM_LBUTTONDOWN,new WinDef.WPARAM(1),MAKLPARAM(x,y));
        win.PostMessage(hwnd,WM_LBUTTONUP,new WinDef.WPARAM(0),MAKLPARAM(x,y));
    }

    public void showPanel(){

    }

    public void hidePanel(){

    }

}
