package com.script.status;

import com.script.GamePanel;
import com.script.Pixel;

import java.util.List;

public abstract class Status {
    protected String statusName;
    protected List<Pixel> pixels;
    public Status(String statusName, List<Pixel> pixels) {
        this.statusName = statusName;
        this.pixels = pixels;
    }

    public abstract String getStatusName();
    public abstract List<Pixel> getPixels();
    public abstract boolean judge(GamePanel gamePanel);

}
