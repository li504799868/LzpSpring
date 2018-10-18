package com.lzp.spring.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库工具类
 */
public class DBUtils {

    public DBUtils() {
    }

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private PlatformTransactionManager platformTransactionManager;

    public DBUtils(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public Address queryAddress(String addressId) {
        try {
            String sql = "select * from address where addressId=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{addressId}, new RowMapper<Address>() {

                public Address mapRow(ResultSet resultSet, int i) throws SQLException {
                    if (!resultSet.first()) {
                        return null;
                    }
                    return new Address(resultSet.getString("addressId"), resultSet.getString("location"));
                }
            });
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 通过事务插入数据
     */
    public void create() {
        // 定义一个事务
        TransactionDefinition definition = new DefaultTransactionDefinition();
        // 获取这个事务的状态
        TransactionStatus status = platformTransactionManager.getTransaction(definition);
        try {
            // 如果已经存在这条数据，删除
            if (queryAddress("003") != null) {
                String deleteSql = "delete from address where addressId=?";
                jdbcTemplate.update(deleteSql, "003");
                System.out.println("delete address 003");
            }

            String sql = "insert into address(addressId, location) values(?,?)";
            jdbcTemplate.update(sql, "003", "沈阳");
            System.out.println("insert address 003");
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

    }

    /**
     * 通过声明式事务，完成create过程
     */
    public void createByXml() {
        // 如果已经存在这条数据，删除
        if (queryAddress("003") != null) {
            String deleteSql = "delete from address where addressId=?";
            jdbcTemplate.update(deleteSql, "003");
            System.out.println("delete address 003");
        }

        String sql = "insert into address(addressId, location) values(?,?)";
        jdbcTemplate.update(sql, "003", "沈阳");
        System.out.println("insert address 003");
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }
}
