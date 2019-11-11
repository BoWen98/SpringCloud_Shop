package com.bowen.shop.mapper;


import com.bowen.shop.mapper.entity.UserDo;
import com.bowen.shop.output.UserOutDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

	@Insert("INSERT INTO `meite_user` VALUES (null,#{mobile}, #{email}, #{password}, #{userName}, null, null, null, 1', null, null, null);")
	int register(UserDo userDo);

	@Select("SELECT * FROM meite_user WHERE MOBILE=#{mobile};")
    UserDo existMobile(@Param("mobile") String mobile);
}
