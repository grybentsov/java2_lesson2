package ru.geekbrains.part_2_lesson_2;

public class Java_2_lesson_2 {
    // 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
    // Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в
    // двумерный массив типа String[][];

    // 2. Преобразовать все элементы массива в числа типа int, просуммировать,
    // поделить полученную сумму на 2, и вернуть результат;

    // 3. Ваши методы должны бросить исключения в случаях:
    //    Если размер матрицы, полученной из строки, не равен 4x4;
    //    Если в одной из ячеек полученной матрицы не число; (например символ или слово)

    public static float calculate (String [][] strings) throws NumberFormatException {
        int sum = 0;
        for (String[] string : strings) {
            for (String s : string) {
                sum += Integer.parseInt(s);
                }
            }
        return (sum * 1.0f) / 2;
    }

    public static String [][] transformStringToArray (String string) throws MyException {
        String[] string1 = string.split("\n");
        if (string1.length != 4) throw new MyException ("Размер матрицы, полученной из строки, не равен 4x4" );
        String[][] string2 = {
                string1[0].split(" "),
                string1[1].split(" "),
                string1[2].split(" "),
                string1[3].split(" ")
        };
        return string2;
    }

    //4. В методе main необходимо вызвать полученные методы, обработать возможные исключения
    // и вывести результат расчета.
    public static void main(String[] args) {
	String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
	try {
        String[][] myArray = transformStringToArray(str);
        System.out.println(calculate(myArray));
    } catch (MyException ex){
            System.out.println(ex.getMessage());
 	} catch (NumberFormatException e){
        System.out.println("В одной из ячеек полученной матрицы не число (например символ или слово)");
        e.getMessage();
    }
    }
}
