/**
 * Planned courses are the courses in the enrollment cart
 */
package entity.plan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PlannedCourse {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("courseCode")
    @Expose
    private String courseCode;
    @SerializedName("sectionCode")
    @Expose
    private String sectionCode;
    @SerializedName("primaryActivityId")
    @Expose
    private String primaryActivityId;
    @SerializedName("secondaryActivityId")
    @Expose
    private String secondaryActivityId;
    @SerializedName("courseTitle")
    @Expose
    private String courseTitle;
    @SerializedName("thirdActivityId")
    @Expose
    private String thirdActivityId;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("regSessionCode1")
    @Expose
    private String regSessionCode1;
    @SerializedName("regSessionCode2")
    @Expose
    private String regSessionCode2;
    @SerializedName("regSessionCode3")
    @Expose
    private String regSessionCode3;
    @SerializedName("messages")
    @Expose
    private List<Message> messages = new ArrayList<Message>();
    @SerializedName("info")
    @Expose
    private Info info;

    public int color;
    
    
    @Override
	public String toString() {
		return  "[PlannedCourse" + courseCode + sectionCode + ", " + regSessionCode1 + " to " + regSessionCode2 + "]";
	}

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * 
     * @param courseCode
     *     The courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * 
     * @return
     *     The sectionCode
     */
    public String getSectionCode() {
        return sectionCode;
    }

    /**
     * 
     * @param sectionCode
     *     The sectionCode
     */
    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    /**
     * 
     * @return
     *     The primaryActivityId
     */
    public String getPrimaryActivityId() {
        return primaryActivityId;
    }

    /**
     * 
     * @param primaryActivityId
     *     The primaryActivityId
     */
    public void setPrimaryActivityId(String primaryActivityId) {
        this.primaryActivityId = primaryActivityId;
    }

    /**
     * 
     * @return
     *     The secondaryActivityId
     */
    public String getSecondaryActivityId() {
        return secondaryActivityId;
    }

    /**
     * 
     * @param secondaryActivityId
     *     The secondaryActivityId
     */
    public void setSecondaryActivityId(String secondaryActivityId) {
        this.secondaryActivityId = secondaryActivityId;
    }

    /**
     * 
     * @return
     *     The courseTitle
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     * 
     * @param courseTitle
     *     The courseTitle
     */
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    /**
     * 
     * @return
     *     The thirdActivityId
     */
    public String getThirdActivityId() {
        return thirdActivityId;
    }

    /**
     * 
     * @param thirdActivityId
     *     The thirdActivityId
     */
    public void setThirdActivityId(String thirdActivityId) {
        this.thirdActivityId = thirdActivityId;
    }

    /**
     * 
     * @return
     *     The cancelled
     */
    public Boolean getCancelled() {
        return cancelled;
    }

    /**
     * 
     * @param cancelled
     *     The cancelled
     */
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * 
     * @return
     *     The regSessionCode1
     */
    public String getRegSessionCode1() {
        return regSessionCode1;
    }

    /**
     * 
     * @param regSessionCode1
     *     The regSessionCode1
     */
    public void setRegSessionCode1(String regSessionCode1) {
        this.regSessionCode1 = regSessionCode1;
    }

    /**
     * 
     * @return
     *     The regSessionCode2
     */
    public String getRegSessionCode2() {
        return regSessionCode2;
    }

    /**
     * 
     * @param regSessionCode2
     *     The regSessionCode2
     */
    public void setRegSessionCode2(String regSessionCode2) {
        this.regSessionCode2 = regSessionCode2;
    }

    /**
     * 
     * @return
     *     The regSessionCode3
     */
    public String getRegSessionCode3() {
        return regSessionCode3;
    }

    /**
     * 
     * @param regSessionCode3
     *     The regSessionCode3
     */
    public void setRegSessionCode3(String regSessionCode3) {
        this.regSessionCode3 = regSessionCode3;
    }

    /**
     * 
     * @return
     *     The messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     *     The messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * 
     * @return
     *     The info
     */
    public Info getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();
        if (getInfo().getPrimaryActivities().size() != 0)
            activities.add(getInfo().getPrimaryActivities().get(0));
        if (getInfo().getSecondaryActivities().size() != 0)
            activities.add(getInfo().getSecondaryActivities().get(0));
        if (getInfo().getThirdActivities().size() != 0)
            activities.add(getInfo().getThirdActivities().get(0));
    return activities;
    }
}
