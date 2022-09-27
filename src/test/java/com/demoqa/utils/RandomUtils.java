package com.demoqa.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }
    public static String getRandomEmail() {
        return getRandomString(10)  + "@gmail.com";
    }
    public static Long getRandomLong(Long min, Long max) { return ThreadLocalRandom.current().nextLong(min, max); }


    public static String getRandomPhone() {
        return "+9" + getRandomLong(1111111111L, 99999999999L).toString();
    }
}
