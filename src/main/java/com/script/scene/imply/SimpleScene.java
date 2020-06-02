package com.script.scene.imply;

import com.script.GamePanel;
import com.script.behavior.Action;
import com.script.scene.Scene;
import com.script.status.Status;

import java.util.List;

public class SimpleScene extends Scene {
    public SimpleScene(String sceneName, Action action, Status currentStatus, List<String> candidates) {
        super(sceneName, action, currentStatus, candidates);
    }

    @Override
    public void show(GamePanel gamePanel) {
        action.execute(gamePanel);
    }
}
