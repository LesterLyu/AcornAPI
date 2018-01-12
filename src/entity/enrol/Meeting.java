
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Meeting.
 */
public class Meeting {

	@Override
	public String toString() {
		return "Meeting [waitlistRank=" + waitlistRank + ", displayName=" + displayName + "]";
	}

	@SerializedName("sectionNo")
    @Expose
    private String sectionNo;
    @SerializedName("sessionCode")
    @Expose
    private String sessionCode;
    @SerializedName("teachMethod")
    @Expose
    private String teachMethod;
    @SerializedName("enrollSpace")
    @Expose
    private Integer enrollSpace;
    @SerializedName("enrollmentSpaceAvailable")
    @Expose
    private Integer enrollmentSpaceAvailable;
    @SerializedName("totalSpace")
    @Expose
    private Integer totalSpace;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("waitlistable")
    @Expose
    private Boolean waitlistable;
    @SerializedName("subTitle1")
    @Expose
    private String subTitle1;
    @SerializedName("subTitle2")
    @Expose
    private String subTitle2;
    @SerializedName("subTitle3")
    @Expose
    private String subTitle3;
    @SerializedName("waitlistRank")
    @Expose
    private Integer waitlistRank;
    @SerializedName("waitlistLookupMethod")
    @Expose
    private Object waitlistLookupMethod;
    @SerializedName("times")
    @Expose
    private List<Time> times = new ArrayList<Time>();
    @SerializedName("displayTime")
    @Expose
    private String displayTime;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("full")
    @Expose
    private Boolean full;
    @SerializedName("enrollmentControlFull")
    @Expose
    private Boolean enrollmentControlFull;
    @SerializedName("enrollmentControlMissing")
    @Expose
    private Boolean enrollmentControlMissing;
    @SerializedName("deliveryMode")
    @Expose
    private String deliveryMode;
    @SerializedName("waitlistableForAll")
    @Expose
    private Boolean waitlistableForAll;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("professorApprovalReq")
    @Expose
    private String professorApprovalReq;
    @SerializedName("meetingResources")
    @Expose
    private List<MeetingResource> meetingResources = new ArrayList<MeetingResource>();
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("subTitle")
    @Expose
    private String subTitle;
    @SerializedName("hasSubTitle")
    @Expose
    private Boolean hasSubTitle;
    @SerializedName("commaSeparatedInstructorNames")
    @Expose
    private String commaSeparatedInstructorNames;


    /**
     * Gets section no.
     *
     * @return The      sectionNo
     */
    public String getSectionNo() {
        return sectionNo;
    }

    /**
     * Sets section no.
     *
     * @param sectionNo The sectionNo
     */
    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    /**
     * Gets session code.
     *
     * @return The      sessionCode
     */
    public String getSessionCode() {
        return sessionCode;
    }

    /**
     * Sets session code.
     *
     * @param sessionCode The sessionCode
     */
    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    /**
     * Gets teach method.
     *
     * @return The      teachMethod
     */
    public String getTeachMethod() {
        return teachMethod;
    }

    /**
     * Sets teach method.
     *
     * @param teachMethod The teachMethod
     */
    public void setTeachMethod(String teachMethod) {
        this.teachMethod = teachMethod;
    }

    /**
     * Gets enroll space.
     *
     * @return The      enrollSpace
     */
    public Integer getEnrollSpace() {
        return enrollSpace;
    }

    /**
     * Sets enroll space.
     *
     * @param enrollSpace The enrollSpace
     */
    public void setEnrollSpace(Integer enrollSpace) {
        this.enrollSpace = enrollSpace;
    }

    /**
     * Gets enrollment space available.
     *
     * @return The      enrollmentSpaceAvailable
     */
    public Integer getEnrollmentSpaceAvailable() {
        return enrollmentSpaceAvailable;
    }

    /**
     * Sets enrollment space available.
     *
     * @param enrollmentSpaceAvailable The enrollmentSpaceAvailable
     */
    public void setEnrollmentSpaceAvailable(Integer enrollmentSpaceAvailable) {
        this.enrollmentSpaceAvailable = enrollmentSpaceAvailable;
    }

    /**
     * Gets total space.
     *
     * @return The      totalSpace
     */
    public Integer getTotalSpace() {
        return totalSpace;
    }

    /**
     * Sets total space.
     *
     * @param totalSpace The totalSpace
     */
    public void setTotalSpace(Integer totalSpace) {
        this.totalSpace = totalSpace;
    }

    /**
     * Gets cancelled.
     *
     * @return The      cancelled
     */
    public Boolean getCancelled() {
        return cancelled;
    }

    /**
     * Sets cancelled.
     *
     * @param cancelled The cancelled
     */
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Gets closed.
     *
     * @return The      closed
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * Sets closed.
     *
     * @param closed The closed
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    /**
     * Gets waitlistable.
     *
     * @return The      waitlistable
     */
    public Boolean getWaitlistable() {
        return waitlistable;
    }

    /**
     * Sets waitlistable.
     *
     * @param waitlistable The waitlistable
     */
    public void setWaitlistable(Boolean waitlistable) {
        this.waitlistable = waitlistable;
    }

    /**
     * Gets sub title 1.
     *
     * @return The      subTitle1
     */
    public String getSubTitle1() {
        return subTitle1;
    }

    /**
     * Sets sub title 1.
     *
     * @param subTitle1 The subTitle1
     */
    public void setSubTitle1(String subTitle1) {
        this.subTitle1 = subTitle1;
    }

