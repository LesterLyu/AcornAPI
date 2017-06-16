
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Time {

    @SerializedName("day")
    @Expose
    private Day day;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("buildingCode")
    @Expose
    private String buildingCode;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("instructors")
    @Expose
    private List<String> instructors = new ArrayList<String>();
    @SerializedName("commaSeparatedInstructorNames")
    @Expose
    private String commaSeparatedInstructorNames;

    /**
     * 
     * @return
     *     The day
     */
    public Day getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    public void setDay(Day day) {
        this.day = day;
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
     *     The buildingCode
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * 
     * @param buildingCode
     *     The buildingCode
     */
    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    /**
     * 
     * @return
     *     The room
     */
    public String getRoom() {
        return room;
    }

    /**
     * 
     * @param room
     *     The room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 
     * @return
     *     The instructors
     */
    public List<String> getInstructors() {
        return instructors;
    }

    /**
     * 
     * @param instructors
     *     The instructors
     */
    public void setInstructors(List<String> instructors) {
        this.instructors = instructors;
    }

    /**
     * 
     * @return
     *     The commaSeparatedInstructorNames
     */
    public String getCommaSeparatedInstructorNames() {
        return commaSeparatedInstructorNames;
    }

    /**
     * 
     * @param commaSeparatedInstructorNames
     *     The commaSeparatedInstructorNames
     */
    public void setCommaSeparatedInstructorNames(String commaSeparatedInstructorNames) {
        this.commaSeparatedInstructorNames = commaSeparatedInstructorNames;
    }

}
