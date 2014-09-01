package com.applechip.core.properties;

import java.util.Properties;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import com.applechip.core.constant.DatabaseConstant;
import com.applechip.core.util.CryptoUtil;

@Getter
@Slf4j
public class DatabaseProperties {
  // private String jdbcType;
  private Properties hibernateProperties;
  private Properties dataSourceProperties;
  private Properties transactionProperties;

  public static DatabaseProperties getInstance(Properties properties) {
    return new DatabaseProperties(properties);
  }

  private DatabaseProperties(Properties properties) {
    // this.jdbcType = properties.getProperty("type");
    // properties.put(Environment.DRIVER,
    // HibernateConstant.JDBC_DRIVER_CLASS_MAP.get(this.jdbcType));
    // properties.put(Environment.DIALECT,
    // HibernateConstant.HIBERNATE_DIALECT_MAP.get(this.jdbcType));
    // properties.put("driverClassName",
    // HibernateConstant.JDBC_DRIVER_CLASS_MAP.get(this.jdbcType));
    // properties.put("validationQuery",
    // HibernateConstant.JDBC_VALIDATION_QUERY_MAP.get(this.jdbcType));
    this.setDataSourceProperties(properties);
    this.setHibernateProperties(properties);
    this.setTransactionProperties(properties);
  }

  private void setTransactionProperties(Properties properties) {
    Properties bean = new Properties();
    bean.setProperty("exist*", "PROPAGATION_REQUIRED,readOnly");// ISOLATION_READ_UNCOMMITTED,timeout_30,-Exception
    bean.setProperty("get*", "PROPAGATION_REQUIRED,readOnly");
    bean.setProperty("*", "PROPAGATION_REQUIRED");
    this.transactionProperties = bean;
  }

  private void setHibernateProperties(Properties properties) {
    Properties bean = new Properties();
    for (String string : DatabaseConstant.HIBERNATE_PROPERTIES_SET) {
      if (properties.containsKey(string)) {
        bean.put(string, properties.getProperty(string));
        log.info("setHibernateProperties put finish... key: {}, value: {}", string, properties.getProperty(string));
      }
    }
    this.hibernateProperties = bean;
  }

  private void setDataSourceProperties(Properties properties) {
    Properties bean = new Properties();
    for (String string : DatabaseConstant.DATA_SOURCE_PROPERTIES_SET) {
      if (properties.containsKey(string)) {
        String value = properties.getProperty(string);
        bean.put(string, CryptoUtil.forceDecrypt(value));
        log.info("setDataSourceProperties put finish... key: {}, value: {}", string, value);
      }
    }
    this.dataSourceProperties = bean;
  }
}