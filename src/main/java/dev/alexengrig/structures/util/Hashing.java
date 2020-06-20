package dev.alexengrig.structures.util;

public final class Hashing {
    private Hashing() {
    }

    public static int hashCode(boolean value) {
        return value ? 0 : 1;
    }

    public static int hashCode(byte value) {
        return value;
    }

    public static int hashCode(char value) {
        return value;
    }

    public static int hashCode(short value) {
        return value;
    }

    public static int hashCode(int value) {
        return value;
    }

    public static int hashCode(long value) {
        return (int) (value ^ value >>> 32);
    }

    public static int hashCode(float value) {
        return Float.floatToIntBits(value);
    }

    public static int hashCode(double value) {
        return hashCode(Double.doubleToLongBits(value));
    }

    public static int hashCode(Object object) {
        return object == null ? 0 : object.hashCode();
    }

    public static int hashCode(Object... objects) {
        return hashCode(13, objects);
    }

    public static int hashCode(int initialResult, Object... objects) {
        int result = initialResult;
        for (Object object : objects) {
            result = 31 * result + hashCode(object);
        }
        return result;
    }
}
