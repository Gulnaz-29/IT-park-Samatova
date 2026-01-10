import java.util.Scanner;

public class Game {

    private static Player createPlayer(Scanner scanner) {
        System.out.print("Введите имя игрока - ");
        String name = scanner.nextLine().trim();
        return new Player(name);
    }

    private static int getPowerOfKick(Scanner scanner, String name) {
        while (true) {
            System.out.print("%s, введи силу удара от 1 до 9 - ".formatted(name));
            int power = scanner.nextInt();
            if (power >= 1 && power <= 9) {
                return power;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPlayers = 2;
        Player[] players = new Player[countOfPlayers];
        for (int i = 0; i < countOfPlayers; i++) {
            players[i] = createPlayer(scanner);
        }

        boolean isNotEnd = true;

        while (isNotEnd) {
            for (int i = 0; i < countOfPlayers; i++) {
                Player actualPlayer = players[i];
                Player kickedPlayer = players[countOfPlayers - 1 - i];
                if (actualPlayer.isAlive()) {
                    kickedPlayer.kicked(getPowerOfKick(scanner, actualPlayer.getName()));
                    System.out.print("%s, твой hp  - %s\n".formatted(kickedPlayer.getName(), kickedPlayer.getHp()));
                } else {
                    isNotEnd = false;
                    System.out.println("Игрок %s умер".formatted(actualPlayer.getName()));
                    break;
                }
            }
        }

        System.out.println("КОНЕЦ ИГРЫ");
    }
}
