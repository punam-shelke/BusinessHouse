package cell;

public enum HotelState {
    NEW(0, 0),
    SILVER(200, 50),
    GOLD(300, 150),
    PLATINUM(500, 300);

    private final int value;
    private final int rent;

    HotelState(int value, int rent) {
        this.value = value;
        this.rent = rent;
    }

    public int getValue() {
        return value;
    }

    public int getRent() {
        return rent;
    }

    public int getDelta() {
        final HotelState[] values = values();

        final int currentIndex = ordinal();
        final HotelState currentState = values[currentIndex];

        final int nextIndex = currentIndex + 1;
        final HotelState nextState = values[nextIndex];

        return nextState.getValue() - currentState.getValue();
    }
}
