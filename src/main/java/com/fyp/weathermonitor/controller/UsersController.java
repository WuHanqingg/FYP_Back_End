package com.fyp.weathermonitor.controller;

import java.util.List;

import com.fyp.weathermonitor.entity.Constants;
import com.fyp.weathermonitor.entity.query.UsersQuery;
import com.fyp.weathermonitor.entity.po.Users;
import com.fyp.weathermonitor.entity.vo.ResponseVO;
import com.fyp.weathermonitor.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("usersController")
@RequestMapping("/users")
public class UsersController extends ABaseController{

	@Resource
	private UsersService usersService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UsersQuery query){
		return getSuccessResponseVO(usersService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(@RequestBody Users bean) {
		bean.setPasswordHash(Constants.DEFAULT_PASSWORD);
		usersService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Users> listBean) {
		usersService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Users> listBean) {
		usersService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getUsersById")
	public ResponseVO getUsersById(Long id) {
		return getSuccessResponseVO(usersService.getUsersById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateUsersById")
	public ResponseVO updateUsersById(@RequestBody Users bean,Long id) {
		usersService.updateUsersById(bean, bean.getId());
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteUsersById")
	public ResponseVO deleteUsersById(Long id) {
		usersService.deleteUsersById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username查询对象
	 */
	@RequestMapping("/getUsersByUsername")
	public ResponseVO getUsersByUsername(String username) {
		return getSuccessResponseVO(usersService.getUsersByUsername(username));
	}

	/**
	 * 根据Username修改对象
	 */
	@RequestMapping("/updateUsersByUsername")
	public ResponseVO updateUsersByUsername(Users bean,String username) {
		usersService.updateUsersByUsername(bean,username);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username删除
	 */
	@RequestMapping("/deleteUsersByUsername")
	public ResponseVO deleteUsersByUsername(String username) {
		usersService.deleteUsersByUsername(username);
		return getSuccessResponseVO(null);
	}
}