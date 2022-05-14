package ykvlv.lab3.util;

public class AreaCheckUtil {
    public static float left(float x){
        float hor = x + 3.5f;
        return hor / 7;
    }

    public static float top(float y){
        float ver = 3.5f - y;
        return ver / 7;
    }

    public static boolean isIn(float x, float y, float r) {
        return (isCircle(x, y, r) || isRect(x, y, r) || isTriangle(x, y, r));
    }

    public static boolean isTriangle(float x, float y, float r) {
        return (x >= 0 && y <= 0 && y - 2*x + r >= 0);
    }
    public static boolean isCircle(float x, float y, float r) {
        return (x <= 0 && y <= 0 && x * x + y * y <= r * r);
    }
    public static boolean isRect(float x, float y, float r) {
        return (x <= 0 && y >= 0 && x >= -1 * r / 2 && y <= r);
    }
}
