package com.task.tone.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class AnalyticStringServiceTest {

    private AnalyticStringService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new AnalyticStringServiceImpl();
    }

    @Test
    public void canGiveCountCharacterInString() {
        //given
        String string = "aabbbc";
        //when
        HashMap<Character, Integer> resultArr = underTest.giveCountCharacterInString(string);
        //then
        assertThat(resultArr).isNotNull();
        assertThat(resultArr.size()).isEqualTo(3);
        assertThat(resultArr.get('a')).isEqualTo(2);
        assertThat(resultArr.get('b')).isEqualTo(3);
        assertThat(resultArr.get('c')).isEqualTo(1);
        assertThat(resultArr.toString()).isEqualTo("{b=3, a=2, c=1}");
    }
}
