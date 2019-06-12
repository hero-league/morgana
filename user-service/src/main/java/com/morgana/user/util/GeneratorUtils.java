package com.morgana.user.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName GeneratorUtils
 * @Description Mybatis 代码生成器
 * @Author gm
 * @Date 2019/2/18 15:34
 * @Version 1.0
 **/
@Data
public class GeneratorUtils implements Serializable {

    private static final long serialVersionUID = 2864644901961372086L;

    private String outputDir;

    private String author;

    private String dataUrl;

    private String driverName;

    private String username;

    private String password;

    public static ThreadLocal<Integer> status = new ThreadLocal<>();

    private GlobalConfig globalConfig(){
        GlobalConfig global = new GlobalConfig();
        global.setOutputDir(outputDir);
        global.setFileOverride(false);
        global.setAuthor(author);
        global.setSwagger2(true);
        global.setOpen(false);
        global.setBaseResultMap(true);
        global.setBaseColumnList(true);
        global.setMapperName("%sMapper");
        global.setXmlName("%sMapper");
        global.setServiceName("%sService");
        global.setServiceImplName("%sServiceImpl");
        global.setControllerName("%sController");
        return global;
    }

    private DataSourceConfig dataSource(){
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl(dataUrl);
        dataSource.setDriverName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    private PackageConfig packageConfig(){
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.morgana.account");
        packageConfig.setEntity("domain");
        packageConfig.setController("web");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper.xml");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        return packageConfig;
    }

    private StrategyConfig strategy(){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setVersionFieldName("version");
        return strategy;
    }

    public void run(){

        try {
            AutoGenerator autoGenerator = new AutoGenerator();

            // 1.全局配置
            autoGenerator.setGlobalConfig(globalConfig());

            // 2.数据源配置
            autoGenerator.setDataSource(dataSource());

            // 3.包名配置
            autoGenerator.setPackageInfo(packageConfig());

            // 4.表策略配置
            autoGenerator.setStrategy(strategy());

            // 5.配置模板
            TemplateConfig templateConfig = new TemplateConfig();
            autoGenerator.setTemplate(templateConfig);
            autoGenerator.setTemplateEngine(new VelocityTemplateEngine());

            // 6.执行
            autoGenerator.execute();

            status.set(1);

        } catch (Exception e) {
            e.printStackTrace();
            status.set(0);
        }

    }


    private final static String DATA_PATH = "jdbc:mysql://IP:PORT/DATABASE?useUnicode=true&useSSL=false&characterEncoding=utf8";

    private final static String JDBC_DATA_PATH = "jdbc:mysql://IP:PORT/?user=USER&password=PWD&useUnicode=true&useSSL=false&characterEncoding=utf8";

    public static void main(String[] args) {
        String dataUrl = DATA_PATH
                .replace("IP", "127.0.0.1")
                .replace("PORT", "3306")
                .replace("DATABASE", "morgana_account");
        GeneratorUtils generatorUtils = new GeneratorBuilder()
                .outputDir("D:/IdeaProjects/mogana/account-service/src/main/java")
                .author("gm")
                .dataUrl(dataUrl)
                .driverName("com.mysql.jdbc.Driver")
                .username("root")
                .password("123456")
                .build();
        generatorUtils.run();
    }

}


