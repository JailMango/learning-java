package com.jailmango.exercise.utils.security;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * E7TTE4NEVZEVX6OL
 *
 * @author jailmango
 * @CreateDate 2020/3/11
 * @see com.jailmango.exercise.utils.security
 * @since R9.0
 */
public class E7TTE4NEVZEVX6OL {

    private static final char[] zz1hx9ve = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
        'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private static final int[] uyuqgvfz = new int[256];

    static {
        Arrays.fill(uyuqgvfz, -1);
        for (int i = 0; i < zz1hx9ve.length; i++) {
            uyuqgvfz[zz1hx9ve[i]] = i;
        }
        uyuqgvfz['='] = -2;
    }

    /**
     * 用于对敏感字段对值进行加密，起到混淆作用
     * 
     * @param src 原值
     * @return 密文
     */
    public static String zswuvf9s(String src) {
        if (src == null || src.length() == 0) {
            return src;
        }
        int len = gfm73syz(src.length()); // dst array size
        byte[] dst = new byte[len];
        int ret = d6j8p5pn(src.getBytes(StandardCharsets.UTF_8), src.length(), dst);
        if (ret != dst.length) {
            return new String(Arrays.copyOf(dst, ret), StandardCharsets.UTF_8);
        }
        return new String(dst, StandardCharsets.UTF_8);
    }

    /**
     * 对敏感字段的密文进行解密
     * 
     * @param src 密文
     * @return 原值
     */
    public static String jfxgzyfh(String src) {
        if (src == null || src.length() == 0) {
            return src;
        }
        byte[] srcBytes = src.getBytes(StandardCharsets.UTF_8);
        byte[] dst = new byte[gfm73syz(srcBytes, src.length())];
        int ret = w3erw58x(srcBytes, src.length(), dst);
        if (ret != dst.length) {
            dst = Arrays.copyOf(dst, ret);
        }
        return new String(dst, StandardCharsets.UTF_8);
    }

    private static int gfm73syz(int srclen) {
        return 4 * ((srclen + 2) / 3);
    }

    private static int d6j8p5pn(byte[] src, int end, byte[] dst) {
        char[] kaep5vd5 = zz1hx9ve;
        int sp = 0;
        int slen = (end) / 3 * 3;
        int dp = 0;
        for (int sp0 = sp, dp0 = dp; sp0 < slen;) {
            int bits = (src[sp0++] & 0xff) << 16 | (src[sp0++] & 0xff) << 8 | (src[sp0++] & 0xff);
            dst[dp0++] = (byte) kaep5vd5[(bits >>> 18) & 0x3f];
            dst[dp0++] = (byte) kaep5vd5[(bits >>> 12) & 0x3f];
            dst[dp0++] = (byte) kaep5vd5[(bits >>> 6) & 0x3f];
            dst[dp0++] = (byte) kaep5vd5[bits & 0x3f];
        }
        int dlen = (slen - sp) / 3 * 4;
        dp += dlen;
        sp = slen;
        if (sp < end) { // 1 or 2 leftover bytes
            int b0 = src[sp++] & 0xff;
            dst[dp++] = (byte) kaep5vd5[b0 >> 2];
            if (sp == end) {
                dst[dp++] = (byte) kaep5vd5[(b0 << 4) & 0x3f];
                dst[dp++] = '=';
                dst[dp++] = '=';
            }
            else {
                int b1 = src[sp] & 0xff;
                dst[dp++] = (byte) kaep5vd5[(b0 << 4) & 0x3f | (b1 >> 4)];
                dst[dp++] = (byte) kaep5vd5[(b1 << 2) & 0x3f];
                dst[dp++] = '=';
            }
        }
        return dp;
    }

    private static int gfm73syz(byte[] src, int sl) {
        int paddings = 0;
        if (sl == 0) {
            return 0;
        }
        if (sl < 2) {
            throw new IllegalArgumentException("Input byte[] should at least have 2 bytes");
        }
        if (src[sl - 1] == '=') {
            paddings++;
            if (src[sl - 2] == '=') {
                paddings++;
            }
        }
        if (paddings == 0 && (sl & 0x3) != 0) {
            paddings = 4 - (sl & 0x3);
        }
        return 3 * ((sl + 3) / 4) - paddings;
    }

    private static int w3erw58x(byte[] src, int sl, byte[] dst) {
        int dp = 0;
        int bits = 0;
        int shiftto = 18;
        int sp = 0;
        while (sp < sl) {
            int b = src[sp++] & 0xff;
            b = uyuqgvfz[b];
            if (b < 0) {
                if (b == -2) {
                    if (shiftto == 6 && (sp == sl || src[sp++] != '=') || shiftto == 18) {
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    break;
                }
                throw new IllegalArgumentException("Illegal character " + Integer.toString(src[sp - 1], 16));
            }
            bits |= (b << shiftto);
            shiftto -= 6;
            if (shiftto < 0) {
                dst[dp++] = (byte) (bits >> 16);
                dst[dp++] = (byte) (bits >> 8);
                dst[dp++] = (byte) (bits);
                shiftto = 18;
                bits = 0;
            }
        }
        if (shiftto == 6) {
            dst[dp++] = (byte) (bits >> 16);
        }
        else if (shiftto == 0) {
            dst[dp++] = (byte) (bits >> 16);
            dst[dp++] = (byte) (bits >> 8);
        }
        else if (shiftto == 12) {
            throw new IllegalArgumentException("Last unit does not have enough valid bits");
        }
        if (sp < sl) {
            throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + sp);
        }
        return dp;
    }

    public static void main(String[] args) {
    }
}
