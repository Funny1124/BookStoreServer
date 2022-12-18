package com.guet_unknow.bookstoreserver.mvc.service;

import com.guet_unknow.bookstoreserver.util.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * (File)服务接口
 *
 * @author cyan
 * @since 2022-12-18 17:06:44
 */
public interface FileService {
    R upload(MultipartFile[] files, Long uid);
}
