package com.fyp.weathermonitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fyp.weathermonitor.entity.enums.PageSize;
import com.fyp.weathermonitor.entity.query.UsersQuery;
import com.fyp.weathermonitor.entity.po.Users;
import com.fyp.weathermonitor.entity.vo.PaginationResultVO;
import com.fyp.weathermonitor.entity.query.SimplePage;
import com.fyp.weathermonitor.mappers.UsersMapper;
import com.fyp.weathermonitor.service.UsersService;
import com.fyp.weathermonitor.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper<Users, UsersQuery> usersMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Users> findListByParam(UsersQuery param) {
		return this.usersMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(UsersQuery param) {
		return this.usersMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Users> findListByPage(UsersQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Users> list = this.findListByParam(param);
		PaginationResultVO<Users> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Users bean) {
		return this.usersMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Users> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.usersMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Users> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.usersMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Users bean, UsersQuery param) {
		StringTools.checkParam(param);
		return this.usersMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(UsersQuery param) {
		StringTools.checkParam(param);
		return this.usersMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public Users getUsersById(Long id) {
		return this.usersMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateUsersById(Users bean, Long id) {
		return this.usersMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteUsersById(Long id) {
		return this.usersMapper.deleteById(id);
	}

	/**
	 * 根据Username获取对象
	 */
	@Override
	public Users getUsersByUsername(String username) {
		return this.usersMapper.selectByUsername(username);
	}

	/**
	 * 根据Username修改
	 */
	@Override
	public Integer updateUsersByUsername(Users bean, String username) {
		return this.usersMapper.updateByUsername(bean, username);
	}

	/**
	 * 根据Username删除
	 */
	@Override
	public Integer deleteUsersByUsername(String username) {
		return this.usersMapper.deleteByUsername(username);
	}
}