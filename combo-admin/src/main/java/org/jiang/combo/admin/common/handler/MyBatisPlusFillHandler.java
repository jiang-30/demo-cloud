package org.jiang.combo.admin.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyBatisPlusFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insertFill......");
        boolean createdTime = metaObject.hasSetter("createdTime");
        if(createdTime) {
            log.info("has ...... createdTime");
        }
        this.strictInsertFill(metaObject, "createdTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "updatedTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "createdBy", () -> 1232331231, Integer.class);
        this.strictInsertFill(metaObject, "created_by", () -> 1232331231, Integer.class);
        this.strictInsertFill(metaObject, "updatedBy", () -> 1232331231, Integer.class);

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(!authenticationTrustResolver.isAnonymous(authentication) && authentication!=null){
//            AuthenticationUser user = (AuthenticationUser) authentication.getPrincipal();
//            this.setFieldValByName("updateUser",  user.getUsername(), metaObject);
//        }else{
//            this.setFieldValByName("updateUser",  "unknown", metaObject);
//        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill......");
        Object updatedTime = getFieldValByName("updatedTime", metaObject);

        this.strictInsertFill(metaObject, "updatedTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "updatedBy", () -> 1232331231, Integer.class);
    }
}
