package com.cs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@Component("sequence")
public class Sequence {

    public static final Logger log = LoggerFactory.getLogger(Sequence.class);
    private static Properties  properties = getProperties("jdbc.properties");
    //链接地址
    private static String URL = properties.getProperty("jdbc.url");
    //驱动名称
    private static String DRIVER = properties.getProperty("jdbc.driver");
    //用户名
    private static String USER = properties.getProperty("jdbc.username");
    //密码
    private static String PASSWORD = properties.getProperty("jdbc.password");

    public static void sequence() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS AUTOINCTUTORIAL (priKey INT NOT NULL AUTO_INCREMENT,dataField VARCHAR(64), PRIMARY KEY (priKey))");
            stmt.executeUpdate("INSERT INTO AUTOINCTUTORIAL (dataField) values ('Increment')", Statement.RETURN_GENERATED_KEYS);// 向驱动指明需要自动获取generatedKeys！
            int autoIncKeyFromApi = -1;
            rs = stmt.getGeneratedKeys();// 获取自增主键！
            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            }  else {
                //throw new BusinessException(ErrorCode.ERROR,"当前复合修改条件为0，请确认是否有其他操作已修改次数据");
            }
            System.out.println(autoIncKeyFromApi);
            rs.close();
            rs = null;
        }  finally {

        }
    }


    public static Properties getProperties(String fileName) {
        log.info("开始读取配置文件【{}】...{}", new Object[]{fileName});
        InputStream inputStream = Sequence.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Properties properties = new Properties();
        try {
            properties.load(bufferedReader);
            if (null != inputStream) {
                inputStream.close();
            }
        } catch (IOException var5) {
            log.error("Exception:【{}】...",var5);
        }
        log.info("读取配置文件【{}】结束...", new Object[]{fileName});
        return properties;
    }

}
