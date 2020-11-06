import java.util.Scanner;


public class block2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        // Задача 1 
        System.out.println("enter ur word");
        String word = scan.nextLine();
        System.out.println("how many times");
        int r = scan.nextInt();
        System.out.println(word);
        String result1 = repeat(word, r);
        System.out.println(result1);

        //Задача 2 
        System.out.println("length");
        int length=scan.nextInt();
        int []array;
        array=arraycreator(length);
        System.out.println();
        int result2 = differenceMaxMin(array, length);
        System.out.println("difference = " +result2);

        // Задача 3 
        System.out.println("length");
        int length3=scan.nextInt();
        int []array1;
        array1=arraycreator(length3);
        System.out.println();
        boolean result3 = isAvgWhole(array1,length3);
        System.out.println(result3);

        // Задача 4 
        System.out.println("length");
        int length4=scan.nextInt();
        int []array2;
        array2=arraycreator(length4);
        System.out.println();
        int[] result4=cumulativeSum(array2, length4);
        for (int i =0; i < array2.length; i++){
        System.out.print(result4[i] + ", ");
        }

        //Задача 5 
        System.out.println("enter number");
        String z5 = scan.next();
        System.out.println(getDecimalPlaces(z5));

        // Задача 6 
        System.out.println("enter number");
        int fibo = scan.nextInt();
        int result6 = Fibonacci(fibo);
        System.out.println(result6);

        // задача 7
        System.out.println("enter ur stroka");
        String str = scan1.nextLine();
        boolean result7 = isValid(str);
        System.out.println(result7);

        // Задача 8 
        String word1 = scan1.nextLine();
        String word2 = scan1.nextLine();
        Boolean result8 = isStrangePair(word1, word2);
        System.out.println(result8);

        // Задача 9
        System.out.println("enter ur word");
        String z9 = scan.next();
        System.out.println("enter line");
        String z92 = scan.next();
        System.out.println("1 - isprefix 2 - issuffix");
        int num9 = scan.nextInt();
        switch (num9) {
            case 1:
                Boolean result9v1 = isPrefix(z9, z92);
                System.out.println(result9v1);
                break;
            case 2:
                Boolean result9v2 = isSuffix(z9, z92);
                System.out.println(result9v2);
                break;
        }

        // Задача 10
        System.out.println("10");
        System.out.println("enter step");
        int st = scan.nextInt();
        int result10 = boxSeq(st);
        System.out.println(result10);
    }

    //array creation 
    public static int[] arraycreator(int s) {
        Scanner sca1 = new Scanner(System.in);
        int[] mas = new int[s];
        System.out.println("enter array");
        for (int i = 0; i < s; i++) {
            mas[i] = sca1.nextInt();
        }
        return mas;
    }


    public static String repeat(String a, int b) {
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b; j++) {
                result = result + String.valueOf(a.charAt(i));
            }
        }
        return result;
    }

    public static int differenceMaxMin(int mas[], int a) {
        int max = mas[0];
        int min = mas[0];
        for (int i = 0; i < a; i++) {
            if (max < mas[i]) {
                max = mas[i];
            }
            if (min > mas[i]) {
                min = mas[i];
            }

        }
        return max - min;
    }


    public static boolean isAvgWhole(int mas[], int a) {
        int s = 0;
        boolean res;
        for (int i = 0; i < a; i++) {
            s = s + mas[i];
        }
        if (s % a == 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static int[] cumulativeSum(int[] mas, int s) {
        int mas1[] = new int[s];
        int a = 0;
        for (int i = 0; i < s; i++) {
            a = a + mas[i];
            mas1[i] = a;
        }
        return mas1;
    }

    public static int getDecimalPlaces(String a) {
        int result;
        String sub = ".";
        String sub1=",";
        if (a.indexOf(sub) != -1) {
            result = String.valueOf(a).split("\\.")[1].length();
        } else if (a.indexOf(sub1) != -1){
            result = String.valueOf(a).split("\\,")[1].length();
        }
        else {
            result = 0;
        }
        return result;
    }

    public static int Fibonacci(int n) {
        int a;
        int a1 = 1;
        int a2 = 1;
        if (n < 2) {
            a2 = 1;
        }
        for (int i = 3; i < n + 2; i++) {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
        }
        return a2;
    }

    
    public static boolean isValid(String a) {
        boolean r;
        String sub = " ";
        if (a.length() > 5) {
            r = false;
        } else if (a.indexOf(sub) != -1) {
            r = false;
        } else
            try {
                Double.parseDouble(a);
                r = true;
            } catch (NumberFormatException e) {
                r = false;
            }
        return r;
    }

 

    public static boolean isPrefix(String a, String b) {
        boolean res;
        b = b.replace("-", "");
        if (a.startsWith(b) == true) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static boolean isSuffix(String a, String b) {
        boolean res;
        b = b.replaceFirst("-", "");
        if (a.endsWith(b) == true) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static boolean isStrangePair(String a, String b) {
        boolean res;
        if ((a.trim().length() == 0) && (b.trim().length() == 0)) {
            res = true;
        } else if (a.charAt(0) == b.charAt(b.length() - 1) && a.charAt(a.length() - 1) == b.charAt(0)) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static int boxSeq(int a) {
        int result = 0;
        if (a == 0) {
            result = 0;
        } else {
            for (int i = 1; i <= a; i++) {
                if (i % 2 != 0) {
                    result = result + 3;
                } else {
                    result = result - 1;
                }
            }
        }
        return result;
    }
}

  

 






