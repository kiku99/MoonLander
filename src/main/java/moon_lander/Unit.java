package moon_lander;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    public abstract void Initialize();

    public abstract void Loadcontent();

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
    }
}
