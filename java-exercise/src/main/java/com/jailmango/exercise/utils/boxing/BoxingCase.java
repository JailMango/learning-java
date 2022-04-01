package com.jailmango.exercise.utils.boxing;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BoxingCase
 *
 * @author jailmango
 * @CreateDate 2018-12-17
 * @see com.jailmango.exercise.utils.boxing
 * @since R9.0<br>
 */
public class BoxingCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BoxingCase.class);

    public static void main(String[] args) {
        List<Sequence> list = new ArrayList<>();
        Sequence seq;

        for (int index = 0; index < 10; index++) {
            seq = new Sequence();
            seq.setSeq((long) (index + 1));
            list.add(seq);
        }

        logger.info("end...");
    }
}
