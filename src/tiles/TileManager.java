package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager
{
    /// FIELDS
    public GamePanel gamePanel;
    public Tile[] tiles;

    /// CONSTRUCTORS
    public TileManager(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
        tiles = new Tile[25];

        getTileImage();
    }

    /// METHODS
    public void getTileImage()
    {
        try
        {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tileGrass1.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tileWall1.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D)
    {
        for (int i = 0; i < gamePanel.maxScreenCol; i++)
        {
            for (int j = 0; j < gamePanel.maxScreenRow; j++)
            {
                if (i == 0)
                {
                    graphics2D.drawImage(tiles[1].image, (i * 48), (j * 48), gamePanel.tileSize, gamePanel.tileSize, null);
                }
                else
                {
                    graphics2D.drawImage(tiles[0].image, (i * 48), (j * 48), gamePanel.tileSize, gamePanel.tileSize, null);
                }
            }
        }
    }
}
