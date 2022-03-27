package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarRepository {
    private static final int INITIAL_INDEX = 0;
    private static final String COMMA = ",";
    private static List<String> carName = new ArrayList<>();
    private static List<Car> carList;

    public static List<Car> getCarList() {
        return carList;
    }

    public static void makeCarEntity() {
        carList = new ArrayList<>();
        for (int index = INITIAL_INDEX; index < carName.size(); index++) {
            carList.add(new Car(carName.get(index)));
        }
    }

    public static void carNameListAdd(String userInput) {
        StringTokenizer st = new StringTokenizer(userInput, COMMA);
        while (st.hasMoreTokens()) {
            String carNameInput = st.nextToken();
            carName.add(carNameInput);
        }
    }
}
