package com.danh.vehicle;

public interface DealWithSpeed {
    void startUp(int amount);
    int getCurrentSpeed();
    void applyBreak(int amount);
    default double MilesToKm(double distanceInMiles) {
        return distanceInMiles*1.609;
    };
}
