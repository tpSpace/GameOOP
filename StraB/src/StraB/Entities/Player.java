package StraB.Entities;

import StraB.Controls.keyHandler;
import StraB.GUI.gamePanel;

import java.awt.*;

public class Player extends Entities{
    gamePanel gamepanel;
    keyHandler keyH;

    public Player(gamePanel gp, keyHandler key_H) {
        this.gamepanel = gp;
        this.keyH = key_H;

        setDefaultStats();
    }

    public void setDefaultStats() {
        x = 72;
        y = 72;
        speed = 4;
    }

    public void update() {
        if (keyH.upPressed) y -= speed;
        else if (keyH.downPressed) y += speed;
        else if (keyH.leftPressed) x -= speed;
        else if (keyH.rightPressed) x += speed;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,gamepanel.tiles_size,gamepanel.tiles_size);
    }
}
