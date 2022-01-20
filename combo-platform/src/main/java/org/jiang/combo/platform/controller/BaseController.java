//package org.jiang.combo.platform.controller;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//public class BaseController {
//
//    @Resource
//    MenuService menuService;
//
//    @ApiOperation("查询菜单树结构")
//    @GetMapping("/tree")
//    public String tree(Integer id){
////        Menu menu = menuService.getById(id);
////        return menu;
//
//        return "'tree'";
//    }
//
//    @GetMapping("/page")
//    public IPage<Menu> page(){
//        Page<Menu> menuPage = menuService.page(new Page<>(1, 1));
//        return menuPage;
//    }
//
//    @GetMapping("/list")
//    public List<Menu> list(){
//        List<Menu> menuList = menuService.list();
//        return menuList;
//    }
//
//    @ApiOperation("通过id查询菜单详情")
//    @GetMapping("/{id}")
//    public Menu select(@PathVariable Integer id){
//        Menu menu = menuService.getById(id);
//        return menu;
//    }
//
//    @ApiOperation("新建菜单")
//    @PostMapping("")
//    public void create(Menu menu){
//        boolean b = menuService.save(menu);
//    }
//
//    @ApiOperation("通过id更新菜单")
//    @PutMapping("")
//    public void update(Menu menu){
//        boolean b = menuService.updateById(menu);
//    }
//
//    @ApiOperation("通过id删除菜单")
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Integer id){
//        boolean b = menuService.removeById(id);
//    }
//}
