public class Bird {
    public float x, y, vx, vy;
    public static final int RAD = 25;
    private Image img;

    public Bird() {
        x = FlappyBird.WIDTH / 2;
        y = FlappyBird.HEIGHT / 2;
        try {
            img = ImageIO.read(new File("sticker,375x360.u2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
