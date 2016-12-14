/**
 * Created by Naresh on 14-12-2016.
 */

package naresh.json_dname;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pojo {

    @SerializedName("sampleJson")
    @Expose
    private List<SampleJson> sampleJson = null;

    /**
     *
     * @return
     * The sampleJson
     */
    public List<SampleJson> getSampleJson() {
        return sampleJson;
    }

    /**
     *
     * @param sampleJson
     * The sampleJson
     */
    public void setSampleJson(List<SampleJson> sampleJson) {
        this.sampleJson = sampleJson;
    }

}