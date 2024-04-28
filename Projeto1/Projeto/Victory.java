import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Victory extends UtilWorlds
{
    
    /**
     * Constructor for objects of class Victory.
     * 
     */
    public Victory(int score,int value) //Mostra as informacoes do jogo
    {
        addObject(restart_gameover,550,450);
        addObject(actCounter,550,100);
        actCounter.setValue(value);
        actCounter.setPrefix("Demorou: ");
        actCounter.setSuffix(" segundos");
        showText("Score: "+score,50,Height/20);
        GreenfootSound victorymusic = new GreenfootSound("victorymusic.mp3");         
        victorymusic.play();
        // if(restart_gameover.restartgame()){
            // victorymusic.stop();
        // }
    }
}
