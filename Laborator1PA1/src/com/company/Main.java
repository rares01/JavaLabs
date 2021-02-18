package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world.");
        String [] languages  ={ "C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java" };
        int n = (int) (Math.random() *1000000);
        System.out.println("The random number is : " + n);
        n=n*3;
        System.out.println("N after multiply by 3 : " + n);
        n= n+ 0b10101;
        System.out.println("N after adding binary number : " + n);
        n= n+ 0xFF;
        System.out.println("N after adding hexadecimal number : " + n);
        n=n*6;
        System.out.println("N after multiply by 6: " + n);

        while(n>9)
        {
            int s=0;
            while(n!=0)
            {
                s=s+n%10;
                n=n/10;
            }
            n=s;
        }
        int result=n;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);


    }

}



