package com.alibaba.cloud.ai.tongyi.metadata;

import com.alibaba.dashscope.embeddings.TextEmbeddingUsage;

import org.springframework.ai.embedding.EmbeddingResponseMetadata;

/**
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 */

public class TongYiTextEmbeddingResponseMetadata extends EmbeddingResponseMetadata {

	private Integer totalTokens;

	protected TongYiTextEmbeddingResponseMetadata(Integer totalTokens) {

		this.totalTokens = totalTokens;
	}

	public static TongYiTextEmbeddingResponseMetadata from(TextEmbeddingUsage usage) {

		return new TongYiTextEmbeddingResponseMetadata(usage.getTotalTokens());
	}

	public Integer getTotalTokens() {

		return totalTokens;
	}

	public void setTotalTokens(Integer totalTokens) {

		this.totalTokens = totalTokens;
	}
}
