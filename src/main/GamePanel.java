package main;

import entity.Player;

import javax.swing.JPanel;
import java.awt.*;

/**
 * The class GamePanel contains all the screen information.
 * This class manages the Game Loop, which updates and
 * redraws the screen every frame.
 */
public class GamePanel extends JPanel implements Runnable
{
    /// FIELDS
    // Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    // Game controlers
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Frames values
    int FPS = 60;

    // Player values
    Player player = new Player(this, keyHandler);
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    /// CONSTRUCTORS
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    /// METHODS
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        int drawCount = 0;

        while (gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) { System.out.println("FPS: " + drawCount); drawCount = 0; timer = 0; }
        }
    }

    public void update()
    {
        player.update();

    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        player.draw(graphics2D);

        graphics2D.dispose();
    }
}
