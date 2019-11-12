package com.bowen.shop.mapper;


import com.bowen.shop.mapper.entity.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    @Insert("INSERT INTO `shop_user` VALUES (null,#{mobile}, #{email}, #{password}, #{userName}, null, null, null, '1', null, null, null);")
    int register(UserDo userDo);

    @Select("SELECT * FROM shop_user WHERE MOBILE=#{mobile};")
    UserDo existMobile(@Param("mobile") String mobile);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID "
            + "  FROM shop_user  WHERE MOBILE=#{mobile} and password=#{password};")
    UserDo login(@Param("mobile") String mobile, @Param("password") String password);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID"
            + " FROM shop_user WHERE user_Id=#{userId}")
    UserDo findByUserId(@Param("userId") Long userId);
}
