package com.zc.storage.controller;

import com.zc.storage.entity.Storage;
import com.zc.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao.cheng
 * @date 2020/12/15 14:23
 */
@Slf4j
@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/decrease")
    public void decrease(Storage storage) {

        storageService.decrease(storage);
    }
}
