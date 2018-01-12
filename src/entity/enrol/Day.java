
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Day.
 */
public class Day {

    @SerializedName("dayCode")
    @Expose
    private String dayCode;
    @SerializedName("dayName")
    @Expose
    private String dayName;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("weekDay")
    @Expose
    private Boolean weekDay;
    @SerializedName("gregorianCalendarDayOfWeek")
    @Expose
    private Integer gregorianCalendarDayOfWeek;

    /**
     * Gets day code.
     *
     * @return The      dayCode
     */
    public String getDayCode() {
        return dayCode;
    }

    /**
     * Sets day code.
     *
     * @param dayCode The dayCode
     */
    public void setDayCode(String dayCode) {
        this.dayCode = dayCode;
    }

    /**
     * Gets day name.
     *
     * @return The      dayName
     */
    public String getDayName() {
        return dayName;
    }

    /**
     * Sets day name.
     *
     * @param dayName The dayName
     */
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    /**
     * Gets index.
     *
     * @return The      index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Sets index.
     *
     * @param index The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * Gets week day.
     *
     * @return The      weekDay
     */
    public Boolean getWeekDay() {
        return weekDay;
    }

    /**
     * Sets week day.
     *
     * @param weekDay The weekDay
     */
    public void setWeekDay(Boolean weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * Gets gregorian calendar day of week.
     *
     * @return The      gregorianCalendarDayOfWeek
     */
    public Integer getGregorianCalendarDayOfWeek() {
        return gregorianCalendarDayOfWeek;
    }

    /**
     * Sets gregorian calendar day of week.
     *
     * @param gregorianCalendarDayOfWeek The gregorianCalendarDayOfWeek
     */
    public void setGregorianCalendarDayOfWeek(Integer gregorianCalendarDayOfWeek) {
        this.gregorianCalendarDayOfWeek = gregorianCalendarDayOfWeek;
    }

}
