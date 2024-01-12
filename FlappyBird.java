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
