import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: snowxuyu
 * Date: 2017/3/15
 * Time: 21:57
 */
@Data
public class City implements Serializable {
    private String cityName;
    private List<District> districtList;

    public void addDistrict(List<District> district) {
        for (District d : district) {
            districtList.add(d);
        }
    }

    public City(String cityName, List<District> districtList) {
        this.cityName = cityName;
        this.districtList = districtList;
    }
}
