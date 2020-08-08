package com.zw.algorithms.test1;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * <p>
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * <p>
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * <p>
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class Test13_X {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String str = "1";
        // 当n为2及以上时。因为下一个数列是对上面的解释。
        // 所以用三个变量:一个代表数量count ,一个代表前一个数字pre，一个代表后一个数字back
        for (int i = 2; i <= n; i++) {  //大循环，n==？就循环几次
            StringBuilder builder = new StringBuilder();
            int count = 1;
            char pre = str.charAt(0);//大循环下面pre作为首数字，因为必须从第一个开始往后循环嘛，不然就遗漏了
            for (int j = 1; j < str.length(); j++) {
                char back = str.charAt(j);//后一个数字
                if (back == pre) {//相等count+1
                    count++;
                } else {
                    builder.append(count).append(pre);
                    //不等则append几个pre
                    pre = back;
                    count = 1;//count重置
                }
            }
            // 这一步是因为上层循环结束点在n-1的地方停了。并没有把最后的back加入到builder里面。
            // 并且观察数字，最后一位永远是1.所以可以直接把1个1加入到builder中。
            builder.append(count).append(pre);

            //因为方法体的数据类型是Stirng所以必须转换成String型的数据才能返回。
            str = builder.toString();
        }
        return str;
    }

    public static String countAndSay1(int n) {
        String s = "";
        int p1 = 0;
        int cur = 1;
        if ( n == 1 )
            return "1";
        String str = countAndSay(n - 1);
        for ( cur = 1; cur < str.length(); cur++ ) {
            if ( str.charAt(p1) != str.charAt(cur) ) {
                int count = cur - p1;
                s = s + count + ""+str.charAt(p1);
                p1 = cur;
            }
        }
        if ( p1 != cur ){
            int count = cur - p1;
            s = s + count +""+ str.charAt(p1);
        }
        return s;
    }

}
