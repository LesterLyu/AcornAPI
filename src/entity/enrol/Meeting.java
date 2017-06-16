
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
     * 
     * @return
     *     The sectionNo
     */
    public String getSectionNo() {
        return sectionNo;
    }

    /**
     * 
     * @param sectionNo
     *     The sectionNo
     */
    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    /**
     * 
     * @return
     *     The sessionCode
     */
    public String getSessionCode() {
        return sessionCode;
    }

    /**
     * 
     * @param sessionCode
     *     The sessionCode
     */
    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    /**
     * 
     * @return
     *     The teachMethod
     */
    public String getTeachMethod() {
        return teachMethod;
    }

    /**
     * 
     * @param teachMethod
     *     The teachMethod
     */
    public void setTeachMethod(String teachMethod) {
        this.teachMethod = teachMethod;
    }

    /**
     * 
     * @return
     *     The enrollSpace
     */
    public Integer getEnrollSpace() {
        return enrollSpace;
    }

    /**
     * 
     * @param enrollSpace
     *     The enrollSpace
     */
    public void setEnrollSpace(Integer enrollSpace) {
        this.enrollSpace = enrollSpace;
    }

    /**
     * 
     * @return
     *     The enrollmentSpaceAvailable
     */
    public Integer getEnrollmentSpaceAvailable() {
        return enrollmentSpaceAvailable;
    }

    /**
     * 
     * @param enrollmentSpaceAvailable
     *     The enrollmentSpaceAvailable
     */
    public void setEnrollmentSpaceAvailable(Integer enrollmentSpaceAvailable) {
        this.enrollmentSpaceAvailable = enrollmentSpaceAvailable;
    }

    /**
     * 
     * @return
     *     The totalSpace
     */
    public Integer getTotalSpace() {
        return totalSpace;
    }

    /**
     * 
     * @param totalSpace
     *     The totalSpace
     */
    public void setTotalSpace(Integer totalSpace) {
        this.totalSpace = totalSpace;
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
     *     The closed
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * 
     * @param closed
     *     The closed
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    /**
     * 
     * @return
     *     The waitlistable
     */
    public Boolean getWaitlistable() {
        return waitlistable;
    }

    /**
     * 
     * @param waitlistable
     *     The waitlistable
     */
    public void setWaitlistable(Boolean waitlistable) {
        this.waitlistable = waitlistable;
    }

    /**
     * 
     * @return
     *     The subTitle1
     */
    public String getSubTitle1() {
        return subTitle1;
    }

    /**
     * 
     * @param subTitle1
     *     The subTitle1
     */
    public void setSubTitle1(String subTitle1) {
        this.subTitle1 = subTitle1;
    }

    /**
     * 
     * @return
     *     The subTitle2
     */
    public String getSubTitle2() {
        return subTitle2;
    }

    /**
     * 
     * @param subTitle2
     *     The subTitle2
     */
    public void setSubTitle2(String subTitle2) {
        this.subTitle2 = subTitle2;
    }

    /**
     * 
     * @return
     *     The subTitle3
     */
    public String getSubTitle3() {
        return subTitle3;
    }

    /**
     * 
     * @param subTitle3
     *     The subTitle3
     */
    public void setSubTitle3(String subTitle3) {
        this.subTitle3 = subTitle3;
    }

    /**
     * 
     * @return
     *     The waitlistRank
     */
    public Integer getWaitlistRank() {
        return waitlistRank;
    }

    /**
     * 
     * @param waitlistRank
     *     The waitlistRank
     */
    public void setWaitlistRank(Integer waitlistRank) {
        this.waitlistRank = waitlistRank;
    }

    /**
     * 
     * @return
     *     The waitlistLookupMethod
     */
    public Object getWaitlistLookupMethod() {
        return waitlistLookupMethod;
    }

    /**
     * 
     * @param waitlistLookupMethod
     *     The waitlistLookupMethod
     */
    public void setWaitlistLookupMethod(Object waitlistLookupMethod) {
        this.waitlistLookupMethod = waitlistLookupMethod;
    }

    /**
     * 
     * @return
     *     The times
     */
    public List<Time> getTimes() {
        return times;
    }

    /**
     * 
     * @param times
     *     The times
     */
    public void setTimes(List<Time> times) {
        this.times = times;
    }

    /**
     * 
     * @return
     *     The displayTime
     */
    public String getDisplayTime() {
        return displayTime;
    }

    /**
     * 
     * @param displayTime
     *     The displayTime
     */
    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    /**
     * 
     * @return
     *     The action
     */
    public String getAction() {
        return action;
    }

    /**
     * 
     * @param action
     *     The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     * @return
     *     The full
     */
    public Boolean getFull() {
        return full;
    }

    /**
     * 
     * @param full
     *     The full
     */
    public void setFull(Boolean full) {
        this.full = full;
    }

    /**
     * 
     * @return
     *     The enrollmentControlFull
     */
    public Boolean getEnrollmentControlFull() {
        return enrollmentControlFull;
    }

    /**
     * 
     * @param enrollmentControlFull
     *     The enrollmentControlFull
     */
    public void setEnrollmentControlFull(Boolean enrollmentControlFull) {
        this.enrollmentControlFull = enrollmentControlFull;
    }

    /**
     * 
     * @return
     *     The enrollmentControlMissing
     */
    public Boolean getEnrollmentControlMissing() {
        return enrollmentControlMissing;
    }

    /**
     * 
     * @param enrollmentControlMissing
     *     The enrollmentControlMissing
     */
    public void setEnrollmentControlMissing(Boolean enrollmentControlMissing) {
        this.enrollmentControlMissing = enrollmentControlMissing;
    }

    /**
     * 
     * @return
     *     The deliveryMode
     */
    public String getDeliveryMode() {
        return deliveryMode;
    }

    /**
     * 
     * @param deliveryMode
     *     The deliveryMode
     */
    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    /**
     * 
     * @return
     *     The waitlistableForAll
     */
    public Boolean getWaitlistableForAll() {
        return waitlistableForAll;
    }

    /**
     * 
     * @param waitlistableForAll
     *     The waitlistableForAll
     */
    public void setWaitlistableForAll(Boolean waitlistableForAll) {
        this.waitlistableForAll = waitlistableForAll;
    }

    /**
     * 
     * @return
     *     The message
     */
    public Object getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(Object message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The professorApprovalReq
     */
    public String getProfessorApprovalReq() {
        return professorApprovalReq;
    }

    /**
     * 
     * @param professorApprovalReq
     *     The professorApprovalReq
     */
    public void setProfessorApprovalReq(String professorApprovalReq) {
        this.professorApprovalReq = professorApprovalReq;
    }

    /**
     * 
     * @return
     *     The meetingResources
     */
    public List<MeetingResource> getMeetingResources() {
        return meetingResources;
    }

    /**
     * 
     * @param meetingResources
     *     The meetingResources
     */
    public void setMeetingResources(List<MeetingResource> meetingResources) {
        this.meetingResources = meetingResources;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 
     * @param subTitle
     *     The subTitle
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 
     * @return
     *     The hasSubTitle
     */
    public Boolean getHasSubTitle() {
        return hasSubTitle;
    }

    /**
     * 
     * @param hasSubTitle
     *     The hasSubTitle
     */
    public void setHasSubTitle(Boolean hasSubTitle) {
        this.hasSubTitle = hasSubTitle;
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
