package com.morgana.user.util;

/**
 * @ClassName GeneratorBuilder
 * @Description TODO
 * @Author gm
 * @Date 2019/2/20 11:50
 * @Version 1.0
 **/
public class GeneratorBuilder {

    private GeneratorUtils generatorUtils;

    public GeneratorBuilder(){
        this.generatorUtils = new GeneratorUtils();
    }

    public GeneratorBuilder outputDir(String outputDir){
        this.generatorUtils.setOutputDir(outputDir);
        return this;
    }

    public GeneratorBuilder author(String author){
        this.generatorUtils.setAuthor(author);
        return this;
    }

    public GeneratorBuilder dataUrl(String dataUrl){
        this.generatorUtils.setDataUrl(dataUrl);
        return this;
    }

    public GeneratorBuilder username(String username){
        this.generatorUtils.setUsername(username);
        return this;
    }

    public GeneratorBuilder driverName(String driverName){
        this.generatorUtils.setDriverName(driverName);
        return this;
    }

    public GeneratorBuilder password(String password){
        this.generatorUtils.setPassword(password);
        return this;
    }

    public GeneratorUtils build() {
        return generatorUtils;
    }
}
