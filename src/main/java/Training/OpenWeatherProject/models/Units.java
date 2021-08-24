package Training.OpenWeatherProject.models;

public class Units {

    String temperatureUnit;
    String windSpeedUnit;
    String pressureUnit;
    String precipitationUnit;
    String distanceUnit;
    String timeFormatUnit;

    public String getTemperatureUnit(Integer sts) {
        if (sts == 1) {
            return "°C";
        } else {
            return "°F";
        }
    }

    public String getWindSpeedUnit(Integer sts) {
        if (sts == 1) {
            return "m/s";
        } else if (sts == 2) {
            return  "km/h";
        } else {
            return  "mph";
        }
    }

    public String getPressureUnit(Integer sts) {
        if (sts == 1) {
            return "hPa";
        } else {
            return "inHg";
        }
    }

    public String getPrecipitationUnit(Integer sts) {
        if (sts == 1) {
            return "mm";
        } else {
            return "in";
        }
    }

    public String getDistanceUnit(Integer sts) {
        if (sts == 1) {
            return "km";
        } else {
            return "mi";
        }
    }

    public String getTimeFormatUnit(Integer sts) {
        if (sts == 1) {
            return "12-hour";
        } else {
            return "24-hour";
        }
    }
}
