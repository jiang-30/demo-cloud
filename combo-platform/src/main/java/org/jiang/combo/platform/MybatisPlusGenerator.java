package org.jiang.combo.platform;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class MybatisPlusGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://39.104.48.239:3306/combo_project", "root", "Root1234@")
                .globalConfig(builder -> {
                    builder.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\project\\demo-cloud\\combo-platform\\src\\main\\java") //-- 指定输出目录 -- 工程路径 + src/main/java
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent("org.jiang.combo.platform") //-- 设置父包名
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper")
                            .service("service")
                            .serviceImpl("service");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("s_menu") // 设置需要生成的表名
                            .addTablePrefix("s_") // 设置过滤表前缀
                            .enableCapitalMode()
                            .serviceBuilder()
                            .formatServiceFileName("%sService");
                })
                .execute();
    }
}
