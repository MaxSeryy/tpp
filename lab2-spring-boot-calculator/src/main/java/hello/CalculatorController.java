package hello;

import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String expression, Model model) {
        try {
            double result = new ExpressionBuilder(expression).build().evaluate();
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("error", "Помилка обчислення");
        }
        model.addAttribute("expression", expression);
        return "calculator";
    }
}