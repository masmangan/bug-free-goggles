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
        Scanner in;
        Random r = new Random();
        char guess;
        String history = "";
        int errors = 0;

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

        in = new Scanner(System.in);
        while (true) {
            // bloco principal do jogo
            System.out.printf("DEBUG: %s\n", secret);
            System.out.printf("PALAVRA: %s\n", hint);
            System.out.printf("TENTATIVAS: %s\n", history);
            System.out.printf("ERROS: %d\n", errors);
            
            if (errors >= 6) {
                break;
            }
            
            System.out.print("Escolha uma letra: ");
            String line = in.nextLine();
            guess = line.charAt(0);

            System.out.printf("Voce escolheu: %c.\n", guess);

            if (history.contains(""+guess)) {
                System.out.println("Voce ja escolheu essa letra antes!");
            } else {
                history = history + guess;
                if (secret.contains(""+guess)) {
                    System.out.println("Letra aparece em secret!");
                    
                } else {
                    System.out.println("Voce errou!!");
                    errors = errors + 1;
                }
            }

        }
        //
        System.out.println("Até logo!");
        in.close();
    }
}
