package core.basic.chapter09.策略模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 策略模式
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.策略模式
 * @since R9.0
 */
@Slf4j
public class 策略模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        TravelContext travelContext = new TravelContext();
        TravelStrategy air = new TravelByAirStrategy();
        TravelStrategy car = new TravelByCarStrategy();

        travelContext.setTravelStrategy(air);
        travelContext.travelMode();
        log.info("==================");
        travelContext.setTravelStrategy(car);
        travelContext.travelMode();
    }
}
