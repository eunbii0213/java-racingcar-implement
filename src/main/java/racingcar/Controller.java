package racingcar;

import java.util.Comparator;
import java.util.List;

public class Controller {

    public void makeEveryCarGoOrStop() {
        List<Car> carList = CarRepository.getCarList();
        for (Car car : carList) {
            car.isCarGo();
            View.printPosition(car);
        }
        System.out.println();
    }

    public Car searchMAX() {
        Car maxMember = CarRepository.getCarList()
                .stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(IllegalArgumentException::new);

        return maxMember;
    }

    public void gameSettingBeforeStart(User user) {
        user.userCarNameInput(user);
        user.userGameNumberInput();
        CarRepository.makeCarEntity();
    }
}
