package L4;
import java.util.Scanner;
//составить две программы, которые реализуют метод быстрой сортировки из метода джава и метод сортировки вставками, Исходные данные
//задавать с помощью датчика случайных чисел.
/*
сортировка quick sort и вставками
 */
public class L4Volod {

    public static void quickSort(int[] array, int low, int high) {

        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void inser (int [] array)

    { for (int left = 0; left < array.length; left++) {
        // Вытаскиваем значение элемента
        int value = array[left];
        // Перемещаемся по элементам, которые перед вытащенным элементом
        int i = left - 1;
        for (; i >= 0; i--) {
            // Если вытащили значение меньшее — передвигаем больший элемент дальше
            if (value < array[i]) {
                array[i + 1] = array[i];
            } else {
                // Если вытащенный элемент больше — останавливаемся
                break;
            }
        }
        // В освободившееся место вставляем вытащенное значение
        array[i + 1] = value;
    }

    }

    public static void main(String[] args) {
        int n=10000;
        Scanner inp = new Scanner(System.in);
        System.out.println("Генерируется массив из "+n+" элементов");

        int x1 []= new int [n];
        int x2 []= new int [n];
        for (int i = 0; i < n; i++)
        {
            int r=(int)(Math.random()*250-100);
            x1[i]=r;
            x2[i]=r;

        }
        System.out.println();
        int low = 0;
        int high = x1.length - 1;
        long start = System.currentTimeMillis();
        quickSort(x1,low,high);

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Отсортированный массив методом Quick Sort");
        for (int i = 0; i < n; i++)
        {


            System.out.print(x1[i]+" ");
        }
        System.out.println();
        System.out.println("Время работы, мс: "+elapsed);
        start = System.currentTimeMillis();
        inser(x2);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Отсортированный массив методом вставок");
        for (int i = 0; i < n; i++)
        {


            System.out.print(x2[i]+" ");
        }
        System.out.println();
        System.out.println("Время работы, мс: "+elapsed);



        inp.close();


    }

}
