package cell;

import org.junit.jupiter.api.Test;

import static cell.HotelState.GOLD;
import static cell.HotelState.SILVER;
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
}