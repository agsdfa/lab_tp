import java.util.Scanner;

public class block4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("номер задачи"); 
        int n = scan.nextInt();
        switch (n) {
            // Задача 1
            case 1:
                int sl = scan.nextInt();
                int smb = scan.nextInt();
                scan.nextLine();
                String bs = scan.nextLine();
                String res1 = text(sl, smb, bs);
                System.out.println(res1);
                break;

            // Задача 2
            case 2:
                scan.nextLine();
                String skb = scan.nextLine();
                String res2 = split(skb);
                System.out.println(res2);
                break;

            // Задача 3
            case 3:
                scan.nextLine();
                System.out.println("enter line");
                String ss = scan.nextLine();
                System.out.println("press 1 for toCamelCase press 2 for toSnakeCase");
                int sw = scan.nextInt();
                switch (sw) {
                    case 1:
                        String res31 = toCamelCase(ss);
                        System.out.println(res31);
                        break;
                    case 2:
                        String res32 = toSnakeCase(ss);
                        System.out.println(res32);

                        break;
                }
                break;

            // Задача 4
            case 4:
                System.out.println("enter start time ");
                float time1 = scan.nextFloat();
                System.out.println("enter stop time ");
                float time2 = scan.nextFloat();
                System.out.println("stavka");
                float st = scan.nextFloat();
                System.out.println("mnoj");
                float mn = scan.nextFloat();
                String res4 = overTime(time1, time2, st, mn);
                System.out.println(res4);
                break;

            // Задача 5
            case 5:
                scan.nextLine();
                System.out.println("enter weight");
                String w = scan.nextLine();
                System.out.println("enter height");
                String h = scan.nextLine();
                String res5 = BMI(w, h);
                System.out.println(res5);
                break;

            // Задача 6
            case 6:
                System.out.println("enter number");
                int z6 = scan.nextInt();
                int res6 = bugger(z6);
                System.out.println(res6);
                break;

            // Задача 7
            case 7:
                scan.nextLine();
                System.out.println("enter line");
                String z7 = scan.nextLine();
                String res7 = toStarShorthand(z7);
                System.out.println(res7);
                break;

            // Задача 8
            case 8:
                scan.nextLine();
                System.out.println("enter line 1");
                String z8 = scan.nextLine();
                System.out.println("enter line 2");
                String z81 = scan.nextLine();
                boolean res8 = doesRhyme(z8, z81);
                System.out.println(res8);
                break;

            // Задача 9
            case 9:
                System.out.println("Enter num 1");
                long nmb91 = scan.nextLong();
                System.out.println("Enter num 2");
                long nmb92 = scan.nextLong();
                boolean res9 = trouble(nmb91, nmb92);
                System.out.println(res9);
                break;

            // Задача 10
            case 10:
                scan.nextLine();
                System.out.println("enter line");
                String z10 = scan.nextLine();
                System.out.println("enter symbol");
                char z9c = scan.next().charAt(0);
                int res10 = countUniqueBooks(z10, z9c);
                System.out.println(res10);
                break;
        }
    }

    // Задача 1
    public static String text(int n, int k, String str) {
        String newstr = "";
        String str2 = "";
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < str.length(); i++) {
            sum++;
            if (str.charAt(i) == ' ') {
                str2 = str.substring(i);
                sum2 = str2.split("\\ ")[1].length();
                sum--;
            }
            if (sum + sum2 <= k) {
                sum2 = 0;
                newstr += str.charAt(i);
            } else if (str.charAt(i) != ' ') {
                newstr += "\n" + str.charAt(i);
                sum = 0;
            }
        }
        return newstr;
    }

    // Задача 2
    public static String split(String str) {
        int open = 0;
        int close = 0;
        String newstr = "['";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                newstr += "(";
                open++;
            }
            if (str.charAt(i) == ')') {
                newstr += ")";
                close++;
            }
            if (open == close) {
                if (i != str.length() - 1)
                    newstr += "','";
                else
                    newstr += "']";
            }
        }
        return newstr;
    }

    // Задача 3
    public static String toCamelCase(String str) {
        char[] newstr = str.toCharArray();
        str = "";
        for (int i = 0; i < newstr.length; i++) {
            if (newstr[i] == '_')
                newstr[i + 1] = Character.toUpperCase(newstr[i + 1]);
            else
                str += newstr[i];
        }
        return str;
    }

    public static String toSnakeCase(String str) {
        char[] newstr = str.toCharArray();
        str = "";
        for (int i = 0; i < newstr.length; i++) {
            if (Character.isUpperCase(newstr[i])) {
                str += "_" + Character.toLowerCase(newstr[i]);
            } else
                str += newstr[i];
        }
        return str;
    }

    // Задача 4
    public static String overTime(float x, float y, float c, float dp) {
        String cash = "$";
        float s = 0;
        if (y > 17) {

            s = y - 17;
            s = (y - x - s) * c + (s * 30 * dp);
        } else {
            s = (y - x) * c;
        }
        return cash + String.format("%.2f", s);
    }

    public static String BMI(String str1, String str2) {
        double ves = Double.parseDouble(str1.substring(0, str1.indexOf(' ')));
        if (str1.endsWith("pounds")) {
            ves = ves * 0.453592;
        }
        double rost = Double.parseDouble(str2.substring(0, str2.indexOf(' ')));
        if (str2.endsWith("inches")) {
            rost = rost * 0.0254;
        }
        double IBM = ves / Math.pow(rost, 2);
        if (IBM < 18.5) {
            return String.format("%.1f", IBM) + " NeDostatochnyi Ves";
        } else if (IBM < 24.9)
            return String.format("%.1f", IBM) + " Normalniy Ves";
        else
            return String.format("%.1f", IBM) + " Izbitochniy Ves";

    }

    // Задача 6
    public static int bugger(int n) {
        String str = "" + n;
        int sum = 0;
        int s = 0;
        while (str.length() > 1) {
            sum = 1;
            for (int i = 0; i < str.length(); i++) {
                sum = sum * Integer.parseInt("" + str.charAt(i));
            }
            s++;
            str = "" + sum;
        }
        return s;
    }

    // Задача 7
    public static String toStarShorthand(String str) {
        if (str == "")
            return "";
        char save = str.charAt(0);
        int kol = 1;
        String newst = "";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != save) {
                if (kol > 1) {
                    newst += "" + save + "*" + kol;
                } else
                    newst += "" + save;
                kol = 1;
                if (i != str.length() - 1)
                    save = str.charAt(i);
                else
                    newst += str.charAt(i);
            } else {
                kol++;
                if (i == str.length() - 1) {
                    newst += "" + save + "*" + kol;
                }
            }
        }
        return newst;
    }

    // Задача 8
    public static boolean doesRhyme(String str1, String str2) {
        String s1 = "", s2 = "";
        char v = ' ';
        str1 = str1.substring(str1.lastIndexOf(" ") + 1);
        for (int i = 0; i < str1.length(); i++) {
            v = Character.toLowerCase(str1.charAt(i));
            if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'y') {
                s1 += v;
            }
        }
        str2 = str2.substring(str2.lastIndexOf(" ") + 1);
        for (int i = 0; i < str2.length(); i++) {
            v = Character.toLowerCase(str2.charAt(i));
            if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'y') {
                s2 += v;
            }
        }
        return s1.equals(s2);
    }

    // Задача 9
    public static boolean trouble(long a, long b) {
        String str1 = "" + a;
        String str2 = "" + b;
        int kol = 0, kol2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (i != str1.length() - 1) {
                if (str1.charAt(i) == str1.charAt(i + 1))
                    kol++;
                else
                    kol = 0;
                if (kol == 2) {
                    for (int j = 0; j < str2.length(); j++) {
                        if (str1.charAt(i) == str2.charAt(j)) {
                            kol2++;
                        } else {
                            kol2 = 0;
                        }
                        if (kol2 == 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // Задача 10
    public static int countUniqueBooks(String str, char ch) {
        String newstr1 = "";
        String newstr2 = "";
        String fin = "";
        int ind1 = 0, ind2 = 0;
        while (str.length() != 0) {
            if (str.indexOf(ch) != -1) {
                newstr1 = str.substring(str.indexOf(ch) + 1);
                ind1 = str.indexOf(ch) + 1;
                str = str.substring(ind1);
            }
            if (newstr1.indexOf(ch) != -1) {
                newstr2 = newstr1.substring(0, newstr1.indexOf(ch));
                ind2 = newstr1.indexOf(ch) + 1;
                str = str.substring(ind2);
            }
            for (int i = 0; i < newstr2.length(); i++) {
                if (fin.indexOf(newstr2.charAt(i)) == -1) {
                    fin += newstr2.charAt(i);
                }
            }
        }
        return fin.length();
    }
}
