import acm.graphics.GLabel;

import java.awt.*;


/**
 * The interface contains constants for the NationalEmblemAnimation class.
 */
public interface NationalEmblemConstants {

    /**
     * The width of the animation window in pixels.
     */
    int WINDOW_WIDTH = 500;

    /**
     * The height of the animation window in pixels.
     */
    int WINDOW_HEIGHT = 500;

    /**
     * Frames per second.
     */
    double FPS = 40;

    /**
     * An array of GLabel objects to be animated.
     */
    GLabel[] LETTERS = new GLabel[5];

    /**
     * An array of characters that are displayed during animation.
     */
    String[] LETTERS_STRING = {"В", "о", "л", "Я", "__"};

    /**
     * The font of characters that are animated.
     */
    String LETTERS_FONT = "Candara-150";

    /**
     * The starting coordinates of the letters.
     */
    int[][] LETTERS_START_POSITIONS = {
            {50, 275},
            {150, 275},
            {250, 275},
            {350, 275},
            {170, 265}
    };

    /**
     * The final coordinates of the letters.
     */
    int[][] LETTERS_FINAL_POSITIONS = {
            {130, 240},
            {200, 290},
            {205, 240},
            {270, 240},
            {190, 205}
    };

    /**
     * The main background color.
     */
    Color BACKGROUND_COLOR_1 = Color.BLUE;

    /**
     * The background color to which it switches.
     */
    Color BACKGROUND_COLOR_2 = Color.BLACK;

    /**
     * The main letters color.
     */
    Color LETTERS_COLOR_1 = Color.YELLOW;

    /**
     * The letters color to which it switches.
     */
    Color LETTERS_COLOR_2 = Color.RED;

    /**
     * The time of the first animation part in milliseconds.
     */
    double ANIMATION_PART_1_TIME = 1500;

    /**
     * The time of the second animation part in milliseconds.
     */
    double ANIMATION_PART_2_TIME = 1500;

    /**
     * The time of the pause of the third animation part in milliseconds.
     */
    double ANIMATION_PART_3_PAUSE = 500;

    /**
     * The time between background color switches in milliseconds.
     */
    double ANIMATION_PART_3_SWITCH_TIME = 150;
}
