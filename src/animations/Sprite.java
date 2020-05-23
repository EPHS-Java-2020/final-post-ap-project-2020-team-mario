package animations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Sprite extends JPanel{

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    //protected Image image;

    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }
    
    protected abstract void drawImage(Graphics g);

    public int getX() {
        return x;
    }
    public void setX(int x) {
    this.x=x;
    }
    
    
    public int getY() {
        return y;
    }
    public void setY(int y) {
    this.y=y;
    }
    
    
    public void setWidth(int width)
    {
    this.width=width;
    }
    public int getWidth()
    {
    return width;
    }
    
    
    public void setHeight(int height)
    {
    this.height=height;
    }
    public int getHeight(int height)
    {
    return height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}

