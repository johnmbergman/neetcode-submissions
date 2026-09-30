class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        final int[] result = new int[n];
        final Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            final int temperature = temperatures[i];

            while (!stack.isEmpty() && temperature > stack.peek().temperature) {
                final Pair past = stack.pop();
                result[past.index] = i - past.index;
            }

            stack.push(new Pair(i, temperature));

            /*for (int j = i + 1; j < n; j++) {
                final int futureTemperature = temperatures[j];
                final boolean futureIsWarmer = temperature < futureTemperature;
                if (futureIsWarmer) {
                    result[i] = j - i;
                    break;
                }
            }*/
        }

        return result;
    }

    private static class Pair {
        private final int index;
        private final int temperature;

        private Pair(final int index, final int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
    }
}
