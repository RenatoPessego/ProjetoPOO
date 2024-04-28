import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barbie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barbie extends MainCharacters
{
    /*Importa as fotos num array*/
    public GreenfootImage[] AnimationMotion_barbie_right =
    {
        new GreenfootImage("standing_barbie.png"),
        new GreenfootImage("2.png"),
        new GreenfootImage("3.png"),
        new GreenfootImage("4.png")
    };
    public GreenfootImage[] AnimationMotion_barbie_left =
    {
        new GreenfootImage("standing_barbie.png"),
        new GreenfootImage("2.png"),
        new GreenfootImage("3.png"),
        new GreenfootImage("4.png")
    };
    
    public Barbie(){
        /*Velocidade,Vida*/
        super(4,2,false,false,false,-30);
        AnimationMotion_barbie_left[0].mirrorHorizontally();
        AnimationMotion_barbie_left[1].mirrorHorizontally();
        AnimationMotion_barbie_left[2].mirrorHorizontally();
        AnimationMotion_barbie_left[3].mirrorHorizontally();
    }
    
    public void act()
    {
    try{
        CoinColide(CoinBarbie.class);
        
        MyWorld world = (MyWorld) getWorld();
        
        movement("D","A","W",AnimationMotion_barbie_right,
        AnimationMotion_barbie_left);
        checkFalling();
        checkCollisionWithGround(Ground.class);
        checkCollisionWithBlockForbidden(BlocksForbidden.class);
        
        
        health(damage.class,world.getHeart(2),world.getHeart(3));
        gameover();
        
        //Abrir portas
        
        opendoorslevel1();
    }
    catch(Exception e){
    
        CoinColide(CoinBarbie.class);
        
        Level2 world = (Level2) getWorld();
        
        movement("D","A","W",AnimationMotion_barbie_right,
        AnimationMotion_barbie_left);
        checkFalling();
        checkCollisionWithGround(Ground.class);
        checkCollisionWithBlockForbidden(BlocksForbidden.class);
        
        
        health(damage.class,world.getHeart(2),world.getHeart(3));
        gameover();
    }
    
    }
}
