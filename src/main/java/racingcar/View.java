package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class View {
    private static final String USER_CAR_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String USER_GAME_NUMBER_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    protected static final String ERROR_MESSAGE = "[ERROR]";
    private static final int INITIAL_INDEX = 0;
    private static final String COMMA_WITH_BLANK = ", ";
    private static final String WINNER_IS = "최종 우승자 : ";
    private static final String COLON_WITH_BLANK = " : ";
    private static final String GO = "-";
    private static final int GROUND = 0;
    private static List<String> winnerResult;

    public static void userCarNameInputGuide() {
        System.out.println(USER_CAR_INPUT_GUIDE);
    }

    public static void userGameNumberInputGuide() {
        System.out.println(USER_GAME_NUMBER_INPUT_GUIDE);
    }

    public static void whoIsWinner(Controller controller) {
        Car maxCarEntity = controller.searchMAX();
        winnerResult = new ArrayList<>();

        int bound = CarRepository.getCarList().size();
        IntStream.range(INITIAL_INDEX, bound)
                .filter(index -> Checker.isSameWithPosition(
                        maxCarEntity.getPosition(), CarRepository.getCarList().get(index)))
                .forEach(index -> winnerResult.add(CarRepository.getCarList().get(index).getName()));

        System.out.println(WINNER_IS + String.join(COMMA_WITH_BLANK, winnerResult));
    }

    public static void printPosition(Car car) {
        String positionStr = car.getName() + COLON_WITH_BLANK;
        int tempPositionNumber = car.getPosition();

        while (tempPositionNumber > GROUND) {
            positionStr += GO;
            tempPositionNumber--;
        }
        System.out.println(positionStr);
    }
}
