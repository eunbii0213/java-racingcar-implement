package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Checker {
    private static final int INITIAL_INDEX = 0;
    private static final String COMMA = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String IS_SPECIAL_LETTER = "[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*";
    private static final int LAST_INDEX_CONSTANT = 1;

    public static void containAnotherSpecialLetterChecker(String userInput) {
        for (int index = INITIAL_INDEX; index < userInput.length() - LAST_INDEX_CONSTANT; index++) {
            String oneLetter = userInput.substring(index, index + LAST_INDEX_CONSTANT);
            if (!oneLetter.matches(IS_SPECIAL_LETTER) && !oneLetter.equals(COMMA)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void containSameNameChecker(String userInput) {
        StringTokenizer st = new StringTokenizer(userInput, COMMA);
        List<String> nameList = new ArrayList<>();

        int count = st.countTokens() - LAST_INDEX_CONSTANT;
        for (int index = INITIAL_INDEX; index < st.countTokens(); index++) {
            nameList.add(st.nextToken());
        }
        int index = INITIAL_INDEX;
        while (index < count) {
            String target = nameList.get(index);
            nameList.remove(index);

            if (nameList.contains(target)) {
                throw new IllegalArgumentException();
            }

            count--;
        }
    }

    public static void userInputIsMoreThanFiveLettersChecker(String userInput) {
        StringTokenizer st = new StringTokenizer(userInput, COMMA);
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int userInputNumberChecker(String userInput) {
        int userInputToInt;
        try {
            userInputToInt = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userInputToInt;
    }

    public static boolean isSameWithPosition(int compareNumber, Car car) {
        return compareNumber == car.getPosition();
    }
}
