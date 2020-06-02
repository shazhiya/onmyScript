package com.script.behavior;

import com.script.GamePanel;

public abstract class Action {
    public String actionName;
    public abstract void execute(GamePanel gamePanel);

    public Action(String actionName) {
        this.actionName = actionName;
    }

}
