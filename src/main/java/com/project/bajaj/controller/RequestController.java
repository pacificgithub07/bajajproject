package com.project.bajaj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

import com.project.bajaj.GetRecord;
import com.project.bajaj.PostRecord;

class RequestData {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

@RestController
@RequestMapping("/bfhl")
public class RequestController {

    @GetMapping
    public GetRecord getResponse() {
        return new GetRecord(1);
    }

    @PostMapping
    public PostRecord postResponse(@RequestBody RequestData data) {
        String userId = "Prashant_Kumar_07092003";
        String email = "prashantsinghohm@gmail.com";
        String rollNumber = "2236936";
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> highestalphabet = new ArrayList<>();

        for (String val: data.getData()) {
            if (val.matches("[0-9]+")) {
                numbers.add(val);
            } else if (val.matches("[a-zA-Z]+")) {
                alphabets.add(val);
            }
        }

        if (!alphabets.isEmpty()) {
            String[] sortedAplpha = alphabets.toArray(new String[0]);
            Arrays.sort(sortedAplpha);
            highestalphabet.add(sortedAplpha[sortedAplpha.length - 1]);
        }

        return new PostRecord(
            true,
            userId,
            email,
            rollNumber,
            numbers,
            alphabets,
            highestalphabet
        );
    }
}
