import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends UtilWorlds
{
    private int score;
    private int StartingVelocity=5;
    private int timeElapsed;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public void act(){
        countframes();
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

    private void placeObjects(){ //coloca todos os objetos individuais deste mundo no mundo
        int worldWidth = getWidth();
        int worldHeight = getHeight();
        addObject(new Walls(),175, 580);
        addObject(new Walls(), 175, 555);
        addObject(new Ground(), 195, 550);
        addObject(new Ground(), 225, 550);
        addObject(new Ground(), 255, 550);
        addObject(new Ground(), 285, 550);
        addObject(new Ground(), 315, 550);
        addObject(new Walls(), 330, 580);
        addObject(new Walls(), 330, 555);
        addObject(new Walls(), 330, 530);
        addObject(new Walls(), 330, 510);
        addObject(new mob(), 930, 480);
        addObject(new Ground(), 350, 500);
        addObject(new Ground(), 380,500);
        addObject(new Ground(), 410,500);
        addObject(new Ground(), 440,500);
        addObject(new Ground(), 470,500);
        addObject(new Ground(), 500,500);
        addObject(new Ground(), 530,500);
        addObject(new Walls(), 550, 580);
        addObject(new Walls(), 550, 555);
        addObject(new Walls(), 550, 530);
        addObject(new Walls(), 550, 510);
        addObject(new Ground(), 585, 470);
        addObject(new Ground(), 630, 425);
        addObject(new Ground(), 760, 450);
        addObject(new Ground(), 655, 390);
        addObject(new Ground(), 685, 390);
        addObject(new Ground(), 715, 390);
        addObject(new Ground(), 535, 390);
        addObject(new Ground(), 505, 390);
        addObject(new Ground(), 475, 390);
        addObject(new Ground(), 445, 390);
        addObject(new Ground(), 415, 390);
        addObject(new Walls(), 815, 580);
        addObject(new Walls(), 815, 555);
        addObject(new Walls(), 815, 530);
        addObject(new Walls(), 815, 510);
        addObject(new Ground(), 835, 500);
        addObject(new Ground(), 865, 500);
        addObject(new Ground(), 895, 500);
        addObject(new Ground(), 925, 500);
        addObject(new Ground(), 955, 500);
        addObject(new Walls(), 970, 530);
        addObject(new Walls(), 970, 510);
        addObject(new Ground(),980, 550);
        addObject(new Ground(),1010, 550);
        addObject(new Walls(), 1025, 580);
        addObject(new Walls(), 1025, 555);
        addObject(new Ground(), 780, 300);
        addObject(new Ground(), 810, 300);
        addObject(new Ground(), 840, 300);
        addObject(new Ground(), 870, 300);
        addObject(new Ground(), 900, 300);
        addObject(new Ground(), 930, 300);
        addObject(new Ground(), 960, 300);
        addObject(new Ground(), 610, 310);
        addObject(new Ground(), 580, 310);
        for(int i=0; i<7; i++){
        addObject(new Ground(), 530 - (30*i), 300);
        }
        addObject(new Walls(), 335, 285);
        addObject(new Walls(), 335, 265);
        for(int i=0; i <5; i++){
            addObject(new Ground(), 315 - (30 * i), 255);
        }
        addObject(new Walls(), 180, 215);
        addObject(new Walls(), 180, 240);
        addObject(new Ground(), 170, 205);
        addObject(new Ground(), 140, 205);
        addObject(new Walls(), 120, 190);
        addObject(new Walls(), 120, 165);
        addObject(new Walls(), 120, 140);
        addObject(new Walls(), 120, 115);
        for(int i = 0; i < 15; i++){
            addObject(new Ground(), 260 + (i*30),145);
        }
        addObject(new mob(), 515, 367);
        addObject(new mob(), 790, 575);
        addObject(new mob(), 690, 575);
        addObject(new mob(), 300, 530);
        addObject(new Spikes(), 640, 500);
        addObject(new NavalBomb(), 450, 205);
        addObject(new CoinBarbie(30),470,115);
        addObject(new CoinKen(30),525,115);
        addObject(new CoinBarbie(30),550,260);
        addObject(new CoinKen(30),880,260);
        addObject(new HeartPortal(false),310,95);
        
        addObject(heartken,94,80);
        addObject(heartken2,50,80);
        addObject(heartbarbie,getWidth()-94,80);
        addObject(heartbarbie2,getWidth()-50,80);
        addObject(BarbieText,1030,56);
        addObject(KenText,70,56);
        
        
        actCounter = new Counter("Tempo: ");
        addObject(actCounter, 550, worldHeight/20);
    }
    
    public void prepare(){
        addPlatform();
        placewalls();
        placeObjects();
        addMainCharacters();
    } //coloca todos os objetos necessarios para o bom funcionamento do jogo
    
    public Level2(int score,int value) //recebe o score do mundo anterior e o tempo para continuar de onde parou
    {
        super();
        addScore(score);
        setimelapsed(value);
        prepare();
    } 
}
