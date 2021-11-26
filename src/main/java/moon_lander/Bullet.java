package moon_lander;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bullet extends Unit{
    //총알 객체
    Bullet bullet;

    public Bullet()
    {
        Initialize();
        LoadContent();
    }

    public Bullet(int x, int y)
    {
        this.posx = x;
        this.posy = y;
    }

    public void move()
    {
        posy -= 20;
    }

    @Override
    public void Initialize(){

    }

    @Override
    public void LoadContent()
    {
        try
        {
            URL ImgUrl = this.getClass().getResource("/images/bullet.png");
            Img = ImageIO.read(ImgUrl);
            ImgWidth = Img.getWidth();
            ImgHeight = Img.getHeight();
        }
        catch (IOException ex) {
            Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Update()
    {
        if (Canvas.keyboardKeyState(KeyEvent.VK_L) && Framework.cnt % 3 == 0)
        {
            bullet = new Bullet(PlayerRocket.posx, PlayerRocket.posy);
            Game.bullets.add(bullet);
            Game.Sound("src/main/resources/sounds/shootingsound.wav");
        }
        for (Bullet value : Game.bullets) {
            value.move();
        }

        for(int i = 0; i < Game.bullets.size(); i++) {
            if (Game.bullets.get(i).posy < 0) {
                Game.bullets.remove(i);
            }
        }
    }

    @Override
    public void Draw(Graphics2D g2d)
    {
        for(int i = 0; i < Game.bullets.size(); i++)
        {
            bullet = Game.bullets.get(i);
            g2d.drawImage(Img, bullet.posx + ((PlayerRocket.rocketImgWidth - ImgWidth) / 2), bullet.posy - ImgHeight, null);
        }
    }
}

