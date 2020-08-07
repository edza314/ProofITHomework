
package com.examples.homework;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Scope;
        import org.springframework.context.annotation.ScopedProxyMode;
        import org.springframework.scheduling.annotation.EnableScheduling;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@EnableScheduling
@ComponentScan(basePackages = {"com.examples.homework"})
@Configuration
public class HomeworkConfiguration {
}
