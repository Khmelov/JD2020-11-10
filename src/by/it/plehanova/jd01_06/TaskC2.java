package by.it.plehanova.jd01_06;

import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {

        String random = generate(Poem.text);
        long start;

        start = System.nanoTime();
        String sentence1 = slow(random);

        System.out.println("timeSlow = " + (System.nanoTime() - start) / 1000_000.0 + "ms");
        System.out.println(sentence1);

        start = System.nanoTime();
        String sentence2 = fast(random);

        System.out.println("timeFast = " + (System.nanoTime() - start) / 1000_000.0 + "ms");
        System.out.println(sentence2);

    }

    private static String slow(String text) {
        String[] words = text.split(" ");
        String gen1 = "";

        for (int i = 0; i < words.length; i++) {
            gen1 = gen1 + " " + words[i];
        }

        return gen1;
    }

    private static String fast(String text) {

        String[] words = text.split(" ");
        StringBuilder gen2 = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            gen2 = gen2.append(" ").append(words[i]);
        }
        String str = new String(gen2);

        return str;
    }

    private static String generate(String text) {

        StringBuilder words = new StringBuilder();
        text = text.replaceAll("[^а-яА-ЯёЁ]+"," ").trim();
        String[] array = text.split(" ");

        Random random = new Random();

        while (words.length() < 1000) {
            int i = random.nextInt(array.length);
            words = words.append(" ").append(array[i]);
        }

        String generate = new String(words);
        return generate;
    }
}
