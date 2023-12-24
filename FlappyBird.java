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
    private boolean paused;

    public void move() {
        frame = new JFrame("Flappy Bird");
        panel = new GamePanel(this, bird, rects);
        bird = new Bird();
        rects = new ArrayList<Rectangle>();
        frame.add(panel);
        frame.setSize(WIDTHM, HEIGHT);
        frame.setVisible(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
        paused = true;
        t = new Timer(1000/FPS, this);
        t.start();
    }
        
