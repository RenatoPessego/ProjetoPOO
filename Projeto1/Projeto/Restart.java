import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Button
{
    /**
     * Act - do whatever the Restart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean restartgame(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Start_Menu());
            return true;
        }
        else{
            return false;
        }
    }
    public void act()
    {
        restartgame();
    }
}
