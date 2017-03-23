import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: snowxuyu
 * Date: 2017/3/15
 * Time: 21:50
 */
public class Test {

    public static void main(String[] args){
        List<Area> areaList = new ArrayList<Area>();
        areaList.add(new Area("江苏省", "南京市", "玄武区", "新模范马路1001号"));
        areaList.add(new Area("江苏省", "南京市", "秦淮区", "雨花台路30号"));
        areaList.add(new Area("江苏省", "南京市", "鼓楼区", "中山1路1号"));
        areaList.add(new Area("湖南省", "长沙市", "芙蓉区", "橘子洲"));
        areaList.add(new Area("湖南省", "长沙市", "下沙区", "宝昌路32号"));
        areaList.add(new Area("江苏省", "徐州市", "云龙区", "云龙大道22号"));
        areaList.add(new Area("江苏省", "徐州市", "铜山区", "上海路45号"));


        //
        covertData(areaList);

    }
    private static void covertData(List<Area> areaList) {
        Map<String, City> cityMap = new HashMap<>();
        Map<String, District> districtMap = new HashMap<>();
        areaList.stream().forEach(item -> {
            Detail detail = new Detail(item.getAddress());
            List<Detail> details = new ArrayList<>();
            details.add(detail);
            if (districtMap.containsKey(item.getDistrict())) {
                //如果区名称已经存在，更新区下面的详细地址
                districtMap.get(item.getDistrict()).addDetail(details);
            } else {
                //如果区名称不存在，就创建这个区并且加入map
                District district = new District(item.getDistrict(), details);
                List<District> districtList = new ArrayList<>();
                districtList.add(district);
                districtMap.put(item.getDistrict(), district);

                if (cityMap.containsKey(item.getCity())) {
                    //如果city存在，更新city下面的区
                    cityMap.get(item.getCity()).addDistrict(districtList);
                } else {
                    //如果city名称不存在，就创建这个city并加入map
                    City city = new City(item.getCity(), districtList);
                    cityMap.put(item.getCity(), city);
                }

            }

        });
        System.out.println(JSONObject.toJSONString(cityMap));
    }

}
