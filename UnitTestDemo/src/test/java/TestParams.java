
import com.ntd.unittestdemo.DemoTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class TestParams {
    // Chạy trước tất cả các phương thức testcase
   @BeforeAll
   public static void testBefore() {
       System.out.println("BEFORE ALL");
   }
   // Chạy sau tất cả các phương thức testcase
   @AfterAll
   public static void testAfter() {
       System.out.println("AFTER ALL");
   }
   // Chạy trước mỗi phương thức testcase
   @BeforeEach
   public void testBeforeEach(){
       System.out.println("BEFORE EACH");
   }
   // Chạy sau mỗi 1 phương thức testcase
   @AfterEach
   public void testAfterEach() {
       System.out.println("AFTER EACH");
   }
   // Truyền mảng các đối số
   @ParameterizedTest
   @ValueSource(ints = {4, 6, 110, 250})
   public void testEven(int n) {
       Assertions.assertFalse(DemoTest.isNT(n));
   }
   // Nếu muốn cung cấp thêm 1 đầu ra khác so với mặc định
   @ParameterizedTest
   @CsvSource({"5, true", "7, true", "12, false", "4, false"})
   public void testEven(int n, boolean expected) {
       Assertions.assertEquals(expected, DemoTest.isNT(n));
   }
   // Nếu muốn đọc các đối số từ tập tin csv
   @ParameterizedTest
   @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
   public void testEven2(int n, boolean expected){
       Assertions.assertEquals(expected, DemoTest.isNT(n));
   }
   // Test bài Power đệ quy
   @ParameterizedTest
   @CsvFileSource(resources = "powers.csv", numLinesToSkip = 1)
   public void testPower(double x, int n, double expected){
       double actual = DemoTest.Power(x, n);
       Assertions.assertEquals(expected, actual);
   }
   
   
}
