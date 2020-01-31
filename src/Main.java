import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static com.sun.jna.platform.win32.WinUser.*;

public class Main {


    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();
        User32 win = User32.INSTANCE;
        WinDef.HWND handle = win.FindWindow(null, "夜神模拟器");
//        OnmWindow onm = new OnmWindow(handle);
//        System.out.println(onm.getColor(1144,680));


        WinDef.RECT pos = new WinDef.RECT();
        win.GetWindowRect(handle,pos);
        win.MoveWindow(handle,0,0,pos.right-pos.left,pos.bottom-pos.top,true);
        win.ShowWindow(handle,8);
    }

}
