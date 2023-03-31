import java.util.Scanner;

public class Main {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlayerStatus.setGameName("Kill Enemy");
        System.out.println("Start game " + PlayerStatus.getGameName());
        System.out.println();

        System.out.println("Enter the players' data");

        PlayerStatus player1 = new PlayerStatus();
        PlayerStatus player2 = new PlayerStatus();

        System.out.println("Player1: ");
        System.out.println("Enter the name of the first player:");
        String nickName1 = sc.next();
        System.out.println("Enter the number of lives:");
        int lives1 = sc.nextInt();
        System.out.println("Enter the player's score:");
        int score1 = sc.nextInt();
        player1.initPlayer(nickName1, lives1, score1);
        System.out.println();

        System.out.println("Player2:");
        System.out.println("Enter the name of the second player");
        String nickName2 = sc.next();
        System.out.println("Enter the number of lives:");
        int lives2 = sc.nextInt();
        System.out.println("Enter the player's score:");
        int score2 = sc.nextInt();
        player2.initPlayer(nickName2, lives2, score2);
        System.out.println();

        player1.printPlayerStatus();
        System.out.println();
        player2.printPlayerStatus();
        System.out.println();

        player1.findArtifact(6);
        player1.findArtifact(7);
        player2.findArtifact(6);
        player2.findArtifact(12);

        player1.printPlayerStatus();
        System.out.println();
        player2.printPlayerStatus();
        System.out.println();

        int findArtifactPower1 = getRandomNumber(0,500);
        int findArtifactPower2 = getRandomNumber(0,1000);
        player1.findArtifact(findArtifactPower1);
        player2.findArtifact(findArtifactPower2);

        player1.printPlayerStatus();
        System.out.println();
        player2.printPlayerStatus();
        System.out.println();

        System.out.println("Choose the first player's weapon ->> knife/sniper/kalashnikov");
        String weaponInHand1 = sc.next();
        System.out.println("Choose the second player's weapon ->> knife/sniper/kalashnikov");
        String weaponInHand2 = sc.next();

        player1.setWeaponInHand(weaponInHand1);
        player2.setWeaponInHand(weaponInHand2);
        System.out.println();

        player1.printPlayerStatus();
        System.out.println();
        player2.printPlayerStatus();
        System.out.println();

        System.out.println("The first player's weapon is : " + player1.getWeaponInHand());
        System.out.println("The second player's weapon " + player2.getWeaponInHand());
        System.out.println();

        System.out.print("Enter the coordinates for Player1:"
                + "\nCoordinate Ox: ");
        int distanceOx1 = sc.nextInt();
        System.out.print("Coordinate Oy: ");
        int distanceOy1 = sc.nextInt();
        System.out.println();

        System.out.print("Enter the coordinates for Player2:"
                + "\nCoordinate Ox: ");
        int distanceOx2 = sc.nextInt();
        System.out.print("Coordinate Oy: ");
        int distanceOy2 = sc.nextInt();
        System.out.println();

        System.out.println("The coordinates of the players are:"
                +"\nPlayer1 -> " + nickName1 + ": (" + distanceOx1 + " , " + distanceOy1 + ")"
                +"\nPlayer2 -> " + nickName2 + ": (" + distanceOx2 + " , " + distanceOy2 + ")");
        System.out.println();

        player1.movePlayerTo(distanceOx1, distanceOy1);
        player2.movePlayerTo(distanceOx2, distanceOy2);

        player1.printPlayerStatus();
        System.out.println();
        player2.printPlayerStatus();
        System.out.println();

        player1.shouldAttackOpponent(player2);
        System.out.println("Would Player1 be victorious if he attacked? ->> " + player1.shouldAttackOpponent(player2));
        player2.shouldAttackOpponent(player1);
        System.out.println("Would Player2 be victorious if he attacked? ->>  " + player2.shouldAttackOpponent(player1));

        sc.close();

    }

}
