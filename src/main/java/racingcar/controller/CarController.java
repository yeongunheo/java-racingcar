package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final InputView inputView;
    private final CarService carService;

    public CarController(final Scanner scanner) {
        inputView = new InputView(scanner);
        carService = new CarService();
    }

    public String scanCarNames() {
        return inputView.scanCarNames();
    }

    public List<Car> saveCars(final String carNames) {
        final String[] names = carService.splitCarNames(carNames);
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int scanRacingCnt() {
        return Integer.parseInt(inputView.scanRacingCnt());
    }

    public List<Car> race(List<Car> cars) {
        return carService.race(cars);
    }

    public void printResultInitMessage() {
        OutputView.printResultInitMessage();
    }

    public void printResult(final Map<String, Integer> carNameAndPositions) {
        OutputView.printResult(carNameAndPositions);
    }

    public List<String> getWinners(final List<Car> cars) {
        return carService.getWinners(cars);
    }
}