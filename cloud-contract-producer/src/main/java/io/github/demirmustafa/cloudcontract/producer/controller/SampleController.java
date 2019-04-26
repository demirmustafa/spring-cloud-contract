package io.github.demirmustafa.cloudcontract.producer.controller;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author Mustafa Demir <mustafa.demir@sahabt.com>
 */
@RestController
@RequestMapping("/producer/api/v1/sample")
public class SampleController {


    @GetMapping
    public SampleModel sample(@RequestParam Long id){
        String message = "This is a test message and request id is: " + id;
        return new SampleModel(message);
    }


}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SampleModel implements Serializable {
    private String message;
}
