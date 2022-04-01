package core.basic.chapter09.代理模式;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Proxy
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.代理模式
 * @since R9.0
 */
@Slf4j
public class Proxy implements Company {

    private HR hr;

    public Proxy() {
        super();
        this.hr = new HR();
    }

    @Override
    public void findWorker(String title) {
        hr.findWorker(title);

        String worker = goWorker(title);
        log.info("find a worker by proxy, worker[{}]", worker);
    }

    private String goWorker(String title) {
        Map<String, String> map = new HashMap<String, String>() {
            {
                put("Java", "A");
                put("Python", "B");
                put("C++", "C");
            }
        };

        return map.get(title);
    }
}
