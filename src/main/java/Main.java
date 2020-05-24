import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.User32.*;
import com.sun.jna.platform.win32.WinNT.*;
import com.sun.jna.platform.win32.WinNT.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.sun.jna.platform.win32.WinUser.*;

public class Main {


    public static void main(String[] args) {

        User32 win = User32.INSTANCE;
        GDI32 gdi = GDI32.INSTANCE;
        WinDef.HWND handle = win.FindWindow(null, "夜神模拟器");

//        while (true){
            BufferedImage cap = getImg(handle);
            System.out.println(new Pixel(432,363,cap.getRGB(432,363)));


//        }




    }

    private static LPARAM MAKLPARAM(int mx,int my){
        return new LPARAM(mx+my*65536);
    }

    private static BufferedImage getImg(HWND hwnd){
        return GDI32Util.getScreenshot(hwnd);
    }


}
