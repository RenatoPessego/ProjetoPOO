import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MainCharacters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainCharacters extends Actor
{
    private int Velocity;
    private boolean Walking;
    private boolean FacingRight;
    private boolean Jumping;
    private int vSpeed = 0;
    private int animationCounter = 0;
    private int frame;
    private boolean spaceDown=false;
    private  int jumpHeight;
    private boolean KeyPressed;
    private MyWorld aMyWorld;
    
    
    int pause = 0;
    private int Health=2;
    private int timeCounter;
    public int timeElapsed=0;
    Portao lastopeneddoor = null;
    Hatch lastopenedhatch = null;
    
    /*Recebe o coin de cada personagem.Guarda na variavel aMyWorld o mundo atual.
    Se a Barbie ou o Ken estiver a tocar no coin faz um cast para coins,atualiza o score e remove o coin do mundo*/
    public void CoinColide(Class c){
        UtilWorlds aMyWorld= (UtilWorlds) getWorld();
        if(isTouching(c)){
            GreenfootSound coinmusic = new GreenfootSound("coinsound.mp3");
            coinmusic.play();
            Coins coin_bonus = (Coins) getOneIntersectingObject(c);
            aMyWorld.addScore(coin_bonus.getPoints());
            aMyWorld.removeObject(coin_bonus);
        }
    }
    /*Saber se está a andar*/
    public boolean isWalking(){
        return Walking;
    }
    
    /*Saber a velocidade*/
    public int getVelocity(){
        return Velocity;
    }
    
    /*Saber para que lado está orientado*/
    public boolean isFacingRight(){
        return FacingRight;
    }
    
    /*Saber se está a saltar*/
    public boolean isJumping(){
        return Jumping;
    }
    
    public void act()
    {
        
    }
    
    /*Como a animacao é frames por segundo foi necessario fazer um delay para o
           movimento nao ser muito rapido, como sao cerca de 55/60 frames por segundo
           significa que em 11 frames ja está na segunda posicao img[1] e assim
           sucessivamente para as outras posicoes*/
    public void animation_left(GreenfootImage[] img){
        int delay = 10; 
        /*está a andar para a esquerda logo está virado para a esquerda*/
        FacingRight = false; 
        Walking=true;
        frame ++;
        
        if(frame < 1 * delay)
        {
            setImage(img[0]);
        }
        else if(frame < 2 * delay)
        {
            setImage(img[1]);
        }
        else if(frame < 3 * delay)
        {
            setImage(img[2]);
        }
        else if (frame < 4 * delay)
        {
            setImage(img[3]);
            frame = 1;
            return;
        }
    }   
     
    /*Mesma mecanica da funcao anterior so que em vez de ir para a esquerda
           vai para a direita*/
    public void animation_right(GreenfootImage[] img){
        
        int delay = 10;
        
        FacingRight = true;
        Walking=true;
        frame ++;
        if(frame < 1 * delay)
        {
            setImage(img[0]);
        }
        else if(frame < 2 * delay)
        {
            setImage(img[1]);
        }
        else if(frame < 3 * delay)
        {
            setImage(img[2]);
        }
        else if (frame < 4 * delay)
        {
            setImage(img[3]);
            frame = 1;
            return;
        }
    }
    
    /*ao permir a tecla aciona o movimento,orienta o personagem para o lado em que a tecla está a ser primida.
    Atualiza, a variavel KeyPressedFrame para true para depois atualizar a variavel KeyPressed.O que permite que faça
    a animacao corretamente*/
    public void movement_horinz(String key1, String key2, GreenfootImage[] img_right, GreenfootImage[] img_left) {
    boolean KeyPressedFrame = false; 
    /*variavel auxiliar para mudar o estado de KeyPressed quando nenhuma tecla está a ser primida*/
    
    if (Greenfoot.isKeyDown(key1)) {
        move(Velocity);
        animation_right(img_right);
        KeyPressedFrame = true;
    }
    if (Greenfoot.isKeyDown(key2)) {
        move(-Velocity);
        animation_left(img_left);
        KeyPressedFrame = true;
    }

    // Atualize a variável KeyPressed com o estado atual das teclas
    KeyPressed = KeyPressedFrame;
    }

    /*Se nao estiver nenhum dos botoes de movimento a ser usado, entao
       o objeto nao está a andar. Se estiver virado para a direita fica com
       a imagem em que está parado para a direita caso contrario, a outra imagem
       virado para a esquerda*/
    public void movement_stand(GreenfootImage[] img_right, GreenfootImage[] img_left){
        
    if (KeyPressed==false) {
    Walking = false;
        if (FacingRight) {
            setImage(img_right[0]);
        } else {
            setImage(img_left[0]);
        }
    }
    }
    
    /*Combina o movimento horinzontal,vertical e quando a personagem está parada*/
    public void movement(String key1,String key2,String key3, GreenfootImage[] img_right, GreenfootImage[] img_left){
        movement_horinz(key1,key2,img_right,img_left);
        movement_vertical(key3);
        movement_stand(img_right,img_left);
        
    }
    
    /*Se está a ser pressionada a tecla para saltar é mudado o estado do spaceDown
       para true.Se o objeto estiver no chao(Ground.class) entao pode saltar
       sendo vSpeed uma valor negativo e depois é invocado a funcao para cair*/
    public void movement_vertical(String key3) {
    if (spaceDown != Greenfoot.isKeyDown(key3)) {//W
        spaceDown = !spaceDown;
        if (spaceDown && onGround(Ground.class))
            vSpeed = jumpHeight;
        fall(); 
    }
    
    }

     private void fall()
    {
    setLocation(getX(),getY() + vSpeed);// A posição vertical é atualizada
    vSpeed = vSpeed + 4;//incrementamos 4 ao valor da velocidade vertical
    
    if(onGround(Ground.class)){ // Verifica se o objeto da classe Ground está no chão usando a função 'onGround'.
        setLocation(getX(),getY() - jumpHeight); // Definimos a poscição verical para impedirmos que a nossa personagem fique dentro do chão
    }

    }
   

    private boolean onGround(Class c)
    {// Esta função verifica se há um objeto da classe c diretamente abaixo do ator.
     // O getImage ().getHeight()/2 é metade da altura do objeto da classe Blocks
    Actor under = getOneObjectAtOffset(0,getImage ().getHeight()/2,c);
    // Retorna verdadeiro se houver algum objeto em baixo do ator
    return under!=null;
    }
    
    public void checkFalling()
    {
       //Esta função chama onGround para verificar se o objeto está no chão
       if((onGround(Ground.class)) == false)
       {
           fall();//se não estiver no chão chama a função fall para cair
       }
    }
    
    public void checkCollisionWithGround(Class c)
    {
     if (isTouching(c)|| isTouching(Hatch.class)){
     // Colisão com a classe Ground e na classe Hatch
    // Impede que o personagem "barbie" passe através da plataforma ao descer
     if(vSpeed>0){// Verifica se está descendo
      while (isTouching(c)|| isTouching(Hatch.class)){
          setLocation(getX(), getY() - 1);// Move a barbie ou o ken para cima até que a colisão seja resolvida
          vSpeed = 0;// Impede o ator  de continuar a cair
          Jumping=false;
            }
         }
     if (vSpeed < 0){//Verifica se está a subir
         while(isTouching(c)){
            setLocation(getX(), getY() + 1);//O ator é movido para baixo 
            vSpeed = 1;//vSpeed = 1 logo o nosso ator está a descer
        }
        }
       }
    }

    public void checkCollisionWithBlockForbidden(Class c) {
    // Verifica se o ator está a colidir com um objeto da classe dos BlocksForbidden
    if (isTouching(c)){//Verificamos se o ator estava a colidir com um objeto da classe dos blocos que não podia tocar
        BlocksForbidden c_block = (BlocksForbidden) getOneIntersectingObject(c);// Um objeto da classe BlocksForbidden que está a colidir com o ator e o resultado é armazenado na variável c_block
        if (c_block != null) {//Se houver colisão
            int newX = getX();// Dá-nos a posição atual da personagem
            int actorWidth = getImage().getWidth(); // Largura do ator
            int c_blockX = c_block.getX(); // Obtemos a posição X do bloco
            int portaoWidth = c_block.getImage().getWidth(); // Obtemos a largura do Portao
            if (getX() < c_blockX) {
                // A personagem está à esquerda do bloco
                newX = c_blockX - (actorWidth / 2) - (portaoWidth / 2);
            } else {
                // A personagem está à direita do bloco
                newX = c_blockX + (portaoWidth / 2) + (actorWidth / 2);
            }
        
            // Definimos a nova posição da personagem
            setLocation(newX, getY());
        }
    }
    } 
    
    /*Inicilizacao das personagens*/
    public MainCharacters(int Velocity,int Health,boolean FacingRight,boolean Jumping,boolean Walking,int jumpHeight){
        super();
        this.Velocity = Velocity;
        this.Health = Health;
        this.FacingRight = FacingRight;
        this.Jumping = Jumping;
        this.Walking = Walking;
        this.jumpHeight = jumpHeight;
    }
    
    public void opendoorslevel1(){ //Verifica todas as portas e placas do nivel para ver se as tem de abrir
        MyWorld world = (MyWorld) getWorld();
        opendoor(world.getPlate(1),world.getPortao(5));
        opendoor(world.getPlate(2),world.getPortao(1));
        opendoor(world.getPlate(3), world.getPortao(4));
        opendoor(world.getPlate(4), world.getHatch(1));
    }
    //@overload

    boolean open = false;
    public void opendoor(PressurePlate B, Portao D){
        int X = D.getX();//coordenadas da porta
        int Y = D.getY();
        //A variavel isbeingopen vai evitar que a porta seja aberta duas vezes caso ambos os personagens toquem na placa
        //A variavel lastopeneddoor vai evitar que outras portas se movimentem no if abaixo
        if(D.isbeingopen() == false && intersects(B) && !open && lastopeneddoor == null){//Se o personagem intersetar com a placa atribuida a porta, e este estiver fechado e o booleano lastopeneddoor for null
            GreenfootSound pressureplatemusicon = new GreenfootSound("pressureplateon.mp3");
            pressureplatemusicon.play();
            D.setLocation(X, Y-110);//Vai mover a porta para cima
            D.changebeingopen();
            open= true; //muda a variavel open para true
            lastopeneddoor = D;//e a ultima porta aberta passa para a porta dada como atributo
        }
        if(lastopeneddoor == D && open && !intersects(B)){//Se a ultima porta aberta for a dada, e estiver aberto e, o personagem ja nao esta na placa
            GreenfootSound pressureplatemusicout = new GreenfootSound("pressureplateout.mp3");
            pressureplatemusicout.play();
            D.setLocation(X,Y+110); //move a porta para baixo
            D.changebeingopen();
            lastopeneddoor = null; // coloca esta variavel a null
            open = false; // e coloca open como false
        }
        
    
    }

       public void opendoor(PressurePlate B, Hatch D){
        int X = D.getX(); //coordenadas do Alcapao
        int Y = D.getY();
        //A variavel isbeingopen vai evitar que o alcapao seja aberto duas vezes caso ambos os personagens toquem na placa
        // A variavel lastopenedhatch vai evitar que outros alcapoes se movimentem no if abaixo
        if(D.isbeingopen() == false && intersects(B) && !open && lastopenedhatch == null){ //Se o personagem intersetar com a placa atribuida ao alcapao, e este estiver fechado e o booleano lastopenedhatch for null
            GreenfootSound pressureplatemusicon = new GreenfootSound("pressureplateon.mp3");
            pressureplatemusicon.play();
            D.setLocation(X+110, Y); //Vai mover o alcapao para a direita
            D.changebeingopen();
            open= true; //muda a variavel open para true
            lastopenedhatch = D;    //e o ultimo alcapao aberto passa para o alcapao dado como atributo
        }
        if(lastopenedhatch == D && open && !intersects(B)){ //Se o ultimo alcapao aberto for o dado, e estiver aberto e, o personagem ja nao esta na placa
            GreenfootSound pressureplatemusicout = new GreenfootSound("pressureplateout.mp3");
            pressureplatemusicout.play();
            D.setLocation(X-110,Y); //move o alcapao para a esquerda
            D.changebeingopen();
            lastopenedhatch = null; // coloca esta variavel a null
            open = false; // e coloca open como false
        }
        
    
    }
    
    /*Se a vida dos personagens for zero é criada uma variavel auxiliar que guarda o mundo atual.É
    criado um novo mundo em que passa o score obtido no mundo atual para o novo mundo GameOver, seguidamente muda de
    cenário para o mundo criado*/
    public void gameover(){
        if(Health==0){
            UtilWorlds a= (UtilWorlds) getWorld();
            GameOver b= new GameOver((a.getScore()));
            Greenfoot.setWorld(b); 
        }
        
    }
    //Remover um coracao se o persongaem entrar em contact com a classe de damage
    public void health(Class damage, Heart A, Heart B){ //recebe os objetos Heart de cada personagem
        if (timeElapsed == 0){ //Verifica se nao esta em um momento de delay
            if(isTouching(damage)){ //verifica se esta em contacto com algum objeto da classe damage
            
                if(Health == 2){ //Se a vida estiver em 2 remove o primeiro coracao e coloca um delay pra que o personagem nao morra instantaneamente
                    GreenfootSound gothit = new GreenfootSound("gothit.mp3");
                    gothit.play();
                    getWorld().removeObject(A); //remove o coracao
                    timeElapsed = timeElapsed+240; //coloca o delay
                }
            
                if(Health == 1){ //Se estiver a 1 remove o ultimo coracao
                GreenfootSound deadsound = new GreenfootSound("dead.mp3");
                deadsound.play();
                    getWorld().removeObject(B); 
                    timeElapsed = timeElapsed+240;
                }
            Health = Health - 1; //diminui a vida em 1 sempre que houve contacto entre o personagem e algum objeto de dano fora do tempo de delay
            }
            
            
            }
        else timeElapsed --; //Se estiver em delay vai dimuir o tempo
            }
            }
            