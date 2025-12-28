package com.example.webflux.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Mono의 흐름 시작 방법
 * 1. 데이터로부터 시작 -> 일반적인 경우 just / 특이한 상황 empty (Optional.empty())
 * 2. 함수로부터 시작
 *  -> 동기적인 객체를 Mono로 반환하고 싶을 때 fromCallable / 코드의 흐름을 Mono에서 관리하면서 Mono를 반환하고 싶을 때 defer
 * 3. 데이터 가공: map, filter, flatmap, collectList
 *  -> flatMapMay (Mono에서 데이터 방출의 개수가 많아져서 Flux로 바꾸고 싶을때)
 */
public class BasicMonoOperatorTest {

    // just, empty
    @Test
    public void startMonoFromData() {
        Mono.just(1).subscribe(data -> System.out.println("data = " + data));

        // ex) 사소한 에러가 발생했을 때 로그를 남기고 emptry의 Mono를 전파
        Mono.empty().subscribe(data -> System.out.println("empty data = " + data));
    }

    /**
     * fromCallable, defer
     * fromCallable -> 동기적인 객체를 반환할 때 사용합니다.
     * defer -> Mono를 반환하고 싶을 때 사용합니다.
     * 임시마이그레이션
     * restTemplate, JPA >> 블로킹이 발생하는 라이브러리 Mono로 스레드 분리하여 처리
     */
    @Test
    public void startMonoFromFunction() {
        Mono<String> monoFromCallable = Mono.fromCallable(() -> {
            return callRestTemplate("안녕!");
        }).subscribeOn(Schedulers.boundedElastic());

        Mono<String> monoFromDefer = Mono.defer(() -> {
            return callWebClient("안녕!");
        });

        monoFromDefer.subscribe();

        Mono<String> monoFromJust = Mono.just("안녕!");
    }

    @Test
    public void testDeferNecessity() {
        Mono<String> stringMono = Mono.defer(() -> {
            String a = "안녕";
            String b = "하세";
            String c = "요";
            return callWebClient(a + b + c);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<String> callWebClient(String request) {
        return Mono.just(request + "callWebClient");
    }

    public String callRestTemplate(String request) {
        return request + "callRestTemplate 응답";
    }

    @Test
    public void monoToFlux() {
        Mono<Integer> one = Mono.just(1);
        Flux<Object> integerFlux = one.flatMapMany(data -> {
            return Flux.just(data, data + 1, data + 2);
        });
        integerFlux.subscribe(data -> System.out.println("data = " + data));
    }
}