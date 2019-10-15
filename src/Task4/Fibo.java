
package Task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Fibo
{
    private static BufferedReader br;


    public static void main(String[] args)
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        int count = readCount();
        if (count <= 0) {
            System.out.println("ERROR: Count is too small");
            return ;
        }

        int fib1 = 0;
        int fib2 = 1;
        int fib;
        for (int i = 1; i <= count; i++) {
            fib = fib2 + fib1;
            fib2 = fib1;
            fib1 = fib;

            System.out.println(fib);
        }
    }

    private static int readCount()
    {
        System.out.println("Enter numbers count:");
        int count = 0;
        try {
            count = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            // e.printStackTrace();
        }
        System.out.println("COUNT = " + count);
        System.out.println("");

        return count;
    }


}