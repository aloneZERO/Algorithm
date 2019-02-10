package other.test;

import org.junit.Test;
import other.Huffman;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HuffmanTest {

    @Test
    public void encode() {

        Huffman huffman = new Huffman();
        Map<Character, Integer> frequencyForChar = new HashMap<>();

        frequencyForChar.put('a', 10);
        frequencyForChar.put('b', 20);
        frequencyForChar.put('c', 40);
        frequencyForChar.put('d', 80);

        Map<Character, String> result = huffman.encode(frequencyForChar);
        Map<Character, String> expectEncoding = new HashMap<>();

        expectEncoding.put('a', "000");
        expectEncoding.put('b', "001");
        expectEncoding.put('c', "01");
        expectEncoding.put('d', "1");

        for (Character character : result.keySet()) {
            assertEquals(result.get(character),
                    expectEncoding.get(character));
        }
    }
}