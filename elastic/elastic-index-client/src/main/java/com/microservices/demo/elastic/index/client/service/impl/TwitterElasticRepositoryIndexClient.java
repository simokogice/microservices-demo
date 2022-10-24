package com.microservices.demo.elastic.index.client.service.impl;

import com.microservices.demo.elastic.index.client.repository.TwitterElasticsearchIndexRepository;
import com.microservices.demo.elastic.index.client.service.ElasticIndexClient;
import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@ConditionalOnProperty(name = "elastic-config.is-repository", havingValue = "true", matchIfMissing = true)
public class TwitterElasticRepositoryIndexClient implements ElasticIndexClient<TwitterIndexModel> {
   private final TwitterElasticsearchIndexRepository twitterElasticsearchIndexRepository;
    @Override
    public List<IndexedObjectInformation> save(List<TwitterIndexModel> documents) {
        List<TwitterIndexModel> twitterIndexModels = (List<TwitterIndexModel>) twitterElasticsearchIndexRepository.saveAll(documents);
        var ids = twitterIndexModels.stream().map(twitterIndexModel ->  IndexedObjectInformation.of(twitterIndexModel.getId(), null, null, null))
                .collect(Collectors.toList());
        log.info("Documents indexed successfully with type: {} and ids: {}", TwitterIndexModel.class.getName(), ids);
        return ids;
    }
}
