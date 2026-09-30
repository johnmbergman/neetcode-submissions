class TimeMap {

    private final Map<String, List<TimedValuePair>> data = new HashMap<>();

    public TimeMap() {
        // no-op
    }
    
    public void set(final String key, final String value, final int timestamp) {
        data.computeIfAbsent(key, k -> new ArrayList<>());
        data.get(key).add(new TimedValuePair(timestamp, value));
    }
    
    public String get(final String key, final int timestamp) {
        if (!data.containsKey(key)) return "";
        final List<TimedValuePair> values = data.get(key);

        String result = "";
        int left = 0;
        int right = values.size() - 1;

        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final TimedValuePair pivot = values.get(mid);
            if (pivot.timestamp == timestamp) return pivot.value;

            if (pivot.timestamp <= timestamp) {
                result = pivot.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class TimedValuePair {
        private final int timestamp;
        private final String value;

        public TimedValuePair(final int timestamp, final String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
