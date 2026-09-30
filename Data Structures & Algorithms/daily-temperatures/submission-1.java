class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) return new int[0];

        final int[] result = new int[temperatures.length];

        final Deque<Record> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            final Record curr = new Record(i, temperatures[i]);
            while (!stack.isEmpty()) {
                final Record prev = stack.peek();
                if (prev.temperature < curr.temperature) {
                    stack.pop();
                    result[prev.index] = curr.index - prev.index;
                } else {
                    break;
                }
            }
            stack.push(curr);
        }
        return result;
    }

    private static class Record {
        final int index;
        final int temperature;
        private Record(final int index, final int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
        @Override
        public String toString() {
            return "(" + index + "," + temperature + ")";
        }
    }
}
