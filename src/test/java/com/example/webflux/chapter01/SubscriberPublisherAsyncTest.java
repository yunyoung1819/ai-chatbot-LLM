package com.example.webflux.chapter01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@SpringBootTest
public class SubscriberPublisherAsyncTest {

    @Test
    public void produceOneToNineFlux() {
        Flux<Integer> intFlux = Flux.<Integer>create(sink -> {
            for (int i = 1; i <= 9; i++) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {

                }
                sink.next(i);
            }

            sink.complete();
        }).subscribeOn(Schedulers.boundedElastic());

        // 불로킹 코드가 들어 있는 Flux 코드는 스케쥴러의 스레드가 구독하고 실행시킵니다.
        // 메인 스레드는 이 코드를 그냥 통과합니다.
        intFlux.subscribe(data -> {
            System.out.println("처리 되고 있는 스레드 이름: " + Thread.currentThread().getName());
            System.out.println("WebFlux가 구독 중!! : " + data);
        });
        System.out.println("Netty 이벤트 루프로 스레드 복귀");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
