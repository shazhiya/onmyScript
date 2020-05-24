import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashMap;

public class Main {




    public static void main(String[] args) {
//        GamePanel onmyoji = new GamePanel(null,"夜神模拟器");
        JSONObject json =  Configuration.LoadConfiguration("E:\\webapplication\\win3Pro\\src\\main\\java\\cfg.json");
        System.out.println(json.get("test"));

    }

}
