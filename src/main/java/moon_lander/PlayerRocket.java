package moon_lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * The space rocket with which player will have to land.
 * 
 * @author www.gametutorial.net
 */

public class PlayerRocket extends Unit{

    /**
     * We use this to generate a random number for starting x coordinate of the rocket.
     */
    private Random random;

    public static int posx;

    public static int posy;

    /**
     * Is rocket landed?
     */
    public boolean landed;
    
    /**
     * Has rocket crashed?
     */
    public boolean crashed;
    //로켓 HP < 5
    public boolean damaged;
    /**
     * Accelerating speed of the rocket.
     */
    private int speedAccelerating;
    /**
     * Stopping/Falling speed of the rocket. Falling speed because, the gravity pulls the rocket down to the moon.
     */
    private int speedStopping;
    
    /**
     * Maximum speed that rocket can have without having a crash when landing.
     */
    public int topLandingSpeed;
    
    /**
     * How fast and to which direction rocket is moving on x coordinate?
     */
    private int speedX;
    /**
     * How fast and to which direction rocket is moving on y coordinate?
     */
    public int speedY;
    //로켓 내구도
    public int hp;
    /**
     * Image of the rocket in air.
     */
    private BufferedImage rocketImg;
    /**
     * Image of the rocket when landed.
     */
    private BufferedImage rocketLandedImg;
    /**
     * Image of the rocket when crashed.
     */
    private BufferedImage rocketCrashedImg;

    private BufferedImage rocketDamagedImg;
    /**
     * Image of the rocket fire.
     */
    private BufferedImage rocketFireImg;
    
    /**
     * Width of rocket.
     */
    public static int rocketImgWidth;
    /**
     * Height of rocket.
     */
    public int rocketImgHeight;
    
    
    public PlayerRocket()
    {
        Initialize();
        Loadcontent();
        
        // Now that we have rocketImgWidth we set starting x coordinate.
        posx = random.nextInt(Framework.frameWidth - rocketImgWidth);
    }
    
    
    public void Initialize()
    {
        random = new Random();
        
        ResetPlayer();
        
        speedAccelerating = 2;
        speedStopping = 1;
        topLandingSpeed = 5;

        this.hp = 10;
    }

    @Override
    public void Loadcontent()
    {
        try
        {
            URL rocketImgUrl = this.getClass().getResource("/images/rocket.png");
            rocketImg = ImageIO.read(rocketImgUrl);
            rocketImgWidth = rocketImg.getWidth();
            rocketImgHeight = rocketImg.getHeight();
            
            URL rocketLandedImgUrl = this.getClass().getResource("/images/rocket_landed.png");
            rocketLandedImg = ImageIO.read(rocketLandedImgUrl);
            
            URL rocketCrashedImgUrl = this.getClass().getResource("/images/rocket_crashed.png");
            rocketCrashedImg = ImageIO.read(rocketCrashedImgUrl);

            URL rocketDamagedImgUrl = this.getClass().getResource("/images/rocket_damaged.png");
            rocketDamagedImg = ImageIO.read(rocketDamagedImgUrl);
            
            URL rocketFireImgUrl = this.getClass().getResource("/images/rocket_fire.png");
            rocketFireImg = ImageIO.read(rocketFireImgUrl);
        }
        catch (IOException ex) {
            Logger.getLogger(PlayerRocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Here we set up the rocket when we starting a new game.
     */
    public void ResetPlayer()
    {
        landed = false;
        crashed = false;
        damaged = false;
        
        posx = random.nextInt(Framework.frameWidth - rocketImgWidth);
        posy = 200;
        
        speedX = 0;
        speedY = 0;

        this.hp = 10;
    }
    
    
    /**
     * Here we move the rocket.
     */
    public void Update()
    {
        // Calculating speed for moving up or down.
        if(Canvas.keyboardKeyState(KeyEvent.VK_W) || Canvas.mouseButtonState(MouseEvent.BUTTON2))
            speedY -= speedAccelerating;
        else
            speedY += speedStopping;
        
        // Calculating speed for moving or stopping to the left.
        if(Canvas.keyboardKeyState(KeyEvent.VK_A) || Canvas.mouseButtonState(MouseEvent.BUTTON1))
            speedX -= speedAccelerating;
        else if(speedX < 0)
            speedX += speedStopping;
        
        // Calculating speed for moving or stopping to the right.
        if(Canvas.keyboardKeyState(KeyEvent.VK_D) || Canvas.mouseButtonState(MouseEvent.BUTTON3))
            speedX += speedAccelerating;
        else if(speedX > 0)
            speedX -= speedStopping;
        
        // Moves the rocket.
        posx += speedX;
        posy += speedY;

        //로켓 내구도 체크
        if (this.hp < 0){
            crashed = true;
        }
        else if(this.hp < 5){
            damaged = true;
        }



    }

    @Override
    public void Draw(Graphics2D g2d)
    {
        g2d.setColor(Color.white);
        g2d.drawString("Rocket coordinates: " + posx + " : " + posy, 5, 15);
        
        // If the rocket is landed.
        if(landed)
        {
            g2d.drawImage(rocketLandedImg, posx, posy, null);
        }
        // If the rocket is crashed.
        else if(crashed)
        {
            g2d.drawImage(rocketCrashedImg, posx, posy + rocketImgHeight - rocketCrashedImg.getHeight(), null);
        }
        else if(damaged)
        {
            g2d.drawImage(rocketDamagedImg, posx, posy, null);
        }
        // If the rocket is still in the space.
        else
        {
            // If player hold down a W key we draw rocket fire.
            if(Canvas.keyboardKeyState(KeyEvent.VK_W)|| Canvas.mouseButtonState(MouseEvent.BUTTON2))
                g2d.drawImage(rocketFireImg, posx + 12, posy + 66, null);
            g2d.drawImage(rocketImg, posx, posy, null);
        }
    }
    
}
