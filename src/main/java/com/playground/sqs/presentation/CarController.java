package com.playground.sqs.presentation;

import com.playground.sqs.domain.CarDTO;
import com.playground.sqs.infrastructure.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final MessagePublisher messagePublisher;

    @PostMapping
    public ResponseEntity<String> createCar(@RequestBody CarDTO carDTO) {
        messagePublisher.publisher(carDTO);
        return ResponseEntity.ok("Created");
    }
}
