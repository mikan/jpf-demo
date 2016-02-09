/**
 * Copyright(C) 2016 mikan.
 * Licensed under WTFPL.
 */

package com.github.mikan.demo.jpf.deadlock;

import java.util.Random;

/**
 * デッドロックを検出デモです。
 * 
 * @author mikan
 */
public class DeadlockWithRandom {

	private static final Random random = new Random();
	private final Object resourceA = new Object(); // 資源A
	private final Object resourceB = new Object(); // 資源B

	public static void main(String[] args) {
		new DeadlockWithRandom().work();
	}

	private void work() {
		new Worker().start(); // 処理A
		new Worker().start(); // 処理B
	}

	private class Worker extends Thread {

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			while (!isInterrupted()) {
				Object first = random.nextBoolean() ? resourceA : resourceB;
				Object second = first == resourceA ? resourceB : resourceA;
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
