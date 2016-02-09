/**
 * Copyright(C) 2016 mikan.
 * Licensed under WTFPL.
 */

package com.github.mikan.demo.jpf.exception;

/**
 * 再現率低い例外の可能性を発見するデモです。
 * 
 * @author mikan
 */
public class StopWatch {

	public static void main(String[] args) {
		long tBegin = System.currentTimeMillis();
		System.out.println("すぐに終わる処理をしています");
		long tEnd = System.currentTimeMillis();
		if (tEnd - tBegin > 10 * 10 * 10) {
			throw new RuntimeException("すげー時間かかった！");
		}
		System.out.println("すぐ終わった");
	}
}
