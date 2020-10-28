package practice.example.producerconsumer.imp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import practice.example.producerconsumer.Consumer;
import practice.example.producerconsumer.ProduceConsumerInf;
import practice.example.producerconsumer.Producer;

public class ProducerConsumerInterCommImp implements ProduceConsumerInf {

	private Queue<Integer> queue;
	ExecutorService executor;
	//Thread producerThread;
	//Thread consumerThread;
	@Override
	public void start() {
		queue = new LinkedList<>();
		Runnable producerRunnable = new Runnable() {

			@Override
			public void run() {

				Producer producer = new ProducerUsingInterCommImp(queue, 5);
				while (true) {
					System.out.println("producer");
					producer.produce();
				}
			}
		};
		
		Runnable consumerRunnable = new Runnable() {

			@Override
			public void run() {

				Consumer consumer = new ConsumerUsingInterCommImp(queue);
				while (true) {
					System.out.println("consumer");
					consumer.consume();
				}
			}
		};
		executor = Executors.newCachedThreadPool();
		executor.submit(producerRunnable);
		executor.submit(consumerRunnable);
		
		/*Thread producerThread = new Thread(producerRunnable);
		Thread consumerThread = new Thread(consumerRunnable);
		producerThread.start();
		consumerThread.start();*/
		
	}

	@Override
	public void stop() {
		executor.shutdown();
		//producerThread.stop();;
		//consumerThread.stop();;

	}

}
