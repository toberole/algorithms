package com.zw.algorithms.jzoffer.q1;

/**
 * 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径
 * <p>
 * [
 * ["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]
 * ]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Test11_X {
    /**
     * 整体思路：
     * 1.遍历整个二维数组，以每个元素作为起点进行尝试。
     * 2.进入起点后，往上下左右四个方向前进，直到成功。[深度优先搜索]
     */

    //记录传入的board的边界值
    private static int maxi;
    private static int maxj;

    //临时数组，记录走过的路径
    private static int[][] tempArr;

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String word = "abcd";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        // 初始化边界值
        maxi = board.length - 1;
        maxj = board[0].length - 1;

        // word数组化
        char[] wordCharArr = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                tempArr = new int[board.length][board[0].length];
                if (dfs(board, i, j, wordCharArr, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, char[] word, int wordIndex) {
        // 如果走过的路径长度大于word的长度
        // 说明要走的都走完了，那么就成功了。
        if (wordIndex >= word.length) {
            return true;
        }

        //下表超出边界值 或 路径走过 或 值不匹配，那么失败。
        if (i < 0 || i > maxi ||
                j < 0 || j > maxj ||
                tempArr[i][j] == 1 ||
                board[i][j] != word[wordIndex]) {
            return false;
        }

        //占用路径
        tempArr[i][j] = 1;

        //往四个方向走，只要有一个方向成功了就行
        boolean res = dfs(board, i, j - 1, word, wordIndex + 1) ||
                dfs(board, i, j + 1, word, wordIndex + 1) ||
                dfs(board, i - 1, j, word, wordIndex + 1) ||
                dfs(board, i + 1, j, word, wordIndex + 1);

        //成功了那就成功了
        if (res) {
            return true;
        }

        //没成功就取消当前路径占用，然后返回false
        tempArr[i][j] = 0;
        return false;
    }
}
