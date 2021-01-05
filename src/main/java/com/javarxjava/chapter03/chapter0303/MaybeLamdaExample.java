package com.javarxjava.chapter03.chapter0303;

import com.javarxjava.utils.DateUtil;
import com.javarxjava.utils.LogType;
import com.javarxjava.utils.Logger;
import io.reactivex.Maybe;

public class MaybeLamdaExample {
    public static void main(String[] args){
        Maybe<String> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(DateUtil.getNowDate());
//            emitter.onComplete();
        });

        maybe.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );
    }
}