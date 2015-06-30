dataSource {
    pooled = true
    dbCreate = "update"
    url = "jdbc:mysql://localhost/jurassic"
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "rnchristina"
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

    }
    test {

    }
    production {

    }
}
