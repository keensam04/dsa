package saman.problem.misc;

public class ExcelColumn {

    private static final int NUMBER_OF_ENGLISH_ALPHABETS = 26;
    private static final int ASCII_OFFSET_FOR_UPPER_CASE_ALPHABET = 64;

    /**
     * if columnNumber = 1, then columnName = A
     * if columnNumber = 2, then columnName = B
     * if columnNumber = 26, then columnName = Z
     * if columnNumber = 27, then columnName = AA
     * if columnNumber = 28, then columnName = AB
     * @param columnNumber column index
     * @return column name
     */
    public String getColumnName(long columnNumber) {
        String columnName = "";
        long number = columnNumber;
        while (number > 0) {
            long remainder = number % NUMBER_OF_ENGLISH_ALPHABETS;
            if (remainder == 0) {
                columnName = "Z".concat(columnName);
                number = number / NUMBER_OF_ENGLISH_ALPHABETS - 1;
            } else {
                columnName = String.valueOf((char)((byte)'A' + (remainder - 1))).concat(columnName);
                number = number / NUMBER_OF_ENGLISH_ALPHABETS;
            }
        }
        return columnName;
    }

    /**
     * if columnNumber = A, then columnName = 1
     * if columnNumber = B, then columnName = 2
     * if columnNumber = Z, then columnName = 26
     * if columnNumber = AA, then columnName = 27
     * if columnNumber = AB, then columnName = 28
     * @param columnName column name
     * @return column index
     */
    public long getColumnNumber(String columnName) {
        long columnNumber = 0;
        int exponent = columnName.length() - 1;
        for (int i = 0; i < columnName.length(); i++) {
            columnNumber = columnNumber + ((long)((byte)columnName.charAt(i) - ASCII_OFFSET_FOR_UPPER_CASE_ALPHABET) * Math.power(NUMBER_OF_ENGLISH_ALPHABETS, exponent--));
        }
        return columnNumber;
    }
}
