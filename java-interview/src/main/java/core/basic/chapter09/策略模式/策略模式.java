package core.basic.chapter09.策略模式;

import com.oracle.tools.packager.Log;

/**
 * 策略模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.策略模式
 * @since R9.0
 */
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
        Log.info("==================");
        travelContext.setTravelStrategy(car);
        travelContext.travelMode();
    }
}
