
package Task7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// мы специально забиваем болт на точность вычислений
// на нашем калькуляторе 2-1.1=0.8999999999
// чтобы этой шняги избежать нужно юзать BigDecimal вместо double, но мне лениво
class Calculator
{
    private static BufferedReader br;

    public static void main(String[] args)
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = readString();
            System.out.println("> " + input);
            if (input.length() == 0) {
                error("empty input");
                continue;
            }
            if (input == "quit") {
                System.out.println("Quit!");
                break;
            }

            if (input.contains("+")) {
                double[] results = parseInput(input, "+");
                if (results == null) {
                    continue;
                }
                System.out.println(results[0] + results[1]);
                continue;
            }
            if (input.contains("*")) {
                double[] results = parseInput(input, "*");
                if (results == null) {
                    continue;
                }
                System.out.println(results[0] * results[1]);
                continue;
            }
            if (input.contains("/")) {
                double[] results = parseInput(input, "/");
                if (results == null) {
                    continue;
                }
                if (results[1] == 0) {
                    error("division by zero");
                    continue;
                }
                System.out.println(results[0] / results[1]);
                continue;
            }
            if (input.contains("-")) {
                double[] results = parseInput(input, "-");
                if (results == null) {
                    continue;
                }
                System.out.println(results[0] - results[1]);
                continue;
            }

            error("invalid arguments count!");
        }

    }


    private static double[] parseInput(String input, String mode)
    {
        String[] parts = input.split("[" + mode + "]");
        if (parts.length != 2) {
            error("invalid arguments count!");
            return null;
        }

        try {
            double a = Double.parseDouble(parts[0].replaceAll("\\s+",""));
            double b = Double.parseDouble(parts[1].replaceAll("\\s+",""));

            if (b == 0) {
                error("division by zero");
                return null;
            }

            double[] results = new double[2];
            results[0] = a;
            results[1] = b;

            return results;

        } catch (Exception e) {
            error("invalid input (cannot parse to double)");
            return null;
        }
    }

    private static void error(String error)
    {
        System.out.println("Error: " + error);
    }

    private static String readString()
    {
        String input = "";
        try {
            input = br.readLine();
        } catch (Exception e) {
            // e.printStackTrace();
        }

        // https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
        input = input.replaceAll("\\s+","");
        return input;
    }
}