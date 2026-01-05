package com.fyp.weathermonitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fyp.weathermonitor.entity.enums.PageSize;
import com.fyp.weathermonitor.entity.query.ThresholdQuery;
import com.fyp.weathermonitor.entity.po.Threshold;
import com.fyp.weathermonitor.entity.vo.PaginationResultVO;
import com.fyp.weathermonitor.entity.query.SimplePage;
import com.fyp.weathermonitor.mappers.ThresholdMapper;
import com.fyp.weathermonitor.service.ThresholdService;
import com.fyp.weathermonitor.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("thresholdService")
public class ThresholdServiceImpl implements ThresholdService {

	@Resource
	private ThresholdMapper<Threshold, ThresholdQuery> thresholdMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Threshold> findListByParam(ThresholdQuery param) {
		return this.thresholdMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ThresholdQuery param) {
		return this.thresholdMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Threshold> findListByPage(ThresholdQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Threshold> list = this.findListByParam(param);
		PaginationResultVO<Threshold> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Threshold bean) {
		return this.thresholdMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Threshold> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.thresholdMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Threshold> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.thresholdMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Threshold bean, ThresholdQuery param) {
		StringTools.checkParam(param);
		return this.thresholdMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ThresholdQuery param) {
		StringTools.checkParam(param);
		return this.thresholdMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Threshold getThresholdById(Long id) {
		return this.thresholdMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateThresholdById(Threshold bean, Long id) {
		return this.thresholdMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteThresholdById(Long id) {
		return this.thresholdMapper.deleteById(id);
	}

	/**
	 * 根据NameAndType获取对象
	 */
	@Override
	public Threshold getThresholdByNameAndType(String name, Integer type) {
		return this.thresholdMapper.selectByNameAndType(name, type);
	}

	/**
	 * 根据NameAndType修改
	 */
	@Override
	public Integer updateThresholdByNameAndType(Threshold bean, String name, Integer type) {
		return this.thresholdMapper.updateByNameAndType(bean, name, type);
	}

	/**
	 * 根据NameAndType删除
	 */
	@Override
	public Integer deleteThresholdByNameAndType(String name, Integer type) {
		return this.thresholdMapper.deleteByNameAndType(name, type);
	}
}