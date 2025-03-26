package entity;

import data.Medal;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * The Player class set the behaviours for the player character.
 */
public class Player extends Trainer
{
    /// FIELDS
    GamePanel gamePanel;
    KeyHandler keyHandler;

    static boolean hasShinyCharm = false;

    // Trainer card
    public String playerID;
    public String playerName;
    public int money;
    public int registeredPokemons;
    public Medal[] medals;
    public LocalDateTime startDate;

    // Sprites
    public BufferedImage
            sprHildaWalkUp1, sprHildaWalkUp2, sprHildaWalkUp3, sprHildaWalkUp4,
            sprHildaWalkDown1, sprHildaWalkDown2, sprHildaWalkDown3, sprHildaWalkDown4,
            sprHildaWalkRight1, sprHildaWalkRight2, sprHildaWalkRight3, sprHildaWalkRight4,
            sprHildaWalkLeft1, sprHildaWalkLeft2, sprHildaWalkLeft3, sprHildaWalkLeft4;

    /// CONSTRUCTORS
    public Player(GamePanel gamePanel, KeyHandler keyHandler, String playerName)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.playerName = playerName;

        playerID = "0151";
        registeredPokemons = 0;
        money = 0;
        medals = new Medal[8];
        startDate = LocalDateTime.now();

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
            sprHildaWalkUp1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkUp1.png"));
            sprHildaWalkUp2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkUp2.png"));
            sprHildaWalkUp3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkUp3.png"));
            sprHildaWalkUp4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkUp4.png"));

            sprHildaWalkDown1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkDown1.png"));
            sprHildaWalkDown2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkDown2.png"));
            sprHildaWalkDown3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkDown3.png"));
            sprHildaWalkDown4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkDown4.png"));

            sprHildaWalkRight1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkRight1.png"));
            sprHildaWalkRight2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkRight2.png"));
            sprHildaWalkRight3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkRight3.png"));
            sprHildaWalkRight4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkRight4.png"));

            sprHildaWalkLeft1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkLeft1.png"));
            sprHildaWalkLeft2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkLeft2.png"));
            sprHildaWalkLeft3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkLeft3.png"));
            sprHildaWalkLeft4 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/hilda/walk/sprHildaWalkLeft4.png"));
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
                image = sprHildaWalkUp1;
                break;
            case "Down":
                image = sprHildaWalkDown1;
                break;
            case "Right":
                image = sprHildaWalkRight1;
                break;
            case "Left":
                image = sprHildaWalkLeft1;
                break;
        }
        graphics2D.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
