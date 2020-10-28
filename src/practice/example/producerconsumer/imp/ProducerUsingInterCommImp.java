package practice.example.producerconsumer.imp;

import java.util.Queue;
import java.util.Random;

import practice.example.producerconsumer.Producer;

public class ProducerUsingInterCommImp implements Producer {

	private Queue<Integer> queue;
	private final int queueSize;
	private Random random = new Random();

	public ProducerUsingInterCommImp(Queue<Integer> queue, final int queueSize) {
		this.queue = queue;
		this.queueSize = queueSize;
	}

	@Override
	public void produce() {
		synchronized (queue) 
		{
			try {
				if (queue.size() == queueSize)
					queue.wait();
				int value = random.nextInt();
				System.out.println("Producing value:" + value);
				queue.add(value);
				queue.notify();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

}
