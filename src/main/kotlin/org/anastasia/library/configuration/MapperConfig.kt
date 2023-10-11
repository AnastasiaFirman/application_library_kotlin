package org.anastasia.library.configuration

import org.anastasia.library.mappers.AuthorMapper
import org.anastasia.library.mappers.BookMapper
import org.anastasia.library.mappers.PersonMapper
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MapperConfig {
    @Bean
    open fun personMapper(): PersonMapper {
        return Mappers.getMapper(PersonMapper::class.java)
    }
    @Bean
    open fun bookMapper(): BookMapper {
        return Mappers.getMapper(BookMapper::class.java)
    }
    @Bean
    open fun authorMapper(): AuthorMapper {
        return Mappers.getMapper(AuthorMapper::class.java)
    }
}