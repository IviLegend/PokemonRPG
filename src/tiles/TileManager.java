package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    /// FIELDS
    public GamePanel gamePanel;
    public Tile[] tiles;
    int[][] mapTileNum;

    /// CONSTRUCTORS
    public TileManager(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
        tiles = new Tile[25];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap("room01.txt");
    }

    /// METHODS
    public void loadMap(String mapFileName)
    {
        try
        {
            InputStream inputStream = getClass().getResourceAsStream("/maps/" + mapFileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            
            int col = 0;
            int row = 0;

            while ((col < gamePanel.maxScreenCol) && (row < gamePanel.maxScreenRow))
            {
                String line = bufferedReader.readLine();

                while (col < gamePanel.maxScreenCol)
                {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col == gamePanel.maxScreenCol)
                {
                    col = 0;
                    row++;
                }
            }

            bufferedReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

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
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        // Draw the tilemap
        while ((col < gamePanel.maxScreenCol) && (row < gamePanel.maxScreenRow))
        {
            int tileNum = mapTileNum[col][row];

            graphics2D.drawImage(tiles[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            col++;
            x += gamePanel.tileSize;

            if (col == gamePanel.maxScreenCol)
            {
                col = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }
    }
}
