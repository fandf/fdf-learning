package com.fandf.mall.search.mapper;

import com.fandf.mall.search.model.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuSearchMapper extends ElasticsearchRepository<SkuEs,String> {
}
