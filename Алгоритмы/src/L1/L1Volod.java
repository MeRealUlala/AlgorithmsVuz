package L1;
//Составить программу, которая формирует матрицу из n*n
//случайных чисел. Определить количество простых чисел. Значение n меняется в пределах от 5 до 10 тысяч.
import java.util.Scanner;
public class L1Volod {
    static void massiv (int n)

    {
        //	Scanner inp = new Scanner(System.in);
        //System.out.printf("Введите длину массива =");
        //n = inp.nextInt();
        int[][]z;
        System.out.println("Размерность массива: "+n);


        long p=0;
        long start = System.currentTimeMillis();
        z = new int [n][n];
        for (int i = 0; i < n; i++)
            for (int  j= 0; j < n; j++)
            {
                z [i][j] = (int)(Math.random()*50);
                if (isPrime (z[i][j]))
                    p++;
            }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Время работы, мс: "+elapsed);
        System.out.println("Простых чисел: "+p);
        System.out.println("------------");
        return;
    }
    static boolean isPrime(int n)
    {
        // если n > 1
        if (n > 1)
        {
            // в цикле перебираем числа от 2 до n - 1
            for (int i = 2; i < n; i++)
                if (n % i == 0) // если n делится без остатка на i - возвращаем false (число не простое)
                    return false;

            // если программа дошла до данного оператора, то возвращаем true (число простое) - проверка пройдена
            return true;
        }
        else // иначе возвращаем false (число не простое)
            return false;
    }
    public static void main(String[] args) {
        massiv (5000);
        massiv (6000);
        massiv (7000);
        massiv (8000);
        massiv (9000);
        massiv (10000);
    } }
