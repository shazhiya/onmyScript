package com.script;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.script.behavior.Action;
import com.script.behavior.ActionFactory;
import com.script.status.Status;
import com.script.status.StatusFactory;

import java.util.HashMap;
import java.util.Map;

public class ScriptManager {
    private JSONObject config;
    private Map<String, Status> statusMap = new HashMap<>();
    private Map<String, Action> actionMap = new HashMap<>();
    public ScriptManager(JSONObject config) {
        this.config = config;
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

    }

    public void start(){

    }

}
