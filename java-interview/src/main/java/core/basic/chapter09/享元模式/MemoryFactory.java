package core.basic.chapter09.享元模式;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

/**
 * MemoryFactory
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.享元模式
 * @since R9.0
 */
@Slf4j
public class MemoryFactory {

    private static List<Memory> memoryList = new ArrayList<>();

    public static Memory getMemory(int size) {
        Memory memory = null;
        for (int i = 0; i < memoryList.size(); i++) {
            memory = memoryList.get(i);
            if (memory.getSize() == size && !memory.isIsused()) {
                memory.setIsused(true);
                memoryList.set(i, memory);
                log.info("get memory from list: [{}]", memory.toString());
                break;
            }
        }

        if (memory == null) {
            memory = new Memory(32, false, UUID.randomUUID().toString());
            log.info("create a memory from system and add to list. [{}]", memory.toString());
            memoryList.add(memory);
        }

        return memory;
    }

    public static void releaseMemory(String id) {
        for (int i = 0; i < memoryList.size(); i++) {
            Memory memory = memoryList.get(i);
            if (memory.getId().equals(id)) {
                memory.setIsused(false);
                memoryList.set(i, memory);
                log.info("release memory. [{}]", memory.toString());
                break;
            }
        }
    }
}
