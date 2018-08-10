package com.xkcoding.scaffold.config.security.filter;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xkcoding.scaffold.mapper.SysMenuMapper;
import com.xkcoding.scaffold.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 过滤器权限元数据
 * </p>
 *
 * @package: com.xkcoding.scaffold.config.security.service
 * @description： 过滤器权限元数据
 * @author: yangkai.shen
 * @date: Created in 2018/8/8 下午9:41
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class ScaffoldFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private SysMenuMapper sysMenuMapper;

	private static final HashMap<String, Collection<ConfigAttribute>> cache = Maps.newHashMap();

	/**
	 * 为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if (MapUtil.isEmpty(cache)) {
			loadSysMenuList();
		}

		//object 中包含用户请求的request 信息
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();

		for (Map.Entry<String, Collection<ConfigAttribute>> cacheEntry : cache.entrySet()) {
			String menuUrl = cacheEntry.getKey();
			AntPathRequestMatcher matcher = new AntPathRequestMatcher(menuUrl);
			if (matcher.matches(request)) {
				return cache.get(menuUrl);
			}
		}

		return null;
	}

	public void loadSysMenuList() {
		List<SysMenu> sysMenuList = sysMenuMapper.selectAll();
		for (SysMenu sysMenu : sysMenuList) {
			if (StrUtil.equals(sysMenu.getUrl(), "#")) {
				continue;
			}
			List<ConfigAttribute> configAttributes = Lists.newArrayList();

			// 将菜单的权限表达式和菜单类型添加进权限信息
			if (StrUtil.isNotBlank(sysMenu.getPerms())) {
				ConfigAttribute permAttr = new SecurityConfig(sysMenu.getPerms());
				configAttributes.add(permAttr);
			}

			cache.put(sysMenu.getUrl(), configAttributes);
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Collection<ConfigAttribute> configAttributes = Lists.newArrayList();
		for (Collection<ConfigAttribute> value : cache.values()) {
			configAttributes.addAll(value);
		}
		return configAttributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
