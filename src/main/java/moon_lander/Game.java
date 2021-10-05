package moon_lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


import static moon_lander.Framework.*;
import static moon_lander.Framework.*;

/**
 * Actual game.
 * 
 * @author www.gametutorial.net
 */

public class Game {

    /**
     * The space rocket with which player will have to land.
     */
    private PlayerRocket playerRocket;

    /**
     * Landing area on which rocket will have to land.
     */
    private LandingArea landingArea;

    /**
     * Bullet
     */
    private Bullet bullet;
    //키
    private Key key;

    ArrayList<Enemy> enemies = new ArrayList<>();

    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;
    Enemy enemy7;
    Enemy enemy8;
    Enemy enemy9;

    /**
     * Game background image.
     */
    private BufferedImage backgroundImg;

    /**
     * Red border of the frame. It is used when player crash the rocket.
     */
    private BufferedImage redBorderImg;

    public static int stageNum;

    public int score;

    public Game() {
        Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;

        Thread threadForInitGame = new Thread() {
            @Override
            public void run() {
                // Sets variables and objects for the game.
                Initialize();
                // Load game files (images, sounds, ...)
                LoadContent();


                Framework.gameState = Framework.GameState.PLAYING;
            }
        };
        threadForInitGame.start();
    }


    /**
     * Set variables and objects for the game.
     */
    private void Initialize() {
        playerRocket = new PlayerRocket();
        landingArea = new LandingArea();

        switch (stageNum){
            case 1:
                enemy1 = new Enemy();
                enemy2 = new Enemy();
                enemy3 = new Enemy();
                enemy4 = new Enemy();
                enemy5 = new Enemy();

                enemies.add(enemy1);
                enemies.add(enemy2);
                enemies.add(enemy3);
                enemies.add(enemy4);
                enemies.add(enemy5);

            case 2:
                enemy1 = new Enemy();
                enemy2 = new Enemy();
                enemy3 = new Enemy();
                enemy4 = new Enemy();
                enemy5 = new Enemy();
                enemy6 = new Enemy();

                enemies.add(enemy1);
                enemies.add(enemy2);
                enemies.add(enemy3);
                enemies.add(enemy4);
                enemies.add(enemy5);
                enemies.add(enemy6);

            case 3:
                enemy1 = new Enemy();
                enemy2 = new Enemy();
                enemy3 = new Enemy();
                enemy4 = new Enemy();
                enemy5 = new Enemy();
                enemy6 = new Enemy();
                enemy7 = new Enemy();

                enemies.add(enemy1);
                enemies.add(enemy2);
                enemies.add(enemy3);
                enemies.add(enemy4);
                enemies.add(enemy5);
                enemies.add(enemy6);
                enemies.add(enemy7);


            case 4:
                enemy1 = new Enemy();
                enemy2 = new Enemy();
                enemy3 = new Enemy();
                enemy4 = new Enemy();
                enemy5 = new Enemy();
                enemy6 = new Enemy();
                enemy7 = new Enemy();
                enemy8 = new Enemy();

                enemies.add(enemy1);
                enemies.add(enemy2);
                enemies.add(enemy3);
                enemies.add(enemy4);
                enemies.add(enemy5);
                enemies.add(enemy6);
                enemies.add(enemy7);
                enemies.add(enemy8);

            case 5:
                enemy1 = new Enemy();
                enemy2 = new Enemy();
                enemy3 = new Enemy();
                enemy4 = new Enemy();
                enemy5 = new Enemy();
                enemy6 = new Enemy();
                enemy7 = new Enemy();
                enemy8 = new Enemy();
                enemy9 = new Enemy();

                enemies.add(enemy1);
                enemies.add(enemy2);
                enemies.add(enemy3);
                enemies.add(enemy4);
                enemies.add(enemy5);
                enemies.add(enemy6);
                enemies.add(enemy7);
                enemies.add(enemy8);
                enemies.add(enemy9);
        }

        //총알 생성
        bullet = new Bullet();
        //키 생성
        key = new Key();
    }

