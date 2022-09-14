package lt.codeacademy.libraryapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//swagerio konfiguracija pirmine
//kad konfiguracijos metu sukurtu tam tikra bean
@Configuration
public class SwaggerConfig {

    @Bean
    //docket tai objektas kur susikonfiguruoja swagger
    public Docket api() {
        //nurodom koki documentation tipa naudojam
        //selectinam viska, visas konfiguracijas
        //kad visi parasyti requestai bus surinkti visi kokie gali buti
        //viska susibilidinam kad grazintu docket
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(createApiInfo());
    }

    //sita metoda pridedam prie docket
    private ApiInfo createApiInfo() {
        //bilderis naudojamas tam, kad galetume isideti savo info
        //galima susideti visa reikiama info, licenzijas ir t.t.
        //galima surasyti ka galima issitraukti, pas ka kreitis licenzijos, kad gauti sita api
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder
                .title("Library API")
                .description("Code academy library")
                .version("1.0")
                .contact(new Contact("Simona Landauskiene", "codeacademy.lt", "simona.marcinkeviciute@codeacademy.lt"));

        return builder.build();
    }
}
