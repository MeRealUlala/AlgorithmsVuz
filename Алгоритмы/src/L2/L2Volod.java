package L2;
//Разработать алгоритм и программу ускоренного линейного
//поиска. В качестве исходных данных использовать строку текста, из которой необходимо выделить слова. Затем слова упорядочить по
//алфавиту. Аргумент поиска – слово.
import java.util.*;
public class L2Volod {
    public static void main(String[] args) {

        Comparator <String> Comp = new Comparator <String> () {
            @Override
            public int compare (String o1, String o2)
            {
                if (o1.compareTo(o2)<0) return -1;
                if (o1.compareTo(o2)>0) return 1;
                return 0;
            }
        };


        ArrayList<String> msl = new ArrayList<String> ();
        String Limits = " ().,?!:";
        int i=0, num=-1;
        int Bword =0, Eword=0;
        String strLine, sl;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        strLine = scanner.nextLine();


        Bword=0;
        boolean slovo=false;

        for (i=0; i<strLine.length();i++)
        {
            if ((!(Limits.contains(Character.toString (strLine.charAt (i)))))
                    && (slovo==false))
            {Bword=i;

                slovo=true;}
            if ((Limits.contains(Character.toString (strLine.charAt (i))))
                    && (slovo==true))
            {Eword=i;
                slovo=false;
                msl.add(strLine.substring(Bword, Eword));

            }
        }
        Collections.sort(msl, Comp);
        System.out.println("Введите слово: ");
        sl = scanner.nextLine();
        scanner.close();
        String f = null;
        i=0;
        long start = System.currentTimeMillis();



        while (i<msl.size() && (num==-1)) {
            f=msl.get(i).toString();



            if (f.equals(sl))
                num=i;
            i++;

        }

        if (num==-1)
            System.out.println("Слова -"+sl+"- в строке нет");
        else System.out.println("Слово -"+sl+"- найдено в строке, индекс:"+num);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Время работы, мс: "+elapsed);


    }
}
