package com.javarxjava.chapter01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)
                .doOnNext(data -> System.out.println(getThreadName() + " : #doOnNext() : " + data))
                .subscribeOn(Schedulers.io()) // 데이터 발행, 흐름
                .observeOn(Schedulers.computation()) // 데이터 가공, 구독, 처리
                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

        Thread.sleep(500);
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
