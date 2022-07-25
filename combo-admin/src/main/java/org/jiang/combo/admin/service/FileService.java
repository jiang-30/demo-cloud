package org.jiang.combo.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jiang.combo.admin.model.File;

public interface FileService {
    Page<File> queryPage();

    File query();

    File save();

    File delete();

}