    /**
     * Gets sub title 2.
     *
     * @return The      subTitle2
     */
    public String getSubTitle2() {
        return subTitle2;
    }

    /**
     * Sets sub title 2.
     *
     * @param subTitle2 The subTitle2
     */
    public void setSubTitle2(String subTitle2) {
        this.subTitle2 = subTitle2;
    }

    /**
     * Gets sub title 3.
     *
     * @return The      subTitle3
     */
    public String getSubTitle3() {
        return subTitle3;
    }

    /**
     * Sets sub title 3.
     *
     * @param subTitle3 The subTitle3
     */
    public void setSubTitle3(String subTitle3) {
        this.subTitle3 = subTitle3;
    }

    /**
     * Gets waitlist rank.
     *
     * @return The      waitlistRank
     */
    public Integer getWaitlistRank() {
        return waitlistRank;
    }

    /**
     * Sets waitlist rank.
     *
     * @param waitlistRank The waitlistRank
     */
    public void setWaitlistRank(Integer waitlistRank) {
        this.waitlistRank = waitlistRank;
    }

    /**
     * Gets waitlist lookup method.
     *
     * @return The      waitlistLookupMethod
     */
    public Object getWaitlistLookupMethod() {
        return waitlistLookupMethod;
    }

    /**
     * Sets waitlist lookup method.
     *
     * @param waitlistLookupMethod The waitlistLookupMethod
     */
    public void setWaitlistLookupMethod(Object waitlistLookupMethod) {
        this.waitlistLookupMethod = waitlistLookupMethod;
    }

    /**
     * Gets times.
     *
     * @return The      times
     */
    public List<Time> getTimes() {
        return times;
    }

    /**
     * Sets times.
     *
     * @param times The times
     */
    public void setTimes(List<Time> times) {
        this.times = times;
    }

    /**
     * Gets display time.
     *
     * @return The      displayTime
     */
    public String getDisplayTime() {
        return displayTime;
    }

    /**
     * Sets display time.
     *
     * @param displayTime The displayTime
     */
    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    /**
     * Gets action.
     *
     * @return The      action
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Gets full.
     *
     * @return The      full
     */
    public Boolean getFull() {
        return full;
    }

    /**
     * Sets full.
     *
     * @param full The full
     */
    public void setFull(Boolean full) {
        this.full = full;
    }

    /**
     * Gets enrollment control full.
     *
     * @return The      enrollmentControlFull
     */
    public Boolean getEnrollmentControlFull() {
        return enrollmentControlFull;
    }

    /**
     * Sets enrollment control full.
     *
     * @param enrollmentControlFull The enrollmentControlFull
     */
    public void setEnrollmentControlFull(Boolean enrollmentControlFull) {
        this.enrollmentControlFull = enrollmentControlFull;
    }

    /**
     * Gets enrollment control missing.
     *
     * @return The      enrollmentControlMissing
     */
    public Boolean getEnrollmentControlMissing() {
        return enrollmentControlMissing;
    }

    /**
     * Sets enrollment control missing.
     *
     * @param enrollmentControlMissing The enrollmentControlMissing
     */
    public void setEnrollmentControlMissing(Boolean enrollmentControlMissing) {
        this.enrollmentControlMissing = enrollmentControlMissing;
    }

    /**
     * Gets delivery mode.
     *
     * @return The      deliveryMode
     */
    public String getDeliveryMode() {
        return deliveryMode;
    }

    /**
     * Sets delivery mode.
     *
     * @param deliveryMode The deliveryMode
     */
    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    /**
     * Gets waitlistable for all.
     *
     * @return The      waitlistableForAll
     */
    public Boolean getWaitlistableForAll() {
        return waitlistableForAll;
    }

    /**
     * Sets waitlistable for all.
     *
     * @param waitlistableForAll The waitlistableForAll
     */
    public void setWaitlistableForAll(Boolean waitlistableForAll) {
        this.waitlistableForAll = waitlistableForAll;
    }

    /**
     * Gets message.
     *
     * @return The      message
     */
    public Object getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message The message
     */
    public void setMessage(Object message) {
        this.message = message;
    }

    /**
     * Gets professor approval req.
     *
     * @return The      professorApprovalReq
     */
    public String getProfessorApprovalReq() {
        return professorApprovalReq;
    }

    /**
     * Sets professor approval req.
     *
     * @param professorApprovalReq The professorApprovalReq
     */
    public void setProfessorApprovalReq(String professorApprovalReq) {
        this.professorApprovalReq = professorApprovalReq;
    }

    /**
     * Gets meeting resources.
     *
     * @return The      meetingResources
     */
    public List<MeetingResource> getMeetingResources() {
        return meetingResources;
    }

    /**
     * Sets meeting resources.
     *
     * @param meetingResources The meetingResources
     */
    public void setMeetingResources(List<MeetingResource> meetingResources) {
        this.meetingResources = meetingResources;
    }

    /**
     * Gets display name.
     *
     * @return The      displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets display name.
     *
     * @param displayName The displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets sub title.
     *
     * @return The      subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * Sets sub title.
     *
     * @param subTitle The subTitle
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * Gets has sub title.
     *
     * @return The      hasSubTitle
     */
    public Boolean getHasSubTitle() {
        return hasSubTitle;
    }

    /**
     * Sets has sub title.
     *
     * @param hasSubTitle The hasSubTitle
     */
    public void setHasSubTitle(Boolean hasSubTitle) {
        this.hasSubTitle = hasSubTitle;
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
