public class PlayerStatus {
    static private String gameName;
    private String nickName;
    private int score;
    private int lives;
    private int health;
    private String weaponInHand;
    private double positionX;
    private double positionY;


    PlayerStatus() {
        nickName = "";
        score = 0;
        lives = 3;
        health = 100;
        weaponInHand = "";
        positionX = 0;
        positionY = 0;
        gameName = "";

    }

    public void initPlayer(String nickName) {
        this.nickName = nickName;
    }

    public void initPlayer(String nickName, int lives) {
        initPlayer(nickName);
        this.lives = lives;

    }

    public void initPlayer(String nickName, int lives, int score) {
        initPlayer(nickName, lives);
        this.score = score;
    }

    public void findArtifact(int n) {

        boolean conditionTrue = false;

        if (CheckingNumber.isPerfectNumber(n)) {
            this.score = score + 5000;
            this.lives = lives + 1;
            this.health = 100;
            conditionTrue = true;
        }

        if (CheckingNumber.numberPrime(n)) {
            this.score = score + 1000;
            this.lives = lives + 2;
            if ((this.health + 25) > 100) {
                this.health = 100;
            } else {
                this.health = health + 25;
            }
            conditionTrue = true;
        }

        if (n % 2 == 0 && CheckingNumber.sumOfNumbers(n) % 3 == 0) {
            this.score = score - 3000;
            this.health = health - 25;
            if (this.health <= 0) {
                if (this.lives != 0) {
                    this.lives -= 1;
                    this.health = 100;
                } else {
                    System.out.println("Game over!");
                }
            }
            conditionTrue = true;
        }

        if (conditionTrue == false) {
            this.score += n;
        }
    }

    public boolean setWeaponInHand(String weaponInHand) {
        if (weaponInHand.equals("knife") && this.score >= 1000) {
            this.score = score - 1000;
            this.weaponInHand = "knife";
            return true;
        } else if (weaponInHand.equals("sniper") && this.score >= 10000) {
            this.score = score - 10000;
            this.weaponInHand = "sniper";
            return true;
        } else if (weaponInHand.equals("kalashnikov") && this.score >= 20000) {
            this.score = score - 20000;
            this.weaponInHand = "kalashnikov";
            return true;
        } else {
            System.out.println("Insufficient funds to buy this weapon");
            return false;
        }
    }

    public String getWeaponInHand() {
        return this.weaponInHand;
    }

    static void setGameName(String gameName) {
        PlayerStatus.gameName = gameName;
    }

    static String getGameName() {
        return gameName;
    }

    public void movePlayerTo(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    String getNickName() {
        return this.nickName;
    }

    public boolean shouldAttackOpponent(PlayerStatus opponent) {
        if (this.weaponInHand.equals(opponent.weaponInHand)) {
            int ProbWinPlayer1 = (3 * this.health + this.score / 100) / 4;
            int ProbWinPlayer2 = (3 * opponent.health + opponent.score / 100) / 4;
            if (ProbWinPlayer1 > ProbWinPlayer2) {
                return true;
            }
            return false;
        } else {
            double distanceOx = this.positionX - opponent.positionX;
            double distanceOy = this.positionY - opponent.positionY;
            double distanceBetweenPlayers = Math.sqrt(distanceOx * distanceOx + distanceOy * distanceOy);
            if (distanceBetweenPlayers > 1000) {
                if (this.weaponInHand.equals("sniper")) {
                    return true;
                } else if (opponent.weaponInHand.equals("sniper")) {
                    return false;
                } else if (this.weaponInHand.equals("kalashnikov")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.weaponInHand.equals("kalashnikov")) {
                    return true;
                } else if (opponent.weaponInHand.equals("kalashnikov")) {
                    return false;
                } else if (this.weaponInHand.equals("sniper")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    void printPlayerStatus() {
        System.out.println("Player info:"
                + "\nNickname: " + this.nickName
                + "\nScore: " + this.score
                +"\nLives: " + this.lives
                +"\nHealt: " + this.health
                +"\nPositionX: " + this.positionX
                +"\nPositionY: " + this.positionY
                +"\nWeaponInHand: " + this.weaponInHand);
    }

}
