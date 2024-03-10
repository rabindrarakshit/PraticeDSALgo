package com.algorithm.practice.heap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map;

// Ref: https://leetcode.com/problems/design-twitter/description/

public class Twitter {
    Map<Integer, User> users;
    private static int timeStamp = 0;

    class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    class Tweet {
        int id;
        Tweet next;
        int time;

        public Tweet(int id) {
            this.id = id;
            next = null;
            time = timeStamp++;
        }
    }

    public Twitter() {
        users = new HashMap<Integer, User>();
    }


    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            User user = new User(userId);
            users.put(userId, user);
        }
        users.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        if (!users.containsKey(userId)) {
            return tweets;
        }
        Set<Integer> followedUsers = users.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.time, t1.time));
        for (int user : followedUsers) {
            Tweet t = users.get(user).tweetHead;
            if (t != null) {
                pq.add(t);
            }
        }
        int n = 0;
        while (!pq.isEmpty() || n < 10) {
            Tweet t = pq.poll();
            tweets.add(t.id);
            n++;
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            User user = new User(followerId);
            users.put(followerId, user);
        }
        if (!users.containsKey(followeeId)) {
            User user = new User(followeeId);
            users.put(followeeId, user);
        }
        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).unfollow(followeeId);
        }
    }
}

class TestTwitter{
    public static void main(String[] args) {
        Twitter t = new Twitter();

    }
}
