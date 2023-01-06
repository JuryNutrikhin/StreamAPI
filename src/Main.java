import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /**
         * Задание
         * Все задания, описанные ниже должны быть выполнены с помощью Java 8 Stream API.
         * 1.
         * Напишите метод, который на вход принимает диапазон лет, возвращает список високосных годов в этом диапазоне.
         * Примечание: год високосный если он делится на 400 или делится на 4 при этом не делясь на 100.
         * 2.
         * Напишите метод, который на вход принимает целое число(количество зарплат) и возвращает список вещественных чисел, состоящих из случайных зарплат,
         * распределенных по закону нормального распределения.
         * Примечание: У нормального распределения есть два параметра: mean(среднее значение)  и std(среднее отклонение).
         * У класса Random есть метод nextGaussian(), который генерирует нормально распределенное число с параметрами mean=0, std=1.
         * Для генерации зарплат попробуйте параметры: std = 11190, mean = 29267(можете поподбирать свои). Используйте такую формулу генерации:
         * случайная зарплата = nextGaussian() * std + mean.
         */

        /**Напишите метод, который на вход принимает диапазон лет, возвращает список високосных годов в этом диапазоне.
         * Примечание: год високосный если он делится на 400 или делится на 4 при этом не делясь на 100.
         */
        List<Integer> num = new ArrayList<>();

        for (int i = 1; i < 2023; i++) {
            num.add(i);
        }
        streamAPI(num);

        /**
         *  * 2.
         *          * Напишите метод, который на вход принимает целое число(количество зарплат) и возвращает список вещественных чисел, состоящих из случайных зарплат,
         *          * распределенных по закону нормального распределения.
         *          * Примечание: У нормального распределения есть два параметра: mean(среднее значение)  и std(среднее отклонение).
         *          * У класса Random есть метод nextGaussian(), который генерирует нормально распределенное число с параметрами mean=0, std=1.
         *          * Для генерации зарплат попробуйте параметры: std = 11190, mean = 29267(можете поподбирать свои). Используйте такую формулу генерации:
         *          * случайная зарплата = nextGaussian() * std + mean.
         *
         */

        List<Double> list = salaryRandom(100);
        list.stream()
                .forEach(System.out::println);

    }

    public static void streamAPI(List<Integer> num) {
        num.stream()
                .filter(n -> (n % 400 == 0) || (n % 100 != 0 && n % 4 == 0))
                .forEach(n -> System.out.print(n + " "));
    }

    public static List<Double> salaryRandom(int num) {
        int std = 11190;
        int mean = 29267;

        Random random = new Random(1234);

        return DoubleStream.generate(() -> random.nextGaussian() * std + mean)
                .limit(num)
                .boxed()
                .collect(Collectors.toList());

    }

}