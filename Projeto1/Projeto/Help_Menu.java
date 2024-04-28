import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help_Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help_Menu extends UtilWorlds
{
    private final int DELTA=60;
    /**
     * Constructor for objects of class Help_Menu.
     * 
     */
    
    private void placeObjects(){
        addObject(back_button_helpmenu,
        DELTA,
        DELTA
        );
    }
    public Help_Menu()
    {    
        super(); 
        placeObjects(); 
    }
}