    /**
     * Load game files - images, sounds, ...
     */
    private void LoadContent() {
        try {
            URL backgroundImgUrl = this.getClass().getResource("/background.jpg");
            backgroundImg = ImageIO.read(backgroundImgUrl);

            URL redBorderImgUrl = this.getClass().getResource("/red_border.png");
            redBorderImg = ImageIO.read(redBorderImgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Restart game - reset some variables.
     */
    public void RestartGame() {
        //모든 적 삭제
        enemies.clear();
        //로켓 초기화
        playerRocket.ResetPlayer();
        //모든 적 초기화
        for (Enemy enemy : this.enemies) {
            enemy.ResetEnemy();
        }
        //모든 총알 초기화
        bullet.bullets.clear();
        //열쇠 초기화
        key.ResetKey(this.key);

        //객체 초기화
        Initialize();
    }


    /**
     * Update game logic.
     *
     * @param gameTime      gameTime of the game.
     * @param mousePosition current mouse position.
     */
    public void UpdateGame(long gameTime, Point mousePosition) {
        // Move the rocket
        playerRocket.Update();
        //총알 생성
        bullet.Update();
        // 적 생성
        for (Enemy enemy : this.enemies) {
            enemy.Move();
        }

        // Checks where the player rocket is. Is it still in the space or is it landed or crashed?
        // First we check bottom y coordinate of the rocket if is it near the landing area.
        if (PlayerRocket.y + playerRocket.rocketImgHeight - 10 > landingArea.y) {
            // Here we check if the rocket is over landing area.
            if ((PlayerRocket.x > landingArea.x) && (PlayerRocket.x < landingArea.x + landingArea.landingAreaImgWidth - PlayerRocket.rocketImgWidth)) {
                // Here we check if the rocket speed isn't too high and get key.
                if ((playerRocket.speedY <= playerRocket.topLandingSpeed) && key.getKey)
                    playerRocket.landed = true;
                else
                    playerRocket.crashed = true;
            } else
                playerRocket.crashed = true;

            Framework.gameState = Framework.GameState.GAMEOVER;
        }
        //적들과 로켓이 닿거나 총알로 파괴하는 상황 체크
        for (int i = 0; i < enemies.size(); i++) {
            if (Crash(this.playerRocket, enemies.get(i))) {
                this.playerRocket.hp -= 6;
            }
            if(Destroy(bullet, enemies.get(i))){
                this.enemies.get(i).crashed = true;
                this.enemies.remove(i);
            }
        }

        if (playerRocket.crashed){
            Framework.gameState = Framework.GameState.GAMEOVER;

        }
        //모든 적이 없어지면 키 드랍
        if(enemies.isEmpty()){
            key.Create();
            if (GetKey(playerRocket, key)){
                key.dropKey = false;
                key.getKey = true;
            }
        }
    }

    //로켓과 적이 충돌했을 때
    public boolean Crash(PlayerRocket rocket, Enemy enemy) {
        boolean check = false;
        if (Math.abs((PlayerRocket.x + PlayerRocket.rocketImgWidth / 2) - (enemy.x + enemy.enemyImgWidth / 2)) < (enemy.enemyImgWidth / 2 + PlayerRocket.rocketImgWidth / 2) &&
                Math.abs((PlayerRocket.y + rocket.rocketImgHeight / 2) - (enemy.y + enemy.enemyImgHeight / 2)) < (enemy.enemyImgHeight / 2 + rocket.rocketImgHeight / 2))
            check = true;
        return check;
    }

    //총알과 적이 충돌했을 때
    public boolean Destroy(Bullet bullet, Enemy enemy) {
        boolean check = false;

        for (int i = 0; i < bullet.bullets.size(); i++) {
            if (Math.abs((bullet.bullets.get(i).x + bullet.bulletImgWidth / 2) - (enemy.x + enemy.enemyImgWidth / 2)) < (enemy.enemyImgWidth / 2 + bullet.bulletImgWidth / 2) &&
                    Math.abs((bullet.bullets.get(i).y + bullet.bulletImgHeight / 2) - (enemy.y + enemy.enemyImgHeight / 2)) < (enemy.enemyImgHeight / 2 + bullet.bulletImgHeight / 2)){
                check = true;
                score += 50;
            }

        }
        return check;
    }
    //키와 로켓이 닿을 때
    public boolean GetKey(PlayerRocket rocket, Key key){
        boolean check = false;
        if (Math.abs((PlayerRocket.x + PlayerRocket.rocketImgWidth / 2) - (key.x + key.keyImgWidth / 2)) < (key.keyImgWidth / 2 + PlayerRocket.rocketImgWidth / 2) &&
                Math.abs((PlayerRocket.y + rocket.rocketImgHeight / 2) - (key.y + key.keyImgHeight / 2)) < (key.keyImgHeight / 2 + rocket.rocketImgHeight / 2))
            check = true;
        return check;
    }




    
    /**
     * Draw the game to the screen.
     * 
     * @param g2d Graphics2D
     * @param mousePosition current mouse position.
     */
    public void Draw(Graphics2D g2d, Point mousePosition)
    {
        g2d.drawImage(backgroundImg, 0, 0, Framework.frameWidth, Framework.frameHeight, null);
        
        landingArea.Draw(g2d);
        
        playerRocket.Draw(g2d);

        for (Enemy enemy : this.enemies) {
            enemy.Draw(g2d);
        }

        bullet.Draw(g2d);

        key.Draw(g2d);
    }
    
    
    /**
     * Draw the game over screen.
     * 
     * @param g2d Graphics2D
     * @param mousePosition Current mouse position.
     * @param gameTime Game time in nanoseconds.
     */
    public void DrawGameOver(Graphics2D g2d, Point mousePosition, long gameTime)
    {
        Draw(g2d, mousePosition);
        
        g2d.drawString("Press space or enter to restart. ", Framework.frameWidth / 2 - 100, Framework.frameHeight / 3 + 70);
        
        if(playerRocket.landed)
        {
            g2d.drawString("You have successfully landed!", Framework.frameWidth / 2 - 100, Framework.frameHeight / 3);
            g2d.drawString("You have landed in " + gameTime / Framework.secInNanosec + " seconds.", Framework.frameWidth / 2 - 100, Framework.frameHeight / 3 + 20);
            g2d.drawString("Your Score: " + (score - (gameTime / Framework.secInNanosec) * 50), Framework.frameWidth / 2 - 100, Framework.frameHeight / 3 + 40);
        }
        else
        {
            g2d.setColor(Color.red);
            g2d.drawString("You have crashed the rocket!", Framework.frameWidth / 2 - 95, Framework.frameHeight / 3);
            g2d.drawImage(redBorderImg, 0, 0, Framework.frameWidth, Framework.frameHeight, null);
        }
    }

}
