class Solution {

    public String encode(List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (final String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(final String str) {
        final List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            final int j = str.indexOf('#', i);
            final String numberAsString = str.substring(i, j);
            final int len = Integer.parseInt(numberAsString);
            i++; // Ignore the '#'
            final String val = str.substring(j+1, j+len+1);
            result.add(val);
            i = j+len+1;
        }
        return result;
    }
}
