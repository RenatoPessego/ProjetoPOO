import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hatch extends Blocks
{
    private boolean isbeingopen = false; //verifica se o alcapao esta aberto no momento
    /**
     * Act - do whatever the Hatch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isbeingopen(){ //retorn o valor do booleano
        return isbeingopen;
    }
    public void changebeingopen(){ //altera o valor do booleano para o seu oposto
        isbeingopen = !isbeingopen;
    }
    public Hatch(){
        GreenfootImage Hatch = getImage();
        Hatch.scale(120,15);
    }
    public void act()
    {
        // Add your action code here.
    }
}
