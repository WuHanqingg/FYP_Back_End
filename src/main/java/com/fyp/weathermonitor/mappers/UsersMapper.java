package com.fyp.weathermonitor.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface UsersMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据Id更新
	 */
	 Integer updateById(@Param("bean") T t,@Param("id") Long id);


	/**
	 * 根据Id删除
	 */
	 Integer deleteById(@Param("id") Long id);


	/**
	 * 根据Id获取对象
	 */
	 T selectById(@Param("id") Long id);


	/**
	 * 根据Username更新
	 */
	 Integer updateByUsername(@Param("bean") T t,@Param("username") String username);


	/**
	 * 根据Username删除
	 */
	 Integer deleteByUsername(@Param("username") String username);


	/**
	 * 根据Username获取对象
	 */
	 T selectByUsername(@Param("username") String username);


}
