package cell;

import org.junit.jupiter.api.Test;

import static cell.HotelState.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HotelStateTest {
    @Test
    void givenHotelState_whenAskedForDeltaForSilver_shouldComputeTheDifference() {
        final int delta = SILVER.getDelta();

        assertThat(delta,is(100));
    }

    @Test
    void givenHotelState_whenAskedForDeltaForGold_shouldComputeTheDifference() {
        final int delta = GOLD.getDelta();

        assertThat(delta,is(200));
    }

    @Test
    void givenHotelState_whenAskedUpgradeForSilver_shouldComputeAsGold() {
        final HotelState upgradeState = SILVER.getUpgradeState();

        assertThat(upgradeState,is(GOLD));
    }

    @Test
    void givenHotelState_whenAskedUpgradeForGold_shouldComputeAsPlatinum() {
        final HotelState upgradeState = GOLD.getUpgradeState();

        assertThat(upgradeState,is(PLATINUM));
    }
}