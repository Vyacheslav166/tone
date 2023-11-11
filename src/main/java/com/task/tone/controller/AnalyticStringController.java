package com.task.tone.controller;

import com.task.tone.service.AnalyticStringService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/service/string")
public class AnalyticStringController {

    private final AnalyticStringService analyticStringService;


    public AnalyticStringController(AnalyticStringService analyticStringService) {
        this.analyticStringService = analyticStringService;
    }

    @PostMapping
    public HashMap<Character, Integer> countCharacterInString(@RequestBody String string) {
        return analyticStringService.giveCountCharacterInString(string);
    }

    @GetMapping
    public String eee() {
        return "eeee";
    }
}
