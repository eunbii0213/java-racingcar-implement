package racingcar;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        Controller controller = new Controller();

        gameStart(user, controller);
    }

    public static void gameStart(User user, Controller controller) {
        controller.gameSettingBeforeStart(user);

        while (!user.isGameEnd()) {
            controller.makeEveryCarGoOrStop();
            user.decreaseGameNumber();
        }
        View.whoIsWinner(controller);
    }
}


