package ProjectUAS;

public class Main {
    public static void main(String[] args) {
        PapanSudoku papan = new PapanPermainan(); 
        GameController gameController = new GameController(papan);
        gameController.mulaiPermainan();
    }
}
