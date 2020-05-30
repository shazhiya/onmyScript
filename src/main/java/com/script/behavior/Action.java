package com.script.behavior;

import com.script.GamePanel;
import com.script.Pixel;

import java.util.List;

public abstract class Action {
    public String actionName;
    public abstract void execute(GamePanel gamePanel);

    public Action(String actionName) {
        this.actionName = actionName;
    }

}
