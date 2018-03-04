
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Time.
 */
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
     * Gets day.
     *
     * @return The      day
     */
    public Day getDay() {
        return day;
    }

    /**
     * Sets day.
     *
     * @param day The day
     */
    public void setDay(Day day) {
        this.day = day;
    }

    /**
     * Gets start time.
     *
     * @return The      startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime The startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return The      endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime The endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets building code.
     *
     * @return The      buildingCode
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * Sets building code.
     *
     * @param buildingCode The buildingCode
     */
    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    /**
     * Gets room.
     *
     * @return The      room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room The room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets instructors.
     *
     * @return The      instructors
     */
    public List<String> getInstructors() {
        return instructors;
    }

    /**
     * Sets instructors.
     *
     * @param instructors The instructors
     */
    public void setInstructors(List<String> instructors) {
        this.instructors = instructors;
    }

    /**
     * Gets comma separated instructor names.
     *
     * @return The      commaSeparatedInstructorNames
     */
    public String getCommaSeparatedInstructorNames() {
        return commaSeparatedInstructorNames;
    }

    /**
     * Sets comma separated instructor names.
     *
     * @param commaSeparatedInstructorNames The commaSeparatedInstructorNames
     */
    public void setCommaSeparatedInstructorNames(String commaSeparatedInstructorNames) {
        this.commaSeparatedInstructorNames = commaSeparatedInstructorNames;
    }

}
