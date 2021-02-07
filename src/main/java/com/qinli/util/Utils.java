package com.qinli.util;

import java.io.File;
import java.io.IOException;

/**
 * @Author Cambria
 * @creat 2021/2/7 14:37
 */
public class Utils {
    public static String getProjectPath() throws IOException {
        return new File("").getCanonicalPath();
    }
}
