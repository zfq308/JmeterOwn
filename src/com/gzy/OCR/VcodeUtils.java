package com.gzy.OCR;

import org.testng.annotations.Test;

/**
 * 验证码正确性校验，分别校验纯数字、纯字母、以及数字+字母的准确性
 */
public class VcodeUtils {
	private final static String PATTERNINT = "0123456789";
	private final static String PATTERNAbc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String PATTERNAbcAndINT = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public VcodeUtils() {

	}

	@Test
	public void test() {
		String str = vcode("   1   a    3V  ", 3, 4);
		System.out.println("--->>" + str + "<<---");
	}

	public static String vcode(String vcode, int type, int len) {
		vcode = vcode.trim();
		vcode = vcode.replace(" ", "");
		char[] vcodeChar = vcode.toCharArray();
		if (vcodeChar.length != len) {
			vcode = "error";
			return vcode;
		}

		if (type == 1) {

			// 纯数字

			for (int i = 0; i < len; i++) {
				if (PATTERNINT.indexOf(vcode.toCharArray()[i]) < 0) {
					vcode = "error";
					return vcode;
				}
			}

		} else if (type == 2) {
			// 纯字母
			for (int i = 0; i < len; i++) {
				if (PATTERNAbc.indexOf(vcode.toCharArray()[i]) < 0) {
					vcode = "error";
					return vcode;
				}
			}

		} else {
			// 数字字母混合
			for (int i = 0; i < len; i++) {
				if (PATTERNAbcAndINT.indexOf(vcode.toCharArray()[i]) < 0) {
					vcode = "error";
					return vcode;
				}
			}

		}

		return vcode;

	}
}
