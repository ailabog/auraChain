package ch.fabric.qa.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Helper to generate random strings, numbers, emails
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class GenerateRandomData {

	public static String generateRandomString(int length) {
		return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(length);
	}

	public static String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public static String generateRandomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String generateStringWithAllowedSplChars(int length, String allowedSplChars) {
		String allowedChars = "abcdefgijklmnopqrstuvwxyz" + "1234567890" + allowedSplChars;
		return RandomStringUtils.random(length, allowedChars);
	}

	public static String generateEmail(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp.substring(0, temp.length() - 9) + "@test.org";
		return email;
	}
}
