package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The class KeyHandler manages everything related to inputs.
 */
public class KeyHandler implements KeyListener
{
    /// FIELDS
    public boolean upPressed, downPressed, rightPressed, leftPressed;

    /// METHODS
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) { upPressed = true; }
        if (code == KeyEvent.VK_S) { downPressed = true; }
        if (code == KeyEvent.VK_D) { rightPressed = true; }
        if (code == KeyEvent.VK_A) { leftPressed = true; }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) { upPressed = false; }
        if (code == KeyEvent.VK_S) { downPressed = false; }
        if (code == KeyEvent.VK_D) { rightPressed = false; }
        if (code == KeyEvent.VK_A) { leftPressed = false; }
    }
}
