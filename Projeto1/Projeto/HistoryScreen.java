import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HistoryScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoryScreen extends UtilWorlds
{
    /**
     * Constructor for objects of class HistoryScreen.
     * 
     */
    Play playgame = new Play(getWidth(),getHeight());
    GreenfootSound barbieminaj = new GreenfootSound("plsmusic.mp3");
    public HistoryScreen()
    {
        addObject(playgame, 550, 500);
        barbieminaj.play();
        
        
    }
    public void act(){
        playgame.StartGame();
        if(playgame.StartGame()){
            barbieminaj.stop();
        }
    }
}
