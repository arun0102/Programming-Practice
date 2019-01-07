package arun.pkg.practice.fast_big_integer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;

public class FastBigInteger {
	public static void main(String[] args) {
		long oldTime = System.currentTimeMillis();
		System.out.println(getPower(2, 1111));
		System.out.println("MutableBigInteger time : " + (System.currentTimeMillis() - oldTime));
		oldTime = System.currentTimeMillis();
		System.out.println(new BigInteger("2").pow(1111));
		System.out.println("BigInteger time : " + (System.currentTimeMillis() - oldTime));
	}

	static String getPower(int base, int exponent) {
		if (0 == exponent) {
			return "1";
		} else if (1 == exponent) {
			return "" + base;
		}
		String val = "";
		try {
			Class<?> c = Class.forName("java.math.MutableBigInteger");
			Constructor<?> con = c.getDeclaredConstructor(int.class);
			con.setAccessible(true);
			Object i = con.newInstance(base);
			Method m = c.getDeclaredMethod("mul", new Class[] { int.class, c });
			m.setAccessible(true);
			for (int z = 1; z < exponent; ++z) {
				m.invoke(i, base, i);
			}

			String s = i.toString();
			int n = s.length();
			int lineWidth = 2000;
			for (int j = 0; j < n; j += lineWidth) {
				int j0 = j;
				int j1 = Math.min(s.length(), j + lineWidth);
				// System.out.println(s.substring(j0, j1));
				val = s.substring(j0, j1);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return val;
	}
}
