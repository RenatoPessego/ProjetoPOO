import greenfoot.*;

/**
 * Write a description of class UtilWorlds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UtilWorlds extends World
{
    /*Alocar espaço na memoria*/
    Restart restart_gameover = new Restart();
    Back back_button_helpmenu = new Back(getWidth(),getHeight());
  
    Heart heartken = new Heart();
    Heart heartken2 = new Heart();
    Heart heartbarbie = new Heart();
    Heart heartbarbie2 = new Heart();
    Barbie barbie = new Barbie();
    Ken ken = new Ken();
    private PressurePlate plate = new PressurePlate();
    private Portao portao = new Portao();
    private Portao portao2 = new Portao();
    private Portao portao3 = new Portao();
    private Portao portao4 = new Portao();
    private Portao portao5 = new Portao();
    private PressurePlate plate2 = new PressurePlate();
    private PressurePlate plate3 = new PressurePlate();
    private PressurePlate plate4 = new PressurePlate();
    private PressurePlate plate5 = new PressurePlate();
    private Hatch hatch = new Hatch();
    Counter actCounter = new Counter("Tempo : ");
    CoinBarbie coinBarbie = new CoinBarbie(30);
    CoinKen coinKen = new CoinKen(10);
    Spikes spikes = new Spikes();
    DrawText BarbieText = new DrawText(Barbie,CharactersTextSize,CharactersTextColor,transparent);
    DrawText KenText = new DrawText(Ken,CharactersTextSize,CharactersTextColor,transparent);
    
    public static final Color transparent = new Color(0,0,0,0);
    public static final String Barbie = "Barbie";
    public static final String Ken = "Ken";
    public static final int CharactersTextSize=20;
    public static final Color CharactersTextColor=Color.MAGENTA;
    /*Alocar espaço na memoria*/
    int Height= getHeight();
    int Width = getWidth();
    private int timeCounter;
    private int timeElapsed;
    private int score=0;
    private String prefix="Score: ";
    

    
    public void placewalls(){ //coloca as paredes em volta do mundo
        for(int i=0; i<=23; i++){
            addObject(new Walls(), 1096, 579 - (i*25));
        }
        for(int i=0; i<=23; i++){
            addObject(new Walls(), 4, 579 - (i*25));
        }
        for(int i=0; i<=44; i++){
            addObject(new CopyOfWalls(), 20 + (i * 25), 4);
        }
    
    }
    public void addPlatform(){ //coloca o chao
        for(int i= 0; i <=36;i++){
            addObject(new Ground(),15 + (i * 30), 598);
        }

    }
    public void setimelapsed(int value){
        timeElapsed+=value;
    }
    public int getScore(){
        return score;
    }
    
    public void addScore(int amount){
        score+=amount;
        scoreprefix();
    }
    
    public void removeScore(int amount){
        score-=amount;
    }
    
    public void scoreprefix()
    {
        showText("Score: "+getScore(),50,Height/20);
    }
    public void countframes(){
        timeCounter = (timeCounter+1)%55;
            if (timeCounter == 0)
            {
                timeElapsed++;

            }
            actCounter.setValue(timeElapsed + 1);
    }
    public PressurePlate getPlate(int n){ //retorna a placa desejada
        switch(n){
            case 1:
                return plate;
            case 2:
                return plate2;
            case 3:
                return plate3;
            case 4:
                return plate4;
            case 5:
                return plate5;
        }
        return null;

    }
    public Portao getPortao(int n){ //retorna o portao desejado
        switch(n){
            case 1:
                return portao;
            case 2:
                return portao2;
            case 3:
                return portao3;
            case 4:
                return portao4;
            case 5:
                return portao5;
        }
        return null;

    }
    public Hatch getHatch(int n){ //retorna o alcapao desejado
        switch(n){
            case 1:
                return hatch;
        }
        return null;

    }
    public void addMainCharacters(){ //coloca ambos os personagens principais no mundo
        addObject(barbie,1057,548);
        addObject(ken,32,548);
    }
    public UtilWorlds(){
        super(1100, 600, 1);
        
    }
}
