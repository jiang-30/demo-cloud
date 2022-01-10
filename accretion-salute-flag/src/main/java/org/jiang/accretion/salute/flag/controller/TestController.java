package org.jiang.accretion.salute.flag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String index(){
        String str = "hello index";
        return str;
    }
}

//
//'use strict';
//
//        const Controller = require('egg').Controller;
//
//class MenusController extends Controller {
//    async test() {
//    const host = this.ctx.request.ip;
//        // try {
//        //   this.ctx.validate({
//        //     host: {
//        //       type: String,
//        //       required: true,
//        //     },
//        //   });
//        // } catch (err) {
//        //   this.ctx.logger.warn(err);
//        //   this.ctx.body = { success: false };
//        //   return;
//        // }
//
//    const res = await this.service.flagSalute.index.test({ host });
//        this.ctx.body = {
//                status: { code: 200, message: '成功' },
//        data: res,
//    };
//    }
//    /**
//     * 查询敬礼数
//     */
//    async getNum() {
//    const num = await this.service.flagSalute.index.getNum();
//        this.ctx.body = {
//                status: { code: 200, message: '成功' },
//        data: num,
//    };
//    }
//    /**
//     * 添加敬礼信息
//     */
//    async createNum() {
//    const host = this.ctx.request.ip;
//    const res = await this.service.flagSalute.index.createNum({ host });
//        this.ctx.body = {
//                status: { code: 200, message: '成功' },
//        data: res,
//    };
//    }
//
//    /**
//     * 分页查询留言信息
//     * param { object } query 查询参数
//     * param { number } query.size
//     * param { number } query.current
//     */
//    async getMessagePage() {
//    const query = this.ctx.query;
//        if (!query.size || query.size > 30) {
//            query.size = 10;
//        }
//    const res = await this.service.flagSalute.index.getMessagePage(query);
//        this.ctx.body = {
//                status: { code: 200, message: '成功' },
//        data: res.data,
//                page: { total: res.total, current: query.current, size: query.size },
//    };
//    }
//    /**
//     * 新建留言
//     */
//    async createMessage() {
//    const query = this.ctx.request.body;
//        query.host = this.ctx.request.ip;
//    const res = await this.service.flagSalute.index.createMessage(query);
//        this.ctx.body = {
//                status: { code: 200, message: '成功' },
//        data: res,
//    };
//    }
//}
//
//module.exports = MenusController;