package com.lx.sachik;

import java.lang.Math;

public class Sachik {

	public double add(double a, double b) {
		System.out.println(a + " + " + b + " = " + Math.round(a + b) + "입니다.");
		return a + b;
	}

	public double sub(double a, double b) {
		System.out.println(a + " - " + b + " = " + Math.round(a - b) + "입니다.");
		return a - b;
	}

	public double mul(double a, double b) {
		System.out.println(a + " x " + b + " = " + Math.round(a * b) + "입니다.");
		return a * b;
	}

	public double div(double a, double b) {
		System.out.println(a + " / " + b + " = " + Math.round(a / b) + "입니다.");
		return a / b;
	}
}
