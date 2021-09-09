package com.glmall.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glmall.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//继承BaseMapper后所有的基本CURD操作都已编写完成
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {
}
