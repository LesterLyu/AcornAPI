
package entity.enrol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MeetingResource {

    @SerializedName("sessionCode")
    @Expose
    private String sessionCode;
    @SerializedName("activityCode")
    @Expose
    private String activityCode;
    @SerializedName("sectionCode")
    @Expose
    private String sectionCode;
    @SerializedName("teachMethod")
    @Expose
    private String teachMethod;
    @SerializedName("sectionNumber")
    @Expose
    private String sectionNumber;
    @SerializedName("sequence")
    @Expose
    private Integer sequence;
    @SerializedName("instructorOrgUnit")
    @Expose
    private Object instructorOrgUnit;
    @SerializedName("teachPercent")
    @Expose
    private Object teachPercent;
    @SerializedName("employeeNumber")
    @Expose
    private Object employeeNumber;
    @SerializedName("logCounter")
    @Expose
    private Integer logCounter;
    @SerializedName("employeeType")
    @Expose
    private Object employeeType;
    @SerializedName("instructorSurname")
    @Expose
    private String instructorSurname;
    @SerializedName("instructorFirstName")
    @Expose
    private String instructorFirstName;
    @SerializedName("instructorInitials")
    @Expose
    private String instructorInitials;

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
     *     The activityCode
     */
    public String getActivityCode() {
        return activityCode;
    }

    /**
     * 
     * @param activityCode
     *     The activityCode
     */
    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
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
     *     The sectionNumber
     */
    public String getSectionNumber() {
        return sectionNumber;
    }

    /**
     * 
     * @param sectionNumber
     *     The sectionNumber
     */
    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    /**
     * 
     * @return
     *     The sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 
     * @param sequence
     *     The sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 
     * @return
     *     The instructorOrgUnit
     */
    public Object getInstructorOrgUnit() {
        return instructorOrgUnit;
    }

    /**
     * 
     * @param instructorOrgUnit
     *     The instructorOrgUnit
     */
    public void setInstructorOrgUnit(Object instructorOrgUnit) {
        this.instructorOrgUnit = instructorOrgUnit;
    }

    /**
     * 
     * @return
     *     The teachPercent
     */
    public Object getTeachPercent() {
        return teachPercent;
    }

    /**
     * 
     * @param teachPercent
     *     The teachPercent
     */
    public void setTeachPercent(Object teachPercent) {
        this.teachPercent = teachPercent;
    }

    /**
     * 
     * @return
     *     The employeeNumber
     */
    public Object getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 
     * @param employeeNumber
     *     The employeeNumber
     */
    public void setEmployeeNumber(Object employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 
     * @return
     *     The logCounter
     */
    public Integer getLogCounter() {
        return logCounter;
    }

    /**
     * 
     * @param logCounter
     *     The logCounter
     */
    public void setLogCounter(Integer logCounter) {
        this.logCounter = logCounter;
    }

    /**
     * 
     * @return
     *     The employeeType
     */
    public Object getEmployeeType() {
        return employeeType;
    }

    /**
     * 
     * @param employeeType
     *     The employeeType
     */
    public void setEmployeeType(Object employeeType) {
        this.employeeType = employeeType;
    }

    /**
     * 
     * @return
     *     The instructorSurname
     */
    public String getInstructorSurname() {
        return instructorSurname;
    }

    /**
     * 
     * @param instructorSurname
     *     The instructorSurname
     */
    public void setInstructorSurname(String instructorSurname) {
        this.instructorSurname = instructorSurname;
    }

    /**
     * 
     * @return
     *     The instructorFirstName
     */
    public String getInstructorFirstName() {
        return instructorFirstName;
    }

    /**
     * 
     * @param instructorFirstName
     *     The instructorFirstName
     */
    public void setInstructorFirstName(String instructorFirstName) {
        this.instructorFirstName = instructorFirstName;
    }

    /**
     * 
     * @return
     *     The instructorInitials
     */
    public String getInstructorInitials() {
        return instructorInitials;
    }

    /**
     * 
     * @param instructorInitials
     *     The instructorInitials
     */
    public void setInstructorInitials(String instructorInitials) {
        this.instructorInitials = instructorInitials;
    }

}
