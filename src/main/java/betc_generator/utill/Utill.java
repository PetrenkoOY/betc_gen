package betc_generator.utill;

import java.util.Random;

public class Utill {
	private static final Random gen = new Random();
	private static final String ALPHABET = "abcdefghijklmnoprstuvwxyz";

	public static int getRandomIntInRange(int min, int max) {
		return min + gen.nextInt(max - min + 1);
	}

	public static String nextRandomString(int len) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < len; i++) {
			result = result.append(Character.toString(ALPHABET.charAt(gen.nextInt(ALPHABET.length()))));
		}
		return result.toString();
	}
}
