import java.util.Scanner;
public class block1 {
    public static void main (String[] Args) {
        Scanner scan = new Scanner (System.in);
        //  Задача 1 
        System.out.println("enter 2 numbers");
        int numb1= scan.nextInt();
        int numb2=scan.nextInt();
        int result = remainder(numb1, numb2);
        System.out.println("result " + result);


        // Задача 2
        System.out.println("enter 2 numbers ");
        int base= scan.nextInt();
        int height=scan.nextInt();
        int result2=triArea(base,height);
        System.out.println("result " + result2);


        // Задача 3 
        System.out.println("3 numbers");
        int chick = scan.nextInt();
        int cow = scan.nextInt();
        int pig = scan.nextInt();
        int result3= animals(chick, cow, pig);
        System.out.println("result = " + result3);


        //Задача 4
        System.out.println("enter 3 numbers");
        float prob = scan.nextFloat();
        float prize = scan.nextFloat();
        float pay = scan.nextFloat();
        boolean result4=profitableGamble(prob, prize, pay);
        System.out.println(result4);


        //Задача 5
        System.out.println("enter 3 numbers");
        int n=scan.nextInt();
        int a=scan.nextInt();
        int b=scan.nextInt();
        String result5=operation(a, b, n);
        System.out.println(result5);


        // Задача 6
        System.out.println("enter character");
        char aa = scan.next().charAt(0);
        int res6=ctoa(aa);
        System.out.println(res6);


        // Задача 7
        System.out.println("enter ");
        int q=scan.nextInt();
        int result7=addUpTo(q);
        System.out.println(result7);


        // Задача 8
        System.out.println("enter 2 numbers");
        int w=scan.nextInt();
        int e=scan.nextInt();
        int result8=nextEdge(w, e);
        System.out.println(result8);

        
        //Задача 9
        System.out.println("length");
        int length=scan.nextInt();
        int mas[]=new int [length];
        System.out.println("elements");
        for(int i=0;i<length;i++){
            mas[i]=scan.nextInt();
        }
        System.out.println("");
        int result9=sumofCubes(mas, length);
        System.out.println(result9);
        

        //Задача 10
        System.out.println("enter 3 numbers");
        int r=scan.nextInt();
        int t=scan.nextInt();
        int y=scan.nextInt();
        boolean result10=abcmath(r,t,y);
        System.out.println(result10);
    }
    
    public static int remainder (int a, int b) {
        int rem = a%b;
        return rem;
    }

    public static int triArea (int a, int b){
        int s = (a*b)/2;
        return s;
    }

    public static int animals(int a,int b,int c) {
        int legs = a*2 + b*4 + c*4;
        return legs;
    }



    public static boolean profitableGamble(float prob, float prize, float pay){
        boolean q;
        if ((prob * prize) > pay )
        {
             q = true;
            return q;
        }
        else
            {
                q = false;
                return q;
            }
    }
    public static String operation(int a, int b, int n){
        String res;
        if (a+b==n){ 
            res="added";
        }
        else if (a-b==n){
            res="subtracted";
        }
        else if (a*b==n){
            res="multiplied";
        }
        else if (a/b==n){
            res="divided";
        }
        else{
            res="none";
        }
        return res; 
    }
    public static int ctoa(char a){
        char character = a;
        int ascii = (int) character;
        return ascii;
        }

    public static int addUpTo(int x){
        int sum=0;
        for (int i=1; i<=x; i++){
            sum=sum+i;
        }
        return sum;
    }
    public static int nextEdge(int a, int b){
        int res=(a+b)-1;
        return res;
    }
    public static int sumofCubes(int [] mas, int a){
        int res=0;
        for (int i=0; i<a; i++){
            mas[i]=mas[i]*mas[i]*mas[i];
            res=res + mas[i];
        }
        return res;
    }
    public static boolean abcmath (int a, int b, int c){
        boolean res;
        for (int i=0; i<=b; i++){
            a=a+a;
        }
        if (a%c==0){
            res=true;
        }
        else{
            res=false;
        }
        return res;
    }

}