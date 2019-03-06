package com.xkcoding.scaffold.util;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 根据 IP 进行地理位置转换
 * </p>
 *
 * @package: com.xkcoding.scaffold.util
 * @description： 根据 IP 进行地理位置转换
 * @author: yangkai.shen
 * @date: Created in 2018/8/9 下午4:46
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class Ip2AddressUtil {

    /**
     * 淘宝在线 IP 地址库
     */
    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    /**
     * 利用 ip2region 库进行 IP 地理位置转换
     *
     * @param ip IP地址
     * @return 地址信息
     */
    public static String getAddressInLocal(String ip) {
        if (StrUtil.equals(ip, IpUtil.LOCAL_INNER_LOOP_IP)) {
            ip = IpUtil.LOCAL_IP;
        }
        String address = "";
        boolean ipAddress = Util.isIpAddress(ip);
        if (!ipAddress) {
            return address;
        }
        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, ResourceUtil.getResource("ip/ip2region.db").getFile());
            DataBlock dataBlock = searcher.memorySearch(ip);

            // dataBlock格式：城市Id|国家|区域|省份|城市|ISP
            // region格式：国家|区域|省份|城市|ISP
            // region例如：中国|0|浙江省|杭州市|电信
            String region = dataBlock.getRegion();

            // 按 | 切分
            List<String> regionList = Splitter.on("|").splitToList(region);
            // 过滤为 0 的数据
            List<String> regionListFilter = regionList.stream()
                    .filter(s -> !StrUtil.equals("0", s))
                    .distinct()
                    .collect(Collectors.toList());
            // 再用 | 拼接回来
            address = Joiner.on("|").join(regionListFilter);
        } catch (Exception e) {
            log.error("【获取地理位置】发生异常:", e);
        }
        return address;
    }

    /**
     * 利用淘宝在线 ip 地址库进行 IP 地理位置转换
     *
     * @param ip IP地址
     * @return 地址信息
     */
    public static String getAddressOnNetByTaoBao(String ip) {
        String address = "";
        try {
            // 发请求
            Map<String, Object> params = Maps.newHashMap();
            params.put("ip", ip);
            String ret = HttpUtil.get(IP_URL, params, 2000);

            JSONObject json = JSONUtil.parseObj(ret);
            Integer code = json.getInt("code");
            if (ObjectUtil.equal(code, 0)) {
                JSONObject data = json.getJSONObject("data");
                // 国家|区域|省份|城市|ISP
                String country = data.getStr("country");
                String area = data.getStr("area");
                String region = data.getStr("region");
                String city = data.getStr("city");
                String isp = data.getStr("isp");

                List<String> addressInfo = Lists.newArrayList(country, area, region, city, isp);
                // 过滤为 XX 以及为空的数据
                List<String> addressInfoFilter = addressInfo.stream()
                        .filter(s -> StrUtil.isNotBlank(s) && !StrUtil.equals("XX", s))
                        .distinct()
                        .collect(Collectors.toList());
                // 用 | 拼接回来
                address = Joiner.on("|").join(addressInfoFilter);
            }
        } catch (Exception e) {
            log.error("【获取地理位置】发生异常:", e);
        }
        return address;
    }
}
