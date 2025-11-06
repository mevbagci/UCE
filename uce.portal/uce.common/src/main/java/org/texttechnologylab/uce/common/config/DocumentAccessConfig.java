package org.texttechnologylab.uce.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.texttechnologylab.uce.common.security.DocumentAccessContext;
import org.texttechnologylab.uce.common.security.DocumentAccessManager;
import org.texttechnologylab.uce.common.services.PostgresqlDataInterface_Impl;

@Configuration
public class DocumentAccessConfig {

    @Bean
    @Scope("prototype")
    public DocumentAccessContext documentAccessContext(String principal) {
        return new DocumentAccessContext(principal);
    }

    @Bean
    public DocumentAccessManager documentAccessManager(PostgresqlDataInterface_Impl db) {
        return new DocumentAccessManager(db);
    }
}
