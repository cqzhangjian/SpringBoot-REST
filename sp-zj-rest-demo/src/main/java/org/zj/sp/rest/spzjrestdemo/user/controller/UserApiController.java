package org.zj.sp.rest.spzjrestdemo.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zj.sp.rest.spzjrestdemo.user.model.UserModel;
import org.zj.sp.rest.spzjrestdemo.user.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/api/v1/user/")
@Api(tags="用户接口")
public class UserApiController {
	
	private static  final Logger logger = LoggerFactory.getLogger(UserApiController.class);
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 *   	查询用户列表, 返回 JSON 数据
	 */
	@GetMapping
	@ApiOperation(value="查询用户列表")
	public List<UserModel> getUsers(){
		
		
		return userRepository.findAll();
	} 
	/**
	 *  	按 id 查询用户, 返回 JSON 数据
	 */
	@GetMapping("{id}")
	@ApiOperation(value="通过id 查询用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	public UserModel getUser(@PathVariable("id") Long id) {
		
		logger.info("=================" + id);
		
		return userRepository.getOne(id);
	}
	
	/**
	 *  	新增用户
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="新增用户")
	@ApiImplicitParam(name = "model", value = "用户详细实体UserModel", required = true, dataType = "UserModel")
	public void addUser(@RequestBody UserModel model) {
		
		logger.info(model.toString());
		
		userRepository.save(model);
		
	}
	/**
	 *  	修改用户
	 */
	@PutMapping
	@ApiOperation(value="更新用户")
	@ApiImplicitParam(name = "model", value = "用户详细实体UserModel", required = true, dataType = "UserModel")
	public void modifyUser(@RequestBody UserModel model) {
		userRepository.save(model);
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value="通过id 删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
}
