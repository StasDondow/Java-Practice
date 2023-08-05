import acm.graphics.GLabel;
import cs.a.graphics.WindowProgram;

import java.awt.*;


/**
 * The class implements the animation of the national emblem.
 * The animation consists of 3 parts: first the letters appear on the screen,
 * then they fold into the shape of the national emblem of Ukraine,
 * then the background flashes in a different color.
 */
public class NationalEmblemAnimation extends WindowProgram implements NationalEmblemConstants {

    public void run() {
        setPrerequisites();
        animatePart1();
        animatePart2();
        animatePart3();
    }

    /**
     * The method implements the initial settings of the program.
     */
    private void setPrerequisites() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setBackground(BACKGROUND_COLOR_1);
        setLetters();
    }

    /**
     * The method adds letters to the animation window.
     */
    private void setLetters() {
        for (int i = 0; i < LETTERS.length; i++) {
            GLabel l = new GLabel(LETTERS_STRING[i]);
            l.setFont(LETTERS_FONT);
            // set the color of the letters the same as the background to make them invisible
            l.setColor(BACKGROUND_COLOR_1);
            l.setLocation(LETTERS_START_POSITIONS[i][0], LETTERS_START_POSITIONS[i][1]);
            add(l);
            LETTERS[i] = l;
        }
    }

    /**
     * The first part of the animation.
     * The letters gradually appear on the screen increasing in brightness.
     */
    private void animatePart1() {
        double numFrames = ANIMATION_PART_1_TIME * FPS / 1000;
        for (int i = 0; i < numFrames; i++) {
            for (GLabel l : LETTERS) {
                l.setColor(new Color(255, 255, 0, (int) ((i / numFrames) * 255)));  // yellow
            }
            pause(ANIMATION_PART_1_TIME / FPS);
        }
    }

    /**
     * The second part of the animation.
     * The letters form the national emblem of Ukraine.
     */
    private void animatePart2() {
        double numFrames = ANIMATION_PART_2_TIME * FPS / 1000;
        for (int i = 0; i < numFrames; i++) {
            for (int j = 0; j < LETTERS.length; j++) {
                GLabel l = LETTERS[j];
                double dx = (LETTERS_FINAL_POSITIONS[j][0] - LETTERS_START_POSITIONS[j][0]) / numFrames;
                double dy = (LETTERS_FINAL_POSITIONS[j][1] - LETTERS_START_POSITIONS[j][1]) / numFrames;
                l.move(dx, dy);
            }
            pause(ANIMATION_PART_2_TIME / FPS);
        }
    }

    /**
     * The third part of the animation.
     * The background flashes like a heartbeat.
     */
    private void animatePart3() {
        pause(ANIMATION_PART_3_PAUSE);
        makeOneBeat();
        makeOneBeat();
        pause(ANIMATION_PART_3_PAUSE);
        makeOneBeat();
        makeOneBeat();
    }

    /**
     * The method changes the color of the background and letters
     * and then returns the base color.
     */
    private void makeOneBeat() {
        switchColor(BACKGROUND_COLOR_2, LETTERS_COLOR_2);
        switchColor(BACKGROUND_COLOR_1, LETTERS_COLOR_1);
    }

    /**
     * The method changes the color of the background and letters.
     *
     * @param bgCol background color
     * @param lCol  letters color
     */
    private void switchColor(Color bgCol, Color lCol) {
        setBackground(bgCol);
        for (GLabel l : LETTERS) {
            l.setColor(lCol);
        }
        pause(ANIMATION_PART_3_SWITCH_TIME);
    }
}
