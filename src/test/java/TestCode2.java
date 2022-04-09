import org.junit.Test;

import java.util.Scanner;

public class TestCode2 {


    @Test
    public void testString(){
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();

        String str1 = s.substring(0, 7);
        String str2 = s.substring(7, s.length());

        int i = Integer.parseInt(str1);

        System.out.println("前七位："+i);
        System.out.println("后几位："+str2);

    }
}
