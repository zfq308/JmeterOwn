package com.gzy.OCR;

import org.testng.annotations.Test;

/**
 * * @author author:gaozeya2@bluemoon.com.cn
 * 
 * @date date£º2017Äê3ÔÂ31ÈÕ ÉÏÎç9:29:03
 * @version 1.0 * @parameter * @since * @return
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

			// ´¿Êı×Ö

			for (int i = 0; i < len; i++) {
				if (PATTERNINT.indexOf(vcode.toCharArray()[i]) < 0) {
					vcode = "error";
					return vcode;
				}
			}

		} else if (type == 2) {
			// ´¿×ÖÄ¸
			for (int i = 0; i < len; i++) {
				if (PATTERNAbc.indexOf(vcode.toCharArray()[i]) < 0) {
					vcode = "error";
					return vcode;
				}
			}
			
		} else {
			// Êı×Ö×ÖÄ¸»ìºÏ
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
