/**
 * Enrolled courses are the courses enrolled or waitlisted in Acorn
 */
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class EnrolledCourse {

	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("sectionCode")
	@Expose
	private String sectionCode;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("primaryTeachMethod")
	@Expose
	private String primaryTeachMethod;
	@SerializedName("secondaryTeachMethod1")
	@Expose
	private String secondaryTeachMethod1;
	@SerializedName("secondaryTeachMethod2")
	@Expose
	private String secondaryTeachMethod2;
	@SerializedName("primarySectionNo")
	@Expose
	private String primarySectionNo;
	@SerializedName("secondarySectionNo1")
	@Expose
	private String secondarySectionNo1;
	@SerializedName("secondarySectionNo2")
	@Expose
	private String secondarySectionNo2;
	@SerializedName("deliveryMode")
	@Expose
	private String deliveryMode;
	@SerializedName("waitlistTeachMethod")
	@Expose
	private String waitlistTeachMethod;
	@SerializedName("waitlistSectionNo")
	@Expose
	private String waitlistSectionNo;
	@SerializedName("waitlistMeetings")
	@Expose
	private String waitlistMeetings;
	@SerializedName("meetings")
	@Expose
	private List<Meeting> meetings = new ArrayList<Meeting>();
	@SerializedName("enroled")
	@Expose
	private Boolean enroled;
	@SerializedName("attendanceStatus")
	@Expose
	private String attendanceStatus;
	@SerializedName("sessionCode")
	@Expose
	private String sessionCode;
	@SerializedName("courseCredits")
	@Expose
	private String courseCredits;
	@SerializedName("markApprovedDate")
	@Expose
	private Long markApprovedDate;
	@SerializedName("mark")
	@Expose
	private String mark;
	@SerializedName("regApprovedDate")
	@Expose
	private Object regApprovedDate;
	@SerializedName("regApprovedTime")
	@Expose
	private Object regApprovedTime;
	@SerializedName("subSessionCode")
	@Expose
	private String subSessionCode;
	@SerializedName("currentCncCreditsBalance")
	@Expose
	private Object currentCncCreditsBalance;
	@SerializedName("cncAllowed")
	@Expose
	private String cncAllowed;
	@SerializedName("postCode")
	@Expose
	private Object postCode;
	@SerializedName("activityPrimaryOrgCode")
	@Expose
	private Object activityPrimaryOrgCode;
	@SerializedName("activitySecondaryOrgCode")
	@Expose
	private Object activitySecondaryOrgCode;
	@SerializedName("activityCoSecondaryOrgCode")
	@Expose
	private Object activityCoSecondaryOrgCode;
	@SerializedName("courseStatusIfEnroling")
	@Expose
	private Object courseStatusIfEnroling;
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
	@SerializedName("enrolmentErrorCode")
	@Expose
	private Integer enrolmentErrorCode;
	@SerializedName("enrolmentErrorMessage")
	@Expose
	private Object enrolmentErrorMessage;
	@SerializedName("enrolEnded")
	@Expose
	private Boolean enrolEnded;
	@SerializedName("enrolNotStarted")
	@Expose
	private Boolean enrolNotStarted;
	@SerializedName("retrieveCancelledCourses")
	@Expose
	private Boolean retrieveCancelledCourses;
	@SerializedName("displayName")
	@Expose
	private String displayName;
	@SerializedName("meetingList")
	@Expose
	private List<String> meetingList = new ArrayList<String>();
	@SerializedName("waitlistable")
	@Expose
	private Boolean waitlistable;
	@SerializedName("approved")
	@Expose
	private Boolean approved;
	@SerializedName("dropped")
	@Expose
	private Boolean dropped;
	@SerializedName("refused")
	@Expose
	private Boolean refused;
	@SerializedName("requested")
	@Expose
	private Boolean requested;
	@SerializedName("interim")
	@Expose
	private Boolean interim;
	@SerializedName("waitlisted")
	@Expose
	private Boolean waitlisted;
	@SerializedName("enroledInPrimary")
	@Expose
	private Boolean enroledInPrimary;
	@SerializedName("enroledInSecondary1")
	@Expose
	private Boolean enroledInSecondary1;
	@SerializedName("enroledInSecondary2")
	@Expose
	private Boolean enroledInSecondary2;
	@SerializedName("isEligibleForCnc")
	@Expose
	private Boolean isEligibleForCnc;
	@SerializedName("isWithinSessionalDatesForCnc")
	@Expose
	private Boolean isWithinSessionalDatesForCnc;
	@SerializedName("enroledInAll")
	@Expose
	private Boolean enroledInAll;
	@SerializedName("enroledMeetingSections")
	@Expose
	private List<String> enroledMeetingSections = new ArrayList<String>();
	@SerializedName("teachMethods")
	@Expose
	private List<String> teachMethods = new ArrayList<String>();
	@SerializedName("secondaryTeachMethods")
	@Expose
	private List<Object> secondaryTeachMethods = new ArrayList<Object>();
	@SerializedName("deliveryModeDisplay")
	@Expose
	private String deliveryModeDisplay;

	@Override
	public String toString() {
		String waitList = ", wl: ";
		if(meetings != null && status.equals("WAIT")){
			for(Meeting meeting: meetings){
				if(waitlistMeetings.contains(meeting.getSectionNo()))
					waitList += meeting.getDisplayName() + ": " + meeting.getWaitlistRank() + ", ";
			}
			waitList = waitList.substring(0, waitList.length() - 2);
		}
		else
			waitList = "";
		return  "[" + code + sectionCode + ", " + sessionCode + " to " + regSessionCode2 + ", " + status + waitList + "]";
	}

	/**
	 * 
	 * @return
	 *     The code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 *     The code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 *     The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *     The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return
	 *     The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *     The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 *     The primaryTeachMethod
	 */
	public String getPrimaryTeachMethod() {
		return primaryTeachMethod;
	}

	/**
	 * 
	 * @param primaryTeachMethod
	 *     The primaryTeachMethod
	 */
	public void setPrimaryTeachMethod(String primaryTeachMethod) {
		this.primaryTeachMethod = primaryTeachMethod;
	}

	/**
	 * 
	 * @return
	 *     The secondaryTeachMethod1
	 */
	public String getSecondaryTeachMethod1() {
		return secondaryTeachMethod1;
	}

	/**
	 * 
	 * @param secondaryTeachMethod1
	 *     The secondaryTeachMethod1
	 */
	public void setSecondaryTeachMethod1(String secondaryTeachMethod1) {
		this.secondaryTeachMethod1 = secondaryTeachMethod1;
	}

	/**
	 * 
	 * @return
	 *     The secondaryTeachMethod2
	 */
	public String getSecondaryTeachMethod2() {
		return secondaryTeachMethod2;
	}

	/**
	 * 
	 * @param secondaryTeachMethod2
	 *     The secondaryTeachMethod2
	 */
	public void setSecondaryTeachMethod2(String secondaryTeachMethod2) {
		this.secondaryTeachMethod2 = secondaryTeachMethod2;
	}

	/**
	 * 
	 * @return
	 *     The primarySectionNo
	 */
	public String getPrimarySectionNo() {
		return primarySectionNo;
	}

	/**
	 * 
	 * @param primarySectionNo
	 *     The primarySectionNo
	 */
	public void setPrimarySectionNo(String primarySectionNo) {
		this.primarySectionNo = primarySectionNo;
	}

	/**
	 * 
	 * @return
	 *     The secondarySectionNo1
	 */
	public String getSecondarySectionNo1() {
		return secondarySectionNo1;
	}

	/**
	 * 
	 * @param secondarySectionNo1
	 *     The secondarySectionNo1
	 */
	public void setSecondarySectionNo1(String secondarySectionNo1) {
		this.secondarySectionNo1 = secondarySectionNo1;
	}

	/**
	 * 
	 * @return
	 *     The secondarySectionNo2
	 */
	public String getSecondarySectionNo2() {
		return secondarySectionNo2;
	}

	/**
	 * 
	 * @param secondarySectionNo2
	 *     The secondarySectionNo2
	 */
	public void setSecondarySectionNo2(String secondarySectionNo2) {
		this.secondarySectionNo2 = secondarySectionNo2;
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
	 *     The waitlistTeachMethod
	 */
	public String getWaitlistTeachMethod() {
		return waitlistTeachMethod;
	}

	/**
	 * 
	 * @param waitlistTeachMethod
	 *     The waitlistTeachMethod
	 */
	public void setWaitlistTeachMethod(String waitlistTeachMethod) {
		this.waitlistTeachMethod = waitlistTeachMethod;
	}

	/**
	 * 
	 * @return
	 *     The waitlistSectionNo
	 */
	public String getWaitlistSectionNo() {
		return waitlistSectionNo;
	}

	/**
	 * 
	 * @param waitlistSectionNo
	 *     The waitlistSectionNo
	 */
	public void setWaitlistSectionNo(String waitlistSectionNo) {
		this.waitlistSectionNo = waitlistSectionNo;
	}

	/**
	 * 
	 * @return
	 *     The waitlistMeetings
	 */
	public Object getWaitlistMeetings() {
		return waitlistMeetings;
	}

	/**
	 * 
	 * @param waitlistMeetings
	 *     The waitlistMeetings
	 */
	public void setWaitlistMeetings(String waitlistMeetings) {
		this.waitlistMeetings = waitlistMeetings;
	}

	/**
	 * 
	 * @return
	 *     The meetings
	 */
	public List<Meeting> getMeetings() {
		return meetings;
	}

	/**
	 * 
	 * @param meetings
	 *     The meetings
	 */
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	/**
	 * 
	 * @return
	 *     The enroled
	 */
	public Boolean getEnroled() {
		return enroled;
	}

	/**
	 * 
	 * @param enroled
	 *     The enroled
	 */
	public void setEnroled(Boolean enroled) {
		this.enroled = enroled;
	}

	/**
	 * 
	 * @return
	 *     The attendanceStatus
	 */
	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	/**
	 * 
	 * @param attendanceStatus
	 *     The attendanceStatus
	 */
	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
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
	 *     The courseCredits
	 */
	public String getCourseCredits() {
		return courseCredits;
	}

	/**
	 * 
	 * @param courseCredits
	 *     The courseCredits
	 */
	public void setCourseCredits(String courseCredits) {
		this.courseCredits = courseCredits;
	}

	/**
	 * 
	 * @return
	 *     The markApprovedDate
	 */
	public Long getMarkApprovedDate() {
		return markApprovedDate;
	}

	/**
	 * 
	 * @param markApprovedDate
	 *     The markApprovedDate
	 */
	public void setMarkApprovedDate(Long markApprovedDate) {
		this.markApprovedDate = markApprovedDate;
	}

	/**
	 * 
	 * @return
	 *     The mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * 
	 * @param mark
	 *     The mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * 
	 * @return
	 *     The regApprovedDate
	 */
	public Object getRegApprovedDate() {
		return regApprovedDate;
	}

	/**
	 * 
	 * @param regApprovedDate
	 *     The regApprovedDate
	 */
	public void setRegApprovedDate(Object regApprovedDate) {
		this.regApprovedDate = regApprovedDate;
	}

	/**
	 * 
	 * @return
	 *     The regApprovedTime
	 */
	public Object getRegApprovedTime() {
		return regApprovedTime;
	}

	/**
	 * 
	 * @param regApprovedTime
	 *     The regApprovedTime
	 */
	public void setRegApprovedTime(Object regApprovedTime) {
		this.regApprovedTime = regApprovedTime;
	}

	/**
	 * 
	 * @return
	 *     The subSessionCode
	 */
	public String getSubSessionCode() {
		return subSessionCode;
	}

	/**
	 * 
	 * @param subSessionCode
	 *     The subSessionCode
	 */
	public void setSubSessionCode(String subSessionCode) {
		this.subSessionCode = subSessionCode;
	}

	/**
	 * 
	 * @return
	 *     The currentCncCreditsBalance
	 */
	public Object getCurrentCncCreditsBalance() {
		return currentCncCreditsBalance;
	}

	/**
	 * 
	 * @param currentCncCreditsBalance
	 *     The currentCncCreditsBalance
	 */
	public void setCurrentCncCreditsBalance(Object currentCncCreditsBalance) {
		this.currentCncCreditsBalance = currentCncCreditsBalance;
	}

	/**
	 * 
	 * @return
	 *     The cncAllowed
	 */
	public String getCncAllowed() {
		return cncAllowed;
	}

	/**
	 * 
	 * @param cncAllowed
	 *     The cncAllowed
	 */
	public void setCncAllowed(String cncAllowed) {
		this.cncAllowed = cncAllowed;
	}

	/**
	 * 
	 * @return
	 *     The postCode
	 */
	public Object getPostCode() {
		return postCode;
	}

	/**
	 * 
	 * @param postCode
	 *     The postCode
	 */
	public void setPostCode(Object postCode) {
		this.postCode = postCode;
	}

	/**
	 * 
	 * @return
	 *     The activityPrimaryOrgCode
	 */
	public Object getActivityPrimaryOrgCode() {
		return activityPrimaryOrgCode;
	}

	/**
	 * 
	 * @param activityPrimaryOrgCode
	 *     The activityPrimaryOrgCode
	 */
	public void setActivityPrimaryOrgCode(Object activityPrimaryOrgCode) {
		this.activityPrimaryOrgCode = activityPrimaryOrgCode;
	}

	/**
	 * 
	 * @return
	 *     The activitySecondaryOrgCode
	 */
	public Object getActivitySecondaryOrgCode() {
		return activitySecondaryOrgCode;
	}

	/**
	 * 
	 * @param activitySecondaryOrgCode
	 *     The activitySecondaryOrgCode
	 */
	public void setActivitySecondaryOrgCode(Object activitySecondaryOrgCode) {
		this.activitySecondaryOrgCode = activitySecondaryOrgCode;
	}

	/**
	 * 
	 * @return
	 *     The activityCoSecondaryOrgCode
	 */
	public Object getActivityCoSecondaryOrgCode() {
		return activityCoSecondaryOrgCode;
	}

	/**
	 * 
	 * @param activityCoSecondaryOrgCode
	 *     The activityCoSecondaryOrgCode
	 */
	public void setActivityCoSecondaryOrgCode(Object activityCoSecondaryOrgCode) {
		this.activityCoSecondaryOrgCode = activityCoSecondaryOrgCode;
	}

	/**
	 * 
	 * @return
	 *     The courseStatusIfEnroling
	 */
	public Object getCourseStatusIfEnroling() {
		return courseStatusIfEnroling;
	}

	/**
	 * 
	 * @param courseStatusIfEnroling
	 *     The courseStatusIfEnroling
	 */
	public void setCourseStatusIfEnroling(Object courseStatusIfEnroling) {
		this.courseStatusIfEnroling = courseStatusIfEnroling;
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
	 *     The enrolmentErrorCode
	 */
	public Integer getEnrolmentErrorCode() {
		return enrolmentErrorCode;
	}

	/**
	 * 
	 * @param enrolmentErrorCode
	 *     The enrolmentErrorCode
	 */
	public void setEnrolmentErrorCode(Integer enrolmentErrorCode) {
		this.enrolmentErrorCode = enrolmentErrorCode;
	}

	/**
	 * 
	 * @return
	 *     The enrolmentErrorMessage
	 */
	public Object getEnrolmentErrorMessage() {
		return enrolmentErrorMessage;
	}

	/**
	 * 
	 * @param enrolmentErrorMessage
	 *     The enrolmentErrorMessage
	 */
	public void setEnrolmentErrorMessage(Object enrolmentErrorMessage) {
		this.enrolmentErrorMessage = enrolmentErrorMessage;
	}

	/**
	 * 
	 * @return
	 *     The enrolEnded
	 */
	public Boolean getEnrolEnded() {
		return enrolEnded;
	}

	/**
	 * 
	 * @param enrolEnded
	 *     The enrolEnded
	 */
	public void setEnrolEnded(Boolean enrolEnded) {
		this.enrolEnded = enrolEnded;
	}

	/**
	 * 
	 * @return
	 *     The enrolNotStarted
	 */
	public Boolean getEnrolNotStarted() {
		return enrolNotStarted;
	}

	/**
	 * 
	 * @param enrolNotStarted
	 *     The enrolNotStarted
	 */
	public void setEnrolNotStarted(Boolean enrolNotStarted) {
		this.enrolNotStarted = enrolNotStarted;
	}

	/**
	 * 
	 * @return
	 *     The retrieveCancelledCourses
	 */
	public Boolean getRetrieveCancelledCourses() {
		return retrieveCancelledCourses;
	}

	/**
	 * 
	 * @param retrieveCancelledCourses
	 *     The retrieveCancelledCourses
	 */
	public void setRetrieveCancelledCourses(Boolean retrieveCancelledCourses) {
		this.retrieveCancelledCourses = retrieveCancelledCourses;
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
	 *     The meetingList
	 */
	public List<String> getMeetingList() {
		return meetingList;
	}

	/**
	 * 
	 * @param meetingList
	 *     The meetingList
	 */
	public void setMeetingList(List<String> meetingList) {
		this.meetingList = meetingList;
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
	 *     The approved
	 */
	public Boolean getApproved() {
		return approved;
	}

	/**
	 * 
	 * @param approved
	 *     The approved
	 */
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	/**
	 * 
	 * @return
	 *     The dropped
	 */
	public Boolean getDropped() {
		return dropped;
	}

	/**
	 * 
	 * @param dropped
	 *     The dropped
	 */
	public void setDropped(Boolean dropped) {
		this.dropped = dropped;
	}

	/**
	 * 
	 * @return
	 *     The refused
	 */
	public Boolean getRefused() {
		return refused;
	}

	/**
	 * 
	 * @param refused
	 *     The refused
	 */
	public void setRefused(Boolean refused) {
		this.refused = refused;
	}

	/**
	 * 
	 * @return
	 *     The requested
	 */
	public Boolean getRequested() {
		return requested;
	}

	/**
	 * 
	 * @param requested
	 *     The requested
	 */
	public void setRequested(Boolean requested) {
		this.requested = requested;
	}

	/**
	 * 
	 * @return
	 *     The interim
	 */
	public Boolean getInterim() {
		return interim;
	}

	/**
	 * 
	 * @param interim
	 *     The interim
	 */
	public void setInterim(Boolean interim) {
		this.interim = interim;
	}

	/**
	 * 
	 * @return
	 *     The waitlisted
	 */
	public Boolean getWaitlisted() {
		return waitlisted;
	}

	/**
	 * 
	 * @param waitlisted
	 *     The waitlisted
	 */
	public void setWaitlisted(Boolean waitlisted) {
		this.waitlisted = waitlisted;
	}

	/**
	 * 
	 * @return
	 *     The enroledInPrimary
	 */
	public Boolean getEnroledInPrimary() {
		return enroledInPrimary;
	}

	/**
	 * 
	 * @param enroledInPrimary
	 *     The enroledInPrimary
	 */
	public void setEnroledInPrimary(Boolean enroledInPrimary) {
		this.enroledInPrimary = enroledInPrimary;
	}

	/**
	 * 
	 * @return
	 *     The enroledInSecondary1
	 */
	public Boolean getEnroledInSecondary1() {
		return enroledInSecondary1;
	}

	/**
	 * 
	 * @param enroledInSecondary1
	 *     The enroledInSecondary1
	 */
	public void setEnroledInSecondary1(Boolean enroledInSecondary1) {
		this.enroledInSecondary1 = enroledInSecondary1;
	}

	/**
	 * 
	 * @return
	 *     The enroledInSecondary2
	 */
	public Boolean getEnroledInSecondary2() {
		return enroledInSecondary2;
	}

	/**
	 * 
	 * @param enroledInSecondary2
	 *     The enroledInSecondary2
	 */
	public void setEnroledInSecondary2(Boolean enroledInSecondary2) {
		this.enroledInSecondary2 = enroledInSecondary2;
	}

	/**
	 * 
	 * @return
	 *     The isEligibleForCnc
	 */
	public Boolean getIsEligibleForCnc() {
		return isEligibleForCnc;
	}

	/**
	 * 
	 * @param isEligibleForCnc
	 *     The isEligibleForCnc
	 */
	public void setIsEligibleForCnc(Boolean isEligibleForCnc) {
		this.isEligibleForCnc = isEligibleForCnc;
	}

	/**
	 * 
	 * @return
	 *     The isWithinSessionalDatesForCnc
	 */
	public Boolean getIsWithinSessionalDatesForCnc() {
		return isWithinSessionalDatesForCnc;
	}

	/**
	 * 
	 * @param isWithinSessionalDatesForCnc
	 *     The isWithinSessionalDatesForCnc
	 */
	public void setIsWithinSessionalDatesForCnc(Boolean isWithinSessionalDatesForCnc) {
		this.isWithinSessionalDatesForCnc = isWithinSessionalDatesForCnc;
	}

	/**
	 * 
	 * @return
	 *     The enroledInAll
	 */
	public Boolean getEnroledInAll() {
		return enroledInAll;
	}

	/**
	 * 
	 * @param enroledInAll
	 *     The enroledInAll
	 */
	public void setEnroledInAll(Boolean enroledInAll) {
		this.enroledInAll = enroledInAll;
	}

	/**
	 * 
	 * @return
	 *     The enroledMeetingSections
	 */
	public List<String> getEnroledMeetingSections() {
		return enroledMeetingSections;
	}

	/**
	 * 
	 * @param enroledMeetingSections
	 *     The enroledMeetingSections
	 */
	public void setEnroledMeetingSections(List<String> enroledMeetingSections) {
		this.enroledMeetingSections = enroledMeetingSections;
	}

	/**
	 * 
	 * @return
	 *     The teachMethods
	 */
	public List<String> getTeachMethods() {
		return teachMethods;
	}

	/**
	 * 
	 * @param teachMethods
	 *     The teachMethods
	 */
	public void setTeachMethods(List<String> teachMethods) {
		this.teachMethods = teachMethods;
	}

	/**
	 * 
	 * @return
	 *     The secondaryTeachMethods
	 */
	public List<Object> getSecondaryTeachMethods() {
		return secondaryTeachMethods;
	}

	/**
	 * 
	 * @param secondaryTeachMethods
	 *     The secondaryTeachMethods
	 */
	public void setSecondaryTeachMethods(List<Object> secondaryTeachMethods) {
		this.secondaryTeachMethods = secondaryTeachMethods;
	}

	/**
	 * 
	 * @return
	 *     The deliveryModeDisplay
	 */
	public String getDeliveryModeDisplay() {
		return deliveryModeDisplay;
	}

	/**
	 * 
	 * @param deliveryModeDisplay
	 *     The deliveryModeDisplay
	 */
	public void setDeliveryModeDisplay(String deliveryModeDisplay) {
		this.deliveryModeDisplay = deliveryModeDisplay;
	}

}
