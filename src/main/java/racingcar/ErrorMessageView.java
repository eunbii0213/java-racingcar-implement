package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ErrorMessageView extends View {
    private static final String SAME_NAME_MESSAGE = " 각 자동차마다 다른 이름으로 입력해야한다.";
    private static final String MAX_LENGTH_MESSAGE = " 자동차의 이름은 5글자 이하로 입력해야 한다.";
    private static final String SPECIAL_LETTER_MESSAGE = " 이름으로 숫자와 문자는 입력가능하나 구분자를 쉼표(,)를 사용해야 한다.";
    private static final String MUST_NUMBER_MESSAGE = " 시도 횟수는 숫자여야 한다.";

    public static String userInputChecker(String userInput, User user) {
        userInput = catchErrorSpecialLetter(userInput, user);
        userInput = catchErrorSameName(userInput, user);
        userInput = catchErrorNameLength(userInput, user);

        return userInput;
    }

    public static int catchErrorUserInputNumberChecker(String userNumberInput) {
        int result;
        try {
            result = Checker.userInputNumberChecker(userNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + MUST_NUMBER_MESSAGE);
            result = catchErrorUserInputNumberChecker(Console.readLine());
        }
        return result;
    }

    public static String catchErrorSameName(String userInput, User user) {
        try {
            Checker.containSameNameChecker(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + SAME_NAME_MESSAGE);
            userInput = userInputChecker(Console.readLine(), user);
        }
        return userInput;
    }

    public static String catchErrorNameLength(String userInput, User user) {
        try {
            Checker.userInputIsMoreThanFiveLettersChecker(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + MAX_LENGTH_MESSAGE);
            userInput = userInputChecker(Console.readLine(), user);
        }
        return userInput;
    }

    public static String catchErrorSpecialLetter(String userInput, User user) {
        try {
            Checker.containAnotherSpecialLetterChecker(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + SPECIAL_LETTER_MESSAGE);
            userInput = userInputChecker(Console.readLine(), user);
        }
        return userInput;
    }
}
