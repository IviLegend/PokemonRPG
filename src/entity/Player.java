package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

        setDefaultValues();
        getPlayerImage();
    }

    /// METHODS
    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "Down";
    }

    /**
     * Load all player sprites.
     */
    public void getPlayerImage()
    {
        try
        {
            sprUp1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/sprPlayerUp.png"));
            sprDown1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/sprHildaRunDown1.png"));
            sprRight1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/sprPlayerRight.png"));
            sprLeft1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/sprPlayerLeft.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void update()
    {
        if (keyHandler.upPressed)
        {
            direction = "Up";
            y -= speed;
        }
        if (keyHandler.downPressed)
        {
            direction = "Down";
            y += speed;
        }
        if (keyHandler.rightPressed)
        {
            direction = "Right";
            x += speed;
        }
        if (keyHandler.leftPressed)
        {
            direction = "Left";
            x -= speed;
        }
    }

    public void draw(Graphics2D graphics2D)
    {
        BufferedImage image = null;

        switch (direction)
        {
            case "Up":
                image = sprUp1;
                break;
            case "Down":
                image = sprDown1;
                break;
            case "Right":
                image = sprRight1;
                break;
            case "Left":
                image = sprLeft1;
                break;
        }
        graphics2D.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
