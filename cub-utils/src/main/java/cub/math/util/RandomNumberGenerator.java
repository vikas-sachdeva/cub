package cub.math.util;

import java.util.Random;

public class RandomNumberGenerator {

	public int generateUpToTwoDigitsRandomNumber() {

		return getRandomNumbersInSpecificRange(0, 100, 1)[0];
	}

	public int[] generateUpToTwoDigitsRandomNumbers(int numbersToGenerate) {

		return getRandomNumbersInSpecificRange(0, 100, numbersToGenerate);
	}

	public int generateOnlyTwoDigitsRandomNumber() {
		return getRandomNumbersInSpecificRange(10, 100, 1)[0];

	}

	public int[] generateOnlyTwoDigitsRandomNumbers(int numbersToGenerate) {
		return getRandomNumbersInSpecificRange(10, 100, numbersToGenerate);

	}

	public int[] getRandomNumbersInSpecificRange(int rangeStartPoint, int rangeEndPoint, int numbersToGenerate) {
		if (rangeEndPoint <= rangeStartPoint) {
			throw new IllegalArgumentException("Range End Point should be greater than Range Start Point");
		}

		Random randomGenerator = new Random();
		int[] randomNumberArray = new int[numbersToGenerate];
		int randomInt = 0;
		for (int i = 0; i < numbersToGenerate; i++) {
			randomInt = randomGenerator.nextInt(rangeEndPoint - rangeStartPoint) + rangeStartPoint;
			randomNumberArray[i] = randomInt;
		}

		return randomNumberArray;
	}

	public int getRandomNumberInSpecificRange(int rangeStartPoint, int rangeEndPoint) {
		return getRandomNumbersInSpecificRange(rangeStartPoint, rangeEndPoint, 1)[0];
	}
}