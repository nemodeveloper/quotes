package ru.nemodev.project.quotes.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.nemodev.project.quotes.config.property.DataBaseProperty;

@Configuration
@Profile("stage")
public class StageDataConfigHolder extends AbstractDataSourceHolder
{

    public StageDataConfigHolder(DataBaseProperty dataBaseProperty)
    {
        super(dataBaseProperty);
    }

    @Override
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource()
    {
        return new HikariDataSource(hikariConfig());
    }
}