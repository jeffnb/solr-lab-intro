package com.developintelligence;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;

import java.io.IOException;

/**
 * Created by jeff on 6/8/16.
 */
public class Main {

    public static void main(String[] args) {

        //Stand alone server example
//        String urlString = "http://localhost:8983/solr/techproducts";
//        SolrClient solr = new HttpSolrClient(urlString);

        //SolrCloud Connection
        String zkHostString = "localhost:9983";
        SolrClient solr = new CloudSolrClient(zkHostString);

        SolrDocument doc;
        try {
            //If you are in cloud mode you must specify the collection as well as the id
            doc = solr.getById("movies-cloud", "tt0113497");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
