package com.example.webflux.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BasicFluxMonoTest {

    /**
     * Flux의 흐름을 시작하는 방법은 두가지가 있음
     * 첫번째는 빈 함수로부터, 두번쨰는 데이터로부터 시작할 수 있음
     */
    @Test
    public void testBasicFluxMono() {
        // 1. just 데이터로부터 흐름을 시작했습니다.
        // 2. map과 filter 같은 연산자로 데이터를 가공했습니다.
        // 3. subscribe하면서 데이터를 방출시켰습니다.
        Flux.<Integer>just(1,2,3,4,5)
            .map(data -> data * 2)
            .filter(data -> data % 4 == 0)
            .subscribe(data -> System.out.println("Flux가 구독한 data! = " + data));

        // Mono: 0개부터 1개의 데이터만 방출할 수 있는 객체 -> Optional 정도
        // Flux: 0개 이상의 데이터를 방출할 수 있는 객체 -> List, Stream 0개 이상의 데이터 방출
        Mono.<Integer>just(2)
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
