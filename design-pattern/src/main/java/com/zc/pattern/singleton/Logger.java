package com.zc.pattern.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhao.cheng
 * @date 2020/8/20 13:03
 */
public class Logger {

    private FileWriter fileWriter;
    private static final Logger instance = new Logger();

    private Logger() {
        File file = new File("log.txt");
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) throws IOException {
        fileWriter.write(message);
    }
}
