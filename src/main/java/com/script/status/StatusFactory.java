package com.script.status;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.script.Pixel;

import java.awt.*;
import java.util.ArrayList;

public class StatusFactory {

    public static Status BuildStatus(JSONObject status) {
        String type = status.getString("type");
        if (type == null) type = "simple";
        if (type.equals("simple")) {
            return new SimpleStatus(status.getString("name"), BuildColor(status.getJSONArray("pixels")));
        }
        return null;
    }

    public static ArrayList<Pixel> BuildColor(JSONArray colors) {
        ArrayList<Pixel> pixels = new ArrayList<Pixel>();
        for (int i = 0; i < colors.size(); i++) {
            JSONObject mid = colors.getJSONObject(i);
            pixels.add(new Pixel(mid.getIntValue("x"),mid.getIntValue("y"),new Color(mid.getIntValue("r"),mid.getIntValue("g"),mid.getIntValue("b"))));
        }
        return pixels;
    }

}
