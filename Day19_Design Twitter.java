class Twitter {

    private Map<Integer,User> users;
    private List<Integer> tweets;
    private Map<Integer,Integer> tweetMapping;
    private int defaultFeedCount;
    
    private class User{
        int userId;
        List<Integer> followees;
        User(int userId) {
            this.userId=userId;
            followees=new ArrayList<>();
        }
    }
    
    public Twitter() {
        users=new HashMap<>();
        tweets=new ArrayList<>();
        tweetMapping=new HashMap<>();
        defaultFeedCount=10;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) {
            User nu=new User(userId);
            users.put(userId,nu);
        }
        tweets.add(tweetId);
        tweetMapping.put(tweetId,userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        while(feed.size()!=defaultFeedCount) {
            int idx=tweets.size()-1;
            while(idx>=0) {
                int tweet=tweets.get(idx);
                User cur=users.get(userId);
                if(tweetMapping.get(tweet)==cur.userId) {
                    feed.add(tweet);
                }else {
                    for(int f:cur.followees) {
                        if(tweetMapping.get(tweet)==f)
                            feed.add(tweet);
                    }
                }
                if(feed.size()==defaultFeedCount)
                    return feed;
                idx--;
            }
            if(idx<0)
                break;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
            User nu=new User(followerId);
            nu.followees.add(followeeId);
            users.put(followerId,nu);
        }else {
            User get=users.get(followerId);
            if(!get.followees.contains(followeeId))
                get.followees.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        User get=users.get(followerId);
        get.followees.remove((Integer)followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */