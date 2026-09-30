class Solution {

    // ["neet", "code", "love", "you"]
    // "4#neet4#code4#love3#you"

    public String encode(final List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (final String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(final String str) {
        final List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            // Get the number leading up to the delimiter
            final int j = str.indexOf("#", i);
            final String numberAsString = str.substring(i, j);
            final Integer n = Integer.parseInt(numberAsString);

            // Read next n characters after delimiter
            result.add(str.substring(j+1, j+n+1));
            i = j + n + 1;
        }

        return result;
    }
}
