package com.script.behavior.actions;

import com.script.GamePanel;
import com.script.behavior.Action;
import com.script.diagram.Rect;


public class SimpleClick extends Action {

    private Rect clickRect;

    public SimpleClick(String actionName, Rect clickRect) {
        super(actionName);
        this.clickRect = clickRect;
    }

    @Override
    public void execute(GamePanel gamePanel) {
        gamePanel.clickInRect(
                clickRect.getX(),
                clickRect.getY(),
                clickRect.getWidth(),
                clickRect.getHeight());
    }
}
