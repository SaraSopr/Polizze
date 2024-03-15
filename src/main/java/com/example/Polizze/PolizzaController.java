package com.example.Polizze;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/polizza")
public class PolizzaController {
    @GetMapping("/{nPolizza}", produces = "application/json")
    public @ResponseBody PolizzaDb getBook(@PathVariable String nPolizza) {
        return findPolizzaByNumero(nPolizza);
    }
}
