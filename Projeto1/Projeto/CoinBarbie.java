import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinBarbie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinBarbie extends Coins
{
    private int Points;
    
    /**
     * Act - do whatever the CoinBarbie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CoinBarbie(int Points){
        super();
        addPoints(Points);
        resize_butt(35,35);
    }
    public void act()
    {        
    }
}