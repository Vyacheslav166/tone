package com.task.tone.service;

import com.task.tone.exception.BadRequestException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalyticStringServiceImpl implements AnalyticStringService{

    @Override
    public HashMap<Character, Integer> giveCountCharacterInString(String string) {
        if (!StringUtils.isNotBlank(string)) {
            throw new BadRequestException("Invalid string");
        }

        HashMap<Character, Integer> charArr = new HashMap<>();
        int countChar;

        for (int i = 0; i < string.length(); i++) {
            if (charArr.containsKey(string.charAt(i))) {
                countChar = charArr.get(string.charAt(i));
                charArr.put(string.charAt(i), ++countChar);
            } else {
                charArr.put(string.charAt(i), 1);
            }
        }

        return this.sortHashMapByValueDesc(charArr);
    }

    @Override
    public HashMap<Character, Integer> sortHashMapByValueDesc(HashMap<Character, Integer> data) {
        return data.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
