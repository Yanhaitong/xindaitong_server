package com.yht.demo.service;

import com.yht.demo.common.Result;
import com.yht.demo.dto.ParameterAPPInfoDTO;
import com.yht.demo.dto.ParameterSendVerifyCode;
import com.yht.demo.dto.ParameterUserDTO;

/**
 * <p>
 * APP用户表 服务类
 * </p>
 *
 * @author generator
 * @since 2019-04-22
 */
public interface IUserService {

    Result sendVerificationCode(ParameterSendVerifyCode parameterSendVerifyCode);

    Result verifyCodeLoginOrRegister(ParameterUserDTO parameterUserDTO);

    Result loginOut(ParameterAPPInfoDTO parameterAPPInfoDTO);

    Result getAppInfo(ParameterAPPInfoDTO parameterAPPInfoDTO);
}
