
dormant - not active for some time

tryLock() 
---------

Acquires the lock only if it is free at the time of invocation.
Acquires the lock if it is available and returns immediately with the value true. If the lock is not available 
then this method will return immediately with the value false.

tryLock(long time, TimeUnit unit)
---------------------------------

Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
If the lock is available this method returns immediately with the value true. If the lock is not available then the 
current thread becomes disabled for thread scheduling purposes and lies dormant until one of three things happens:
The lock is acquired by the current thread; or
Some other thread interrupts the current thread, and interruption of lock acquisition is supported; or
The specified waiting time elapses

lock()
------

Acquires the lock.
If the lock is not available then the current thread becomes disabled for thread scheduling purposes 
and lies dormant until the lock has been acquired.


unlock()
--------

Releases the lock.


analysis
----------

![img.png](img.png)

here you can see Thread-1 couldn't acquired the lock will try again later !!

because Thread 1 will wait for 1 second so he won't get the lock so he came in else block

because the reason is Thread 2 is taking 3 seconds to proceed the withdraw process.

here Thread 1 not get a chance to acquire a lock so he not perform withdrawn.

---------------------------------------
step processing...........

1. Thread2 come he run tryLock() he got the lock
2. so, Thread2 started processing for 3 seconds...
3. within that time Thread1 also came and trying to get lock, he wait for 1 sec but he didn't get the lock so he not run
4. so for Thread 1 got printed "Thread-1 couldn't acquired the lock will try again later !!"
5. and when Thread2 has been proceed for 3 seconds then balance got deducted.
6. and then Thread2 got completed.