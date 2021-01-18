import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("FIRST");
        findCommonIntsInDiapason(5,11,18,9);

        System.out.println("\nSECOND");
        System.out.println(Arrays.toString(removeAt(new int[]{1, 2, 3}, 1)));

        System.out.println("\nTHIRD");
        System.out.println(twoArrayComparer(new int[]{1,2,3},new int[]{3,2,1}));

        System.out.println("\nFOUR");
        System.out.println(intToBinary(4));

        System.out.println("\nFIFTH");
        System.out.println(findPalindrome("qwertyolo"));
    }
    /*
    Розробіть метод, який дозволяє знайти спільні елементи двох діапазонів цілих
    чисел, та вивести їх на екран. Приклад: діапазон з 5 до 11 та діапазон з 18  до 9.
    Спільні елементи - 9,10,11.
    */
    public static void findCommonIntsInDiapason(int firstBeg, int firstEnd, int secondBeg, int secondEnd) {
        int tmp;
        if (firstBeg > firstEnd) {
            tmp = firstBeg;
            firstBeg = firstEnd;
            firstEnd = tmp;
        }
        if (secondBeg > firstEnd) {
            tmp = secondBeg;
            secondBeg = secondEnd;
            secondEnd = tmp;
        }

        if (firstBeg > secondBeg) {
            tmp = firstBeg;
            firstBeg = secondBeg;
            secondBeg = tmp;

            tmp = firstEnd;
            firstEnd = secondEnd;
            secondEnd = tmp;
        }
        for(int number = secondBeg; number <= firstEnd;++number){
            System.out.print(number + " ");
        }
    }
    /*
    Створіть метод, який дозволяє видаляти будь який елемент
    по індексу в одновимірному масиві int[].
    Новий масив повинен повертатися з методу.
    */
    public static int[] removeAt(int[] array, int index){
        if(index > array.length){
            return array;
        }
        int[] result = new int[array.length - 1];

        for(int index1 = 0; index1 < index; ++index1){
            result[index1] = array[index1];
        }
        for(int index1 = index+1; index1 < array.length; ++index1){
            result[index1-1] = array[index1];
        }
        return result;
    }
    /*
    Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] за складом.
    Масиви можуть відрізнятися по порядку елементів, але бути однаковими зі складу.
    Приклад: [1,4,7]==[4,7,1- еквівалентні]
    */
    public static boolean twoArrayComparer(int[] arr1, int[] arr2)
    {
        int length = arr1.length;
        if(length != arr2.length) return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int index = 0; index < length;++index)
            if(arr1[index]!=arr2[index])
                return false;
        return true;
    }
    /*
    Створіть метод, який приймає параметр int та конвертує його
    з десяткової у двійкову систему обчислення
    та повертає у вигляді String. Приклад: приймає 4, повертає =0b10=
    */
    public static String intToBinary(int integer){
        return Integer.toBinaryString(integer);
    }
    /*
    Створіть метод, який приймає параметр типу String та шукає у його складі паліндроми (рядки букв,
    які однаково читаються у любому напрямку - приклад  йцууцй). Метод повинен повертати паліндром,
    який має найбільшу довжину серед знайдених,
    якщо не знайдено жодного, повертає пустий рядок "".
    Приклад при параметрі "qwertyolo" результат буде "olo".
    */
    public static String findPalindrome(String str){
        StringBuilder result = new StringBuilder("");
        String res = "";
        for(int index1 = 0, length= str.length(); index1 < length; ++index1){
            for(int index2 = index1+2; index2  <= length;++index2){
                result.append(str.substring(index1, index2));
                if(result.toString().equals(result.reverse().toString()) && res.length() < result.length()){
                    res = result.toString();
                }
                result.setLength(0);
            }
        }
        return res;
    }
}
