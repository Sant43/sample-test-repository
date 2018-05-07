package com.concurrent;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	BlockingQueue<Integer> queue = null;
	int i = 0;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
			
	@Override
	public void run() {
		for(int i = 0; i<10 ;i++) {
			produce();
		}
	}
	
	public void produce() {
		System.out.println("In Producer");
		queue.offer(++i);
		System.out.println("Out of Producer");
	}
}
