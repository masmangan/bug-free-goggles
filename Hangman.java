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

    //hint = update(hint, secret, guess);
    /**
     * Revela as ocorrencia de guess em secret na palavra hint.
     * 
     * secret e hint tem o mesmo comprimento.
     * 
     * guess aparece em secret.
     * 
     * guess nao aparece em hint.
     * 
     */
    public static String update(String hint, String secret, char guess) {
        String newHint = "";

        for (int i = 0; i < secret.length(); i++) {
            char h = hint.charAt(i);
            char s = secret.charAt(i);
            char g = guess;

            //System.out.printf("H=%c S=%c G=%c\n", h, s, g);

            if (s == g) {
                newHint = newHint + g;
            } else {
                newHint = newHint + h;
            }

        }
        return newHint;
    }

    
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
        int turn = 0;

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
            //System.out.printf("DEBUG: %s\n", secret);
            turn++;
            System.out.printf("\nRODADA #%d\n", turn);
            System.out.printf("PALAVRA: %s\n", hint);
            System.out.printf("TENTATIVAS: %s\n", history);
            System.out.printf("ERROS: %d\n", errors);

            if (errors >= 6) {
                System.out.println("Voce perdeu!!");
                break;
            }

            if (secret.equals(hint)) {
                System.out.println("Voce ganhou!!");
                break;
            }

            System.out.print("Escolha uma letra: ");
            String line = in.nextLine();
            if (line.length() > 1) {
                System.out.println("TUDO OU NADA!");
                if (secret.equals(line)) {
                    System.out.println("VOCE VENCEU!");
                } else {
                    System.out.println("VOCE PERDEU!");
                    System.out.printf("A palavra era: %s.\n", secret);                    
                }
                break;
            }
            guess = line.charAt(0);

            System.out.printf("Voce escolheu: %c.\n", guess);

            if (history.contains(""+guess)) {
                System.out.println("Voce ja escolheu essa letra antes!");
            } else {
                history = history + guess;
                if (secret.contains(""+guess)) {
                    System.out.println("Letra aparece em secret!");
                    hint = update(hint, secret, guess);
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
