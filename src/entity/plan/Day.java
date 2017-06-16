
package entity.plan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import entity.enrol.Time;


public class Day {

    @SerializedName("roomLocation")
    @Expose
    private String roomLocation;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("dayOfWeek")
    @Expose
    private String dayOfWeek;

    public Day(Time time){
        roomLocation = time.getBuildingCode() + time.getRoom();
        startTime = time.getStartTime();
        endTime = time.getEndTime();
        dayOfWeek = time.getDay().getDayName();
    }

    /**
     * 
     * @return
     *     The roomLocation
     */
    public String getRoomLocation() {
        if(roomLocation.trim().equals(""))
            return "TBA";
        return roomLocation;
    }

    /**
     * 
     * @param roomLocation
     *     The roomLocation
     */
    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    /**
     * 
     * @return
     *     The startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 
     * @param startTime
     *     The startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 
     * @return
     *     The endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 
     * @param endTime
     *     The endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     * @return
     *     The dayOfWeek
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * 
     * @param dayOfWeek
     *     The dayOfWeek
     */
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
