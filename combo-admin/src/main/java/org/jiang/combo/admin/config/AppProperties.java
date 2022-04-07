package org.jiang.combo.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "combo")
public class AppProperties {
    private String url;
}
