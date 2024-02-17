package com.ontariotechu.sofe3980U;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

    // Add operation - String return type
    @GetMapping("/add")
    public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.add(number1, number2).getValue();
    }
    
    // Add operation - JSON return type
    @GetMapping("/add_json")
    public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
    }
  
    // Multiply operation - String return type
    @GetMapping("/multiply")
    public String multiplyString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                 @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.multiply(number1, number2).getValue();
    }
    
    // Multiply operation - JSON return type
    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                        @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
    }
    
    // OR operation - String return type
    @GetMapping("/or")
    public String orString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                           @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.or(number1, number2).getValue();
    }
    
    // OR operation - JSON return type
    @GetMapping("/or_json")
    public BinaryAPIResult orJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                  @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "or", number2, Binary.or(number1, number2));
    }
    
    // AND operation - String return type
    @GetMapping("/and")
    public String andString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.and(number1, number2).getValue();
    }
    
    // AND operation - JSON return type
    @GetMapping("/and_json")
    public BinaryAPIResult andJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "and", number2, Binary.and(number1, number2));
    }

    private boolean isValidBinary(String number) {
        return number.matches("[01]+");
    }
}
