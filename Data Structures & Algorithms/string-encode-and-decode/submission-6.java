class Solution {
    private static final String DELIMITER = ";";

    // ["hello", "world"]
    // "helloworld"
    // "5hello5world"
    // ["1", "2", "3"]
    // "111213"
    // "5;hello5;world
    public String encode(final List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (final String str : strs) {
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(final String str) {
        final List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Get the number
            final String numberAsString = str.substring(i, str.indexOf(DELIMITER, i));
            final int len = Integer.parseInt(numberAsString);
            i += numberAsString.length();
            i += DELIMITER.length();
            final String val = str.substring(i, i+len);
            i += val.length();
            result.add(val);
        }
        return result;
    }
}
