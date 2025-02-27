package com.javarxjava.chapter03.chapter0303;

import com.javarxjava.utils.DateUtil;
import com.javarxjava.utils.LogType;
import com.javarxjava.utils.Logger;
import io.reactivex.Single;

public class SingleLamdaExample {
    public static void main(String[] args){
        Single<String> single = Single.create(emitter -> emitter.onSuccess(DateUtil.getNowDate()));

        single.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                error -> Logger.log(LogType.ON_ERROR, error)
        );
    }
}