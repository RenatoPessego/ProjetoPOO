import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends UtilWorlds
{

    public MyWorld()
    {    
        // Create a new world with 1100x600 cells with a cell size of 1x1 pixels.
        super();
        prepare();
        scoreprefix();
    }

    private void placeObjects() { //coloca todos os objetos individuais deste mundo no mundo
        int worldWidth = getWidth();
        int worldHeight = getHeight();
        addObject(new Ground(),160,300);
        addObject(new Ground(),190,300);
        addObject(new Ground(),130,300);
        addObject(new Ground(),220,300);
        addObject(new Ground(),310,260);
        addObject(new Ground(),430,265);
        addObject(new Ground(),540,240);
        addObject(new Ground(),350,400);
        addObject(new Ground(),615,300);
        addObject(new Ground(),705,240);
        addObject(new Ground(),780,275);
        addObject(new Ground(),280,355);
        addObject(new Ground(),840,325);
        addObject(new Ground(),980,400);
        addObject(new Ground(),925,360);
        addObject(new NavalBomb(),750,300);
        addObject(new NavalBomb(),160,250);
        addObject(new Ground(),340,260);
        addObject(new Ground(),645,300);
        addObject(new Ground(),505,260);
        addObject(getPortao(1),185,535);
        addObject(getPortao(2),490,535);
        addObject(getPortao(3),490, 415);
        addObject(getPortao(4), 695, 415);
        addObject(getPortao(5), 840, 535);
        addObject(getPlate(1),110, 585);
        addObject(getPlate(2),770,585);
        addObject(getPlate(3), 740, 465);
        addObject(getPlate(4),1060,465);
        addObject(getHatch(1), 620, 235);
        addObject(new HeartPortal(true),90,430);
        addObject(new Spikes(), 435, 375);
        for(int i= 0; i <=13;i++){
            addObject(new Ground(),15 + (i * 30), 480);
        }
        for(int i= 23; i <=36;i++){
            addObject(new Ground(),15 + (i * 30), 480);
         }
        addObject(new CoinBarbie(30),630,270);
        addObject(new CoinKen(30),800,410);
        addObject(heartken,94,80);
        addObject(heartken2,50,80);
        addObject(heartbarbie,getWidth()-94,80);
        addObject(heartbarbie2,getWidth()-50,80);
        addObject(BarbieText,1030,56);
        addObject(KenText,70,56);
        
        
        actCounter = new Counter("Tempo: ");
        addObject(actCounter, 550, worldHeight/20);

    }

    
    
    public void prepare() //coloca todos os objetos necessarios para o bom funcionamento do jogo
    {
        addPlatform();
        placewalls();
        placeObjects();
        addMainCharacters();
        
    }
    
    public Heart getHeart(int n){ //retorna o coracao desejado
        switch(n){
            case 0:
                return heartken;
            case 1:
                return heartken2;
            case 2:
                return heartbarbie;
            case 3:
                return heartbarbie2;
        }
        return null;
    
    }
    
    public void act()
    {
        countframes();
    }
    
}
