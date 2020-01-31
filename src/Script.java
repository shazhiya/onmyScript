import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Script {


    public static void main(String[] args) {

        String state = "0";
        Map<String, ArrayList<ColorOfPoint>> map;
        map = new HashMap<>();


        {
            ArrayList<ColorOfPoint> l = new ArrayList<>();
//            l.add(new ColorOfPoint(1144,680,new Color(230,40,24)));
            l.add(new ColorOfPoint(1143,691,new Color(232,205,87)));
            map.put("0", l);

        }
        {
            ArrayList<ColorOfPoint> l = new ArrayList<>();
            l.add(new ColorOfPoint(1139,97,new Color(233,225,209)));
            map.put("1", l);

        }
        {
            ArrayList<ColorOfPoint> l = new ArrayList<>();
//            l.add(new ColorOfPoint(1164,585,new Color(245,217,184)));
            l.add(new ColorOfPoint(614,576,new Color(225,184,90)));
            map.put("2", l);

        }

        {
            ArrayList<ColorOfPoint> l = new ArrayList<>();
            l.add(new ColorOfPoint(573 ,312,new Color(160,143,111)));
            map.put("4", l);

        }


        User32 win = User32.INSTANCE;
        WinDef.HWND handle = win.FindWindow(null, "夜神模拟器");
        OnmWindow onm = new OnmWindow(handle);
//        int num = 0;
        while (true){

                if (state.equals("0")){
//                    if(num++>=555){
//                        win.CloseWindow(handle);
//                    }
                    int x = 1100,y=630;
                    onm.robot.delay(500+(int)(Math.random()*1000));
                    onm.click(x + (int)(Math.random()*100),y+(int)(Math.random()*100));
                    onm.robot.delay(5000);
                    state = "1";
                }
                if (state.equals("1")) {
                    onm.robot.delay(1000);
                }
                if (state.equals("2") ) {
                    /*
                    * 20,400 - 220,600
                    * */

                    int x = 20,y=400;
                    onm.robot.delay(500+(int)(Math.random()*1000));
                    onm.click(x+(int)(Math.random()*200),y+(int)(Math.random()*200));

                }
            if (state.equals("4") ) {
                /*
                 * 20,400 - 220,600
                 * */

                int x = 20,y=400;
                onm.robot.delay(500+(int)(Math.random()*1000));
                onm.click(x+(int)(Math.random()*200),y+(int)(Math.random()*200));

            }
                if (state.equals("3")){
                    onm.robot.delay(100);
                }



                    state = "3";
                    System.out.println("default");
                    for(String key : map.keySet()){
                        if (onm.colors(map.get(key))){
                            state = key;
                            break;
                        }
                    }
                    System.out.println(state);
                    onm.robot.delay(1000);

        }

    }
}
