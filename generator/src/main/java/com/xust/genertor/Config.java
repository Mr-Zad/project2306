package com.xust.genertor;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.xust.core.BaseEntity;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static void main(String[] args) {
        //表名
        String table = "pms_brand";
        //模块名
        String module = "product";
        //取得父项目路径
        String parent_path = System.getProperty("user.dir");
        //配置entity路径
        String entity_path = parent_path + "/entity/src/main/java/com/xust/entity";
        //配置mapper路径
        String mapper_path = parent_path + "/" + module + "/src/main/java/com/xust/mapper";
        //配置xml路径
        String xml_path = parent_path + "/" + module + "/src/main/resources/com/xust/mapper";
        //配置service路径
        String service_path = parent_path + "/" + module + "/src/main/java/com/xust/service";
        //配置service_impl路径
        String service_impl_path = parent_path + "/" + module + "/src/main/java/com/xust/service/impl";
        //配置controller路径
        String controller_path = parent_path + "/" + module + "/src/main/java/com/xust/controller";

        //创建生成器对象
        AutoGenerator ag = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("zs");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        ag.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://192.168.36.33:3306/shop?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
        dsc.setUsername("root");
        dsc.setPassword("root");
        ag.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xust");

        //配置路径
        Map<String,String> pathInfo = new HashMap<>();
        pathInfo.put("entity_path",entity_path);
        pathInfo.put("mapper_path",mapper_path);
        pathInfo.put("xml_path",xml_path);
        pathInfo.put("service_path",service_path);
        pathInfo.put("service_impl_path",service_impl_path);
        pathInfo.put("controller_path",controller_path);

        pc.setPathInfo(pathInfo);
        ag.setPackageInfo(pc);

        //配置策略
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(false);
        sc.setSuperEntityClass(BaseEntity.class);
        sc.setSuperEntityColumns("id");
        sc.setInclude(table);
        ag.setStrategy(sc);

        ag.setTemplateEngine(new FreemarkerTemplateEngine());

        ag.execute();

    }
}
