package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Дана строка (возможно, пустая), состоящая из букв A-Z: AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
 * Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
 * И сгенерирует ошибку, если на вход пришла невалидная строка.
 * Пояснения: Если символ встречается 1 раз, он остается без изменений; Если символ повторяется более 1 раза, к нему добавляется количество повторений.
 */
public class RLEStringTest {


    private String toRle(String input) {
        if(input==null || input.isEmpty()) {
            return "";
        }
        if(!input.matches("[A-Z]+")) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        char prev = input.charAt(0);
        int counter = 1;
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if(current == prev) {
                counter++;
            } else {
                sb.append(prev);
                if(counter > 1) {
                    sb.append(counter);
                }
                prev = current;
                counter = 1;
            }
            if(i == input.length() - 1) {
                sb.append(prev);
                if(counter > 1) {
                    sb.append(counter);
                }
            }
        }


        return sb.toString();
    }


    @Test
    public void whenInvalid(){
        String input = "123";

        Assertions.assertThrows(IllegalArgumentException.class, () -> toRle(input));

    }


    @Test
    public void whenEmpty(){
        String input = "";
        String expected = "";

        String actual = toRle(input);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void whenNull(){
        String input = null;
        String expected = "";

        String actual = toRle(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void fromTask(){
        String input = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        String expected = "A4B3C2XYZD4E3F3A6B28";

        String actual = toRle(input);

        Assertions.assertEquals(expected, actual);
    }
}
