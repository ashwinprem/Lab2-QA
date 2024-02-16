package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }


  /*
  @Test
  public void addWithInvalidBinaryNumber() throws Exception {
      this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "102"))
          .andExpect(status().isBadRequest()) // Assuming API responds with 400 Bad Request for invalid input.
          .andExpect(content().string(containsString("Invalid binary number"))); 
  }
  */

  @Test
  public void addWithEmptyOperands() throws Exception {
      this.mvc.perform(get("/add").param("operand1", "").param("operand2", ""))
          .andExpect(status().isOk()) // Assuming API treats empty operands as 0.
          .andExpect(content().string("0")); // Expecting the addition of 0 + 0 to result in 0.
  }

  @Test
  public void addWithMissingOperand() throws Exception {
      this.mvc.perform(get("/add").param("operand1", "1010")) // Missing operand2
          .andExpect(status().isOk()) // Depending on implementation, this could also result in a BadRequest.
          // Assuming API defaults missing operand to 0 or similar behavior.
          .andExpect(content().string("1010")); // Expecting the result to be the same as the provided operand.
  }

  // Multiply
  @Test
  public void multiplyBinaryNumbers() throws Exception {
      this.mvc.perform(get("/multiply").param("operand1", "101").param("operand2", "10"))
          .andExpect(status().isOk())
          .andExpect(content().string("1010"));
  }

  @Test
  public void multiplyByZero() throws Exception {
      this.mvc.perform(get("/multiply").param("operand1", "101").param("operand2", "0"))
          .andExpect(status().isOk())
          .andExpect(content().string("0"));
  }

  // And
  @Test
  public void andBinaryNumbers() throws Exception {
      this.mvc.perform(get("/and").param("operand1", "111").param("operand2", "101"))
          .andExpect(status().isOk())
          .andExpect(content().string("101"));
  }

  @Test
  public void andWithZero() throws Exception {
      this.mvc.perform(get("/and").param("operand1", "111").param("operand2", "0"))
          .andExpect(status().isOk())
          .andExpect(content().string("0"));
  }

  // or
  @Test
  public void orBinaryNumbers() throws Exception {
      this.mvc.perform(get("/or").param("operand1", "100").param("operand2", "001"))
          .andExpect(status().isOk())
          .andExpect(content().string("101"));
  }

  @Test
  public void orWithZero() throws Exception {
      this.mvc.perform(get("/or").param("operand1", "100").param("operand2", "0"))
          .andExpect(status().isOk())
          .andExpect(content().string("100"));
  }

}
