package com.task.tone.service;

import java.util.HashMap;

public interface AnalyticStringService {

    /**
     * Сounts the number of letters in a string
     *
     * @param string - input string
     * @return HashMap (Character, Count)
     */
    HashMap<Character, Integer> giveCountCharacterInString(String string);

    /**
     * Sort HashMap by value desc
     *
     * @param data sourse HashMap<Character, Integer>
     * @return sorted HashMap<Character, Integer> by value
     */
    HashMap<Character, Integer> sortHashMapByValueDesc(HashMap<Character, Integer> data);
}
