
package Task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;


class QuadraticEquation
{
    private static BufferedReader br;

    public static void main(String[] args)
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        double a = readVar("A");
        if (a == 0) {
            throw new InvalidParameterException("[A] cannot be zero");
        }

        double b = readVar("B");
        double c = readVar("C");

        double d = b*b - 4*a*c;

        if (d < 0) {
            System.out.println("I've got no roots! (c) A. Merton");
            return ;
        }
        if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("X1 = X2 = " + x);
            return ;
        }

        double x1 = (-b - Math.sqrt(d)) / (2 * a);
        double x2 = (-b + Math.sqrt(d)) / (2 * a);

        System.out.println("X1 = " + x1);
        System.out.println("X2 = " + x2);
    }

    private static double readVar(String varName)
    {
        System.out.println("Enter " + varName + ": ");

        double a = 0;
        try {
            a = Double.parseDouble(br.readLine());
        } catch (Exception e) {
            // e.printStackTrace();
        }
        System.out.println(varName + "=" + a);
        System.out.println("");
        return a;
    }
}