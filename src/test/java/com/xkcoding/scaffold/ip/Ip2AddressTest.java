package com.xkcoding.scaffold.ip;

import com.google.common.collect.Lists;
import com.xkcoding.scaffold.ScaffoldApplicationTests;
import com.xkcoding.scaffold.util.Ip2AddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * <p>
 * 测试 ip2region
 * </p>
 *
 * @package: com.xkcoding.scaffold.ip
 * @description： 测试 ip2region
 * @author: yangkai.shen
 * @date: Created in 2018/8/9 下午3:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class Ip2AddressTest extends ScaffoldApplicationTests {
	@Test
	public void test1() {
		String ip0 = "122.233.48.34";
		String ip1 = "42.200.112.232";
		String ip2 = "127.0.0.1";
		String ip3 = "47.95.196.158";
		String ip4 = "101.105.35.57";
		String ip5 = "101.105.35.57";
		String ip6 = "101.47.19.139";
		List<String> ipList = Lists.newArrayList(ip0, ip1, ip2, ip3, ip4, ip5, ip6);

		for (String ip : ipList) {
			String addressInfo1 = Ip2AddressUtil.getAddressInLocal(ip);
			String addressInfo2 = Ip2AddressUtil.getAddressOnNetByTaoBao(ip);
			log.info("[{}] 本地地理解码 [{}]", ip, addressInfo1);
			log.info("[{}] 在线地理解码 [{}]", ip, addressInfo2);
		}
	}
}
