
package entity.plan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Info {

    @SerializedName("primaryActivities")
    @Expose
    private List<Activity> primaryActivities = new ArrayList<Activity>();
    @SerializedName("secondaryActivities")
    @Expose
    private List<Activity> secondaryActivities = new ArrayList<Activity>();
    @SerializedName("thirdActivities")
    @Expose
    private List<Activity> thirdActivities = new ArrayList<Activity>();

    /**
     * 
     * @return
     *     The primaryActivities
     */
    public List<Activity> getPrimaryActivities() {
        return primaryActivities;
    }

    /**
     * 
     * @param primaryActivities
     *     The primaryActivities
     */
    public void setPrimaryActivities(List<Activity> primaryActivities) {
        this.primaryActivities = primaryActivities;
    }

    /**
     * 
     * @return
     *     The secondaryActivities
     */
    public List<Activity> getSecondaryActivities() {
        return secondaryActivities;
    }

    /**
     * 
     * @param secondaryActivities
     *     The secondaryActivities
     */
    public void setSecondaryActivities(List<Activity> secondaryActivities) {
        this.secondaryActivities = secondaryActivities;
    }

    /**
     * 
     * @return
     *     The thirdActivities
     */
    public List<Activity> getThirdActivities() {
        return thirdActivities;
    }

    /**
     * 
     * @param thirdActivities
     *     The thirdActivities
     */
    public void setThirdActivities(List<Activity> thirdActivities) {
        this.thirdActivities = thirdActivities;
    }

}
