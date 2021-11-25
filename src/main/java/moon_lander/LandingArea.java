package moon_lander;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Landing area where rocket will land.
 * 
 * @author www.gametutorial.net
 */

public class LandingArea extends Unit{

    public LandingArea()
    {
        Initialize();
        Loadcontent();
    }
    
    @Override
    public void Initialize()
    {   
        // X coordinate of the landing area is at 46% frame width.
        posx = (int)(Framework.frameWidth * 0.46);
        // Y coordinate of the landing area is at 86% frame height.
        posy = (int)(Framework.frameHeight * 0.88);
    }

    @Override
    public void Loadcontent()
    {
        try
        {
            URL ImgUrl = this.getClass().getResource("/images/landing_area.png");
            Img = ImageIO.read(ImgUrl);
            ImgWidth = Img.getWidth();
        }
        catch (IOException ex) {
            Logger.getLogger(LandingArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Draw(Graphics2D g2d)
    {
        g2d.drawImage(Img, posx, posy, null);
    }
    
}
