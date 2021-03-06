package org.openhab.binding.rflink.messages;

public class RfLinkDataParser {

    // TODO needs to be tested
    /**
     * Parse temperature
     *
     * @param value Temperature (hexadecimal string) high bit contains negative sign, needs division by 10 (0xC0 = 192
     *            decimal = 19.2 degrees)
     * @return the temperature in Celcius degrees
     */
    public static double parseTemperature(String value) {

        int iValue = Integer.parseInt(value, 16);
        float negativeSignCoef = ((iValue & 0x80) > 0) ? -10.0f : 10.0f;

        return (iValue & 0x7F) / negativeSignCoef;
    }

    // TODO needs to be tested
    /**
     * Parse Wind Direction
     *
     * @param value Wind direction (integer value from 0-15) reflecting 0-360 degrees in 22.5 degree steps
     * @return the wind direction in degrees
     */
    public static double parseWindDirection(String value) {

        return Integer.parseInt(value, 10) * 22.5f;
    }

}
