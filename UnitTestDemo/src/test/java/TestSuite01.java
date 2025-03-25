
import com.ntd.unittestdemo.DemoTest;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class TestSuite01 {
    // Đặt tên theo quy ước test+mụctieutest
    // Vd: Test với số chẵn (even number)
    // Gắn annotation (chú thích) phụ thuộc từ gói jupiter để trở thành phương thức testcase
    @Test
    public void testEvenNumber() {
        int n = 2;
        // Đầu ra mong muốn
        boolean expectedOutput = true;
        boolean actualOutput = DemoTest.isNT(n);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testWrongEvenNumber() {
        int n = 4;
        Assertions.assertFalse(DemoTest.isNT(n));
//        boolean expectedOutput = false;
//        boolean actualOutput = DemoTest.isNT(n);
//        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testOddNumber() {
        int n = 11;
        Assertions.assertTrue(DemoTest.isNT(n));
    }
    @Test
    public void testException(){
        int n = -7;
        Assertions.assertThrows(ArithmeticException.class, () -> {
            DemoTest.isNT(n);
        });
    }
    @Test
    public void testTimeout() {
        int n = 117;
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            DemoTest.isNT(n);
        });
    }
}
