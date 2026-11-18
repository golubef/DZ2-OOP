import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RadioTest {

    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    @Test
    void nextFromZero() {
        radio.setCurrentStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void nextFromFive() {
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void nextFromNine() {
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prevFromNine() {
        radio.setCurrentStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    void prevFromFive() {
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void prevFromZero() {
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void setBelowRangeIgnored() {
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void setAboveRangeIgnored() {
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void increaseVolumeFromZero() {
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeFromFifty() {
        for (int i = 0; i < 50; i++) radio.increaseVolume();
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeToHundred() {
        for (int i = 0; i < 99; i++) radio.increaseVolume();
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeAtMaxDoesNothing() {
        for (int i = 0; i < 100; i++) radio.increaseVolume();
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeFromHundred() {
        for (int i = 0; i < 100; i++) radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeFromFifty() {
        for (int i = 0; i < 50; i++) radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeToZero() {
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeAtMinDoesNothing() {
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}