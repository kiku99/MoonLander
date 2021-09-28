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
    //열쇠를 드랍한 상태
    public boolean dropKey;



    public Key(){
        Initialize();
        Loadcontent();
    }

    private void Initialize(){
        getKey = false;
        dropKey = false;
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

    public void ResetKey(Key key) {
        getKey = false;
        dropKey = false;
    }
    //키 생성
    public void Create(){
        //키 드랍
        dropKey = true;
        //키 x좌표 설정
        this.x = 360;
        //키 y좌표 설정
        this.y = 100;
    }

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
        //키를 획득했을 때 이미지 삭제
        if (getKey) {
            g2d.drawImage(null, x, y, null);
        }
        //키를 드랍했을 때 이미지 생성
        else if (dropKey){
            g2d.drawImage(keyImg, x, y, null);
        }
        //키가 드랍되지 않았을 때 이미지 삭제
        else {
            g2d.drawImage(null, x, y, null);
        }
    }
}
