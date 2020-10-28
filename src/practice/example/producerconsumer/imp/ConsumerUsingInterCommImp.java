package practice.example.producerconsumer.imp;

import java.util.Queue;

import practice.example.producerconsumer.Consumer;

public class ConsumerUsingInterCommImp implements Consumer {

	private Queue<Integer> queue;

	public ConsumerUsingInterCommImp(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void consume() {
		synchronized (queue) 
		{
			try {
				if (queue.isEmpty())
					queue.wait();

				int value = queue.poll();
				System.out.println("Consuming value:" + value);
				queue.notify();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
