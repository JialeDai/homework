package com.techbow.homework.y2022.m01.jiale.leetcode.marketaxess.threadrelated;

import sun.security.krb5.internal.Ticket;

public class TicketThread extends Thread {
    private static int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票" + (this.ticket--));
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        new Thread(t1).start();
        new Thread(t2).start();
    }
    /**
     * 只能通过创建一个TicketThread 来共享变量
     * Thread-2卖票10
     * Thread-3卖票10
     * Thread-3卖票9
     * Thread-3卖票8
     * Thread-3卖票7
     * Thread-3卖票6
     * Thread-3卖票5
     * Thread-3卖票4
     * Thread-3卖票3
     * Thread-3卖票2
     * Thread-3卖票1
     * Thread-2卖票9
     * Thread-2卖票8
     * Thread-2卖票7
     * Thread-2卖票6
     * Thread-2卖票5
     * Thread-2卖票4
     * Thread-2卖票3
     * Thread-2卖票2
     * Thread-2卖票1
     */
}
