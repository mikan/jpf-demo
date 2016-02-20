/**
 * Copyright(C) 2016 mikan.
 * Licensed under WTFPL.
 */

package com.github.mikan.demo.jpf.random;

import java.util.Random;

/**
 * ランダムがあるプログラムを入力するデモです。
 * <p>
 * {@code cg.enumerate_random=true} を有効にすることで、JPF がランダムをコントロールしながら全てのパスに到達できます。
 * </p>
 * 
 * @author mikan
 */
public class Randomize {
	
	public static void main(String[] args) {
		
		Random random = new Random(42); // Random を作った

		int a = random.nextInt(2); // 1回目
		System.out.println("a=" + a);

		doSomething(1); // なんか処理をしたとする (特に意味はない)

		int b = random.nextInt(3); // 2回目
		System.out.println("  b=" + b);
		
		int c = a / (b + a - 2);
		System.out.println("    c=" + c);
	}

	private static void doSomething(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
