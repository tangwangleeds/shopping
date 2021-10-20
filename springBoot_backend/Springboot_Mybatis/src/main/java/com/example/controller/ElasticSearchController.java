package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author  wangtang
 */
@Slf4j
@RestController
@RequestMapping("/elasticSearch")
public class ElasticSearchController {





    @RequestMapping("/selectElastic")
    private String search() throws IOException {

        RestHighLevelClient highLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("54.179.56.210", 9200, "http")));

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("packetbeat-7.15.0-2021.10.11-000001");
        searchRequest.types("_doc");

        // 条件=
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("host.hostname", "ip-172-31-45-177.ap-southeast-1.compute.internal");
        TermQueryBuilder termQuery = QueryBuilders.termQuery("host.os.name", "Amazon Linux");
        // 范围查询
        RangeQueryBuilder timeFilter = QueryBuilders.rangeQuery("log_time").gt(12345).lt(343750);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        QueryBuilder totalFilter = QueryBuilders.boolQuery()
                .filter(matchQuery)
                .filter(timeFilter)
                .mustNot(termQuery);

        int size = 200;
        int from = 0;
        long total = 0;

        do {
            try {
                sourceBuilder.query(totalFilter).from(from).size(size);
                sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
                searchRequest.source(sourceBuilder);

              //  RequestOptions  options=new RequestOptions();
                SearchResponse response = highLevelClient.search(searchRequest);
                SearchHit[] hits = response.getHits().getHits();
                for (SearchHit hit : hits) {
                    System.out.println(hit.getSourceAsString());
                }

                 response.getHits();

                System.out.println("Test:[" + total + "][" + from + "-" + (from + hits.length) + ")");

                from += hits.length;

                // from + size must be less than or equal to: [10000]
                if (from >= 10000) {
                    System.out.println("Test:Interruptions over 10,000 entries");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (from < total);


        return "ok";
    }


}
