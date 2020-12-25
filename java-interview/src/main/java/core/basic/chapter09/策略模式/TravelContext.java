package core.basic.chapter09.策略模式;

/**
 * TravelContext
 *
 * @author he.gang33
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.策略模式
 * @since R9.0
 */
public class TravelContext {

    private TravelStrategy travelStrategy;

    public void travelMode() {
        this.travelStrategy.travelMode();
    }

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }
}
