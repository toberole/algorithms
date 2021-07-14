package com.zw.algorithms.test3;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || board[i][j] != word[k])
            return false;

        if (k == word.length - 1) return true;

        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i, j - 1, k + 1);

        board[i][j] = word[k];

        return res;
    }

    public boolean exist1(char[][] board, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

            }
        }
        return false;
    }

    public boolean dfs1(char[][] board, char[] word, int i, int j, int k) {
        if (i > board.length || i < 0 || j > board[0].length || j < 0 || word[k] != board[i][j])
            return false;

        if (k == word.length - 1) return true;

        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 100, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("beforeExecute ......");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("afterExecute ......");
            }

            @Override
            protected void terminated() {
                super.terminated();
            }
        };

        for (int i = 0; i < 10; i++) {
            int k = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(k);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
        Thread.sleep(1000 * 10);

        System.out.println("end ......");
    }

}