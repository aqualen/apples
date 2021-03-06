dataSource {
  pooled = true
  driverClassName = "org.h2.Driver"
  username = "sa"
  password = ""
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = false
  cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
  //    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
  development {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
      url = "jdbc:h2:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
    }
  }
  test {
    dataSource {
      dbCreate = "create-drop" // mebbe good? or "create"
      url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
    }
  }
  integration {
    // we're not ready for production, yet.
    dataSource {
      dbCreate = "update"
      url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
      properties {
        maxActive = -1
        minEvictableIdleTimeMillis = 1800000
        timeBetweenEvictionRunsMillis = 1800000
        numTestsPerEvictionRun = 3
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = false
        validationQuery = "SELECT 1"
        jdbcInterceptors = "ConnectionState"
      }
    }
  }
}
