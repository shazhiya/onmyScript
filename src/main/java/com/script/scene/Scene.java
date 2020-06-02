package com.script.scene;

import com.script.GamePanel;
import com.script.behavior.Action;
import com.script.status.Status;

import java.util.List;
import java.util.Map;

public abstract class Scene {

    protected String sceneName;
    protected Action action;
    protected Status currentStatus;
    protected List<String> candidates;

    public Scene(String sceneName, Action action, Status currentStatus, List<String> candidates) {
        this.sceneName = sceneName;
        this.action = action;
        this.currentStatus = currentStatus;
        this.candidates = candidates;
    }

    public abstract void show(GamePanel gamePanel);

    public Scene gotoNextScene(Map<String,Scene> sceneMap,GamePanel gamePanel){
        for (String nextScene : candidates) {
            if (sceneMap.get(nextScene).currentStatus.judge(gamePanel)) return sceneMap.get(nextScene);
        }
        return null;
    }


}
