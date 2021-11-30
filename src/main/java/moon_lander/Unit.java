package moon_lander;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Unit {
    //x 좌표
    protected int posx;
    //y 좌표
    protected int posy;
    //이미지
    protected BufferedImage Img;
    //이미지 넓이
    protected int ImgWidth;
    //이미지 높이
    protected int ImgHeight;

    public abstract void Initialize();

    public abstract void LoadContent();

    public abstract void Draw(Graphics2D g2d);
}
