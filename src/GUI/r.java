package GUI;

import java.util.Scanner;

public class r {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // String input
        System.out.println("coloque el primer numero");
        String primer = sc.nextLine();
        System.out.println("coloque el segundo numero");
        String segundo=sc.nextLine();
        dos_mas_dos(Integer.parseInt(primer),Integer.parseInt(segundo));
    }
    public static void dos_mas_dos(int i, int parseInt){
        System.out.println(i+parseInt);
    }
}
