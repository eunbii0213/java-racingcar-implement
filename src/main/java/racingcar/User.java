package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int DONT_START_GAME = 0;
    private int gameNumber;

    public void userCarNameInput(User user) {
        View.userCarNameInputGuide();
        String beforeCheckInput = Console.readLine();

        String userInput = ErrorMessageView.userInputChecker(beforeCheckInput, user);
        CarRepository.carNameListAdd(userInput);
    }

    public void userGameNumberInput() {
        View.userGameNumberInputGuide();
        String userNumberInputBeforeCheck = Console.readLine();
        gameNumber = ErrorMessageView.catchErrorUserInputNumberChecker(userNumberInputBeforeCheck);
    }

    public void decreaseGameNumber() {
        gameNumber--;
    }

    public boolean isGameEnd() {
        return gameNumber == DONT_START_GAME;
    }
}