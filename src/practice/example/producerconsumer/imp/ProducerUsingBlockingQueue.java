package practice.example.producerconsumer.imp;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import practice.example.producerconsumer.Producer;

public class ProducerUsingBlockingQueue implements Producer {
	
	private BlockingQueue<Integer> queue;
	private Random random = new Random();
	public ProducerUsingBlockingQueue(BlockingQueue queue)
	{
		this.queue=queue;
	}
	@Override
	public void produce() {
		int num = random.nextInt();
		System.out.println("producing:"+num);
		queue.add(num);
	}

}
