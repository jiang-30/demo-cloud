package org.jiang.combo.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;

public class MybatisPlusGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://39.104.48.239:3306/combo_project", "root", "Root1234@")
                .globalConfig(builder -> {
                    builder.fileOverride()
                            .enableSwagger()
                            .disableOpenDir()
                            .author("combo")
                            .outputDir("E:\\project\\demo-cloud\\combo-platform\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("org.jiang.combo.platform")
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper")
                            .service("service")
                            .serviceImpl("service");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("s_user", "s_platform", "s_department", "s_role", "s_menu", "s_dict", "s_dict_item")
                            .addTablePrefix("s_")
                            .enableCapitalMode()
                            .entityBuilder()
                                .enableLombok()
                                .disableSerialVersionUID()
                                .enableTableFieldAnnotation()
                                .logicDeleteColumnName("deleted_flag")
                                .addTableFills(new Column("created_by", FieldFill.INSERT),  new Column("updated_by", FieldFill.INSERT_UPDATE))
                                .idType(IdType.AUTO)
                            .controllerBuilder()
                                .enableRestStyle()
                            .serviceBuilder()
                                .formatServiceFileName("%sService")
                            .mapperBuilder()
                                .enableBaseResultMap()
                                .enableBaseColumnList();
                })
                .execute();
    }
}
