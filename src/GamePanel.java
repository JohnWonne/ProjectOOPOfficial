package flappybird;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOExeption;
import java.until.ArrayList;

public class GamePanel extends JPanel {
  private Bird bird;
  private ArrayList<Ractangle> rects;
  private FlappyBird fb;
  private Font scoreFont, showscoreFont;
  private BufferedImage backgroundImage;
  public static final int PIPE_W = 50, PIPE_H = 30;
  private Image pipeHead, pipeLength;

  public GamePanel(FlappyBird fb, Bird bird, ArrayList<Rectangle> rects) {
    this.fb = fb:
    this.bird = bird;
    this.rects = rects;
    scoreFont = new Font("Indie Flower", Font.BOLD, 18);
    showscoreFont = new Font("Sacramento", Font.BOLD, 48);


    try {
      backgroundImage = ImageIO.read(new File("sky.png"));
      pipeHead = ImageIO.read(new File("78px-Pipe.png"));
      pipeLength = ImageIO.read(new File("pipe_part.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (fb.showingInstructions1()) {
      try {
        Image instructionsScreen1 = ImageIO.read(new File("instructions1.png"));
        g.drawImage(instructionsScreen1, 0, 0, getWidth(), getHeight(), null);
      } catch (IOException e) {
        e.printStackTrace();
       }
    } else if (fb.showingInstructions2()) {
      try {
        Image instructionsScreen2 = ImageIO.read(new File("instructions2.png"));
        g.drawImage(instructionsScreen2, 0, 0, getWidth(), getHeight(), null);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (fb.showingInstructions3()) {
      try {
        Image instructionsScreen3 = ImageIO.read(new File("instructions3.png"));
        g.drawImage(instructionsScreen3, 0, 0, getWidth(). getHeight(), null);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (fb.paused()) {
      try {
        Image welcomeImage = ImageIO.read(new File("welcomeimg.png"));
        g.drawImage(welcomeImage, 0, 0, getWidth(),get Height(), null);
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (fb.showingDifficultyScreen()) {
        try {
          Image difficultyScreen = ImageIO.read(new File("difficultyselect.png"));
          g.drawImage(difficultyScreen, 0, 0, getWidth(), getHeight(), null);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } else if (fb.showingResult1()) {
      try {
        Image result1 = ImageIO.read(new File("result1.png"));
        g.drawImage(result1, 0, 0, getWidth(), getHeight(). null);
      } catch (IOException e) {
        e.printStackTrace();
      }
      g.setFont(showscoreFont);
      g.setColor(Color.BLACK);
      String scoreText = String.valueOf(fb.getScore());
      int scoreX = (getWidth() - g.getFontMetrics().stringWidth(scoreText)) / 2;
      int scoreY = getHeight() / 3;
      g.drawString(scoreText, scoreX, scoreY);
    } else if (fb.showingResult2()) {
      try {
        Image result2 = ImageIO.read(new File("result2.png"));
        g.drawImage(result1, 0, 0, getWidth(), getHeight(). null);
      } catch (IOException e) {
        e.printStackTrace();
      }
      g.setFont(showscoreFont);
      g.setColor(Color.BLACK);
      String scoreText = String.valueOf(fb.getScore());
      int scoreX = (getWidth() - g.getFontMetrics().stringWidth(scoreText)) / 2;
      int scoreY = getHeight() / 3;
      g.drawString(scoreText, scoreX, scoreY);
    } else if (fb.showingResult3()) {
      try {
        Image result3 = ImageIO.read(new File("result3.png"));
        g.drawImage(result1, 0, 0, getWidth(), getHeight(). null);
      } catch (IOException e) {
        e.printStackTrace();
      }
      g.setFont(showscoreFont);
      g.setColor(Color.BLACK);
      String scoreText = String.valueOf(fb.getScore());
      int scoreX = (getWidth() - g.getFontMetrics().stringWidth(scoreText)) / 2;
      int scoreY = getHeight() / 3;
      g.drawString(scoreText, scoreX, scoreY);
    } else if (fb.select1()){
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
      bird.update(g);
      g.setColor(Color.RED);
      for (Rectangle r : rects) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        AffineTransform old = g2d.getTransform();
        g2d.translate((r.x + PIPE_W / 2), (r.y + PIPE_H / 2) - 8);
        if (r.y < FlappyBird.HEIGHT / 2) {
          g2d.translate(0, r.height);
          g2d.rotate(Math.PI);
        }

        g2d.drawImage(pipeHead, -PIPE_W /2, (-PIPE_H / 2), GamePanel.PIPE_W, GamePanel.PIPE_H, null);
        g2d.drawImage(pipeLegth, -PIPE_W / 2, (PIPE_H / 2), GamePanel.PIPE_W, r.height, null);
        g2d.setTransform(old);
      }
      g.setFont(scoreFont);
      g.setColor(Color.BLACK);
      g.drawString("Score: " + fb.getScore(), 10, 20);
    } else if (fb.select2()) {
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
      bird.update(g);
      g.setColor(Color.RED);
      for (Rectangle r : rects) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        AffineTransform old = g2d.getTransform();
        g2d.translate((r.x + PIPE_W / 2), (r.y + PIPE_H / 2) - 8);
        if (r.y < FlappyBird.HEIGHT / 2) {
          g2d.translate(0, r.height);
          g2d.rotate(Math.PI);
        }

        g2d.drawImage(pipeHead, -PIPE_W /2, (-PIPE_H / 2), GamePanel.PIPE_W, GamePanel.PIPE_H, null);
        g2d.drawImage(pipeLegth, -PIPE_W / 2, (PIPE_H / 2), GamePanel.PIPE_W, r.height, null);
        g2d.setTransform(old);
      }
      g.setFont(scoreFont);
      g.setColor(Color.BLACK);
      g.drawString("Score: " + fb.getScore(), 10, 20);
    }
  }
}
