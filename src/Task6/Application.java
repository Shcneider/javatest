
package Task6;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Основа
 */
class Application
{
    private static int studentsCount = 5;
    private static String chars = "abcdefjhijklmnopqrstuvwxyz";

    public static void main(String[] args) throws Exception
    {
        Random random = new Random();

        if (studentsCount == 0) {
            throw new Exception("fuck");
        }

        int[] results = new int[studentsCount];
        List<Student> students = new ArrayList<Student>();
        for (int id = 1; id <= studentsCount; id++) {

            Student st = new Student();

            // в задании ни слова нет о том, что имя и фамилию нужно запрашивать через консоль
            // поэтому генерим рандомно данные каждого студента
            st.name = randomString(random, chars, 5);
            st.lastName = randomString(random, chars, 7);

            // рандомная оценка
            st.score = randomInt(random, 5);

            students.add(st);
            results[id-1] = st.score;
        }


        double sum = IntStream.of(results).sum();
        double avgScore = sum / results.length;

        System.out.println("Total average score: " + avgScore);
    }

    public static String randomString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private static int randomInt(Random random, int maxValue)
    {
        return random.ints(1, maxValue+1).findFirst().getAsInt();
    }

}