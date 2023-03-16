package pro.sky.skyprochikinsergeycalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String greeting() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>ОШИБКА! ВВЕДИТЕ 2 ПАРАМЕТРА!</b>";
        }
        return num1 + " + " + num2 + " = " + calculatorService.sum(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>ОШИБКА! ВВЕДИТЕ 2 ПАРАМЕТРА!</b>";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>ОШИБКА! ВВЕДИТЕ 2 ПАРАМЕТРА!</b> ";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping(path = "/divide")
    public String division(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>ОШИБКА! ВВЕДИТЕ 2 ПАРАМЕТРА!</b>";
        } else if (num2.equals("0")) {
            return "<b>На ноль делить НЕЛЬЗЯ!";
        }
        return num1 + " / " + num2 + " = " + calculatorService.division(Integer.parseInt(num1), Integer.parseInt(num2));
    }

}
