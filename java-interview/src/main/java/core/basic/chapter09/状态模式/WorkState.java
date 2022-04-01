package core.basic.chapter09.状态模式;

import lombok.extern.slf4j.Slf4j;

/**
 * WorkState
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.状态模式
 * @since R9.0
 */
@Slf4j
public class WorkState extends AbstractState {

    @Override
    public void action(Context context) {
        log.info("state change to work state...");
        log.info("work state actions is meeting...");
    }
}
