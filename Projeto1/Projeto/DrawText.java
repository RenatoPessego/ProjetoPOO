import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DrawText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawText extends Actor
{
    /**
     * Act - do whatever the DrawText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public DrawText(String s,int size,Color Cletter,Color background){
        setImage(new GreenfootImage(s, size,Cletter,background));
    }
    public void act()
    {
        // Add your action code here.
    }
}
