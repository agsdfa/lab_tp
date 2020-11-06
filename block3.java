import java.util.Scanner;

public class block3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Задача 1 работает
        System.out.println("enter a b c");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int result1 = solutions(a, b, c);
        System.out.println("result" + result1);

        // Задача 2 работает
        scan.nextLine();
        System.out.println("enter line");
        String z1 = scan.nextLine();
        int result2 = findZip(z1);
        System.out.println("result" + result2);

        // Задача 3
        System.out.println();
        System.out.println("enter num");
        int sov = scan.nextInt();
        boolean result3 = checkPerfect(sov);
        System.out.println("result" + result3);

        // Задача 4
        scan.nextLine();
        System.out.println("enter line");
        String z4 = scan.nextLine();
        String res4 = flipEndChars(z4);
        System.out.println(res4);

        // Задача 5
        System.out.println("enter line");
        String z5 = scan.next();
        boolean result5 = isValidHexCode(z5);
        System.out.println(result5);

        // Задача 6
        System.out.println("arr 1 lenght");
        int leng61 = scan.nextInt();
        int[] arr1 = arraycreator(leng61);
        System.out.println("arr 2 lenght");
        int leng62 = scan.nextInt();
        int[] arr2 = arraycreator(leng62);
        boolean result6 = same(arr1, arr2);
        System.out.println(result6);

        // Задача 7
        System.out.println("enter number");
        int z7 = scan.nextInt();
        boolean result7 = isKaprekar(z7);
        System.out.println(result7);

        // Задача 8
        scan.nextLine();
        System.out.println("enter 1s and 0s");
        String z8 = scan.nextLine();
        String result8 = longestZero(z8);
        System.out.println(result8);

        // Задача 9
        System.out.println("enter number");
        int z9 = scan.nextInt();
        int result9 = nextPrime(z9);
        System.out.println(result9);

        // Задача 10
        System.out.println("enter x y z");
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        boolean result10 = rightTriangle(x, y, z);
        System.out.println(result10);


    }

    public static int[] arraycreator(int s) {
        Scanner sca1 = new Scanner(System.in);
        int[] mas = new int[s];
        System.out.println("enter array");
        for (int i = 0; i < s; i++) {
            mas[i] = sca1.nextInt();
        }
        return mas;
    }

    public static String flipEndChars(String a) {
        String res = "";
        if (a.length() < 2) {
            res = "Incompatible";
        } else if (a.charAt(0) == a.charAt(a.length() - 1)) {
            res = "Two's a pair";
        } else {
            res = a.charAt(a.length() - 1) + a.substring(1, a.length() - 1) + a.charAt(0);
        }
        return res;
    }

    public static boolean isValidHexCode(String a) {
        if (a.matches("(#[a-fA-F0-9]{1,6})")) {
            return true;
        }
        {
            return false;
        }

    }

    public static String longestZero(String a) {
        int maxl = 1;
        int curl = 1;
        String result = "";
        int one = 0;
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == '1') {
                one += 1;
            } else {
                if (a.charAt(i) == a.charAt(i + 1)) {
                    curl += 1;
                } else {
                    if (curl > maxl) {
                        maxl = curl;
                    }
                    curl = 1;
                }
            }
        }

        if (one == a.length() - 1) {
            return result;
        }

        if (curl > maxl) {
            maxl = curl;
        }

        for (int i = 0; i < maxl; i++) {
            result += "0";
        }
        return result;

    }

    public static boolean checkPerfect(int a) {
        boolean isperfect;
        int sum = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == a) {
            isperfect = true;
        } else {
            isperfect = false;
        }

        return isperfect;
    }

    public static int findZip(String a) {
        return a.indexOf("zip", a.indexOf("zip") + 1);
    }

    public static int solutions(int a, int b, int c) {
        int d = (b * b) - 4 * a * c;
        if (d > 0) {
            return 2;
        } else if (d == 0) {
            return 1;
        } else {
            return 0;
        }

    }

    public static boolean same(int[] mas1, int[] mas2) {
        boolean res;
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    s1++;
                    ;
                }
                if (mas1[i] == mas1[j]) {
                    break;
                }

            }
        }
        for (int i = 0; i < mas2.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    s2++;
                }
                if (mas2[i] == mas2[j]) {
                    break;
                }

            }
        }
        if (s1 == s2) {
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    public static boolean isKaprekar(int a) {
        String res = "" + (int) a * a;
        int k = 0;
        boolean rs;
        if (res.length() > 1) {
            for (int i = 1; i < res.length(); i++) {
                k = Integer.parseInt(res.substring(0, i)) + Integer.parseInt(res.substring(i, res.length()));
                if (k == a) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int nextPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                i = 2;
                a = a + 1;
            }
        }
        return a;
    }

    public static boolean rightTriangle(int a, int b, int c){
        return (c * c == a * a + b * b || a * a == b * b + c * c || b * b == a * a + c * c);
    }
}
