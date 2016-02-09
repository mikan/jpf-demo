/**
 * Copyright(C) 2016 mikan.
 * Licensed under WTFPL.
 */

package com.github.mikan.demo.jpf.deadlock;

/**
 * デッドロックを検出デモです。
 * 
 * @author mikan
 */
public class Deadlock {

	private final Object resourceA = new Object(); // 資源A
	private final Object resourceB = new Object(); // 資源B

	public static void main(String[] args) {
		new Deadlock().work();
	}

	private void work() {
		new Worker(resourceA, resourceB).start(); // 処理A
		new Worker(resourceB, resourceA).start(); // 処理B
	}

	private class Worker extends Thread {
		
		private final Object first;
		private final Object second;
		
		Worker(Object first, Object second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			while (!isInterrupted()) {
				synchronized (first) {
					System.out.println("[" + name + "]第一資源もぐもぐ");
					synchronized (second) {
						System.out.println("[" + name + "]第二資源もぐもぐ");
					}
					System.out.println("[" + name + "]第二資源ポイッ");
				}
				System.out.println("[" + name + "]第一資源ポイッ");
			}
		}
	}
}
