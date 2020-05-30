package com.script.status;

import com.script.GamePanel;
import com.script.Pixel;

import java.util.List;

public class SimpleStatus extends Status {
    public SimpleStatus(String statusName, List<Pixel> pixels) {
        super(statusName, pixels);
    }

    @Override
    public String getStatusName() {
        return this.statusName;
    }

    @Override
    public List<Pixel> getPixels() {
        return this.pixels;
    }

    @Override
    public boolean judge(GamePanel gamePanel) {
        for (Pixel pix : this.pixels) {
            if (!gamePanel.comparePixel(pix)) return false;
        }
        return true;
    }
}
