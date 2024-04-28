import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Play(int Width,int Height){
        super();
        resize_butt(150,150);
    }
    public void HistoryMenu(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new HistoryScreen());
        }
    }
    public boolean StartGame(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MyWorld());
            return true;
        }
        return false;
    }
    public void act()
    {
    }
}
