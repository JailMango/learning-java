package core.basic.chapter09.策略模式;

import lombok.extern.slf4j.Slf4j;

/**
 * TravelByAirStrategy
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.策略模式
 * @since R9.0
 */
@Slf4j
public class TravelByAirStrategy implements TravelStrategy {

    @Override
    public void travelMode() {
        log.info("travel by air...");
    }
}
