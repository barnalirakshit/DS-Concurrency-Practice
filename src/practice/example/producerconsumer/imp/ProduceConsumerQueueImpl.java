package practice.example.producerconsumer.imp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import practice.example.producerconsumer.Consumer;
import practice.example.producerconsumer.ProduceConsumerInf;
import practice.example.producerconsumer.Producer;

public class ProduceConsumerQueueImpl implements ProduceConsumerInf {
	private BlockingQueue<Integer> queue;
	ExecutorService executor;

	@Override
	public void start() {
		queue = new ArrayBlockingQueue<>(5);
		executor = Executors.newCachedThreadPool();
		executor.submit(new Runnable() {

			@Override
			public void run() {

				Producer producer = new ProducerUsingBlockingQueue(queue);
				while (true) {
					producer.produce();
				}
			}
		});
		executor.submit(new Runnable() {

			@Override
			public void run() {

				Consumer consumer = new ConsumerUsingBlockingQueue(queue);
				while (true) {
					consumer.consume();
				}
			}
		});
		

	}

	@Override
	public void stop() {
		executor.shutdown();

	}

}
