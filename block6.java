import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;
import java.util.Scanner;
import java.util.Vector;


public class block6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("номер задачи");
        int n = scan.nextInt();
        switch (n) {
            // Задача 1
            case 1:
                System.out.println("enter numb");
                int z1 = scan.nextInt();
                System.out.println(bell(z1));
                break;

            // Задача 2
            case 2:
                scan.nextLine();
                System.out.println("enter word ");
                String z21 = scan.nextLine();
                System.out.println("enter sentence");
                String z22 = scan.nextLine();
                System.out.println("1 - translateword, 2 - translatesentece");
                int z2 = scan.nextInt();
                switch(z2){
                    case 1:
                        System.out.println(translateWord(z21));
                    break;
                    case 2:
                    System.out.println(translateSentence(z22));
                    break;
                }
                break;

            // Задача 3
            case 3:
                scan.nextLine();
                System.out.println("enter line");
                String z3 = scan.nextLine();
                System.out.println(validColor(z3));
                break;

            // Задача 4
            case 4:
            String[] extraOpt = {"b"};
            System.out.println(stripUrlParams("https://edabit.com?a=3&c=4&a=5&a=4&b=8&c=5", extraOpt));
                break;

            // Задача 5
            case 5:
            scan.nextLine();
            System.out.println("enter line");
            String z5 = scan.nextLine();
            System.out.println(getHashTags(z5));

                break;

            // Задача 6
            case 6:
          System.out.println("enter numb");
          int z6 = scan.nextInt();
          System.out.println(ulam(z6));
                break;

            // Задача 7
            case 7:
            scan.nextLine();
            System.out.println("enter line");
            String z7 = scan.nextLine();
            System.out.println(longestNonrepeatingSubstring(z7));
                break;

            // Задача 8
            case 8:
            System.out.println("enter numb");
            int z8 = scan.nextInt();
            System.out.println(convertToRoman(z8));
                break;

            // Задача 9
            case 9:
                scan.nextLine();
                System.out.println("enter ur formula");
                String z9 = scan.next();
                System.out.println(formula(z9));
                break;

            // Задача 10
            case 10:
               System.out.println("enter numb");
               int z10 = scan.nextInt();
               System.out.println(palindromedescendant(z10));
                break;
        }
    }
    //Задача 1
    public static int bell(int n) {
        int[][] Bel = new int[n + 1][n + 1];
        Bel[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            Bel[i][0] = Bel[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                Bel[i][j] = Bel[i-1][j-1]+Bel[i][j-1];
            }
        }
        return Bel[n][0];
    }
    //Задача 2
    public static String translateWord(String str) {
        if (str != "") {
            String newstr = "";
            char ch = str.charAt(0);
            str = str.toLowerCase();
            if (str.matches("^(?i:[bcdfghjklmnpqrstvwxyz]).*") == true) {
                while (str.matches("^(?i:[bcdfghjklmnpqrstvwxyz]).*") == true) {
                    newstr += str.charAt(0);
                    str = str.substring(1);
                }
                str += newstr + "ay";
            } else if (str.matches("^(?i:[aeiouy]).*") == true) {
                str += "yay";
            }
            if (Character.toUpperCase(ch) == ch) {
                str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
        }
        return str;
    }

    public static String translateSentence(String str) {
        String newstr = (str + " ");
        str = "";
        String s = "";
        while (newstr.length() > 1) {
            if (newstr.matches("^(?i:[bcdfghjklmnpqrstvwxyz]).*") == true
                    || newstr.matches("^(?i:[aeiouy]).*") == true) {
                s += newstr.charAt(0);
                newstr = newstr.substring(1);
            } else {
                str += translateWord(s) + newstr.charAt(0);
                s = "";
                if (newstr.length() > 1)
                    newstr = newstr.substring(1);
            }
        }
        return str;
    }
    //задача 3
    public static boolean validColor(String str) {
        if (str.matches(
                "^rgb\\((0|255|25[0-4]|2[0-4]\\d|1\\d\\d|0?\\d?\\d),(0|255|25[0-4]|2[0-4]\\d|1\\d\\d|0?\\d?\\d),(0|255|25[0-4]|2[0-4]\\d|1\\d\\d|0?\\d?\\d)\\)$") == true) {
            return true;
        } else if (str.matches(
                "^rgba[(](?:\\s*0*(?:\\d\\d?(?:\\.\\d+)?(?:\\s*%)?|\\.\\d+\\s*%|100(?:\\.0*)?\\s*%|(?:1\\d\\d|2[0-4]\\d|25[0-5])(?:\\.\\d+)?)\\s*,){3}\\s*0*(?:\\.\\d+|1(?:\\.0*)?)\\s*[)]$") == true) {
            return true;
        }
        return false;
    }

    //задача 4
    public static String stripUrlParams (String str, String... args) {
        int i = str.indexOf("?");
        String bufPar = "", bufNum = "", res;
        if (i == -1)
            return str;
        i++;
        res = str.substring(0, i);
        Boolean boolPar = true, inArgs;
        ArrayList<String> params = new ArrayList<>(args.length);
        ArrayList<Integer> values = new ArrayList<>(args.length);
        while (i<str.length()) {
            if (str.charAt(i) == '&' && bufNum.length() > 0 && !boolPar) {
                if (params.indexOf(bufPar) != -1)
                    values.set((params.indexOf(bufPar)), Integer.parseInt(bufNum));
                boolPar = true;
                bufPar = "";
                bufNum = "";
            }
            else
                if (!boolPar)
                    bufNum += str.charAt(i);
            if (str.charAt(i) == '=' && bufPar.length() > 0 && boolPar) {
                if (params.indexOf(bufPar) == -1) {
                    inArgs = false;
                    for (String j:args)
                        if (j.equals(bufPar))
                            inArgs = true;
                    if (!inArgs) {
                        params.add(bufPar);
                        values.add(null);
                    }
                }
                boolPar = false;
            }
            else
                if (boolPar && str.charAt(i) != '&')
                    bufPar += str.charAt(i);
            i++;
        }
        if (!boolPar && bufNum.length() > 0) // for last
            if (params.indexOf(bufPar) != -1)
                values.set((params.indexOf(bufPar)), Integer.parseInt(bufNum));
        for (i=0; i<params.size(); i++) {
            res += params.get(i) + "=" + values.get(i);
            if (i<params.size() - 1)
                res += "&";
        }
        return res;

    }
    //Задача 5
    public static String getHashTags(String str) {
        String newstr2 = str;
        String newstr3 = "";
        while (newstr2.length() >= 1) {
            if (newstr2.matches("^(?i:[bcdfghjklmnpqrstvwxyz ]).*") == true
                    || newstr2.matches("^(?i:[aeiouy ]).*") == true) {
                newstr3 += newstr2.charAt(0);
            }
            newstr2 = newstr2.substring(1);
        }
        newstr2 = newstr3.toLowerCase()+" ";
        String newstr = "";
        String[] mas = { "", "", "" };
        while (newstr2.length() > 1) {
            newstr = newstr2.substring(0, newstr2.indexOf(" "));
            newstr2 = newstr2.substring(newstr2.indexOf(" ") + 1);
            if (newstr.length() > mas[0].length()) {
                mas[0] = newstr;
            }
        }
        newstr2 = newstr3.toLowerCase()+" ";
        while (newstr2.length() > 1) {
            newstr = newstr2.substring(0, newstr2.indexOf(" "));
            newstr2 = newstr2.substring(newstr2.indexOf(" ") + 1);
            if (newstr.length() > mas[1].length() && newstr.equals(mas[0]) == false) {
                mas[1] = newstr;
            }
        }
        newstr2 = newstr3.toLowerCase()+" ";
        while (newstr2.length() > 1) {
            newstr = newstr2.substring(0, newstr2.indexOf(" "));
            newstr2 = newstr2.substring(newstr2.indexOf(" ") + 1);
            if (newstr.length() > mas[2].length() && newstr.equals(mas[0]) == false && newstr.equals(mas[1]) == false) {
                mas[2] = newstr;
            }
        }
        if (mas[0].equals(""))
            return "";
        if (mas[1].equals(""))
            return "['#" + mas[0] + "']";
        if (mas[2].equals(""))
            return "['#" + mas[0] + "', '#" + mas[1] + "']";
        return "['#" + mas[0] + "', '#" + mas[1] + "', '#" + mas[2] + "']";
    }
    //Задача 6
    static Vector<Integer> vect = new Vector<Integer>(); // can change size
    public static int ulam(int n)
    {
        vect.add(1);
        vect.add(2);
        for (int i=3; vect.size()<n; i++) {
            int count = 0;
            for (int j=0; j<vect.size()-1; j++) {
                for (int k=j+1; k<vect.size(); k++) {
                    if (vect.get(j) + vect.get(k) == i)
                        count++;
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                vect.add(i);
            }
        }
        return vect.get(n-1);
    }
    //Задача 7
    public static String longestNonrepeatingSubstring(String str) {
        String newstr1 = "";
        String newstr2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (newstr1.indexOf(str.charAt(i)) == -1) {
                newstr1 += str.charAt(i);
            } else {
                if (newstr1.length() > newstr2.length())
                    newstr2 = newstr1;
                newstr1 = "";
                i--;
            }
            if (i == str.length() - 1) {
                if (newstr1.length() > newstr2.length())
                    newstr2 = newstr1;
            }
        }
        return newstr2;
    }
    //Задача 8

    public static String convertToRoman(int n) {
        if (n > 3999 && n <= 0)
            return "invailed";
        String res = "";
        while (n >= 1000) {
            n -= 1000;
            res += "M";
        }
        if (n >= 900) {
            n -= 900;
            res += "CM";
        }
        if (n >= 500) {
            n -= 500;
            res += "D";
        }
        if (n >= 400) {
            n -= 400;
            res += "CD";
        }
        while (n >= 100) {
            n -= 100;
            res += "C";
        }
        if (n >= 90) {
            n -= 90;
            res += "XC";
        }
        if (n >= 50) {
            n -= 50;
            res += "L";
        }
        if (n >= 40) {
            n -= 40;
            res += "XL";
        }
        while (n >= 10) {
            n -= 10;
            res += "X";
        }
        if (n == 9) {
            n -= 9;
            res += "IX";
        }
        if (n >= 5) {
            n -= 5;
            res += "V";
        }
        if (n == 4) {
            n -= 4;
            res += "IV";
        }
        while (n >= 1) {
            n -= 1;
            res += "I";
        }
        return res;
    }
    //Задача 9
    public static boolean formula(String str)
    {
        String[] params = str.split("=");
        String a, b;
        if (params.length < 2)
            return false;
	    ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
	    try {
			a = engine.eval(params[0]).toString(); // for first
		} catch (ScriptException e) {
			return false;
		}
        for (int i=1; i<params.length; i++) {
            try {
                b = engine.eval(params[i]).toString(); // others
            } catch (ScriptException e) {
                return false;
            }
            if (!a.equals(b)) // if not equals
                return false;
        }
        return true;
    }
    //Задача 10
    public static boolean palindromedescendant(int n) {
        String str = "" + n;
        String newstr1="";
        String newstr2="";
        int a = 0;
        String newstr3 = "";
        while (str.length() > 1) {
            if(str.length()%2!=0)
            {
                newstr1 = str.substring(0,(int)str.length()/2+1);
                a = newstr1.length();
                while (a!=0) 
                {
                    a--;
                    newstr2 += newstr1.charAt(a);
                }                
                if(newstr2.equals(str.substring((int)str.length()/2)))
                    return true;
                else
                    return false;
            }
            else
            {
                newstr1 = str.substring(0,str.length()/2);
                a = newstr1.length();
                while (a!=0) 
                {
                    a--;
                    newstr2 += newstr1.charAt(a);
                }
                if(newstr2.equals(str.substring((int)str.length()/2)))
                    return true;
                else
                {
                    for (int i=0; i<str.length(); i+=2) 
                    {
                        newstr3 += Integer.toString(Integer.parseInt(str.substring(i,i+1)) + Integer.parseInt(str.substring(i+1,i+2)));
                    }
                    str = newstr3;
                }
                newstr1 = "";
                newstr2 = "";
                newstr3 = "";
                a=0;
            }
        }
        return true;
    }
}
