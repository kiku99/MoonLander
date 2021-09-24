package moon_lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Enemy {

    //적의  랜덤 x, y 좌표룰 생성하기 위한 변수
    private Random random;
    //적의 x 좌표
    public int x;
    //적의 y 좌표
    public int y;
    //적의 x 축 속도
    private int speedX;
    //적의 y 축 속도
    private int speedY;
    //적 이미지
    private BufferedImage enemyImg;
    //적 파괴시 이미지
    private BufferedImage enemyCrashedImg;
    //적이 파괴된 상태
    public boolean crashed;

    public Enemy(){
        Initialize();
        LoadContent();

        x = random.nextInt(700);
    }

    private void Initialize(){
        random = new Random();

        ResetEnemy();
    }

    private void LoadContent(){
        try {
            URL enemyImgUrl = this.getClass().getResource("/resources/images/rocket.png");
            enemyImg = ImageIO.read(enemyImgUrl);

            URL enemyCrashedImgUrl = this.getClass().getResource("/resources/images/rocket.png");
            enemyCrashedImg = ImageIO.read(enemyCrashedImgUrl);
        } catch (IOException ex) {
            Logger.getLogger(PlayerRocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ResetEnemy(){
        crashed = false;

        x = random.nextInt(700);
        y = -100;

        speedY = 5;
    }

    public void Move(){
        this.y += this.speedY;
        //적이 화면을 넘어가면 위치 초기화
        if(this.y > 550){
            this.y = -100;
            this.x = random.nextInt(700);
        }
    }



    public void Draw(Graphics2D g2d){
        g2d.setColor(Color.white);

        g2d.drawImage(enemyImg, x, y, null);
    }

}
