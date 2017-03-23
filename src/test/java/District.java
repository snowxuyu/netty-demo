import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: snowxuyu
 * Date: 2017/3/15
 * Time: 21:59
 */
@Data
public class District implements Serializable{
    private String districtName;
    private List<Detail> detailList;

    public void addDetail(List<Detail> detail) {
        for (Detail d : detail) {
            detailList.add(d);
        }
    }

    public District(String districtName, List<Detail> detailList) {
        this.districtName = districtName;
        this.detailList = detailList;
    }
}
