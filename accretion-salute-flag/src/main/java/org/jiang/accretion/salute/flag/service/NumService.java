package org.jiang.accretion.salute.flag.service;

public class NumService {
}
//
//'use strict';
//
//        const Service = require('egg').Service;
//
//class FlagSaluteService extends Service {
//
//    /**
//     * test
//     */
//    async test() {
//    const total = await this.ctx.model.FlagSalute.Message.find().count();
//    const result = await this.ctx.model.FlagSalute.Message.find().skip(20012 + 543032).limit(20)
//                .sort({ _id: 1 });
//        return { result, total };
//    }
//
//    /**
//     * 查询敬礼数
//     * @param { object } params - 参数
//     */
//    async getNum(params = {}) {
//        let result = await this.ctx.model.FlagSalute.Num.find(params).count();
//        if (result) {
//            result = result + 450000 - Math.floor(this.app.cache.index / 2);
//        }
//        return result;
//    }
//    /**
//     * 添加敬礼
//     * @param {*} params - 参数
//     */
//    async createNum(params) {
//    const result = await this.ctx.model.FlagSalute.Num.create(params);
//        return result;
//    }
//
//    /**
//     * 分页查询留言
//     * @param { Object } params - 参数
//     */
//    async getMessagePage(params) {
//    const size = parseInt(params.size);
//    const current = parseInt(params.current);
//    const skip = size * (current - 1);
//    const filter = {};
//        // const time = new Date().getTime();
//        let result = [];
//    const total = await this.ctx.model.FlagSalute.Message.find(filter).count();
//        if (total > 0) {
//
//            result = await this.ctx.model.FlagSalute.Message
//                    // .find({ created: { $gt: new Date(time - 7200000) } })
//                    // .find({ _id: { $gt: '5f767476958aa10cc11bc183' } })
//                    .find({})
//                    .sort({ _id: -1 })
//        .skip(skip)
//                    .limit(size);
//            // result = await this.ctx.model.FlagSaluteMessage.find(filter).skip(skip)
//
//        }
//        return {
//                total,
//                data: result,
//    };
//    }
//    /**
//     * 新建留言
//     * @param { Object } params - 参数
//     */
//    async createMessage(params) {
//    const result = await this.ctx.model.FlagSalute.Message.create(params);
//        this.app.cache.index++;
//        return result;
//    }
//}
//
//module.exports = FlagSaluteService;