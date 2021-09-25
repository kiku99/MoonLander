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
    private ArrayList<Bullet> bullets = new ArrayList<>();

    private BufferedImage bulletImg;

    public int bulletImgWidth;

    public int bulletImgHeight;

    Bullet bullet;

    public Point pos;

    public Bullet()
    {
        LoadContent();
    }

    public Bullet(int x, int y)
    {
        pos = new Point(x, y);
    }

    public void move()
    {
        pos.y -= 20;
    }

    private void LoadContent()
    {
        try
        {
            URL bulletImgUrl = this.getClass().getResource("/resources/images/bullet.png");
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
        if (Canvas.keyboardKeyState(KeyEvent.VK_L))
        {
            bullet = new Bullet(PlayerRocket.x, PlayerRocket.y);
            bullets.add(bullet);
        }
    }

    public void Draw(Graphics2D g2d)
    {
        for(int i = 0; i < this.bullets.size(); i++)
        {
            bullet = bullets.get(i);

            g2d.drawImage(bulletImg, bullet.pos.x + ((PlayerRocket.rocketImgWidth - bulletImgWidth) / 2), bullet.pos.y - bulletImgHeight, null);

            bullet.move();

            if ( bullet.pos.y > Framework.frameHeight ){
                bullets.remove(i);
            }
        }
    }
}

