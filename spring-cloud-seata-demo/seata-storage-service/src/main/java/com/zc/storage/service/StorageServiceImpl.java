package com.zc.storage.service;

import com.zc.storage.entity.Storage;
import com.zc.storage.mapper.StorageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhao.cheng
 * @date 2020/12/15 14:16
 */
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
