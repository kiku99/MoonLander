package moon_lander;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Key extends Unit {

    //열쇠를 획득한 상태
    public boolean getKey;
    //열쇠를 드랍한 상태
    public boolean dropKey;

    public Key(){
        Initialize();
        LoadContent();
    }

    @Override
    public void Initialize(){
        getKey = false;
        dropKey = false;
    }

    @Override
    public void LoadContent() {
        try {
            URL ImgUrl = this.getClass().getResource("/images/key.png");
            Img = ImageIO.read(ImgUrl);
            ImgWidth = Img.getWidth();
            ImgHeight = Img.getHeight();

        } catch (IOException ex){
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Reset() {
        getKey = false;
        dropKey = false;
    }
    //키 생성
    public void Create(){
        //키 드랍
        dropKey = true;
        //키 x좌표 설정
        this.posx = 360;
        //키 y좌표 설정
        this.posy = 100;
    }

    @Override
    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
        //키를 획득했을 때 이미지 삭제
        if (getKey) {
            g2d.drawImage(null, posx, posy, null);
        }
        //키를 드랍했을 때 이미지 생성
        else if (dropKey){
            g2d.drawImage(Img, posx, posy, null);
        }
        //키가 드랍되지 않았을 때 이미지 삭제
        else {
            g2d.drawImage(null, posx, posy, null);
        }
    }
}
