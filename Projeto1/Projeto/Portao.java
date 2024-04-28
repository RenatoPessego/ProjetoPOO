import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portao extends BlocksForbidden
{
    private boolean isbeingopen = false; //Verifica se a porta esta aberta no momento
    /**
     * Act - do whatever the Portao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isbeingopen(){ //retorna o booleano
        return isbeingopen;
    }
    public void changebeingopen(){ //altera o booleano para o seu oposto
        isbeingopen = !isbeingopen;
    }
    public Portao() {
        resize_image(15,120);
    }
    public void act()
    {
        
    }
}
