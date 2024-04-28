import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends UtilWorlds
{
    private int score = 0;
    public GameOver(int score) //recebe o score final como atributo
    {
        super();
        this.score = score;
        prepare();
        
    }
    
    //@Overide
    public void scoreprefix() //Mostra o Score numa posicao diferente da funcao inicial
    {
        showText("Score: "+score,550,300);
    }
    
    private void prepare()
    {
        addObject(restart_gameover,550,450);
        scoreprefix();
    }
}
