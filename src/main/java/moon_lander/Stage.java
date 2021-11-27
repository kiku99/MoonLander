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

    private StoreDB db;

    Object score;

    public Stage()
    {
        Initialize();
        LoadContent();
    }
    public void Initialize(){
        db = new StoreDB();
        db.readData();
        score = db.returnData();
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
        btDesign(bt_one, 1);

        bt_two = new JButton("stage 2");
        bt_two.setBounds(Framework.frameWidth / 2 - 200, Framework.frameHeight / 2 - 100, 100, 50);
        btDesign(bt_two, 2);

        bt_three = new JButton("stage 3");
        bt_three.setBounds(Framework.frameWidth / 2 - 50, Framework.frameHeight / 2 - 100, 100, 50);
        btDesign(bt_three, 3);

        bt_four = new JButton("stage 4");
        bt_four.setBounds(Framework.frameWidth / 2 + 100, Framework.frameHeight / 2 - 100, 100, 50);
        btDesign(bt_four, 4);

        bt_five = new JButton("stage 5");
        bt_five.setBounds(Framework.frameWidth / 2 + 250, Framework.frameHeight / 2 - 100, 100, 50);
        btDesign(bt_five, 5);

        this.setBounds(0, 0, Framework.frameWidth, Framework.frameHeight);
        this.setLayout(null);
        this.add(bt_one);
        this.add(bt_two);
        this.add(bt_three);
        this.add(bt_four);
        this.add(bt_five);
        jl1 = new JLabel("                     high score");
        jl2 = new JLabel("                     " + score);
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

    public void btDesign(JButton bt, final int stageNum) {
        bt.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bt.setOpaque(false);
        bt.setBackground(Color.blue);
        bt.setForeground(Color.BLACK);
        bt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Game.stageNum = stageNum;
                setVisible(false);
                Framework.gameState = Framework.GameState.STAGE_SELECT;
            }
        });
    }
}
