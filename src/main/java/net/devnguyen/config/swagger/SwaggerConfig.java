package net.devnguyen.config.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
@ConditionalOnExpression(value = "${spring.swagger.enable:false}")
public class SwaggerConfig extends AbstractSwaggerConfig {

    @Override
    protected ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Tantum Indent")
                .description(
                        "Tantum Indent extension for twitch")
                .build();
    }
}
