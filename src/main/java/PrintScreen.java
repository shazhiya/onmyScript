import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PrintScreen {

    public static void main(String[] args) throws IOException {
        User32 win = User32.INSTANCE;
        WinDef.HWND wnd = win.FindWindow(null,"夜神模拟器");
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            scanner.hasNext();scanner.next();
            BufferedImage a = GDI32Util.getScreenshot(wnd);
            WinDef.RECT rect = new WinDef.RECT();
            win.GetWindowRect(wnd,rect);
            System.out.println(rect);
            File outputfile  = new File("capture_"+(i++)+"_.png");
            ImageIO.write(a,"png",outputfile);
        }


    }


}
