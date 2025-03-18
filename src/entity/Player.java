package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

/**
 * The Player class set the behaviours for the player character.
 */
public class Player extends Entity
{
    /// FIELDS
    GamePanel gamePanel;
    KeyHandler keyHandler;

    /// CONSTRUCTORS
    public Player(GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
    }

    /// METHODS
    public void update()
    {
        if (keyHandler.upPressed)
        {
            playerY -= playerSpeed;
        }
        if (keyHandler.downPressed)
        {
            playerY += playerSpeed;
        }
        if (keyHandler.rightPressed)
        {
            playerX += playerSpeed;
        }
        if (keyHandler.leftPressed)
        {
            playerX -= playerSpeed;
        }
    }

    public void draw()
    {
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(playerX, playerY, tileSize, tileSize);
    }
}
