
package entity.plan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    @SerializedName("sectionNo")
    @Expose
    private String sectionNo;
    @SerializedName("teachMethod")
    @Expose
    private String teachMethod;
    @SerializedName("activityId")
    @Expose
    private String activityId;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("spaceTotal")
    @Expose
    private String spaceTotal;
    @SerializedName("spaceLeft")
    @Expose
    private String spaceLeft;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("waitlistable")
    @Expose
    private String waitlistable;
    @SerializedName("joinedActivity")
    @Expose
    private String joinedActivity;
    @SerializedName("checkedStatus")
    @Expose
    private String checkedStatus;
    @SerializedName("enroled")
    @Expose
    private String enroled;
    @SerializedName("commaSeparatedInstructorNames")
    @Expose
    private String commaSeparatedInstructorNames;
    @SerializedName("subTitle")
    @Expose
    private String subTitle;
    @SerializedName("hasSubTitle")
    @Expose
    private Boolean hasSubTitle;
    @SerializedName("days")
    @Expose
    private List<Day> days = new ArrayList<Day>();
    @SerializedName("enrolledInAllActivities")
    @Expose
    private String enrolledInAllActivities;
    @SerializedName("readOnlyMode")
    @Expose
    private String readOnlyMode;
    @SerializedName("formName")
    @Expose
    private String formName;
    @SerializedName("waitlistRank")
    @Expose
    private String waitlistRank;
    @SerializedName("classTotal")
    @Expose
    private String classTotal;
    @SerializedName("waitlistLookupMethod")
    @Expose
    private Object waitlistLookupMethod;
    @SerializedName("waitlistableForAll")
    @Expose
    private String waitlistableForAll;

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
     *     The activityId
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * 
     * @param activityId
     *     The activityId
     */
    public void setActivityId(String activityId) {
        this.activityId = activityId;
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
     *     The spaceTotal
     */
    public String getSpaceTotal() {
        return spaceTotal;
    }

    /**
     * 
     * @param spaceTotal
     *     The spaceTotal
     */
    public void setSpaceTotal(String spaceTotal) {
        this.spaceTotal = spaceTotal;
    }

    /**
     * 
     * @return
     *     The spaceLeft
     */
    public String getSpaceLeft() {
        return spaceLeft;
    }

    /**
     * 
     * @param spaceLeft
     *     The spaceLeft
     */
    public void setSpaceLeft(String spaceLeft) {
        this.spaceLeft = spaceLeft;
    }

    /**
     * 
     * @return
     *     The note
     */
    public String getNote() {
        return note;
    }

    /**
     * 
     * @param note
     *     The note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 
     * @return
     *     The waitlistable
     */
    public String getWaitlistable() {
        return waitlistable;
    }

    /**
     * 
     * @param waitlistable
     *     The waitlistable
     */
    public void setWaitlistable(String waitlistable) {
        this.waitlistable = waitlistable;
    }

    /**
     * 
     * @return
     *     The joinedActivity
     */
    public String getJoinedActivity() {
        return joinedActivity;
    }

    /**
     * 
     * @param joinedActivity
     *     The joinedActivity
     */
    public void setJoinedActivity(String joinedActivity) {
        this.joinedActivity = joinedActivity;
    }

    /**
     * 
     * @return
     *     The checkedStatus
     */
    public String getCheckedStatus() {
        return checkedStatus;
    }

    /**
     * 
     * @param checkedStatus
     *     The checkedStatus
     */
    public void setCheckedStatus(String checkedStatus) {
        this.checkedStatus = checkedStatus;
    }

    /**
     * 
     * @return
     *     The enroled
     */
    public String getEnroled() {
        return enroled;
    }

    /**
     * 
     * @param enroled
     *     The enroled
     */
    public void setEnroled(String enroled) {
        this.enroled = enroled;
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
     *     The days
     */
    public List<Day> getDays() {
        return days;
    }

    /**
     * 
     * @param days
     *     The days
     */
    public void setDays(List<Day> days) {
        this.days = days;
    }

    /**
     * 
     * @return
     *     The enrolledInAllActivities
     */
    public String getEnrolledInAllActivities() {
        return enrolledInAllActivities;
    }

    /**
     * 
     * @param enrolledInAllActivities
     *     The enrolledInAllActivities
     */
    public void setEnrolledInAllActivities(String enrolledInAllActivities) {
        this.enrolledInAllActivities = enrolledInAllActivities;
    }

    /**
     * 
     * @return
     *     The readOnlyMode
     */
    public String getReadOnlyMode() {
        return readOnlyMode;
    }

    /**
     * 
     * @param readOnlyMode
     *     The readOnlyMode
     */
    public void setReadOnlyMode(String readOnlyMode) {
        this.readOnlyMode = readOnlyMode;
    }

    /**
     * 
     * @return
     *     The formName
     */
    public String getFormName() {
        return formName;
    }

    /**
     * 
     * @param formName
     *     The formName
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }

    /**
     * 
     * @return
     *     The waitlistRank
     */
    public String getWaitlistRank() {
        return waitlistRank;
    }

    /**
     * 
     * @param waitlistRank
     *     The waitlistRank
     */
    public void setWaitlistRank(String waitlistRank) {
        this.waitlistRank = waitlistRank;
    }

    /**
     * 
     * @return
     *     The classTotal
     */
    public String getClassTotal() {
        return classTotal;
    }

    /**
     * 
     * @param classTotal
     *     The classTotal
     */
    public void setClassTotal(String classTotal) {
        this.classTotal = classTotal;
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
     *     The waitlistableForAll
     */
    public String getWaitlistableForAll() {
        return waitlistableForAll;
    }

    /**
     * 
     * @param waitlistableForAll
     *     The waitlistableForAll
     */
    public void setWaitlistableForAll(String waitlistableForAll) {
        this.waitlistableForAll = waitlistableForAll;
    }

}
