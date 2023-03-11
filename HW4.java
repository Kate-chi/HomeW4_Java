import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class HW4{

    public static void Sort(ArrayList<Integer> age, LinkedList<Integer> index)
    {
        ArrayList<Integer> ageTmp = new ArrayList<>(age);
        boolean isSorted = false;
        while (!isSorted) 
        {
            isSorted = true;
            for (int i = 0; i < ageTmp.size() - 1; i++) 
            {
                if(ageTmp.get(i) > ageTmp.get(i + 1))
                {
                    int temp = ageTmp.get(i);
                    ageTmp.set(i, ageTmp.get(i + 1));
                    ageTmp.set(i + 1, temp);

                    int temp2 = index.get(i);
                    index.set(i, index.get(i + 1));
                    index.set(i + 1, temp2);
                    isSorted = false;
                }
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        Scanner fileScanner = new Scanner(new FileReader("people.txt")); // читаем из файла, чтоб не печатать постоянно
        //Scanner scanner = new Scanner(System.in); чтение с консоли
        System.out.println("Введите ФИО, возраст, пол через пробел, <exit> для завершения");

        while (true) 
        {
            String input = fileScanner.nextLine();
            if (input.equals("exit")) 
                break;
            else 
            {
                String[] data = input.split(" ");
                index.add(lastName.size());
                lastName.add(data[0]);
                firstName.add(data[1]);
                patronymic.add(data[2]);
                age.add(Integer.parseInt(data[3]));
                gender.add(data[4]);
            }
        }
        System.out.println("Вывод неотсортированного списка: ");
        for (int i = 0; i < lastName.size(); i++) 
        {
            StringBuilder str = new StringBuilder();
            str.append(lastName.get(i))
                .append(" ")
                .append(firstName.get(i).charAt(0))
                .append(".")
                .append(patronymic.get(i).charAt(0))
                .append(". ")
                .append(age.get(i))
                .append(" ")
                .append(gender.get(i));
            System.out.println(str);
        }

        System.out.println("=".repeat(23));

        while (true)
        {
            System.out.println("Хотите отсортировать список по возрасту? Напишите <sort>, для выхода напишите <exit>: ");
            String input = fileScanner.nextLine();
            if (input.equals("sort"))
            {
                System.out.println("Сортируем: ");
                Sort(age, index);
                for (int i: index) 
                {
                    StringBuilder str = new StringBuilder();
                    str.append(lastName.get(i))
                        .append(" ")
                        .append(firstName.get(i).charAt(0))
                        .append(".")
                        .append(patronymic.get(i).charAt(0))
                        .append(". ")
                        .append(age.get(i))
                        .append(" ")
                        .append(gender.get(i));
                    System.out.println(str);
                }
            } 
            else if (input.equals("exit"))
                break;
            
        }

    }
}