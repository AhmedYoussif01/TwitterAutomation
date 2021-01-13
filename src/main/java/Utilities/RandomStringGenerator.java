package Utilities;

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringGenerator {
    public static String randomString() throws InterruptedException {
        String characters = "abcd";
        String generateText = RandomStringUtils.random(20, characters);
        String generatedValue = generateText;
        return generatedValue;
    }

}
