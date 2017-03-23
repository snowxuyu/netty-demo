import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: snowxuyu
 * Date: 2017/3/15
 * Time: 21:58
 */
@Data
public class Detail implements Serializable {
    private String address;

    public Detail(String address) {
        this.address = address;
    }
}
