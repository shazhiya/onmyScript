package com.script;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.script.behavior.Action;
import com.script.behavior.ActionFactory;
import com.script.scene.Scene;
import com.script.scene.SceneFactory;
import com.script.status.Status;
import com.script.status.StatusFactory;

import java.util.HashMap;
import java.util.Map;

public class ScriptManager {
    private JSONObject config;
    private Map<String, Status> statusMap = new HashMap<>();
    private Map<String, Action> actionMap = new HashMap<>();
    private Map<String, Scene> sceneMap = new HashMap<>();
    private GamePanel gamePanel = null;
    public ScriptManager(JSONObject config, GamePanel gamePanel) {
        this.config = config;
        this.gamePanel = gamePanel;
        init();
    }

    private void init(){
        JSONArray statusList = config.getJSONArray("status");
        for (int i = 0; i< statusList.size();i++){
            JSONObject object = statusList.getJSONObject(i);
            statusMap.put(object.getString("name"), StatusFactory.BuildStatus(object));
        }

        JSONArray actionList = config.getJSONArray("actions");
        for (int i = 0; i< actionList.size();i++){
            JSONObject object = actionList.getJSONObject(i);
            actionMap.put(object.getString("name"), ActionFactory.BuildAction(object));
        }

        JSONArray sceneList = config.getJSONArray("scenes");
        for (int i = 0; i< sceneList.size();i++){
            JSONObject object = actionList.getJSONObject(i);
            sceneMap.put(object.getString("name"), SceneFactory.SceneBuilder(object,statusMap,actionMap));
        }


    }

    public void start(){
        new Thread(() -> {
            while (true){
                for (String scene: sceneMap.keySet()){
                    Scene sce = sceneMap.get(scene);
                    while (sce!=null){
                        sce.show(gamePanel);
                        sce = sce.gotoNextScene(sceneMap,gamePanel);
                    }
                }
            }
        }).start();
    }

}
