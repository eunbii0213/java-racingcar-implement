package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_RANGE_START = 1;
    private static final int RANDOM_RANGE_END = 9;
    private static final int GO_NUMBER = 4;
    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isCarGo() {
        if(makeRandomNumber() >= GO_NUMBER){
            position++;
            return true;
        }
        return false;
    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
    }

    public String getName() {
        return name;
    }
}
