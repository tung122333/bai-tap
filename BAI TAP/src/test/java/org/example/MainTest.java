package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testTinhDiemTongKet() {
        // Diem CC=8, GK=7, CK=9 -> 8*0.1 + 7*0.3 + 9*0.6 = 8.3
        double result = Main.tinhDiemTongKet(8, 7, 9);
        assertEquals(8.3, result, 0.001);
    }

    @Test
    public void testXepLoaiLoaiA() {
        assertEquals("A", Main.xepLoai(8.5));
        assertEquals("A", Main.xepLoai(9.0));
    }

    @Test
    public void testXepLoaiLoaiB() {
        assertEquals("B", Main.xepLoai(8.3));
        assertEquals("B", Main.xepLoai(7.0));
    }

    @Test
    public void testXepLoaiLoaiC() {
        assertEquals("C", Main.xepLoai(5.5));
        assertEquals("C", Main.xepLoai(6.8));
    }

    @Test
    public void testXepLoaiLoaiD() {
        assertEquals("D", Main.xepLoai(4.0));
        assertEquals("D", Main.xepLoai(5.0));
    }

    @Test
    public void testXepLoaiLoaiF() {
        assertEquals("F", Main.xepLoai(3.9));
        assertEquals("F", Main.xepLoai(0.0));
    }
}
