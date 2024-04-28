import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ken extends MainCharacters
{
    public GreenfootImage[] AnimationMotion_ken_right =
    {
        new GreenfootImage("standing_ken.png"),
        new GreenfootImage("2_ken.png"),
        new GreenfootImage("3_ken.png"),
        new GreenfootImage("4_ken.png")
    };
    public GreenfootImage[] AnimationMotion_ken_left =
    {
        new GreenfootImage("standing_ken.png"),
        new GreenfootImage("2_ken.png"),
        new GreenfootImage("3_ken.png"),
        new GreenfootImage("4_ken.png")
    };
    
    public Ken(){
        /*int Velocity,int Health,boolean FacingRight,boolean Jumping,boolean Walking*/
        super(4,2,true,false,false,-30);
        AnimationMotion_ken_left[0].mirrorHorizontally();
        AnimationMotion_ken_left[1].mirrorHorizontally();
        AnimationMotion_ken_left[2].mirrorHorizontally();
        AnimationMotion_ken_left[3].mirrorHorizontally();
    }
    /**
     * Act - do whatever the ken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        try{
        CoinColide(CoinKen.class);
        
        MyWorld world = (MyWorld) getWorld();
        
        movement("right","left","up",AnimationMotion_ken_right,
        AnimationMotion_ken_left);
        checkFalling();
        checkCollisionWithGround(Ground.class);
        checkCollisionWithBlockForbidden(BlocksForbidden.class);
        
        
        health(damage.class,world.getHeart(0),world.getHeart(1));
        gameover();
        
        //Abrir portas
        
        opendoorslevel1();
        
        
    }
    catch(Exception e){
    
        CoinColide(CoinKen.class);
        
        Level2 world = (Level2) getWorld();
        
        movement("right","left","up",AnimationMotion_ken_right,
        AnimationMotion_ken_left);
        checkFalling();
        checkCollisionWithGround(Ground.class);
        checkCollisionWithBlockForbidden(BlocksForbidden.class);
        
        
        health(damage.class,world.getHeart(0),world.getHeart(1));
        gameover();
    }
        
    }
}
