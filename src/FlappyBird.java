import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird implements ActionListener, KeyListener {
    public static final int FPS = 60, WIDTH = 640, HEIGHT = 480;
    private Bird bird;
    private JFrame frame;
    private JPanel panel;
    private ArrayList<Rectangle> rects;
    private int time, scroll;
    private Timer t;
    private int currentScreenIndex = 0;
    public int score = 0;
    private boolean paused;

    private boolean select1;
    private boolean select2;
    
    private boolean showingDifficutyScreen;
    private boolean startthegame;
    private boolean showingInstructions1;
    private boolean showingInstructions2;
    private boolean showingInstructions3;
    private boolean showingResult1;
    private boolean showingResult2;
    private boolean showingResuls3;
    
    public void go() {
        frame = new JFrame("Flappy Bird");
        panel = new GamePanel(this, bird, rects);
        bird = new Bird();
        rects = new ArrayList<Rectangle>();
        
        frame.add(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
        
        paused = true;
        
        t = new Timer(1000/FPS, this);
        t.start();
    }
    public static void main(String[] args) {
        new FlappyBird().go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();
        if(!paused) {
            bird.physics();
            if(scroll % 90 == 0) {
                Rectangle r = new Rectangle(WIDTH, 0, GamePanel.PIPE_W, (int) ((Math.random()*HEIGHT)/5f + (0.2f)*HEIGHT));
                int h2 = (int) ((Math.random()*HEIGHT)/5f + (0.2f)*HEIGHT);
                Rectangle r2 = new Rectangle(WIDTH, HEIGHT - h2, GamePanel.PIPE_W, h2);
                rects.add(r);
                rects.add(r2);
            }
            ArrayList<Rectangle> toRemove = new ArrayList<Rectangle>();
            boolean game = true;
            for(Rectangle r : rects) {
                r.x-=3;
                if(r.x + r.width <= 0) {
                    toRemove.add(r);
                }
                if(r.contains(bird.x, bird.y)) {
                    JOptionPane.showMessageDialog(frame, "You lose!\n"+"Your score was: "+time+".");
                    game = false;
                }
            }
            rects.removeAll(toRemove);
            time++;
            scroll++;

            if (bird.y > HEIGHT) {
            	bird.playHitSound();
                showingResult1 = false;
                showingResult2 = true;
                showingResult3 = false;
                game = false;
               
            }
            if (bird.y + bird.RAD < 0) {
            	bird.playHitSound();
                showingResult1 = false;
                showingResult2 = false;
                showingResult3 = true;
                game = false;
            }
            if (!game) {
            	paused = false;
                rects.clear();
                bird.reset();
                scroll = 0;
            }     
        	
        }
        if(select2 && (!showingResult1 && !showingResult2 && !showingResult3)) { // little hard mode
            bird.physics();
            if(scroll % 30 == 0) {
                Rectangle r = new Rectangle(WIDTH, 0, GamePanel.PIPE_W , (int) ((Math.random()*HEIGHT)/4.5f + (0.17f)*HEIGHT));
                int h2 = (int) ((Math.random()*HEIGHT)/4.5f + (0.17f)*HEIGHT);
                Rectangle r2 = new Rectangle(WIDTH, HEIGHT - h2, GamePanel.PIPE_W, h2);
                rects.add(r);
                rects.add(r2);
            }
            ArrayList<Rectangle> toRemove = new ArrayList<Rectangle>();
            boolean game = true;
            for(Rectangle r : rects) {
                r.x-=13;
                if(r.x + r.width <= 0) {
                    toRemove.add(r);
                }
                
                if (r.intersects(Math.round(bird.x - (bird.getWidth() / 2)), Math.round(bird.y - (bird.getHeight() / 2)), bird.getWidth(), bird.getHeight())) {                	bird.playHitSound();
                    showingResult1 = true;
                    showingResult2 = false;
                    showingResult3 = false;
                    game = false;
                    
                }
            }
            rects.removeAll(toRemove);
            time++;
            scroll++;

            if (bird.y > HEIGHT) {
            	bird.playHitSound();
                showingResult1 = false;
                showingResult2 = true;
                showingResult3 = false;
                game = false;
               
            }
            if (bird.y + bird.RAD < 0) {
            	bird.playHitSound();
                showingResult1 = false;
                showingResult2 = false;
                showingResult3 = true;
                game = false;
                
            }
            if (!game) {
            	paused = false;

                rects.clear();
                bird.reset();
                scroll = 0;   
            }     
        }
    }
    public int getScore() {
        return time;
    }
    
    
