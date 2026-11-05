import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RadioTest {

    @BeforeEach
    void setUp() {
        Radio radio = new Radio();
    }

    @Test
    void nextFromZero() {
        Radio.setCurrentStation(0);
        Radio.next();
        assertEquals(1, Radio.getCurrentStation());
    }

    @Test
    void nextFromFive() {
        Radio.setCurrentStation(5);
        Radio.next();
        assertEquals(6, Radio.getCurrentStation());
    }

    @Test
    void nextFromNine() {
        Radio.setCurrentStation(9);
        Radio.next();
        assertEquals(0, Radio.getCurrentStation());
    }

    @Test
    void prevFromNine() {
        Radio.setCurrentStation(9);
        Radio.prev();
        assertEquals(8, Radio.getCurrentStation());
    }

    @Test
    void prevFromFive() {
        Radio.setCurrentStation(5);
        Radio.prev();
        assertEquals(4, Radio.getCurrentStation());
    }

    @Test
    void prevFromZero() {
        Radio.setCurrentStation(0);
        Radio.prev();
        assertEquals(9, Radio.getCurrentStation());
    }

    @Test
    void increaseVolumeFromZero() {
        Radio.increaseVolume();
        assertEquals(1, Radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeFromFifty() {
        for (int i = 0; i < 50; i++) RadioincreaseVolume();
        Radio.increaseVolume();
        assertEquals(51, Radio.getCurrentVolume());
    }

    private void RadioincreaseVolume() {

    }

    @Test
    void increaseVolumeToHundred() {
        for (int i = 0; i < 99; i++) Radio.increaseVolume();
        Radio.increaseVolume();
        assertEquals(100, Radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeAtMaxDoesNothing() {
        for (int i = 0; i < 100; i++) Radio.increaseVolume();
        Radio.increaseVolume();
        assertEquals(100, Radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeFromHundred() {
        for (int i = 0; i < 100; i++) Radio.increaseVolume();
        Radio.decreaseVolume();
        assertEquals(99, Radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeFromFifty() {
        for (int i = 0; i < 50; i++) Radio.increaseVolume();
        Radio.decreaseVolume();
        assertEquals(49, Radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeToZero() {
        Radio.increaseVolume();
        Radio.decreaseVolume();
        assertEquals(0, Radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeAtMinDoesNothing() {
        Radio.decreaseVolume();
        assertEquals(0, Radio.getCurrentVolume());
    }
}
