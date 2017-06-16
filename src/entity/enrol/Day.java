
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
     * 
     * @return
     *     The dayCode
     */
    public String getDayCode() {
        return dayCode;
    }

    /**
     * 
     * @param dayCode
     *     The dayCode
     */
    public void setDayCode(String dayCode) {
        this.dayCode = dayCode;
    }

    /**
     * 
     * @return
     *     The dayName
     */
    public String getDayName() {
        return dayName;
    }

    /**
     * 
     * @param dayName
     *     The dayName
     */
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    /**
     * 
     * @return
     *     The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The weekDay
     */
    public Boolean getWeekDay() {
        return weekDay;
    }

    /**
     * 
     * @param weekDay
     *     The weekDay
     */
    public void setWeekDay(Boolean weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * 
     * @return
     *     The gregorianCalendarDayOfWeek
     */
    public Integer getGregorianCalendarDayOfWeek() {
        return gregorianCalendarDayOfWeek;
    }

    /**
     * 
     * @param gregorianCalendarDayOfWeek
     *     The gregorianCalendarDayOfWeek
     */
    public void setGregorianCalendarDayOfWeek(Integer gregorianCalendarDayOfWeek) {
        this.gregorianCalendarDayOfWeek = gregorianCalendarDayOfWeek;
    }

}
