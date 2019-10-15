
package Task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Основа + 2 звездочки
 */
class Application3
{
    private static int ticketsCount = 10;

    private static int groupSize = 5;
    private static int groupsCount = 2;

    private static String chars = "abcdefjhijklmnopqrstuvwxyz";


    public static void main(String[] args) throws Exception
    {
        Random random = new Random();

        // высчитываем количество студентов всего
        int studentsCount = groupsCount * groupSize;
        if (studentsCount == 0) {
            throw new Exception("fuck");
        }

        // tickets
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int id = 1; id <= ticketsCount; id++) {
            Ticket ticket = new Ticket();
            ticket.id = id;
        }

        // группы
        List<Group> groups = new ArrayList<Group>();

        // лудшая оценка и список "лидеров"
        // инициализируем нулем, чтобы даже долбаеб с 1 баллом стал лидером
        int highScore = 0;
        List<Integer> highScoreStudents = new ArrayList<Integer>();

        // худшая оценка и список лидеров
        // инициализируем максимальной оценкой, чтобы даже отличники попали в этот список, если все сдадут на 5
        int lowScore = 5;
        List<Integer> lowScoreStudents = new ArrayList<Integer>();

        // студенты
        List<Student> students = new ArrayList<Student>();
        for (int groupId = 1; groupId <= groupsCount; groupId++) {
            Group group = new Group();
            group.id = groupId;

            // результаты
            int[] results = new int[groupSize];


            for (int studentInGroupId = 1; studentInGroupId <= groupSize; studentInGroupId++) {
                int studentId = studentInGroupId + (groupSize * (groupId - 1));

                Student st = new Student();

                st.id = studentId;

                // в задании ни слова нет о том, что имя и фамилию нужно запрашивать через консоль
                // поэтому генерим рандомно данные каждого студента
                st.name = randomString(random, chars, 5);
                st.lastName = randomString(random, chars, 7);

                // рандомная оценка
                st.score = randomInt(random, 5);

                // выбираем билет
                // в задании нет ни слова, что билет должен быть исключен из пула билетов после того, как его вытянул студент
                // поэтому мы его оставляем там, и следующий может вытянуть его же опять
                st.ticketId = randomInt(random, 10);

                // мы  будем хранить просто айди группы внутри студента, а не самого студента в инстансе группы
                st.groupId = groupId;

                students.add(st);

                // групповые результаты
                results[studentInGroupId-1] = st.score;

                // если у нашего студента оценка выше, чем уже зафиксированная лучшая
                if (st.score > highScore) {

                    // помещаем его в список лидеров (предварительно отчистив)
                    highScoreStudents.clear();
                    highScoreStudents.add(studentId);

                    // и устанавливаем его оценку как максимально зафиксированную
                    highScore = st.score;

                } else if (st.score == highScore) {
                    // добавляем к уже существующим лидерам
                    highScoreStudents.add(studentId);
                }

                // если у нашего студента оценка ниже, чем уже зафиксированная худшая
                if (st.score < lowScore) {

                    // помещаем его в список лидеров (предварительно отчистив)
                    lowScoreStudents.clear();
                    lowScoreStudents.add(studentId);

                    // и устанавливаем его оценку как максимально зафиксированную
                    lowScore = st.score;

                } else if (st.score == lowScore) {
                    // добавляем к уже существующим донышкам
                    lowScoreStudents.add(studentId);
                }
            }

            double sum = IntStream.of(results).sum();
            double avgScore = sum / results.length;

            System.out.println("Total average score for group #" + groupId + ": " + avgScore);
        }
        System.out.println("");
        System.out.println("Higher score is: " + highScore);
        System.out.println("Students ids:");
        System.out.println(Arrays.toString(highScoreStudents.toArray()));

        System.out.println("");
        System.out.println("Lower score is: " + lowScore);
        System.out.println("Students ids:");
        System.out.println(Arrays.toString(lowScoreStudents.toArray()));

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