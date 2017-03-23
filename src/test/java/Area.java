import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: snowxuyu
 * Date: 2017/3/15
 * Time: 21:49
 */
@Data
public class Area implements Serializable {

    private String prvoince;
    private String city;
    private String district;
    private String address;

    public Area(String prvoince, String city, String district, String address) {
        this.prvoince = prvoince;
        this.city = city;
        this.district = district;
        this.address = address;
    }
}
