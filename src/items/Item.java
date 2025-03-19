package items;

import java.awt.image.BufferedImage;

/**
 * The abstract class Item serves to make objects.
 */
public abstract class Item
{
    /// FIELDS
    // Item information
    public String name;
    public String description;
    public BufferedImage icon;

    // Economy values
    public int purchasePrice;
    public int sellingPrice;
}
