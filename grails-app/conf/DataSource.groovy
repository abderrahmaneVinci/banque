dataSource {

}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource{
		
			// Modifier "Nom de la base de donn�e" par le noom de votre BD et "votre mot de passe MySQL" par le mot de passe du serveur MySQL (serveur local)
			logSql="true"
			pooled = true
			dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost:3306/bmce"
			driverClassName = "com.mysql.jdbc.Driver"
			dialect= "org.hibernate.dialect.MySQL5InnoDBDialect"
			username = "root"
			password = "root"
		}
	}
	test {
		dataSource {
			dbCreate = "update" //one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost:3306/bmce"
			logSql="true"
		}
	}

	production {

		dataSource {
			 dbCreate = "update"
            url = "jdbc:h2:bmce;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
		}

	}
}}
