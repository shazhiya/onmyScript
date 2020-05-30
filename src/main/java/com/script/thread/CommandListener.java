package com.script.thread;

import com.script.GamePanel;

import java.io.IOException;
import java.util.Scanner;

public class CommandListener implements Runnable {


    GamePanel gamePanel = null;

    public CommandListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    @Override
    public void run() {
        Scanner commander = new Scanner(System.in);
        while (commander.hasNextLine()){
            String instruct = commander.nextLine();
            if (instruct.equals("show")) gamePanel.showPanel();
            if (instruct.equals("hide")) gamePanel.hidePanel();
            if (instruct.split(" ")[0].equals("capture")){
                try {
                    if (instruct.split(" ")[1] == null || instruct.split(" ")[1].equals("")) continue;
                    gamePanel.printScreen(instruct.split(" ")[1]);
                    System.out.println("ok");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("failure");
                }
            }
        }
    }
}
