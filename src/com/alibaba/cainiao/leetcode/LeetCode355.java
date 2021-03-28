package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 */
public class LeetCode355 {

    class Tweet {
        int userId;
        int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    List<Tweet> allTweets = new ArrayList<>(64);

    Map<Integer, List<Integer>> followMap = new HashMap<>(64);

    /** Initialize your data structure here. */
    public LeetCode355() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        allTweets.add(new Tweet(userId, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>(10);
        List<Integer> followedUserIds = followMap.get(userId);
        // 后顺遍历，表示最近的推文开始找
        int count = 0, idx = allTweets.size() - 1;
        while (count < 10 && idx >= 0) {
            Tweet lastTweet = allTweets.get(idx);
            if (followedUserIds.size() > 0 && (followedUserIds.contains(lastTweet.userId) || userId == lastTweet.userId)) {
                //不包含重复的
                if (!res.contains(lastTweet.userId)) {
                    res.add(lastTweet.tweetId);
                    count++;
                }
            }
            idx--;
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, p -> new ArrayList<>()).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followeeIds = followMap.get(followerId);
        //如果没有该用户的关注列表，直接返回
        if (followeeIds.size() == 0) {
            return;
        }

        //如果follower关注了这个followee,去解除
        if (followeeIds.contains(followeeId)) {
            followeeIds.remove(followeeId);
            if (followeeIds.size() == 0) {
                //如果把所有的都删除了, 把列表也干掉
                followMap.remove(followerId);
            }
        }
    }
}
