package com.alibaba.cloud.ai.example.tongyi.service.impl.textembedding;

import java.util.List;
import java.util.logging.Logger;

import com.alibaba.cloud.ai.example.tongyi.service.AbstractTongYiServiceImpl;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.stereotype.Service;

/**
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 */

@Service
public class TongYiTextEmbeddingServiceImpl extends AbstractTongYiServiceImpl {

	private final Logger logger = Logger.getLogger(TongYiTextEmbeddingServiceImpl.class.getName());

	private final EmbeddingClient embeddingClient;

	public TongYiTextEmbeddingServiceImpl(EmbeddingClient embeddingClient) {

		this.embeddingClient = embeddingClient;
	}

	@Override
	public List<Double> textEmbedding(String text) {

		return embeddingClient.embed(text);
	}
}
