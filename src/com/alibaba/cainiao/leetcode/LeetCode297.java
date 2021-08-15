package com.alibaba.cainiao.leetcode;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class LeetCode297 {
    StringBuilder sbs;
    StringBuilder sbd;
    int u = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sbs = new StringBuilder();
        dfsS(root);
        return sbs.toString();
    }

    private void dfsS(TreeNode root) {
        if (root == null) {
            sbs.append("#,");
        } else {
            sbs.append(root.val).append(",");;
            dfsS(root.left);
            dfsS(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        sbd = new StringBuilder(data);
        return dfsD(sbd);
    }

    private TreeNode dfsD(StringBuilder sb) {
        if (sb.charAt(u) == '#') {
            u += 2;
            return null;
        } else {
            int k = u;
            while (sb.charAt(k) != ',') {
                k++;
            }
            TreeNode root = new TreeNode(Integer.parseInt(sb.substring(u, k)));
            //跳过,
            u = k + 1;
            root.left = dfsD(sb);
            root.right = dfsD(sb);
            return root;
        }
    }
}
