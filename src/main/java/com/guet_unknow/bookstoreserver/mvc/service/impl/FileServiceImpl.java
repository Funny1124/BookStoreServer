package com.guet_unknow.bookstoreserver.mvc.service.impl;

import com.guet_unknow.bookstoreserver.mvc.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * (File)服务实现
 *
 * @author cyan
 * @since 2022-12-18 17:06:44
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${filepath.dir}")
    String filePath;
    @Value("${filepath.trueResourceHandler}")
    String trueResourceHandler;
    private final SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("_yyyyMMddHHmmssSSS");

    public List<String> upload(MultipartFile[] files, Long uid) {
        List<String> list = new ArrayList<>();//将重命名的文件名保存，用于返回
        if (files.length == 0) {
            list.add("文件获取失败，请确认是否已经选择文件");
            return list;
        }
        for (MultipartFile multipartFile : files) {
            String suffix = Objects.requireNonNull(
                    multipartFile.getOriginalFilename()).substring(
                    multipartFile.getOriginalFilename().lastIndexOf("."));
            String fileName = simpleDateFormat.format(new Date());
            File file = new File(filePath + uid + fileName + suffix);
            String returnPath = trueResourceHandler + file.getName();
            list.add(returnPath);
            if (!file.getParentFile().exists()) {
                if (!file.getParentFile().mkdirs()) {
                    list.add("创建文件夹失败");
                    return list;
                }
            }
            try {
                multipartFile.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                list.add("从临时文件复制到目标位置出错");
                return list;
            }
        }
        return list;
    }
}
