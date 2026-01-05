package com.fyp.weathermonitor.controller;

import java.util.List;

import com.fyp.weathermonitor.entity.query.ThresholdQuery;
import com.fyp.weathermonitor.entity.po.Threshold;
import com.fyp.weathermonitor.entity.vo.ResponseVO;
import com.fyp.weathermonitor.service.ThresholdService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("thresholdController")
@RequestMapping("/threshold")
public class ThresholdController extends ABaseController{

	@Resource
	private ThresholdService thresholdService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ThresholdQuery query){
		return getSuccessResponseVO(thresholdService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Threshold bean) {
		thresholdService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Threshold> listBean) {
		thresholdService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Threshold> listBean) {
		thresholdService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getThresholdById")
	public ResponseVO getThresholdById(Long id) {
		return getSuccessResponseVO(thresholdService.getThresholdById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateThresholdById")
	public ResponseVO updateThresholdById(Threshold bean,Long id) {
		thresholdService.updateThresholdById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteThresholdById")
	public ResponseVO deleteThresholdById(Long id) {
		thresholdService.deleteThresholdById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据NameAndType查询对象
	 */
	@RequestMapping("/getThresholdByNameAndType")
	public ResponseVO getThresholdByNameAndType(String name,Integer type) {
		return getSuccessResponseVO(thresholdService.getThresholdByNameAndType(name,type));
	}

	/**
	 * 根据NameAndType修改对象
	 */
	@RequestMapping("/updateThresholdByNameAndType")
	public ResponseVO updateThresholdByNameAndType(Threshold bean,String name,Integer type) {
		thresholdService.updateThresholdByNameAndType(bean,name,type);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据NameAndType删除
	 */
	@RequestMapping("/deleteThresholdByNameAndType")
	public ResponseVO deleteThresholdByNameAndType(String name,Integer type) {
		thresholdService.deleteThresholdByNameAndType(name,type);
		return getSuccessResponseVO(null);
	}
}