package com.javarxjava.chapter03.chapter0303;

import com.javarxjava.utils.DateUtil;
import com.javarxjava.utils.LogType;
import com.javarxjava.utils.Logger;
import io.reactivex.Single;

public class SingleJustExample {
    public static void main(String[] args){
        Single.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
    }
}