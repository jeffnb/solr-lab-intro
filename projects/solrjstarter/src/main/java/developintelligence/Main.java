package developintelligence;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * Created by omni on 4/30/17.
 */
public class Main {

    public static void main(String[] args) {
        //Stand alone server example
        String urlString = "http://localhost:8983/solr/movies";
        SolrClient solr = new HttpSolrClient
                .Builder(urlString).build();

        // Solr cloud connection
        // String zkHostString = "http://localhost:9983";
        // SolrClient solr = new CloudSolrClient.Builder().withZkHost(zkHostString).build();
    }

}
