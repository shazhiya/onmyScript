package com.script.behavior;

import com.alibaba.fastjson.JSONObject;
import com.script.behavior.actions.SimpleClick;
import com.script.diagram.Rect;

public class ActionFactory {

    public static Action BuildAction(JSONObject action){
        String actionType = action.getString("type");
        if ("click".equals(actionType)) {
            return new SimpleClick(
                    action.getString("name"),
                    new Rect(action.getIntValue("x"), action.getIntValue("y"), action.getIntValue("width"), action.getIntValue("height")));
        }
        return null;
    }

}
