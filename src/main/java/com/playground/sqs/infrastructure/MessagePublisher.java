package com.playground.sqs.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.playground.sqs.domain.CarDTO;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.playground.sqs.shared.DependencyConfig.OBJECT_MAPPER;

@Service
public class MessagePublisher {

    private final String queueName;
    private final SqsTemplate sqsTemplate;

    public MessagePublisher(@Value("${NOME_FILA}") String queueName,
                            SqsTemplate sqsTemplate) {
        this.queueName = queueName;
        this.sqsTemplate = sqsTemplate;
    }

    public void publisher(CarDTO carDTO) {
        sqsTemplate.send(to -> to.queue(queueName)
                .payload(parseToString(carDTO))
                .header("my", "header")
        );
    }

    private String parseToString(CarDTO carDTO) {
        try {
            return OBJECT_MAPPER.writeValueAsString(carDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
