import com.minhdd.isograd.Utils;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class UtilsTest {
    @Test
    public void getFloatsArrayTest() {
        String line = "48.8580001 2.2910001 48.8800001 2.4040001";
        double[] expected = new double[]{48.8580001, 2.2910001, 48.8800001, 2.4040001};
        assertArrayEquals(expected, Utils.doubleArray(line, 4), 0.0000000001);
    }

    @Test
    public void intArrayTest() {
        String line = "3 4 5 5 6 3 2";
        int[] expected = new int[]{3, 4, 5, 5, 6, 3, 2};
        assertArrayEquals(expected, Utils.intArray(line));
    }
}
