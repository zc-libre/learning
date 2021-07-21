package com.libre.redisson.controller;

import com.libre.core.result.R;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ZC
 * @date 2021/7/19 15:40
 */
@RestController
public class RedissonController {

    private final RedissonClient redissonClient;

    public RedissonController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @GetMapping("/lock")
    public R lock() {
        RLock lock = redissonClient.getLock("lock");
        lock.lock();
        try {
            System.out.println("获取分布式锁成功！");
            TimeUnit.SECONDS.sleep(30);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("释放锁成功！");
        }
        return R.status(true);
    }

    @GetMapping("/write")
    public R writeLock() {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("rw-lock");
        RLock rLock = readWriteLock.writeLock();
        rLock.lock();
        try {
            System.out.println("获取写锁成功！" + Thread.currentThread().getId());
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放写锁");
            rLock.unlock();
        }
        return R.status(true);
    }

    @GetMapping("/read")
    public R readLock() {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("rw-lock");
        RLock rLock = readWriteLock.readLock();
        rLock.lock();
        try {
            System.out.println("获取读锁成功！" + Thread.currentThread().getId());
            TimeUnit.SECONDS.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("释放读锁");
            rLock.unlock();
        }
        return R.status(true);
    }

}
