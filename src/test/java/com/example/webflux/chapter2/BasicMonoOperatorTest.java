package com.example.webflux.chapter2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Mono의 흐름 시작 방법
 * 1. 데이터로부터 시작 -> 일반적인 경우 just / 특이한 상황 empty (Optional.empty())
 * 2. 함수로부터 시작 -> 동기적인 객체를 Mono로 반환하고 싶을 때 fromCallable / 코드의 흐름을 Mono 안에서 관리하면서 Mono를 반환하고 싶을 때 defer
 */
public class BasicMonoOperatorTest {

    // just, empty
    @Test
    public void startMonoFromData() {
        Mono.just(1).subscribe(data -> System.out.println("data = " + data));

        // ex) 사소한 에러가 발생했을 때 로그를 남기고 empty의 Mono를 전파
        Mono.empty().subscribe(data -> System.out.println("empty data = " + data));
    }

    /**
     * fromCallable -> 동기적인 객체를 반환할 때 사용
     * defer -> Mono를 반환하고 싶을 때 사용
     */
    @Test
    public void startMonoFromFunction() {
        Mono<String> monoFromCallable = Mono.fromCallable(() -> {
            return callRestTemplate("안녕!");
        }).subscribeOn(Schedulers.boundedElastic());

       // Mono 객체를 Mono 객체로 반환
        Mono<String> monoFromDefer = Mono.defer(() -> {
            return callWebClient("안녕!");
        });

        monoFromDefer.subscribe();
        Mono<String> monoFromJust = Mono.just("안녕!");
    }

    public Mono<String> callWebClient(String request) {
        return Mono.just(request + "callWebClient");
    }

    public String callRestTemplate(String request) {
        return request + "callRestTemplate 응답";
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

    /**
     *  흐름 시작/데이터 가공/구독
     */
    @Test
    public void testBasicFluxMono() {
        Flux.<Integer>just(1,2,3,4,5,6)
                .map(data -> data * 2)
                .filter(data -> data % 4 == 0)
                .subscribe(data -> System.out.println("Flux가 구독한 data! = " + data));

        Mono.<Integer>just(2)
                .map(data -> data * 2)
                .filter(data -> data % 4 == 0)
                .subscribe(data -> System.out.println("Mono가 구독한 data! =" + data));
    }

    // Mono -> Flux 변환 (flatMapMany)
    // mono에서 데이터 방출의 개수가 많아져서 Flux로 바꾸고 싶다. -> flatMapMany
    @Test
    public void monoToFlux() {
        Mono<Integer> one = Mono.just(1);
        Flux<Integer> integerFlux = one.flatMapMany(data -> {
            return Flux.just(data, data + 1, data + 2);
        });
        integerFlux.subscribe(data -> System.out.println("data = " + data));
    }
}
