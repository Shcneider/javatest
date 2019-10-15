
package Task3;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;


class Numbers
{
    private static BufferedReader br;

    private static int maxInt = 1000;

    public static void main(String[] args)
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        int count = readCount();
        if (count == 0) {
            System.out.println("0? Really? You are funny!");
            return ;
        }

        int[] numbers = new int[count];

        int[] even = new int[count];
        int evenPointer = 0;

        int[] notEven = new int[count];
        int notEvenPointer = 0;

        int[] divBy3 = new int[count];
        int divBy3Pointer = 0;

        int[] divBy5 = new int[count];
        int divBy5Pointer = 0;

        Random random = new Random();
        int number;
        for (int i = 0; i < count; i++) {
            number = random.ints(1, maxInt+1).findFirst().getAsInt();

            if (number % 2 == 0) {
                even[evenPointer] = number;
                evenPointer++;
            } else {
                notEven[notEvenPointer] = number;
                notEvenPointer++;

                if (number % 3 == 0) {
                    divBy3[divBy3Pointer] = number;
                    divBy3Pointer++;
                }
                if (number % 5 == 0) {
                    divBy5[divBy5Pointer] = number;
                    divBy5Pointer++;
                }
            }

            numbers[i] = number;
        }

        // System.out.println(Arrays.toString(numbers));


        System.out.println("Even: ");
        System.out.println(Arrays.toString(even));
        System.out.println("");

        System.out.println("NotEven: ");
        System.out.println(Arrays.toString(notEven));
        System.out.println("");

        System.out.println("Div by 3: ");
        System.out.println(Arrays.toString(divBy3));
        System.out.println("");

        System.out.println("Div by 5: ");
        System.out.println(Arrays.toString(divBy5));
        System.out.println("");

    }

    private static int readCount()
    {
        System.out.println("Enter number's count");
        int count = 0;
        try {
            count = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            // e.printStackTrace();
        }
        System.out.println("COUNT=" + count);

        return count;
    }


}