import com.alibaba.fastjson.JSONObject;
import com.script.Configuration;
import com.script.GamePanel;
import com.script.Pixel;
import com.script.thread.CommandListener;

import java.awt.*;


public class Main {




    public static void main(String[] args) throws InterruptedException {
        GamePanel onmyoji = new GamePanel(null,"夜神模拟器");
        System.out.println("script is ready");

        JSONObject json =  Configuration.LoadConfiguration("E:\\webapplication\\win3Pro\\src\\main\\java\\cfg.json");
        System.out.println(json.get("test"));

        Pixel start = new Pixel(432,388,new Color(219,35,33));
        Pixel finish = new Pixel(467,469,new Color(113,28,15));
        Thread commander = new Thread(new CommandListener(onmyoji));
        commander.start();

        while (true){
            onmyoji.sleep(200,0);
            if (onmyoji.comparePixel(finish)){
                onmyoji.clickInRect(640,360,280,170);
                onmyoji.sleep(300,100);
            }

            if (onmyoji.comparePixel(start)){
                onmyoji.clickInRect(830,470,90,80);
                onmyoji.sleep(300,100);
            }
        }

    }

}
