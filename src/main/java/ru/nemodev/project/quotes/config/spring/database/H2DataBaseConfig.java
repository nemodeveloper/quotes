package ru.nemodev.project.quotes.config.spring.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * created by sbrf-simanov-an on 21.11.2018 - 18:11
 */
@Configuration
@Profile("h2")
public class H2DataBaseConfig implements DataBaseSource
{
    @Bean
    public DataSource dataSource()
    {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(false)
                .setName("quotes-embedded-db")
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("config/schema.sql", "config/data.sql")
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .build();
    }

    @Override
    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
    {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}