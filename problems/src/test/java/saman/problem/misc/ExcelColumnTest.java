package saman.problem.misc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelColumnTest {

    private final ExcelColumn excel = new ExcelColumn();

    @Test
    public void testGetColumnName() {
        assertEquals("A", excel.getColumnName(1));
        assertEquals("B", excel.getColumnName(2));
        assertEquals("Z", excel.getColumnName(26));
        assertEquals("AA", excel.getColumnName(27));
    }

    @Test
    public void testGetColumnNumber() {
        assertEquals(1, excel.getColumnNumber("A"));
        assertEquals(2, excel.getColumnNumber("B"));
        assertEquals(26, excel.getColumnNumber("Z"));
        assertEquals(27, excel.getColumnNumber("AA"));
    }

    @Test
    public void testIntegrity() {
        assertEquals(Long.MAX_VALUE, excel.getColumnNumber(excel.getColumnName(Long.MAX_VALUE)));
        assertEquals("CRPXNLSKVLJFHG", excel.getColumnName(excel.getColumnNumber("CRPXNLSKVLJFHG")));
    }

}
