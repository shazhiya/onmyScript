package com.script.scene;

import com.alibaba.fastjson.JSONObject;
import com.script.behavior.Action;
import com.script.scene.imply.SimpleScene;
import com.script.status.Status;

import java.util.Map;

public class SceneFactory {
    public static Scene SceneBuilder(JSONObject jsonObject, Map<String, Status> statusMap, Map<String, Action> actionMap){
        String type = jsonObject.getString("type");
        if (type==null|| type.equals("")||type.equals("simple")){
            return new SimpleScene(
                    jsonObject.getString("name"),
                    actionMap.get(jsonObject.getString("action")),
                    statusMap.get(jsonObject.getString("status")),
                    jsonObject.getJSONArray("candidates").toJavaList(String.class));
        }

        return null;
    }
}
