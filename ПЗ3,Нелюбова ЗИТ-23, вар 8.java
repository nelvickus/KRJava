import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EveryThirdGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        int totalPlayers = scanner.nextInt();
        System.out.print("Введите номер игрока, с которого начинается игра: ");
        int startPlayer = scanner.nextInt();

        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= totalPlayers; i++) {
            players.add(i);
        }

        List<Integer> eliminatedPlayers = new ArrayList<>();
        int index = startPlayer - 1; 

        while (players.size() > 1) {
            index = (index + 2) % players.size();
            int eliminatedPlayer = players.remove(index); 
            eliminatedPlayers.add(eliminatedPlayer);
            System.out.println("[" + players + "] => " + eliminatedPlayer + " is counted out and goes into the result " + eliminatedPlayers);
        }

  
        int winner = players.get(0);
        eliminatedPlayers.add(winner);
        System.out.println("[" + players + "] => " + winner + " is counted out and goes into the result " + eliminatedPlayers);

        scanner.close();
    }
}
