package hello;

import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorrectCalculation() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("expression", "1+1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 2.0))
                .andExpect(view().name("calculator"));
    }

//    @Test
//    public void testIncorrectCalculation() throws Exception {
//        double result = new ExpressionBuilder("5-1").build().evaluate();
//        assertEquals(2.0, result, "Помилка");
//    }
}