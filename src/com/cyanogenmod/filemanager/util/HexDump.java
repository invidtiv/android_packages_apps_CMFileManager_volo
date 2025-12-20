package com.cyanogenmod.filemanager.util;

/** Simple replacement for android internal HexDump utility. */
public class HexDump {
    /** Convert entire byte array to hex string. */
    public static String toHexString(byte[] bytes) {
        return toHexString(bytes, 0, bytes.length);
    }

    /** Convert a range of a byte array to hex string. */
    public static String toHexString(byte[] bytes, int offset, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = offset; i < offset + length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }

    /** Convert an integer offset to an 8‑character hex string (like internal HexDump). */
    public static String toHexString(int value) {
        return String.format("%08x", value);
    }
}

