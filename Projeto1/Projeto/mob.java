import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mob extends damage
{
    /**
     * Act - do whatever the mob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   int speed=-1;
    int count=0;
    public mob()
    {
        getImage().scale(30,30);
    }
    public void monster_movement()
    {
        if(count<100)
        setLocation(getX() +speed,getY());
        else
        {
            speed=-speed;
            getImage().mirrorHorizontally();
            count=0;
        }
    }
    public void act()
    {
        count++;
        monster_movement();
    }
    
}