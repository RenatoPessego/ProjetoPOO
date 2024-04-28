import greenfoot.*;

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor 
{
    private int Points;
    public void resize_butt(int width,int height){
        GreenfootImage image = getImage();  
        image.scale(width, height);
        setImage(image);
    }
    
    public int getPoints(){
        return Points;
    }
    public void addPoints(int amount){
        Points+=amount;
    }
    
    public Coins(){
        this.Points=Points;
    }
}
