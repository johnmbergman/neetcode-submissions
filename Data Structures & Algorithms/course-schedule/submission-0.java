class Solution {
    public boolean canFinish(final int numCourses, final int[][] prerequisites) {

        // Build the requirements map
        final Map<Integer, List<Integer>> prereqs = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereqs.put(i, new ArrayList<>());
        }
        for (int[] req : prerequisites) {
            prereqs.get(req[0]).add(req[1]);
        }

        // Start a search from each course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, prereqs, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(
        final int course,
        final Map<Integer, List<Integer>> prereqs,
        final Set<Integer> visited
    ) {
        // Detect cycles
        if (visited.contains(course)) return false;

        // Allow if no prereqs
        if (prereqs.get(course).isEmpty()) return true;

        visited.add(course);
        for (final int prereq : prereqs.get(course)) {
            if (!dfs(prereq, prereqs, visited)) return false;
        }
        visited.remove(course);
        prereqs.put(course, new ArrayList<>());
        return true;
    }
}
