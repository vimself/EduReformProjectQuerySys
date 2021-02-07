package com.qinli.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author Cambria
 * @creat 2021/2/7 14:37
 */
public class Utils {

    @Test
    void test1() throws IOException {
        System.out.println(getProjectPath());
    }

    public static String getProjectPath() throws IOException {
        return new File("").getCanonicalPath();
    }
}
