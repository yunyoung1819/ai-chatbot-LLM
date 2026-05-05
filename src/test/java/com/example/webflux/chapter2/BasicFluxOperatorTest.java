package com.example.webflux.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;


public class BasicFluxOperatorTest {

    /**
     * Flux
     * 데이터: just, empty, from~
     * 함수: defer, create
     */
    @Test
    public void testFluxFromData() {
        Flux.just(1, 2, 3, 4)
                .subscribe(data -> System.out.println("data = " + data));

        List<Integer> basicList = List.of(1, 2, 3, 4);
        Flux.fromIterable(basicList)
                .subscribe(data -> System.out.println("data fromIterable = " + data));

    }

    /**
     * Flux defer -> 안에서 Flux 객체를 반환
     * Flux create -> 안에서 동기적인 객체를 반환
     */
    @Test
    public void testFluxFromFunction() {
        Flux.defer(() -> {
            return Flux.just(1, 2, 3, 4);
        }).subscribe(data -> System.out.println("data from defer = " + data));

        Flux.create(sink -> {
            sink.next(1);
            sink.next(2);
            sink.next(3);
            sink.complete();
        }).subscribe(data -> System.out.println("data from sink = " + data));
    }
}
