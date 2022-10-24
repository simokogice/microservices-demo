package com.microservices.demo.elastic.index.client.service;

import com.microservices.demo.elastic.model.index.IndexModel;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;

import java.util.List;

public interface ElasticIndexClient<T extends IndexModel> {
    List<IndexedObjectInformation> save(List<T> documents);
}
