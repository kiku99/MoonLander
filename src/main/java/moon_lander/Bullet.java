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

public class Bullet {
    public ArrayList<Bullet> bullets = new ArrayList<>();

    private BufferedImage bulletImg;

    public int bulletImgWidth;

    public int bulletImgHeight;

    Bullet bullet;

    public int x;

    public int y;

    public Bullet()
    {
        LoadContent();
    }

    public Bullet(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void move()
    {
        y -= 20;
    }

    private void LoadContent()
    {
        try
        {
            URL bulletImgUrl = this.getClass().getResource("/bullet.png");
            bulletImg = ImageIO.read(bulletImgUrl);
            bulletImgWidth = bulletImg.getWidth();
            bulletImgHeight = bulletImg.getHeight();
        }
        catch (IOException ex) {
            Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Update()
    {
        if (Canvas.keyboardKeyState(KeyEvent.VK_L) && Framework.cnt % 1 == 0)
        {
            bullet = new Bullet(PlayerRocket.x, PlayerRocket.y);
            bullets.add(bullet);
            Game.Sound("src/main/java/resources/sound/shootingsound.wav");
        }
        for (Bullet value : this.bullets) {
            value.move();
        }

        for(int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i).y < 0) {
                bullets.remove(i);
            }
        }

    }

    public void Draw(Graphics2D g2d)
    {
        for(int i = 0; i < this.bullets.size(); i++)
        {
            bullet = bullets.get(i);

            g2d.drawImage(bulletImg, bullet.x + ((PlayerRocket.rocketImgWidth - bulletImgWidth) / 2), bullet.y - bulletImgHeight, null);
        }
    }
}

