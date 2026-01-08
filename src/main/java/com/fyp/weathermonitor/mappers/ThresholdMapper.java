package com.fyp.weathermonitor.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface ThresholdMapper<T,P> extends BaseMapper<T,P> {

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
	 * 根据NameAndType更新
	 */
	Integer updateByNameAndType(@Param("bean") T t,@Param("name") String name,@Param("type") Integer type);


	/**
	 * 根据NameAndType删除
	 */
	Integer deleteByNameAndType(@Param("name") String name,@Param("type") Integer type);


	/**
	 * 根据NameAndType获取对象
	 */
	T selectByNameAndType(@Param("name") String name,@Param("type") Integer type);


}
