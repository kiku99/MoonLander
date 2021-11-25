package moon_lander;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Unit {
    //x 좌표
    public int posx;
    //y 좌표
    public int posy;
    //이미지
    public BufferedImage Img;
    //이미지 넓이
    public int ImgWidth;
    //이미지 높이
    public int ImgHeight;

    public void Initialize(){

    }

    public void Loadcontent() {
        try {
            URL ImgUrl = this.getClass().getResource("");
            Img = ImageIO.read(ImgUrl);
            ImgWidth = Img.getWidth();
            ImgHeight = Img.getHeight();

        } catch (IOException ex){
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.white);

    }
}
