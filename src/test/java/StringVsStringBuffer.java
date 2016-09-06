import org.junit.Test;

public class StringVsStringBuffer {

	@Test
	public void testWithStringBuffer() {
		StringBuffer s3 = new StringBuffer("Value1");
		String s2 = "Value2";
		for (int i = 0; i < 100000; ++i) {
			s3.append(s2);
		}
		System.out.println(s3);
	}

	@Test
	public void testWithString() {
		String s3 = "Value1";
		String s2 = "Value2";
		for (int i = 0; i < 100000; ++i) {
			s3 = s3 + s2;
		}
		System.out.println(s3);
	}

}
