package com.playground.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagePublisher {

    private final SqsTemplate sqsTemplate;

    public void publisher() {
        sqsTemplate.send(to -> to.queue("CARS-CREATION")
                .payload("testing")
                .header("my", "header")
        );
    }
}
