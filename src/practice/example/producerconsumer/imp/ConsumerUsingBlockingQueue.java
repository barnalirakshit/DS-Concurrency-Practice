package practice.example.producerconsumer.imp;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import practice.example.producerconsumer.Consumer;

public class ConsumerUsingBlockingQueue implements Consumer{
	
	private BlockingQueue<Integer> queue;
	
	public ConsumerUsingBlockingQueue(BlockingQueue queue)
	{
		this.queue=queue;
	}
	@Override
	public void consume() {
		int num = queue.poll();
		System.out.println("consuming:"+num);
		
	}

}
