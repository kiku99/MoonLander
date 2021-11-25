package moon_lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Enemy extends Unit{

    //적의  랜덤 x, y 좌표룰 생성하기 위한 변수
    private Random random;
    //적이 파괴된 상태
    public boolean crashed;

    private int speedY;

    public Enemy(){
        Initialize();
        Loadcontent();
    }

    @Override
    public void Initialize(){
        random = new Random();
        ResetEnemy();
    }

    @Override
    public void Loadcontent(){
        try {
            URL ImgUrl = this.getClass().getResource("/images/metheo.png");
            Img = ImageIO.read(ImgUrl);
            ImgWidth = Img.getWidth() - 20;
            ImgHeight = Img.getHeight() - 20;
        } catch (IOException ex) {
            Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ResetEnemy(){
        crashed = false;

        posx = random.nextInt(700);
        posy = -200;

        speedY = random.nextInt(10) + 3;
    }

    public void Move(){
        this.posy += this.speedY;
        //적이 화면을 넘어가면 위치 초기화
        if(this.posy > 550){
            this.posy = -100;
            this.posx = random.nextInt(700);
            ResetEnemy();
        }
    }


    @Override
    public void Draw(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.drawImage(Img, posx, posy, null);
    }

}
