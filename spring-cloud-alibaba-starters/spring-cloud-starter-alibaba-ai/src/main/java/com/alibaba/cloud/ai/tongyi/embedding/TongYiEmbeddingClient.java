package com.alibaba.cloud.ai.tongyi.embedding;

import com.alibaba.cloud.ai.tongyi.exception.TongYiImagesException;
import com.alibaba.dashscope.embeddings.TextEmbedding;
import com.alibaba.dashscope.embeddings.TextEmbeddingParam;
import com.alibaba.dashscope.embeddings.TextEmbeddingResult;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.embedding.*;
import org.springframework.util.Assert;

import java.util.List;

import static com.alibaba.cloud.ai.tongyi.metadata.TongYiImagesResponseMetadata.from;

public class TongYiEmbeddingClient implements EmbeddingClient {
    private final Logger logger = LoggerFactory.getLogger(TongYiEmbeddingClient.class);

    //调用api
    private final  TextEmbedding textEmbedding;

    //声明参数
    private TongYiEmbeddingOptions defaultOptions;

    //获取默认的参数
    public TongYiEmbeddingOptions getDefaultOptions(){
        return this.defaultOptions;
    }

    //构造器
    public TongYiEmbeddingClient(TextEmbedding textEmbedding) {

        this(textEmbedding, TongYiEmbeddingOptions.
                builder()
                .build()
        );
    }

    public TongYiEmbeddingClient(TextEmbedding textEmbedding, TongYiEmbeddingOptions embedoptions){

        Assert.notNull(textEmbedding, "textEmbedding must not be null");
        Assert.notNull(embedoptions, "TongYiEmbeddingOptions must not be null");


        this.textEmbedding = textEmbedding;
        this.defaultOptions = embedoptions;
    }

    //调用嵌入服务
    @Override
    public EmbeddingResponse call(EmbeddingRequest embeddingRequest) {
        TextEmbeddingResult result;
        //进行输入参数处理,主要和EmbeddingRequest处理相关
        List<String> request = embeddingRequest.getInstructions();
        var embedParams = TextEmbeddingParam.builder()
                .textType()
                .build();


        //进行调用
        try {
            result = textEmbedding.call(embedParams);
        }
        catch (NoApiKeyException e) {

            logger.error("TongYi models embedding failed: {}.", e.getMessage());
            throw new TongYiImagesException(e.getMessage());
        }
        return convert(result);
    }

    //进行响应转换
    private EmbeddingResponse convert(TextEmbeddingResult result){
        //进行输出的处理
        return new EmbeddingResponse(
                result.getOutput().getEmbeddings(),
                from(result)
                //把通义的返回值变成spring ai返回值类型？
        );
    }

    //进行嵌入处理
    // 实现 embed 方法，将文本转换为嵌入向量
    @Override
    public List<Double> embed(String text) {
        Assert.notNull(text, "Text must not be null");
        // 调用父类的 embed 方法
        return embed(List.of(text)).get(0);
    }

    // 实现 dimensions 方法，获取嵌入向量的维度
    @Override
    public int dimensions() {
        // 调用父类的 dimensions 方法
        return EmbeddingClient.super.dimensions();
    }

}
