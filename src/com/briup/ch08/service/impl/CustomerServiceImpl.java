package com.briup.ch08.service.impl;

import com.briup.ch08.service.ICustomerService;
import com.briup.ch08.common.exception.ServiceException;
import com.briup.ch08.dao.CustomerDao;
import com.briup.ch08.bean.Customer;
/**
 * 业务逻辑层
 *   事务管理（事务提交以及回滚）、
 *   多次调用Dao层代码完成增删改成
 *   处理复杂业务逻辑
 *   	
 * */
public class CustomerServiceImpl implements ICustomerService {
	private CustomerDao customerDao;

	/**
	 */
	public CustomerServiceImpl() {
		//实例化CustomerDao对象
		customerDao = new CustomerDao();
	}

	/**
	 * @param name
	 * @param password
	 * @return com.briup.ch08.bean.Customer
	 */
	public Customer login(String name, String password) throws ServiceException {
		Customer customer = null;
		Customer dbCustomer = customerDao.findByName(name);
		if(dbCustomer!=null){
			if(dbCustomer.getPassword().equals(password)){
				customer = dbCustomer;
			}else{
				throw new ServiceException("密码错误");
			}
		}else{
			throw new ServiceException("该用户不存在");
		}
		return customer;
	}

	/**
	 * 注册
	 * 	1. 查询该用户名是否已经被人占用 find  
	 *  2. 注册用户信息	save
	 *  3. 初始化用户信息	update
	 * @param customer
	 */
	public void register(Customer customer) {
		customerDao.save(customer);
	}
	public void delete(long id){
		customerDao.deleteById(id);
	}
}
