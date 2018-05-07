package com.concurrent;

import java.util.concurrent.Executors;

public class ThreadUsingExecutors {

	public static void main(String[] args) {
		/*Runnable r = new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (++i < 10) {
					System.out.println(i);
				}
			}
		};
		Executors.newSingleThreadExecutor().execute(r);
		*/

		Executors.newSingleThreadExecutor().execute(() -> {
			int i = 0;
			while (++i < 10) {
				System.out.println(i);
			}
		});

	}

}
