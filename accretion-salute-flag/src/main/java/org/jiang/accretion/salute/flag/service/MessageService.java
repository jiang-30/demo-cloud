package org.jiang.accretion.salute.flag.service;

public class MessageService {
}
//
//'use strict';
//
//        const Controller = require('egg').Controller;
//        const fs = require('fs');
//        const path = require('path');
//        const uuid = require('node-uuid');
//        const officegen = require('officegen');
//
//class TranslateController extends Controller {
//    async test() {
//    const docx = officegen('docx');// word
//    const data = [
//        {
//            from: 'mw',
//                    originText: 'ᠢᠳᠡᠭᠰᠡᠨ ᠦᠸ ᠴᠢ ᠢᠳᠡᠭᠰᠡᠨ ᠦᠸ᠃',
//                resultText: 'zhzhzhzhzh',
//        },
//        {
//            from: 'zh',
//                    originText: 'mwmwmwmwmw',
//                resultText: 'zhzhzhzhzh',
//        },
//        {
//            from: 'mw',
//                    originText: 'mwmwmwmwmw',
//                resultText: 'zhzhzhzhzh',
//        },
//        {
//            from: 'mw',
//                    originText: 'mwmwmwmwmw',
//                resultText: 'zhzhzhzhzh',
//        },
//    ];
//
//        let pObj = docx.createP({ align: 'center' });
//        pObj.addText('翻译', { font_size: 24, color: '333333', bold: true });
//        data.forEach(item => {
//        if (item.from === 'mw') {
//            pObj = docx.createP();
//            pObj.addText(item.originText, { font_size: 16, color: '7578fc' }); // back: 'c2d2f6'
//            pObj.addLineBreak();
//            pObj.addText(item.resultText, { font_size: 16, color: '000000' });
//            pObj = docx.createP();
//        } else {
//            pObj = docx.createP();
//            pObj.addText(item.originText, { font_size: 16, color: 'ff6e7d' }); // , back: 'fbe7e8'
//            pObj.addLineBreak();
//            pObj.addText(item.resultText, { font_size: 16, color: '000000' });
//            pObj = docx.createP();
//        }
//    });
//    const fileName = uuid.v1() + '.docx';
//    const out = fs.createWriteStream(path.resolve(__dirname, '../../public/translate/' + fileName));// 文件写入
//        out.on('error', function(err) {
//            console.log(err);
//            this.ctx.body = {
//                    code: 1,
//                    message: '失败',
//      };
//        });
//        docx.on('finalize', written => {
//                this.ctx.body = {
//                        code: 0,
//                message: '成功',
//                data: fileName,
//      };
//        console.log('Finish to create Word file.\nTotal bytes created: ' + written + '\n');
//    });
//
//        docx.on('error', function(err) {
//            console.log(err);
//            this.ctx.body = {
//                    code: 1,
//                    message: '失败',
//      };
//        });
//        docx.generate(out);// 服务端生成word
//    }
//
//    /**
//     * 生产docx文档
//     */
//    async create() {
//    const data = this.ctx.request.body;
//    const docx = officegen('docx');// word
//        console.log(docx);
//        let pObj = docx.createP({ align: 'center' });
//        pObj.addText('翻译', { font_size: 24, color: '333333', bold: true });
//        data.forEach(item => {
//        if (item.from === 'mw') {
//            pObj = docx.createP();
//            pObj.addText(item.originText, { font_size: 16, color: '7578fc' }); //  back: 'c2d2f6'
//            pObj.addLineBreak();
//            pObj.addText(item.resultText, { font_size: 16, color: '000000' });
//            pObj = docx.createP();
//        } else {
//            pObj = docx.createP();
//            pObj.addText(item.originText, { font_size: 16, color: 'ff6e7d' }); // , back: 'fbe7e8'
//            pObj.addLineBreak();
//            pObj.addText(item.resultText, { font_size: 16, color: '000000' });
//            pObj = docx.createP();
//        }
//    });
//    const fileName = uuid.v1() + '.docx';
//    const filePath = path.resolve(__dirname, '../../public/translate/' + fileName);
//    const out = fs.createWriteStream(filePath);// 文件写入
//        out.on('error', function(err) {
//            console.log(err);
//            this.ctx.body = {
//                    code: 1,
//                    message: '失败',
//      };
//        });
//        docx.on('finalize', written => {
//                this.ctx.body = {
//                        code: 0,
//                message: '成功',
//                data: fileName,
//                path: filePath,
//      };
//        console.log('Finish to create Word file.\nTotal bytes created: ' + written + '\n');
//    });
//
//        docx.on('error', function(err) {
//            console.log(err);
//            this.ctx.body = {
//                    code: 1,
//                    message: '失败',
//      };
//        });
//        docx.generate(out);// 服务端生成word
//
//    }
//    /**
//     * 下载
//     */
//    async download() {
//    const query = this.ctx.query;
//    const fileName = query.fileName;
//    const filePath = path.resolve(__dirname, '../../public/translate/' + fileName);
//        this.ctx.attachment(filePath);
//        this.ctx.set('Content-Type', 'application/octet-stream');
//        this.ctx.body = fs.createReadStream(filePath);
//    }
//
//}
//
//module.exports = TranslateController;