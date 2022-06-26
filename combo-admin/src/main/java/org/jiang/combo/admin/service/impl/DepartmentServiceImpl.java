package org.jiang.combo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.model.Department;
import org.jiang.combo.admin.service.DepartmentService;
import org.jiang.combo.admin.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author jiangbo
* @description 针对表【s_department(组织机构)】的数据库操作Service实现
* @createDate 2022-04-20 21:52:35
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

    /**
     *
     */
    @Override
    public List<Department> getTree() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("is_enabled", "1");
//        BeanUtils.copyProperties();

        List<Department> list = list(queryWrapper);
        List<Department> tree = new ArrayList<>();
        List<Department> rootList = list.stream().filter(item -> item.getParentId() == null).collect(Collectors.toList());
        rootList.forEach(node -> tree.add(findChildren(node, list)));
        return tree;
    }

    private Department findChildren(Department node, List<Department> list) {
        list.stream().filter(item -> node.getId().equals(item.getParentId())).collect(Collectors.toList()).forEach(item -> {
            if(node.getChildren() == null) {
                node.setChildren(new ArrayList<>());
            }
            node.getChildren().add(findChildren(item, list));
        });
        return node;
    }
}




