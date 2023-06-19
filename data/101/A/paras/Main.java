import java.util.*;
public class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        String s = sc.nextLine();
        int count = 0;
        for(char c : s.toCharArray())
            count += (c == 'X' ? 1 : 0);
        System.out.println(count);
    }
}
