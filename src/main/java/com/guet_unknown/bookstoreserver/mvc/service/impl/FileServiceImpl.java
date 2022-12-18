package com.guet_unknown.bookstoreserver.mvc.service.impl;

import com.guet_unknown.bookstoreserver.mvc.service.FileService;
import com.guet_unknown.bookstoreserver.util.R;
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

    public R upload(MultipartFile[] files, Long uid) {
        List<String> list = new ArrayList<>();//将重命名的文件名保存，用于返回
        if (files.length == 0) {
            return R.failure().setData("文件获取失败，请确认是否已经选择文件");
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
                    return R.failure().setData("创建文件夹失败");
                }
            }
            try {
                multipartFile.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                return R.failure().setData("从临时文件复制到目标位置出错");
            }
        }
        return R.success().setData(list);
    }
}
