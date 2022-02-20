package Moonlander;

import java.util.Objects;

public class LunarLanding {
    final int FUEL_POWER = 40;
    final int G = 500;

    final ILanderControls controls;
    int altitude;
    int velocity;

    public LunarLanding(ILanderControls controls, int altitude, int velocity) {

        Objects.requireNonNull(controls);
        this.controls = controls;

        if (altitude < 0) throw new IllegalArgumentException("Altitude should not be negative. ");
        this.altitude = altitude;
        this.velocity = velocity;
    }

    public int land() {

        int fuelSpent = 0;

        while (true) {
            if (altitude < 10) {
                if (velocity < 50) break;
                else
                    throw new IllegalStateException("Lander crashed at a velocity of: " + velocity);
            }

            int fuel = controls.getSecondsOfFuelBurn(altitude, velocity);
            if (fuel < 0) fuel = 0; // TODO throw exception
            fuelSpent += fuel;
            velocity -= (fuel * FUEL_POWER) - G;
            altitude -= velocity;
        }
        return fuelSpent;
    }
}
