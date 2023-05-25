package com.playground.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Service
@RequiredArgsConstructor
public class PublisherConfigFactory {

    private final SqsAsyncClient asyncClient;

    @Bean
    public SqsTemplate getSqsTemplate() {
        return SqsTemplate.builder()
                .sqsAsyncClient(asyncClient)
                .configure(options -> options
                        .acknowledgementMode(TemplateAcknowledgementMode.ACKNOWLEDGE))
                .build();
    }
}
