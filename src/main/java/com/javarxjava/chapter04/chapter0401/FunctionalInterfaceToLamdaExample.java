package com.javarxjava.chapter04.chapter0401;

import com.javarxjava.common.Car;
import com.javarxjava.common.CarFilter;
import com.javarxjava.common.CarMaker;
import com.javarxjava.common.CarType;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자 정의 Predicate를 람다 표현식으로 사용하는 예제
 */
public class FunctionalInterfaceToLamdaExample {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(CarMaker.HYUNDAE, CarType.SUV, "팰리세이드", 28000000, true),
                new Car(CarMaker.SAMSUNG, CarType.SEDAN, "SM5", 35000000, true),
                new Car(CarMaker.CHEVROLET, CarType.SUV, "트래버스", 50000000, true),
                new Car(CarMaker.KIA, CarType.SEDAN, "K5", 20000000, false),
                new Car(CarMaker.SSANGYOUNG, CarType.SUV, "티볼리", 23000000, true)
        );

        List<Car> carsFilteredByPrice =
                CarFilter.filterCarByCustomPredicate(cars, (Car car) -> car.getCarPrice() > 30000000);
        for(Car car : carsFilteredByPrice)
            System.out.println("차 이름: " + car.getCarName() + ", 가격: " + car.getCarPrice());

        List<Car> carsFilteredByCarType =
                CarFilter.filterCarByCustomPredicate(cars, car -> car.getCarType().equals(CarType.SUV));
        for(Car car : carsFilteredByCarType)
            System.out.println("차 이름: " + car.getCarName() + ", 차종: " + car.getCarType());
    }
}