package L3;
import java.util.Scanner;
//Перевода целого числа, введенного с клавиатуры, в двоичную систему счисления.
public class L3Volod{
    static long find(long decimal_number)

    {

        if (decimal_number == 0)

            return 0;

        else

            return (decimal_number % 2 + 10 *    find(decimal_number / 2));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean r=true;
        System.out.println("Введите число в десятичной системе: ");
        long  num = scanner.nextInt();
        while (r) {

            long start = System.currentTimeMillis();
            System.out.println(find (num));
            long finish = System.currentTimeMillis();
            long elapsed = finish - start;
            System.out.println("Время работы, мс: "+elapsed);

            System.out.println("Ещё раз? Введите любое число, если да или 0, если нет");
            num = scanner.nextInt();
            if (num==0) {
                r=false;
                scanner.close();
            }
        }


    }
}
