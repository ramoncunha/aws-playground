package com.playground.sqs.infrastructure;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageSubscription {

    @SqsListener("${NOME_FILA}")
    public void subscription(String message) {
        log.atInfo().log(message);
    }
}
