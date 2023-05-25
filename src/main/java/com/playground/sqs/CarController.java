package com.playground.sqs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final MessagePublisher messagePublisher;

    @PostMapping
    public String createCar() {
        messagePublisher.publisher();
        return "Created";
    }
}
