import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);

        String filePath = "src\\song.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.stop();

        while(true){
            Thread.sleep((int)(Math.random() * 35000) + 20000);
            vol();
            clip.start();

            while(true){
                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();
                int x = (int) b.getX();
                int y = (int) b.getY();

                Thread.sleep(10);
                PointerInfo aa = MouseInfo.getPointerInfo();
                Point bb = aa.getLocation();
                int xx = (int) bb.getX();
                int yy = (int) bb.getY();
                if(xx != x || yy != y)
                    break;
            }
            clip.stop();
        }
    }
    public static void vol() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(1470, 880);

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(100);
        robot.mouseMove(1536, 832);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}