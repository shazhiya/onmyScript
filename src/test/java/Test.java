import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.script.Configuration;
import com.script.Pixel;
import com.script.status.StatusFactory;

public class Test {

    @org.junit.Test
    public void test(){
        JSONObject json = Configuration.LoadConfiguration("E:\\webapplication\\win3Pro\\src\\main\\java\\com\\script\\cfg.json");
        System.out.println(StatusFactory.BuildColor(json.getJSONArray("pixels")));
    }
}
