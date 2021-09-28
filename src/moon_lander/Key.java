package moon_lander;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Key {

    //열쇠의 x좌표
    public int x;
    //열쇠의 y좌표
    public int y;
    //열쇠 이미지
    private BufferedImage keyImg;
    //열쇠 이미지 넓이
    public int keyImgWidth;
    //열쇠 이미지 높이
    public int keyImgHeight;
    //열쇠를 획득한 상태
    public boolean getKey;

    public Key(){
        Initialize();
        Loadcontent();


    }

    private void Initialize(){
        ResetKey();

    }

    private void Loadcontent() {
        try {
            URL keyImgUrl = this.getClass().getResource("/resources/images/key.png");
            keyImg = ImageIO.read(keyImgUrl);
            keyImgWidth = keyImg.getWidth();
            keyImgHeight = keyImg.getHeight();

        } catch (IOException ex){
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ResetKey() {
        getKey = false;

        this.x = 200;

        this.y = 200;
    }

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.white);

        if (getKey = false) {
            g2d.drawImage(keyImg, x, y, null);
        }
    }
}
