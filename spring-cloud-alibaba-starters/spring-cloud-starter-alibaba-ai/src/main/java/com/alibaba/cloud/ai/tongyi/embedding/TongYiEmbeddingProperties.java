package com.alibaba.cloud.ai.tongyi.embedding;

import com.alibaba.cloud.ai.tongyi.image.TongYiImagesOptions;
import com.alibaba.cloud.ai.tongyi.image.TongYiImagesProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.embedding.EmbeddingOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(TongYiEmbeddingProperties.CONFIG_PREFIX)
public class TongYiEmbeddingProperties {
    private final Logger logger = LoggerFactory.getLogger(TongYiEmbeddingProperties.class);

    public static final String CONFIG_PREFIX = "spring.cloud.ai.tongyi.embedding";

   //一些默认配置

    private boolean enabled = true;

    @NestedConfigurationProperty
    private TongYiEmbeddingOptions options;

    public TongYiEmbeddingOptions getOptions() {

        return this.options;
    }

    public void setOptions(TongYiEmbeddingOptions options) {

        this.options = options;
    }

    public boolean isEnabled() {

        return this.enabled;
    }

    public void setEnabled(boolean enabled) {

        this.enabled = enabled;
    }

}
