public class Radio {
    private static int currentStation;
    private static int currentVolume;

    public static int getCurrentStation() {
        return currentStation;
    }

    public static void setCurrentStation(int station) {
        if (station < 0 || station > 9) {
            return;
        }
        currentStation = station;
    }

    public static void next() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public static void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public static int getCurrentVolume() {
        return currentVolume;
    }

    public static void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public static void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}