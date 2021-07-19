package com.avaliacaoestudos.avaliacaoestudos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculadora")
public class CalculadoraController {


    @GetMapping("/somar/{a}/{b}")
    public double somar(@PathVariable double a, @PathVariable double b) {
        return a + b;
    }

    @GetMapping("/subtrair/{a}/{b}")
    public double subtrair(@PathVariable double a, @PathVariable double b) {
        return a - b;
    }

    @GetMapping("/multiplicar/{a}/{b}")
    public double multiplicar(@PathVariable double a, @PathVariable double b) {
        return a * b;
    }

    @GetMapping("/dividir/{a}/{b}")
    public double dividir(@PathVariable double a, @PathVariable double b) {
        return a / b;
    }

    @GetMapping("/exponenciar/{a}/{b}")
    public int exponenciar(@PathVariable int a, @PathVariable int b) {
        if (a > 0) {
            if (b > 0) {
                return (int) Math.pow(a, b);
            }
        }
        throw new NumberFormatException("Utilize um valor maior que 0");
    }

    @GetMapping("/radiciacao/{a}/{b}")
    public int radiciacao(@PathVariable int a, @PathVariable int b) {
        if (a > 0) {
            if (b > 0) {
                return (int) Math.pow(a, 1.0 / b);
            }
        }
        throw new NumberFormatException("Utilize um valor maior que 0");
    }
}

