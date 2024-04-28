import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class HeartPortal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class HeartPortal extends Blocks
{
    /**
     * Act - do whatever the HeartPortal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean level1= true; //variavel para saber se ainda estamos no nivel 1
    public HeartPortal(boolean level1){ //quando o portal e criado ele recebe o atributo se e do nivel 1 ou nao
        this.level1 = level1;
        resize_image(80,80);
    }
    
    public void changelevel(Barbie barbie, Ken ken){ 
        if(intersects(barbie) && intersects(ken) && level1){ //Se ambos os personagens tocam no portal e estamos no nivel 1
            startlevel2(); //comeca o nivel 2
            GreenfootSound portalsound = new GreenfootSound("portalsound.mp3");
            portalsound.play();
        }


         if(intersects(barbie) && intersects(ken) && !level1) { //Se ambos intersetam o portal e nao estamos no nivel 1
            wingame(); //inicia a tela de vitoria
        }
    }
    
    public void startlevel2(){ //inicia o nivel2
        UtilWorlds a = (UtilWorlds) getWorld(); 
        MyWorld b = (MyWorld) getWorld();
        UtilWorlds c = new Level2(a.getScore(),b.actCounter.getValue()); //Inicia o nivel 2 com o score do utilworlds, e o contador de tempo do primeiro mundo
        Greenfoot.setWorld(c); //munda para esse nivel criado
    }
    public void wingame(){
        UtilWorlds a = (UtilWorlds) getWorld();
        Level2 c = (Level2) getWorld();
        UtilWorlds V = new Victory(a.getScore(),c.actCounter.getValue()); //Inicia a tela de vitoria com o score do utilworlds, e o contador de tempo do jogo
        Greenfoot.setWorld(V); //muda para esta tela
    }
    public void act()
    {   
    if(level1){ //Se estiver no nivel 1, usa os personagens do nivel 1 como atributos
        MyWorld a= (MyWorld) getWorld();
        changelevel(a.barbie, a.ken);
    }
    if(!level1){ //Senao usa os do nivel 2
        Level2 b = (Level2) getWorld();
        changelevel(b.barbie,b.ken);
    }
    }
    }
