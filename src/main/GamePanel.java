package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    /// FIELDS
    // Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    /// CONSTRUCTORS
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
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
        while (gameThread != null)
        {
            // 1. UPDATE: Update the information of the game
            update();
            // 2. DRAW: Draw the screen with the updated information
            repaint();
        }
    }

    public void update()
    {

    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
    }
}
