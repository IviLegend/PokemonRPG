package entity;

import java.awt.image.BufferedImage;

/**
 * The Entity class is used for the Player and every NPC in the game.
 */
public class Entity
{
    public int x, y;
    public int speed;

    public BufferedImage
            sprUp1, sprUp2, sprUp3,
            sprDown1, sprDown2, sprDown3,
            sprRight1, sprRight2, sprRight3,
            sprLeft1, sprLeft2, sprLeft3;
    public String direction;
}
