package org.binshow;

/**
 * 1. mybatis 日志配置
 *      <settings>
 *          <!-- SLF4J 选择slf4j输出！ -->
 *      <setting name="logImpl" value="SLF4J"/>
 *      </settings>
 * 2. sql 动态参数 #{} 和 ${} 的区别
 *      Mybatis会将SQL语句中的#{}转换为问号占位符。
 *      ${}形式传参，底层Mybatis做的是字符串拼接操作。
 *      实际开发中，能用#{}实现的，肯定不用${}！！！
 *      一个特定的适用场景是：通过Java程序动态生成数据库表，表名部分需要Java程序通过参数传入；而JDBC对于表名部分是不能使用问号占位符的，此时只能使用
 *
 * 3. 单表的基础CURD演示
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}