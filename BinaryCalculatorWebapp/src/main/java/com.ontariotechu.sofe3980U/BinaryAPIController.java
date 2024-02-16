package com.ontariotechu.sofe3980U;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

  // For handling invalid binary inputs explicitly
  /*
  @GetMapping("/validateAndAdd")
  public ResponseEntity<?> validateAndAdd(@RequestParam String operand1, @RequestParam String operand2) {
      if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
          return ResponseEntity.badRequest().body("Invalid binary number format");
      }
      Binary number1 = new Binary(operand1);
      Binary number2 = new Binary(operand2);
      String result = Binary.add(number1, number2).getValue();
      return ResponseEntity.ok(result);
  }
  */

  private boolean isValidBinary(String number) {
      return number.matches("[01]+");
  }

  @GetMapping("/multiply")
  public String multiply(@RequestParam String operand1, @RequestParam String operand2) {
      Binary result = Binary.multiply(new Binary(operand1), new Binary(operand2));
      return result.getValue();
  }

  @GetMapping("/and")
  public String and(@RequestParam String operand1, @RequestParam String operand2) {
      Binary result = Binary.and(new Binary(operand1), new Binary(operand2));
      return result.getValue();
  }

  @GetMapping("/or")
  public String or(@RequestParam String operand1, @RequestParam String operand2) {
      Binary result = Binary.or(new Binary(operand1), new Binary(operand2));
      return result.getValue();
  }
}
