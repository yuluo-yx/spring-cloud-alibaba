package com.alibaba.cloud.ai.tongyi.embedding;

import com.alibaba.dashscope.embeddings.TextEmbeddingParam;
import org.springframework.ai.embedding.EmbeddingOptions;

import java.util.List;

public class TongYiEmbeddingOptions implements EmbeddingOptions {
    //通义参数
    private List<String> texts;
    private TextEmbeddingParam.TextType textType;

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    public TextEmbeddingParam.TextType getTextType() {
        return textType;
    }

    public void setTextType(TextEmbeddingParam.TextType textType) {
        this.textType = textType;
    }

    public static TongYiEmbeddingOptions.Builder builder() {
        return new TongYiEmbeddingOptions.Builder();
    }

    public final static class Builder {

        private final TongYiEmbeddingOptions options;

        private Builder() {
            this.options = new TongYiEmbeddingOptions();
        }

        public TongYiEmbeddingOptions.Builder withtexts(List<String> texts) {

            options.setTexts(texts);
            return this;
        }

        public TongYiEmbeddingOptions.Builder withtextType(TextEmbeddingParam.TextType textType) {

            options.setTextType(textType);
            return this;
        }

        public TongYiEmbeddingOptions build() {

            return options;
        }

    }

}
