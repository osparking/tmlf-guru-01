package space.bum.thyleaf.config;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
  @Bean
  LocaleResolver localeResolver() {
    var localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(Locale.KOREAN);
    localeResolver.setDefaultTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
    return localeResolver;
  }

}
