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
		long begin = System.currentTimeMillis();
		System.out.println("すぐに終わる処理をしています");
		long elapsed = System.currentTimeMillis() - begin;
		if (elapsed > 1000) {
			throw new RuntimeException("すげー時間かかった！ (" + elapsed + "ms)");
		}
		System.out.println("すぐ終わった (" + elapsed + "ms)");
	}
}
