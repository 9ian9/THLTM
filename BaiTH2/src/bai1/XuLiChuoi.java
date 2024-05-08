package bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XuLiChuoi {

	public static String Uppercase(String str) {
		char[] new_str = str.toCharArray();
		for (int i = 0; i < new_str.length; i++) {
			if (97 <= new_str[i] && new_str[i] <= 122) {
				new_str[i] = (char) (new_str[i] - 32);
			} else {
				new_str[i] = new_str[i];

			}
		}
		return String.valueOf(new_str);
	}

	public static String Lowercase(String str) {
		char[] new_str = str.toCharArray();
		for (int i = 0; i < new_str.length; i++) {
			if (65 <= new_str[i] && new_str[i] <= 90) {
				new_str[i] = (char) (new_str[i] + 32);
			} else {
				new_str[i] = new_str[i];

			}
		}
		return String.valueOf(new_str);
	}

	public static String Reverse(String number) {
		String new_number = "";
		for (int i = number.length() - 1; i >= 0; i--) {
			new_number += number.charAt(i);

		}
		return new_number;
	}

	public static String UpperLowercase(String str) {
		char[] new_str = str.toCharArray();
		for (int i = 0; i < new_str.length; i++) {
			if (97 <= new_str[i] && new_str[i] <= 122) {
				new_str[i] = (char) (new_str[i] - 32);
			} else if (65 <= new_str[i] && new_str[i] <= 90) {
				new_str[i] = (char) (new_str[i] + 32);

			} else {
				new_str[i] = new_str[i];
			}
		}
		return String.valueOf(new_str);
	}

	public static String DemNguyenAm(String str) {
		int[] a = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'u') {
				a[0] += 1;
			}
			if (str.charAt(i) == 'e') {
				a[1] += 1;
			}
			if (str.charAt(i) == 'o') {
				a[2] += 1;
			}
			if (str.charAt(i) == 'a') {
				a[3] += 1;
			}
			if (str.charAt(i) == 'i') {
				a[4] += 1;
			}
		}

		return "So lan xuat hien cua u:" + a[0] + "\n" + "So lan xuat hien cua e:" + a[1] + "\n"
				+ "So lan xuat hien cua o:" + a[2] + "\n" + "So lan xuat hien cua a:" + a[3] + "\n"
				+ "So lan xuat hien cua i:" + a[4] + "\n";
	}

	public static String XuLiChuoi(String content) {

		return ("Chuoi Nguoc:  " + XuLiChuoi.Reverse(content) + "\n" + "Chuoi khong in hoa:  " + XuLiChuoi.Lowercase(content)
				+ "\n" + "Chuoi in hoa:  " + XuLiChuoi.Uppercase(content) + "\n" + "Chuoi vua hoa vua thuong:  "
				+ XuLiChuoi.UpperLowercase(content) + "\n" + "Dem nguyen am:  " + XuLiChuoi.DemNguyenAm(content) + "\n");
	}
}
