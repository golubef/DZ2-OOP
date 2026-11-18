public class Radio {
    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() { return currentStation; }

    public void setCurrentStation(int station) {
        if (station < 0 || station > 9) return;
        currentStation = station;
    }

    public void next() {
        currentStation = (currentStation == 9) ? 0 : currentStation + 1;
    }

    public void prev() {
        currentStation = (currentStation == 0) ? 9 : currentStation - 1;
    }

    public int getCurrentVolume() { return currentVolume; }

    public void increaseVolume() {
        if (currentVolume < 100) currentVolume++;
    }

    public void decreaseVolume() {
        if (currentVolume > 0) currentVolume--;
    }
}