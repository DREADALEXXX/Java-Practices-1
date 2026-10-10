import java.lang.*;
import java.util.Scanner;
public class TestAuthor {
    public static void main(String[] args){
        String email;
        Author pushkin=new Author("Alex","alex@ru",'m');
        System.out.println(pushkin.getEmail());
        Scanner scanner=new Scanner(System.in);
        email=scanner.nextLine();
        pushkin.setEmail(email);
        System.out.println(pushkin.getEmail());
    }
}
