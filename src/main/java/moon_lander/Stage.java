package moon_lander;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stage extends JPanel {
    private BufferedImage backgroundImg;

    JButton bt_one;
    JButton bt_two;
    JButton bt_three;
    JButton bt_four;
    JButton bt_five;

    JLabel jl1, jl2;

    private Graphics2D g2d;

    public Stage()
    {
        //Initialize();
        LoadContent();
    }
    public void LoadContent() {
        try {
            URL backgroundImgUrl = this.getClass().getResource("/images/background.jpg");
            backgroundImg = ImageIO.read(backgroundImgUrl);

        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        bt_one = new JButton("stage 1");
        bt_one.setBounds(Framework.frameWidth / 2 - 350, Framework.frameHeight / 2 - 100, 100, 50);
        bt_one.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bt_one.setOpaque(false);
        bt_one.setBackground(Color.blue);
        bt_one.setForeground(Color.BLACK);
        bt_one.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bt_one.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Game.stageNum = 1;
                setVisible(false);
                Framework.gameState = Framework.GameState.STAGE_SELECT;
            }
        });

        bt_two = new JButton("stage 2");
        bt_two.setBounds(Framework.frameWidth / 2 - 200, Framework.frameHeight / 2 - 100, 100, 50);
        bt_two.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bt_two.setOpaque(false);
        bt_two.setBackground(Color.blue);
        bt_two.setForeground(Color.BLACK);
        bt_two.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bt_two.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Game.stageNum = 2;
                setVisible(false);
                Framework.gameState = Framework.GameState.STAGE_SELECT;
            }
        });

        bt_three = new JButton("stage 3");
        bt_three.setBounds(Framework.frameWidth / 2 - 50, Framework.frameHeight / 2 - 100, 100, 50);
        bt_three.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bt_three.setOpaque(false);
        bt_three.setBackground(Color.blue);
        bt_three.setForeground(Color.BLACK);
        bt_three.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bt_three.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Game.stageNum = 3;
                setVisible(false);
                Framework.gameState = Framework.GameState.STAGE_SELECT;
            }
        });

        bt_four = new JButton("stage 4");
        bt_four.setBounds(Framework.frameWidth / 2 + 100, Framework.frameHeight / 2 - 100, 100, 50);
        bt_four.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bt_four.setOpaque(false);
        bt_four.setBackground(Color.blue);
        bt_four.setForeground(Color.BLACK);
        bt_four.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bt_four.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Game.stageNum = 4;
                setVisible(false);
                Framework.gameState = Framework.GameState.STAGE_SELECT;
            }
        });

        bt_five = new JButton("stage 5");
        bt_five.setBounds(Framework.frameWidth / 2 + 250, Framework.frameHeight / 2 - 100, 100, 50);
        bt_five.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bt_five.setOpaque(false);
        bt_five.setBackground(Color.blue);
        bt_five.setForeground(Color.BLACK);
        bt_five.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bt_five.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Game.stageNum = 5;
                setVisible(false);
                Framework.gameState = Framework.GameState.STAGE_SELECT;
            }
        });

        this.setBounds(0, 0, Framework.frameWidth, Framework.frameHeight);
        this.setLayout(null);
        this.add(bt_one);
        this.add(bt_two);
        this.add(bt_three);
        this.add(bt_four);
        this.add(bt_five);
        jl1 = new JLabel("                     high score");
        jl2 = new JLabel("                     " + StoreDB.score);
        jl1.setForeground(Color.BLACK);
        jl2.setForeground(Color.BLACK);
        jl1.setBounds(0, Framework.frameHeight / 2 - 60, Framework.frameWidth, 50);
        jl2.setBounds(0, Framework.frameHeight / 2 - 40, Framework.frameWidth, 50);
        this.add(jl1);
        this.add(jl2);
        Window.frame.add(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImg, 0, 0, Framework.frameWidth, Framework.frameHeight, null);
    }

}
