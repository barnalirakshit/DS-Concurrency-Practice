package practice.example.deadlock;

import java.lang.management.ManagementFactory;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.management.ThreadMXBean;

public class DeadLockDetector {

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	public void processForThread1() {
		lock1.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		lock2.lock();
		lock2.unlock();
		lock1.unlock();
	}

	public void processForThread2() {
		lock2.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		lock1.lock();
		lock1.unlock();
		lock2.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		DeadLockDetector deadLockDetector = new DeadLockDetector();
		new Thread(deadLockDetector::processForThread1).start();
		new Thread(deadLockDetector::processForThread2).start();
		Thread.sleep(1000);
		ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
		long ids[] = threadMXBean.findDeadlockedThreads();
		boolean deadLock = ids != null && ids.length > 0;
		System.out.println("DeadLock Found:" + deadLock);
		if (deadLock) {
			Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
			for (long id : ids) {
				for (Thread t : threads.keySet()) {
					if (t.getId() == id) {
						System.out.println("Stopping thread:" + t.getName() + "-" + id);
						t.stop();
					}

				}
			}
		}

	}

}
