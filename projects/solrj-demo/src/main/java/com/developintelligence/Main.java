package com.developintelligence;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.request.ConfigSetAdminRequest;
import org.apache.solr.client.solrj.request.schema.AnalyzerDefinition;
import org.apache.solr.client.solrj.request.schema.FieldTypeDefinition;
import org.apache.solr.client.solrj.request.schema.SchemaRequest;
import org.apache.solr.client.solrj.response.*;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;

import java.io.IOException;
import java.util.*;

/**
 * Created by jeff on 6/8/16.
 */
public class Main {

    public static void main(String[] args) throws IOException, SolrServerException {

        //Stand alone server example
//        String urlString = "http://localhost:8983/solr/movies";
//        SolrClient solr = new HttpSolrClient
//                .Builder(urlString).build();

        String zkHostString = "http://localhost:9983";
        SolrClient solr = new CloudSolrClient.Builder().withZkHost(zkHostString).build();

//        SolrClient solr2 = new HttpSolrClient(urlString);

        SolrDocument doc = solr.getById("tt0114709");

        String title = (String)doc.get("Title");
        Integer metaScore = (Integer)doc.getFieldValue("Metascore");
        Collection genres = doc.getFieldValues("genres");

        SolrQuery query = new SolrQuery();
        query.setQuery("Title:future Plot:future");
        query.setFields("id", "Title", "Plot", "Year");
        query.setRows(10);

//        QueryResponse response = solr.query(query);
//        for(SolrDocument d : response.getResults()){
//            System.out.println(d.get("Title"));
//        }

        //Facets
        query.setFacet(true);
        query.addFacetField("Year", "Rated", "genres");
        query.setFacetMinCount(1);

        query.addNumericRangeFacet("Metascore", 0, 100, 10);

        String[] intervals = {"{!key=horrible}[0,50)", "{!key=meh}[50, 75)", "{!key=good}[75, 90)", "{!key=great}[90, 100]"};
        query.addIntervalFacets("Metascore", intervals);

        QueryResponse response = solr.query(query);
        List<FacetField> fields = response.getFacetFields();

        // Year, Rated, genres
        for(FacetField ff : fields){
            String name = ff.getName();
            int valueCount = ff.getValueCount();
            System.out.println("Name: " + name + "Count: " + valueCount);
            // Individual values
            for(FacetField.Count fieldCount : ff.getValues()){
                String value = fieldCount.getName();
                long count = fieldCount.getCount();
            }
        }

        List<RangeFacet> ranges = response.getFacetRanges();
        for(RangeFacet range : ranges){

            List<RangeFacet.Count> counts = range.getCounts();
            for(RangeFacet.Count count : counts){
                String value = count.getValue();
                int valueCount = count.getCount();
            }
        }

        //Intervals
        List<IntervalFacet> intervalFacets = response.getIntervalFacets();
        for(IntervalFacet intervalFacet : intervalFacets){
            for(IntervalFacet.Count count : intervalFacet.getIntervals()){
                String key = count.getKey();
                int keyCount = count.getCount();
            }
        }


        String foo = "Bar";
    }
}
