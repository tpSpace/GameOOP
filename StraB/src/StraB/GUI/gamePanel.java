package StraB.GUI;

import StraB.Controls.keyHandler;
import StraB.Entities.Player;

import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable {
    public final int tiles_size = 16,
            WIDTH = tiles_size * 16,
            HEIGHT = tiles_size * 9,
            FPS = 60;
    static int scale = 3;

    //Player Start

    keyHandler keyH = new keyHandler();

    public gamePanel() {
        this.setPreferredSize(new Dimension(WIDTH*scale,HEIGHT*scale));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    Thread gameThread;

    Player player = new Player(this, keyH);

    public void start_gameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS, delta = 0;
        long lastTime = System.nanoTime(), currentTime, timer = 0;
        int Count = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                Count++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + Count);
                Count = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}
