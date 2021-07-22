package com.zw.algorithms.test4;

import com.zw.algorithms.bean.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 1;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public int cuttingRope1(int n) {
        if (n <= 3) return n - 1;
        long res = 1L;
        int p = (int) 1e9 + 7;
        //贪心算法，优先切三，其次切二
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int) (res * n % p);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public double myPow(double x, int n) {
        int k = n > 0 ? n : -1 * n;

        double ret = 1;
        for (int i = 0; i < k; i++) {
            ret *= x;
        }

        if (n < 0) {
            ret = 1.0d / ret;
        }
        return ret;
    }

    public double myPow1(double x, int n) {
        if (x == 0) return 0;

        long b = n;

        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }

    public static double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (x == 1)
            return 1;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double ret = 1.0d;
        while (n > 0) {
            if (n % 2 == 1) ret = ret * x;

            x = x * x;

            n = n / 2;
        }

        return ret;
    }

    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        Map<ListNode, ListNode> map = new HashMap();
        ListNode listNode = head;
        while (listNode != null) {
            map.put(listNode, new ListNode(listNode.val));
            head = head.next;
        }

        listNode = head;
        while (listNode != null) {
            ListNode temp = map.get(listNode);
            temp.next = listNode.next;
            temp.random = listNode.random;
        }

        return map.get(head);
    }

    public int countDigitOne(int n) {
        java.util.List<String> list = new ArrayList<String>();
        String s;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            s = "" + i;
            if (s.contains("1")) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '1') count++;
                }
            }
        }
        return count;

    }

    public int countDigitOne1(int n) {
        int res = 0;

        int digit = 1;

        int high = n / 10;
        int cur = n % 10;

        int low = 0;

        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int fast = 1;
        int slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int fast = 1;
        int slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(myPow2(2.0d, -2));
    }
}
