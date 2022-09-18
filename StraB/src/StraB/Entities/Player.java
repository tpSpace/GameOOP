package StraB.Entities;

import StraB.Controls.keyHandler;
import StraB.GUI.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entities{
    gamePanel gamepanel;
    keyHandler keyH;

    public Player(gamePanel gp, keyHandler key_H) {
        this.gamepanel = gp;
        this.keyH = key_H;

        setDefaultStats();
        getPlayerImage();
    }

    public void setDefaultStats() {
        x = 0;
        y = 0;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_up4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_down4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_left4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/PlayerWhite/player_right4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            }
            else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            }
            else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            else if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 8) {
                if (spriteNum != 4) {
                    spriteNum++;
                } else spriteNum = 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.WHITE);
        //g2.fillRect(x,y,gamepanel.tiles_size,gamepanel.tiles_size);

        BufferedImage img = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    img = up1;
                }
                if (spriteNum == 2) {
                    img = up2;
                }
                if (spriteNum == 3) {
                    img = up3;
                }
                if (spriteNum == 4) {
                    img = up4;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    img = down1;
                }
                if (spriteNum == 2) {
                    img = down2;
                }
                if (spriteNum == 3) {
                    img = down3;
                }
                if (spriteNum == 4) {
                    img = down4;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    img = left1;
                }
                if (spriteNum == 2) {
                    img = left2;
                }
                if (spriteNum == 3) {
                    img = left3;
                }
                if (spriteNum == 4) {
                    img = left4;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    img = right1;
                }
                if (spriteNum == 2) {
                    img = right2;
                }
                if (spriteNum == 3) {
                    img = right3;
                }
                if (spriteNum == 4) {
                    img = right4;
                }
                break;
        }
        g2.drawImage(img,x,y,gamepanel.tiles_size*2,gamepanel.tiles_size*2,null);

    }
}
