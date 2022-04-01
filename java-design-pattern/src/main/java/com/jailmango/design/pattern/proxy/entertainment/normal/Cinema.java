package com.jailmango.design.pattern.proxy.entertainment.normal;

/**
 * Cinema
 *
 * @author jailmango
 * @CreateDate 2018/10/23
 * @see com.jailmango.design.pattern.proxy.entertainment
 * @since R9.0<br>
 */
public class Cinema implements Movie {

    /**
     * movie
     */
    private RealMovie movie;

    /**
     * Consturctor
     * 
     * @param movie RealMovie
     */
    public Cinema(RealMovie movie) {
        super();
        this.movie = movie;
    }

    @Override
    public void play() {
        tips(true);
        movie.play();
        tips(false);
    }

    /**
     * 提醒
     * 
     * @param isStart boolean
     */
    private void tips(boolean isStart) {
        if (isStart) {
            System.out.println("Starting...");
        }
        else {
            System.out.println("Ending...");
        }
    }
}
