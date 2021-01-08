package com.zc.transaction.service.required;

import com.zc.transaction.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhao.cheng
 * @date 2020/12/16 16:41
 */
@Service
@RequiredArgsConstructor
public class ClassA {

    private final UserMapper userMapper;


}
