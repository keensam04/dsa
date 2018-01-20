package saman.problem.strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testIsVowel() {
        assertTrue(StringUtils.isVowel('a'));
        assertTrue(StringUtils.isVowel('e'));
        assertTrue(StringUtils.isVowel('i'));
        assertTrue(StringUtils.isVowel('o'));
        assertTrue(StringUtils.isVowel('u'));

        assertFalse(StringUtils.isVowel('b'));
        assertFalse(StringUtils.isVowel('c'));
        assertFalse(StringUtils.isVowel('d'));
        assertFalse(StringUtils.isVowel('f'));
        assertFalse(StringUtils.isVowel('g'));
        assertFalse(StringUtils.isVowel('h'));
        assertFalse(StringUtils.isVowel('j'));
        assertFalse(StringUtils.isVowel('k'));
        assertFalse(StringUtils.isVowel('l'));
        assertFalse(StringUtils.isVowel('m'));
        assertFalse(StringUtils.isVowel('n'));
        assertFalse(StringUtils.isVowel('p'));
        assertFalse(StringUtils.isVowel('q'));
        assertFalse(StringUtils.isVowel('r'));
        assertFalse(StringUtils.isVowel('s'));
        assertFalse(StringUtils.isVowel('t'));
        assertFalse(StringUtils.isVowel('v'));
        assertFalse(StringUtils.isVowel('w'));
        assertFalse(StringUtils.isVowel('x'));
        assertFalse(StringUtils.isVowel('y'));
        assertFalse(StringUtils.isVowel('z'));

        assertTrue(StringUtils.isVowel('A'));
        assertTrue(StringUtils.isVowel('E'));
        assertTrue(StringUtils.isVowel('I'));
        assertTrue(StringUtils.isVowel('O'));
        assertTrue(StringUtils.isVowel('U'));

        assertFalse(StringUtils.isVowel('B'));
        assertFalse(StringUtils.isVowel('C'));
        assertFalse(StringUtils.isVowel('D'));
        assertFalse(StringUtils.isVowel('F'));
        assertFalse(StringUtils.isVowel('G'));
        assertFalse(StringUtils.isVowel('H'));
        assertFalse(StringUtils.isVowel('J'));
        assertFalse(StringUtils.isVowel('K'));
        assertFalse(StringUtils.isVowel('L'));
        assertFalse(StringUtils.isVowel('M'));
        assertFalse(StringUtils.isVowel('N'));
        assertFalse(StringUtils.isVowel('P'));
        assertFalse(StringUtils.isVowel('Q'));
        assertFalse(StringUtils.isVowel('R'));
        assertFalse(StringUtils.isVowel('S'));
        assertFalse(StringUtils.isVowel('T'));
        assertFalse(StringUtils.isVowel('V'));
        assertFalse(StringUtils.isVowel('W'));
        assertFalse(StringUtils.isVowel('X'));
        assertFalse(StringUtils.isVowel('Y'));
        assertFalse(StringUtils.isVowel('Z'));
    }

    @Test
    public void testIsConsonant() {
        assertFalse(StringUtils.isConsonant('a'));
        assertFalse(StringUtils.isConsonant('e'));
        assertFalse(StringUtils.isConsonant('i'));
        assertFalse(StringUtils.isConsonant('o'));
        assertFalse(StringUtils.isConsonant('u'));

        assertTrue(StringUtils.isConsonant('b'));
        assertTrue(StringUtils.isConsonant('c'));
        assertTrue(StringUtils.isConsonant('d'));
        assertTrue(StringUtils.isConsonant('f'));
        assertTrue(StringUtils.isConsonant('g'));
        assertTrue(StringUtils.isConsonant('h'));
        assertTrue(StringUtils.isConsonant('j'));
        assertTrue(StringUtils.isConsonant('k'));
        assertTrue(StringUtils.isConsonant('l'));
        assertTrue(StringUtils.isConsonant('m'));
        assertTrue(StringUtils.isConsonant('n'));
        assertTrue(StringUtils.isConsonant('p'));
        assertTrue(StringUtils.isConsonant('q'));
        assertTrue(StringUtils.isConsonant('r'));
        assertTrue(StringUtils.isConsonant('s'));
        assertTrue(StringUtils.isConsonant('t'));
        assertTrue(StringUtils.isConsonant('v'));
        assertTrue(StringUtils.isConsonant('w'));
        assertTrue(StringUtils.isConsonant('x'));
        assertTrue(StringUtils.isConsonant('y'));
        assertTrue(StringUtils.isConsonant('z'));

        assertFalse(StringUtils.isConsonant('A'));
        assertFalse(StringUtils.isConsonant('E'));
        assertFalse(StringUtils.isConsonant('I'));
        assertFalse(StringUtils.isConsonant('O'));
        assertFalse(StringUtils.isConsonant('U'));

        assertTrue(StringUtils.isConsonant('B'));
        assertTrue(StringUtils.isConsonant('C'));
        assertTrue(StringUtils.isConsonant('D'));
        assertTrue(StringUtils.isConsonant('F'));
        assertTrue(StringUtils.isConsonant('G'));
        assertTrue(StringUtils.isConsonant('H'));
        assertTrue(StringUtils.isConsonant('J'));
        assertTrue(StringUtils.isConsonant('K'));
        assertTrue(StringUtils.isConsonant('L'));
        assertTrue(StringUtils.isConsonant('M'));
        assertTrue(StringUtils.isConsonant('N'));
        assertTrue(StringUtils.isConsonant('P'));
        assertTrue(StringUtils.isConsonant('Q'));
        assertTrue(StringUtils.isConsonant('R'));
        assertTrue(StringUtils.isConsonant('S'));
        assertTrue(StringUtils.isConsonant('T'));
        assertTrue(StringUtils.isConsonant('V'));
        assertTrue(StringUtils.isConsonant('W'));
        assertTrue(StringUtils.isConsonant('X'));
        assertTrue(StringUtils.isConsonant('Y'));
        assertTrue(StringUtils.isConsonant('Z'));
    }

    @Test
    public void testIsDigit() {
        assertTrue(StringUtils.isDigit('0'));
        assertTrue(StringUtils.isDigit('1'));
        assertTrue(StringUtils.isDigit('2'));
        assertTrue(StringUtils.isDigit('3'));
        assertTrue(StringUtils.isDigit('4'));
        assertTrue(StringUtils.isDigit('5'));
        assertTrue(StringUtils.isDigit('6'));
        assertTrue(StringUtils.isDigit('7'));
        assertTrue(StringUtils.isDigit('8'));
        assertTrue(StringUtils.isDigit('9'));
    }

    @Test
    public void testRemoveVowels() {
        assertEquals("fdtqq", StringUtils.removeVowels("fdatuqiq"));
        assertEquals("fdtqq", StringUtils.removeVowels("fdauituqiq"));
    }

}
