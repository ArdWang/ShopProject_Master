package com.shop.config;


import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

/**
 * MybatisConfig分页处理插件
 */
@Configuration
public class PageHelperConfig {
    /**
     * 5.x 与4.x 不同的是 5.0可以执行mapper里面定义的sql语句去实现分页效果，而4.0去执行分页效果取消了mapper里面的分页
     * 导致分页查询出来的数据出现了重复的值。
     * @return
     */
    @Bean
    public PageHelper pageHelper() {
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //5.0之后就必须要添加指定的数据库类型
        properties.setProperty("dialect","mysql");
        /**
         * 默认值为 false，该参数对使用 RowBounds 作为分页参数时有效。 当该参数设置为 true 时，
         * 会将 RowBounds 中的 offset 参数当成 pageNum 使用，可以用页码和页面大小两个参数进行分页。
         */
        properties.setProperty("offsetAsPageNum","false");
        /**
         * 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页，
         */
        properties.setProperty("reasonable", "false");
        /**
         * 支持通过 Mapper 接口参数来传递分页参数，默认值false，分页插件会从查询方法的参数值中，
         * 自动根据上面 params 配置的字段中取值，查找到合适的值时就会自动分页。
         * 使用方法可以参考测试代码中的 com.github.pagehelper.test.basic 包下的 ArgumentsMapTest 和 ArgumentsObjTest。
         */
        properties.setProperty("supportMethodsArguments", "false");
        //properties.setProperty("returnPageInfo", "check");
        /**
         * 默认值为 false，当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0
         * 就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是 Page 类型）
         * 相当于不需要分页的时候 设置为true
         */
        properties.setProperty("pageSizeZero","false");
        /**
         * 默认值为false，该参数对使用 RowBounds 作为分页参数时有效。
         * 当该参数设置为true时，使用 RowBounds 分页会进行 count 查询。
         */
        properties.setProperty("rowBoundsWithCount","false");
        //properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    //增加拦截器
    /*public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor())    //指定拦截器类
                .addPathPatterns("/Handles");        //指定该类拦截的url
    }*/
}
