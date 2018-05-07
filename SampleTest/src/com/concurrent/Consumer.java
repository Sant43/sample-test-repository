package com.concurrent;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	BlockingQueue<Integer> queue = null; 
			
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<10 ;i++) {
			consume();
		}
	}
	
	public void consume() {
		System.out.println("In Consumer");
		if(queue.isEmpty()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(queue.poll());
		System.out.println("Out of Consumer");
	}
}
