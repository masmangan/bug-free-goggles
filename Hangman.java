import java.util.Scanner;
import java.util.Random;

/**
 * A hangman game.
 * 
 * @author marco.mangan@pucrs.br
 * @date 2025-05-19
 */
public class Hangman
{
    /**
     * 
     */
    private Hangman() { }
    
    /**
     * 
     */
    public static void main(String[] args)
    {
        Random r = new Random();
        
        String[] secrets = {"garrafa", "elefante",
        "suspeito", "banana", "carro"};
        int selected = r.nextInt(secrets.length);
        
        System.out.println("Jogo da Forca");
        System.out.println("=============");
        
        String secret = secrets[selected];
        String hint =   "";
        for (int i = 0; i < secret.length(); i++) {
            hint = hint + "-";
        }

        System.out.println(secret);
        System.out.println(hint);

        // Scanner in;
        // int a;
        // int b;
        // int s;

        // // entrada de dados
        // in = new Scanner(System.in);
        // a = in.nextInt();      
        // b = in.nextInt();      
        // in.close();

        // // processamento de dados
        // s = a + b;

        // // saida de dados
        // System.out.println(s);
    }
}
