package com.fyp.weathermonitor.service;

import java.util.List;

import com.fyp.weathermonitor.entity.query.UsersQuery;
import com.fyp.weathermonitor.entity.po.Users;
import com.fyp.weathermonitor.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface UsersService {

	/**
	 * 根据条件查询列表
	 */
	List<Users> findListByParam(UsersQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(UsersQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Users> findListByPage(UsersQuery param);

	/**
	 * 新增
	 */
	Integer add(Users bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Users> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Users> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Users bean,UsersQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(UsersQuery param);

	/**
	 * 根据Id查询对象
	 */
	Users getUsersById(Long id);


	/**
	 * 根据Id修改
	 */
	Integer updateUsersById(Users bean,Long id);


	/**
	 * 根据Id删除
	 */
	Integer deleteUsersById(Long id);


	/**
	 * 根据Username查询对象
	 */
	Users getUsersByUsername(String username);


	/**
	 * 根据Username修改
	 */
	Integer updateUsersByUsername(Users bean,String username);


	/**
	 * 根据Username删除
	 */
	Integer deleteUsersByUsername(String username);

}