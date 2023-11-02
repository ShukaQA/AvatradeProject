package util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotExample {
    public static void typeText(Robot robot, String text) {
        char[] characters = text.toCharArray();

        for (char character : characters) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);

            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new IllegalArgumentException("Cannot type character: " + character);
            }

            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
}
