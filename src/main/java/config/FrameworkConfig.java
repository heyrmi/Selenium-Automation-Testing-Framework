package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/config.properties"
})

public interface FrameworkConfig extends Config{
    // TODO: Transform this to follow different environment structures

    @Key("url")
    String url();

    @Key("overridereports")
    @DefaultValue("true")
    Boolean overridereports();

    @Key("passedstepsscreenshots")
    @DefaultValue("false")
    Boolean passedstepsscreenshots();

    @Key("failedstepsscreenshots")
    @DefaultValue("false")
    Boolean failedstepsscreenshots();

    @Key("retryfailedtests")
    @DefaultValue("false")
    Boolean retryfailedtests();

    @Key("runmode")
    @DefaultValue("remote")
    String runmode();

    @Key("platform")
    @DefaultValue("selenoid")
    String platform();

    @Key("sendresulttoelk")
    @DefaultValue("false")
    Boolean sendresulttoelk();

    @Key("seleniumgridurl")
    @DefaultValue("http://localhost:4444/wd/hub")
    String seleniumgridurl();

    @Key("elasticurl")
    @DefaultValue("http://localhost:9200/regression/results")
    String elasticurl();

}
