package Moonlander;

public class BurnedFuel implements ILanderControls {
    @Override
    public int getSecondsOfFuelBurn(int altitude, int velocity) {
        return altitude / velocity;
    }
}
