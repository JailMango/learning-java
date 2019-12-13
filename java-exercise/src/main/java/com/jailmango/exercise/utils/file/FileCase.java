package com.jailmango.exercise.utils.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileCase
 *
 * @author he.gang33
 * @CreateDate 2019-02-12
 * @see com.jailmango.exercise.utils.file
 * @since R9.0
 */
public class FileCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        File file = new File("/Users/mango/Documents/repository/github/learning-java/file/file.data");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write("hello.".getBytes("UTF-8"));
        }
        catch (FileNotFoundException e) {
            logger.error(e.getLocalizedMessage());
        }
        catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
        finally {
            if (null != fos) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        }
    }
}
