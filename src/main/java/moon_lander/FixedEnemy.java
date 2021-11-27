package moon_lander;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FixedEnemy extends Unit{

    public FixedEnemy(){
        Initialize();
        LoadContent();
    }

    @Override
    public void Initialize() {
    }

    @Override
    public void LoadContent() {
        try {
            URL ImgUrl = this.getClass().getResource("/images/blackhole.png");
            Img = ImageIO.read(ImgUrl);
            ImgWidth = Img.getWidth();
            ImgHeight = Img.getHeight();

        } catch (IOException ex){
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Create(){
        this.posx = 200;
        this.posy = 100;
    }

    @Override
    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.drawImage(Img, posx, posy, null);
    }
}
