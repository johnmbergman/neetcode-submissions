class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        final StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        final List<String> result = new ArrayList<>();

        if (str.length() == 0) return result;

        int i = 0;
        while (i < str.length()) {
            // Get the length
            final int j = str.indexOf("#", i);
            final String lengthAsString = str.substring(i, j);
            final int length = Integer.parseInt(lengthAsString);
            final String val = str.substring(j+1, j+1+length);
            result.add(val);
            i = j+1+length;
        }

        return result;
    }
}
