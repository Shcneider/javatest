
package Task5;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Palindrome
{
    private static BufferedReader br;

    public static void main(String[] args)
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        String phrase = readPhrase();
        if (phrase.length() == 0) {
            System.out.println("Error: empty string");
            return ;
        }

        String reversedString = new StringBuffer(phrase).reverse().toString();
        if (reversedString.equalsIgnoreCase(phrase)) {
            System.out.println("Phrase is palindrome!");
            return ;
        }

        System.out.println("Phrase is NOT palindrome!");
        return ;
    }

    private static String readPhrase()
    {
        System.out.println("Enter phrase:");
        String phrase = new String();
        try {
            phrase = br.readLine();
        } catch (Exception e) {
            // e.printStackTrace();
        }

        return phrase;
    }
}