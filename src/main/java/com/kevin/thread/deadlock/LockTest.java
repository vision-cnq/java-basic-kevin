package com.kevin.thread.deadlock;

/**
 * @author caonanqing
 * @version 1.0
 * @description         死锁
 *
 *      当一个线程永远地持有一个锁，并且其他线程都尝试去获得这个锁时，那么它们将永远被阻塞，
 *      这个我们都知道。如果线程A持有锁L并且想获得锁M，线程B持有锁M并且想获得锁L，
 *      那么这两个线程将永远等待下去，这种情况就是最简单的死锁形式。
 *
 *      死锁是设计的BUG，问题比较隐晦。不过死锁造成的影响很少会立即显现出来，一个类可能发生死锁，
 *      并不意味着每次都会发生死锁，这只是表示有可能。当死锁出现时，往往是在最糟糕的情况----高负载的情况下。
 *
 *  避免死锁的方式：
 *      既然可能产生死锁，那么接下来，讲一下如何避免死锁。
 *      1、让程序每次至多只能获得一个锁。当然，在多线程环境下，这种情况通常并不现实
 *      2、设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量
 *      3、既然死锁的产生是两个线程无限等待对方持有的锁，那么只要等待时间有个上限不就好了。
 *          当然synchronized不具备这个功能，但是我们可以使用Lock类中的tryLock方法去尝试获取锁，
 *          这个方法可以指定一个超时时限，在等待超过该时限之后变回返回一个失败信息
 *
 * @createDate 2019/5/31
 */
public class LockTest {

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        Thread0 t0 = new Thread0(dl);
        Thread1 t1 = new Thread1(dl);
        t0.start();
        t1.start();
        while (true);
    }
}
