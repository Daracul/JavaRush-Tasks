package com.javarush.task.task21.Expirience;

/**
 * Created by amalakhov on 26.04.2017.
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if(b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() { return id; }
            }
            TrackingSlip ts = new TrackingSlip("ожидание");
            String s = ts.getSlip();
        }
        // Здесь использовать класс нельзя!
        // Вне области видимости
        //! TrackingSlip ts = new TrackingSlip("x");
    }
    public void track() { internalTracking(true); }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
