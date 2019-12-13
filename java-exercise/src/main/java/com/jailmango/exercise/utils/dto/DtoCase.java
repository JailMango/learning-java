package com.jailmango.exercise.utils.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DtoCase
 *
 * @author he.gang33
 * @CreateDate 2019-07-11
 * @see com.jailmango.exercise.utils.dto
 * @since R9.0
 */
public class DtoCase {
    
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DtoCase.class);

    public static void main(String[] args) {
        TableSegDto dto = new TableSegDto();

        logger.info("{}", dto.getSpId());
    }
}
