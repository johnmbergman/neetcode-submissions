class Solution {
    private static final Character DELIMITER = '#';

    // ["neet", "code", "love", "you"]
    // "4#neet4#code4#love3#you"
    public String encode(final List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (String str : strs) {
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
            // Get next count (value from i inclusive to # exclusive)
            final int j = str.indexOf(DELIMITER, i);
            final String lengthAsString = str.substring(i, j);
            final int length = Integer.parseInt(lengthAsString);
            i = j + 1;
            final String word = str.substring(i, i + length);
            result.add(word);
            i += length;
        }
        return result;
    }
}
