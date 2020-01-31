import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class OnmWindow {

    WinDef.HWND self = null;
    WinDef.RECT rect = new WinDef.RECT();
    private User32 win = User32.INSTANCE;
    Robot robot = null;
    int mouseLeftDown = 513;
    int mouseLeftup = 514;

    boolean bindSelf(WinDef.HWND window){
        if (window == null) return false;
        this.self = window;
        return true;
    }

    public OnmWindow(WinDef.HWND self) {
        this.self = self;
        init();
    }

    public OnmWindow() {
    }

    private boolean init(){
        win.GetWindowRect(self,rect);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            return false;
        }
        return true;
    }


    public boolean click(int x, int y)  {
        win.GetWindowRect(self,rect);
        win.SetFocus(self);
        win.SetForegroundWindow(self);
        win.ShowWindow(self,8);
        robot.mouseMove(x+rect.left,y+rect.top);
        robot.delay(100);
        robot.mousePress(KeyEvent.BUTTON1_MASK);
        robot.delay((int)(Math.random()*100)+100);
        robot.mouseRelease(KeyEvent.BUTTON1_MASK);
        return true;
    }


    public Color getColor(int x,int y){
        win.GetWindowRect(self,rect);
        win.SetFocus(self);
        win.SetForegroundWindow(self);
        win.ShowWindow(self,8);
        return robot.getPixelColor(x+rect.left,y+rect.top);
    }

    public boolean colors(ArrayList<ColorOfPoint> points){
        win.GetWindowRect(self,rect);
        win.SetFocus(self);
        win.SetForegroundWindow(self);
        win.ShowWindow(self,8);
        for(ColorOfPoint point : points){
            if (!robot.getPixelColor(rect.left+point.x,rect.top+point.y).equals(point.color)) return false;
        }
        return true;
    }

}
