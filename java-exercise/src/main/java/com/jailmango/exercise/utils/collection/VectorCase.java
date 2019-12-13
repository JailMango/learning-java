package com.jailmango.exercise.utils.collection;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VectorCase
 *
 * @author he.gang33
 * @CreateDate 2019-07-08
 * @see com.jailmango.exercise.utils.collection
 * @since R9.0
 */
public class VectorCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(VectorCase.class);

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        logger.info("Remove: [{}]", vector.remove(0));
        logger.info("First-Element: [{}]", vector.firstElement());
        logger.info("Index-5: [{}]", vector.elementAt(5));

        logger.info("end...");
    }
}
