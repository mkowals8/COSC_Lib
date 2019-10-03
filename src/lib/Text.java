package lib;

import java.util.Scanner;

/**
 * Text
 */
public class Text {

    /**
     *
     */
    private static final Scanner FOUR_BY_SIX = new Scanner("5x7.text");

    public static void printBlock4x6(String _text) {
        pullCharacterArray(0x4A);
    }

    private static int[] pullCharacterArray(int _character) {
        System.out.println(FOUR_BY_SIX);
        int[] character = new int[7];
        return character;
    }
}