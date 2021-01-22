package fr.semifir.demospringboot.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @GetMapping("hello") //http://localhost:8080/hello
    public String hello() {
        return "Hello World";
    }

    @GetMapping("bye")
    public String bye() {
        return "Bye World";
    }

    // METHODE 1 pour envoyer des informations
    @PostMapping("message/{message2}/{message1}")
    public String message(@PathVariable String message1, @PathVariable String message2) {
        return "message1 = " + message1 + " | message2 = " + message2;
    }

    // METHODE 2 pour envoyer des informations
    @PostMapping("messages")
    public String messages(@RequestBody List<String> messages) {
        return "Vous avez " + messages.size() + " nouveaux messages";
    }

    // METHODE 3 pour envoyer des informations
    @PostMapping("params")
    public String params(@RequestParam String a, @RequestParam String b) {
        return "Vous avez " + List.of(a,b).size() + " nouveaux messages ! (avec params)";
    }
}
