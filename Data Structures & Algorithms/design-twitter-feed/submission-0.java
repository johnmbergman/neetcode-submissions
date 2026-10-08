class Twitter {

    private static final int DEFAULT_NEWS_FEED_SIZE = 10;

    private int sequence = 0;
    private final Map<Integer, List<Tweet>> tweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> followers = new HashMap<>();
    
    public void postTweet(int userId, int tweetId) {
        tweets
            .computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new Tweet(tweetId, sequence--));
    }
    
    public List<Integer> getNewsFeed(final int userId) {
        final Queue<Tweet> minHeap = new PriorityQueue<>(Comparator.comparingInt(tweet -> tweet.sequence));
        followers.computeIfAbsent(userId, x -> new HashSet<>()).add(userId);

        for (final int followeeId : followers.get(userId)) {
            if (tweets.containsKey(followeeId)) {
                final List<Tweet> tweetsFromFollowee = tweets.get(followeeId);
                // Could be optimized to only store the latest until needed
                minHeap.addAll(tweetsFromFollowee);
            }
        }

        final List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty() && result.size() < DEFAULT_NEWS_FEED_SIZE) {
            final Tweet tweet = minHeap.poll();
            result.add(tweet.id);
        }
        return result;
    }
    
    public void follow(final int followerId, final int followeeId) {
        followers
            .computeIfAbsent(followerId, x -> new HashSet<>())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers
            .computeIfAbsent(followerId, x -> new HashSet<>())
            .remove(followeeId);
    }

    private static class Tweet {
        private final int id;
        private final int sequence;

        private Tweet(final int id, final int sequence) {
            this.id = id;
            this.sequence = sequence;
        }
    }
}
