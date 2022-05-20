package ykvlv.lab3.util;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AreaCheckUtilTest {
    boolean checkTriangle(float x, float y, float r) {
        return AreaCheckUtil.isTriangle(x, y, r);
    }

    boolean checkRect(float x, float y, float r) {
        return AreaCheckUtil.isRect(x, y, r);
    }

    boolean checkCircle(float x, float y, float r) {
        return AreaCheckUtil.isCircle(x, y, r);
    }

    @Test
    void checkTriangleBorder() {

        int radius = 3;
        assertTrue(checkTriangle(0, 0, radius));
        assertFalse(checkTriangle(0, 0.001f, radius));
        assertFalse(checkTriangle(-0.001f, 0, radius));
        assertTrue(checkTriangle(0.001f, 0, radius));
        assertTrue(checkTriangle(0, -0.001f, radius));

        assertTrue(checkTriangle(1.5f, 0, radius));
        assertFalse(checkTriangle(1.5f, 0.001f, radius));
        assertFalse(checkTriangle(1.501f, 0, radius));
        assertTrue(checkTriangle(1.499f, 0, radius));


        assertTrue(checkTriangle(0, -1, radius));
        assertFalse(checkTriangle(-0.001f, -1, radius));
        assertTrue(checkTriangle(0.001f, -1, radius));

        assertTrue(checkTriangle(1, -1, radius));
        assertFalse(checkTriangle(1.001f, -1, radius));
        assertFalse(checkTriangle(1, -1.001f, radius));
        assertTrue(checkTriangle(0.999f, -1, radius));
        assertTrue(checkTriangle(1, -0.999f, radius));

        assertTrue(checkTriangle(0, -3, radius));
        assertFalse(checkTriangle(0, -3.001f, radius));
        assertFalse(checkTriangle(-0.001f, -3, radius));
        assertFalse(checkTriangle(0.001f, -3, radius));
    }

    @Test
    void checkRectBorder() {

        float radius = 3;
        assertTrue(checkRect(0, 0, radius));
        assertFalse(checkRect(0.001f, 0, radius));
        assertFalse(checkRect(0, -0.001f, radius));
        assertTrue(checkRect(-0.001f, 0, radius));
        assertTrue(checkRect(0, 0.001f, radius));

        assertTrue(checkRect(0, 1.5f, radius));
        assertFalse(checkRect(0.001f, 1.5f, radius));
        assertTrue(checkRect(-0.001f, 1.5f, radius));
        assertTrue(checkRect(0, 1.501f, radius));

        assertTrue(checkRect(0, 3, radius));
        assertFalse(checkRect(0, 3.001f, radius));
        assertFalse(checkRect(0.001f, 3, radius));
        assertTrue(checkRect(-0.001f, 3, radius));
        assertTrue(checkRect(0, 2.999f, radius));

        assertTrue(checkRect(-1.5f, 3, radius));
        assertFalse(checkRect(-1.5f, 3.001f, radius));
        assertFalse(checkRect(-1.501f, 3f, radius));
        assertTrue(checkRect(-1.499f, 3, radius));
        assertTrue(checkRect(-1.5f, 2.999f, radius));

        assertTrue(checkRect(-1.5f, 1.5f, radius));
        assertFalse(checkRect(-1.501f, 1.5f, radius));
        assertTrue(checkRect(-1.499f, 1.5f, radius));
        assertTrue(checkRect(-1.5f, 1.501f, radius));
        assertTrue(checkRect(-1.5f, 1.499f, radius));

        assertTrue(checkRect(-1.5f, 0, radius));
        assertFalse(checkRect(-1.501f, 0, radius));
        assertFalse(checkRect(-1.5f, -0.001f, radius));
        assertTrue(checkRect(-1.5f, 0.001f, radius));
        assertTrue(checkRect(-1.499f, 0, radius));
    }

    @Test
    void checkCircleBorder() {
        float radius = 3;
        assertTrue(checkCircle(0, 0, radius));
        assertFalse(checkCircle(0.001f, 0, radius));
        assertFalse(checkCircle(0, 0.001f, radius));
        assertTrue(checkCircle(0, -0.001f, radius));
        assertTrue(checkCircle(-0.001f, 0, radius));

        assertTrue(checkCircle(0, -1.5f, radius));
        assertFalse(checkCircle(0.001f, -1.5f, radius));
        assertTrue(checkCircle(-0.001f, -1.5f, radius));

        assertTrue(checkCircle(0, -3, radius));
        assertFalse(checkCircle(0.001f, -3, radius));
        assertFalse(checkCircle(0, -3.001f, radius));
        assertFalse(checkCircle(-0.001f, -3, radius));
        assertTrue(checkCircle(0, -2.999f, radius));

        assertTrue(checkCircle(-1.5f, 0, radius));
        assertFalse(checkCircle(-1.5f, 0.001f, radius));
        assertTrue(checkCircle(-1.499f, 0, radius));

        assertTrue(checkCircle(-3, 0, radius));
        assertFalse(checkCircle(-3.001f, 0, radius));
        assertFalse(checkCircle(-3, 0.001f, radius));
        assertFalse(checkCircle(-3, -0.001f, radius));

        assertTrue(checkCircle((float) (-1.5 * Math.sqrt(2)), (float) (-1.5 * Math.sqrt(2)), radius));
        assertFalse(checkCircle((float) (-1.5 * Math.sqrt(2)) - 0.001f, (float) (-1.5 * Math.sqrt(2)), radius));
        assertFalse(checkCircle((float) (-1.5 * Math.sqrt(2)), (float) (-1.5 * Math.sqrt(2)) - 0.001f , radius));
        assertTrue(checkCircle((float) (-1.5 * Math.sqrt(2)) + 0.001f, (float) (-1.5 * Math.sqrt(2)), radius));
        assertTrue(checkCircle((float) (-1.5 * Math.sqrt(2)), (float) (-1.5 * Math.sqrt(2)) + 0.001f, radius));
    }

    @Test
    void checkTriangleIn() {
        float radius = 3;

        assertTrue(checkTriangle(0.75f, -0.75f, radius));
        assertTrue(checkTriangle(0.5f, -0.75f, radius));
    }

    @Test
    void checkRectIn() {
        float radius = 3;

        assertTrue(checkRect(-0.75f, 1.5f, radius));
        assertTrue(checkRect(-0.75f, 2, radius));
        assertTrue(checkRect(-0.75f, 1, radius));
    }

    @Test
    void checkCircleIn() {
        float radius = 3;
        assertTrue(checkCircle(-2, -1, radius));
        assertTrue(checkCircle(-1, -2, radius));
    }

    @Test
    void checkTriangleOut() {
        float radius = 3;

        assertFalse(checkTriangle(1.5f, -2, radius));
        assertFalse(checkTriangle(2, -1, radius));
    }

    @Test
    void checkRectOut() {
        float radius = 3;

        assertFalse(checkCircle(1, 1, radius));
        assertFalse(checkCircle(1, 2, radius));
        assertFalse(checkCircle(-1, 4, radius));
        assertFalse(checkCircle(-2, 1, radius));

    }

    @Test
    void checkCircleOut() {
        float radius = 3;

        assertFalse(checkCircle(-3, -3, radius));
        assertFalse(checkCircle(-3, -1, radius));
        assertFalse(checkCircle(-1, -3, radius));
    }
}