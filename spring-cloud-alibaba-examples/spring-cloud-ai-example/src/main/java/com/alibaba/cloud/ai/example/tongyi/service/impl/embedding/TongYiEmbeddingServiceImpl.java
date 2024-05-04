package com.alibaba.cloud.ai.example.tongyi.service.impl.embedding;

import com.alibaba.cloud.ai.example.tongyi.service.AbstractTongYiServiceImpl;
import com.alibaba.cloud.ai.example.tongyi.service.TongYiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingOptions;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TongYiEmbeddingServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TongYiService.class);

    private final EmbeddingClient embeddingClient;

    @Autowired
    public TongYiEmbeddingServiceImpl(EmbeddingClient client) {

        this.embeddingClient = client;
    }

    public EmbeddingResponse embedding() {

        var request = new EmbeddingRequest(List<String> inputs, EmbeddingOptions options);

        return embeddingClient.call(request);
    }


}
