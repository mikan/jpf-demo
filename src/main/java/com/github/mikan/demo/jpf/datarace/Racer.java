/**
 * Copyright(C) 2016 mikan.
 * Licensed under WTFPL.
 */

package com.github.mikan.demo.jpf.datarace;

//@formatter:off

/**
 * データ競合を検出するデモです。
 * 
 * @author mikan
 */
public class Racer implements Runnable {

	int d = 42; // 特に深い意味はない初期値

	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer).start();
		doSomething(1000);					// (1) 1秒後に (2) を動かすぞ
		int c = 420 / racer.d;				// (2) 420 / 42 は 10、でも万が一 (4) 発動後なら・・・
		System.out.println(c);
	}

	public void run() {
		doSomething(1001);					// (3) 1.001秒後に (4) を動かすぞ
		d = 0;								// (4) フィールドを書き換える！
	}
	
	private static void doSomething(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}

//@formatter:on