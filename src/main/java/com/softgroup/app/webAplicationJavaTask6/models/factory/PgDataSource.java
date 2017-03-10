package com.softgroup.app.webAplicationJavaTask6.models.factory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.sql2o.Sql2o;

/**
 * Created by inna on 09.03.17.
 */
public class PgDataSource extends AbstractDaoFactory implements DataSource {

    private volatile static PgDataSource dataSource;
    private Sql2o sql2o;

    public PgDataSource() {
    }

    @Override
    public Sql2o getDataSource() {
        if (sql2o == null) {
            synchronized (PgDataSource.class) {
                if (sql2o == null)
                    sql2o = new Sql2o(getDataSourcePg());
            }
        }
        return sql2o;
    }

    public static PgDataSource getInstance() {
        if (dataSource == null) {
            synchronized (PgDataSource.class) {
                if (dataSource == null)
                    dataSource = new PgDataSource();
            }
        }
        return dataSource;
    }

    private HikariDataSource getDataSourcePg() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbs:postgresql://localhost:5432/softgroup");
        config.setUsername("postgres");
        config.setPassword("");

        return new HikariDataSource(config);
    }
}
