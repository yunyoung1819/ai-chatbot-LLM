package com.example.webflux.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Flux와 Mono
 * 1. Flux, Mono는 크게 [데이터 흐름 시작, 데이터 가공, 구독]의 흐름으로 이루어진다.
 * 2. Flux는 0개 이상의 무한정 데이터를 방출한다.
 * 3. Mono는 0개, 1개의 데이터만 방출한다.
 */
public class BasicFluxMonoTest {

    // 첫번째는 빈 함수로부터, 두번째는 데이터로부터 시작할 수 있다.
    @Test
    public void testBasicFluxMono() {
        Flux.<Integer>just(1,2,3,4,5)
                .map(data -> data * 2)
                .filter(data -> data % 4 == 0)
                .subscribe(data -> System.out.println("Flux가 구독한 data! = " + data));
        // 1. just 데이터로부터 흐름을 시작
        // 2. map과 filter 같은 연산자로 데이터를 가공
        // 3. subscribe하면서 데이터를 방출

        // Mono 0개부터 1개의 데이터만 방출할 수 있는 객체 -> Optional 정도
        // Flux 0개 이상의 데이터를 방출할 수 있는 객체 -> List, Stream

        Mono.just(2)
                .map(data -> data * 2)
                .filter(data -> data % 4 == 0)
                .subscribe(data -> System.out.println("Mono가 구독한 data! = " + data));
    }

    @Test
    public void testFluxMonoBlock() {
        Mono<String> justString = Mono.just("String");
        String string = justString.block();
        System.out.println("string = " + string);
    }
}
