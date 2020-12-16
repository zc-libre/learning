package com.zc.storage.service;

import com.zc.storage.entity.Storage;
import com.zc.storage.mapper.StorageMapper;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhao.cheng
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final StorageMapper storageMapper;

    @Override
    public boolean decrease(Storage storage) {

        storageMapper.updateById(storage);
        return true;
    }
}
