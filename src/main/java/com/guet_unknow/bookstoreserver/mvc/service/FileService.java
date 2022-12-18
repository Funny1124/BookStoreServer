package com.guet_unknow.bookstoreserver.mvc.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * (File)服务接口
 *
 * @author cyan
 * @since 2022-12-18 17:06:44
 */
public interface FileService {
    List<String> upload(MultipartFile[] files, Long uid);
}
