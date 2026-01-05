package com.fyp.weathermonitor.service;

import java.util.List;

import com.fyp.weathermonitor.entity.query.ThresholdQuery;
import com.fyp.weathermonitor.entity.po.Threshold;
import com.fyp.weathermonitor.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ThresholdService {

	/**
	 * 根据条件查询列表
	 */
	List<Threshold> findListByParam(ThresholdQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ThresholdQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Threshold> findListByPage(ThresholdQuery param);

	/**
	 * 新增
	 */
	Integer add(Threshold bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Threshold> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Threshold> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Threshold bean,ThresholdQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ThresholdQuery param);

	/**
	 * 根据Id查询对象
	 */
	Threshold getThresholdById(Long id);


	/**
	 * 根据Id修改
	 */
	Integer updateThresholdById(Threshold bean,Long id);


	/**
	 * 根据Id删除
	 */
	Integer deleteThresholdById(Long id);


	/**
	 * 根据NameAndType查询对象
	 */
	Threshold getThresholdByNameAndType(String name,Integer type);


	/**
	 * 根据NameAndType修改
	 */
	Integer updateThresholdByNameAndType(Threshold bean,String name,Integer type);


	/**
	 * 根据NameAndType删除
	 */
	Integer deleteThresholdByNameAndType(String name,Integer type);

}