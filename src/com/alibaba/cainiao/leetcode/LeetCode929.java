package com.alibaba.cainiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 * Easy
 *
 *
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 *
 *
 * Example 1:
 *
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 *
 * Note:
 *
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 * All local and domain names are non-empty.
 * Local names do not start with a '+' character.
 */
public class LeetCode929 {

    public int numUniqueEmails(String[] emails) {
        int n = emails.length;
        if (n == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            String email = emails[i];
            String[] split = email.split("@");
            String localName = split[0];
            String domainName = split[1];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < localName.length(); j++) {
                if (localName.charAt(j) == '.') {
                    continue;
                }
                if (localName.charAt(j) == '+') {
                    break;
                }
                sb.append(localName.charAt(j));
            }
            sb.append("@").append(domainName);
            set.add(sb.toString());
        }

        return set.size();
    }

}
