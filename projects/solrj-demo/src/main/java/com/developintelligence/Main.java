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
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
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
        String urlString = "http://localhost:8983/solr/demo";
        SolrClient solr = new HttpSolrClient
                .Builder(urlString).build();

        //SolrCloud Connection
//        String zkHostString = "localhost:9983";
//        SolrClient solr = new CloudSolrClient.Builder()
//                .withZkHost(zkHostString).build();

        /************************************************
         * Searching
         ************************************************/

        SolrDocument doc = null;
        //Simple Search by Id
        doc = solr.getById("tt0113497");

        //SolrDocument basically wrapped Map
        String title = (String)doc.get("Title");
        Integer metascore = (Integer)doc.getFieldValue("Metascore");
        Collection<Object> genres = doc.getFieldValues("genres");
        Collection<String> names = doc.getFieldNames();

        if(doc != null){
            System.out.println("Got a doc");
        }
        // Simple search for toy with a few fields
        SolrQuery query = new SolrQuery();
        query.setQuery("Title:future");
        query.setFields("id", "Title", "Plot", "Year");
        query.setRows(10);

        // Sorting done with a SortClause
        SolrQuery.SortClause sort;
        sort = new SolrQuery.SortClause("Title",
                SolrQuery.ORDER.asc);
        query.setSort(sort);

        // Facets
        query.setFacet(true);
        query.addFacetField("Year", "Rated", "genres");
        query.setFacetMinCount(1);
        query.addNumericRangeFacet("Metascore", 1, 100, 10);
        query.setFacetLimit(100);

        // Call solr with search
        QueryResponse response = solr.query(query);
        // Get Facet Fields
        List<FacetField> fields = response.getFacetFields();
        for(FacetField ff : fields){
            String name = ff.getName();
            int valueCount = ff.getValueCount();
            // Get individual values/counts
            for(FacetField.Count fieldCount : ff.getValues()){
                String value = fieldCount.getName();
                long count = fieldCount.getCount();
            }
        }

        /************************************************
         * Schema Api
         ************************************************/

        // Get all fields
        SchemaRequest.Fields fieldsRequest =
                new SchemaRequest.Fields();
        NamedList fieldsResponse = solr.request(fieldsRequest);
        List fieldsList = (List)fieldsResponse.get("fields");

        // Getting a field
        SchemaRequest.Field request =
                new SchemaRequest.Field("Title");
        NamedList fieldResponse = solr.request(request);

        // Getting a field type
        SchemaRequest.FieldType ft = new SchemaRequest.FieldType("text_general");
        NamedList ftNamedList = solr.request(ft);


        // Don't be fooled this is not extending map
        SimpleOrderedMap fieldMap =
                (SimpleOrderedMap)fieldResponse.get("field");
        String name = (String)fieldMap.get("name");
        String type = (String)fieldMap.get("type");
        Boolean indexed = (Boolean)fieldMap.get("indexed");

        // Create the map for the values
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name", "amazon");
        valueMap.put("type", "string");
        valueMap.put("stored", true);
        valueMap.put("indexed", false);
        SchemaRequest.AddField addFieldRequest =
                new SchemaRequest.AddField(valueMap);
        //Returns the newly created field
        NamedList addFieldResponse = solr.request(request);

        FieldTypeDefinition fieldTypeDefinition = new FieldTypeDefinition();
        AnalyzerDefinition analyzerDefinition = new AnalyzerDefinition();
        analyzerDefinition.setFilters();
        fieldTypeDefinition.setAnalyzer();
        SchemaRequest.AddFieldType addFieldType = new SchemaRequest.AddFieldType()


        /************************************************
         * Indexing
         ************************************************/
        ConcurrentUpdateSolrClient conSolr =
                new ConcurrentUpdateSolrClient.Builder(urlString).build();
        conSolr.setRequestWriter(new BinaryRequestWriter());

        SolrInputDocument document = new SolrInputDocument();
        document.addField("Type", "movie");
        document.addField("id", "tt1234566");
        document.addField("genres",
                Arrays.asList("horror", "thriller"));
        UpdateResponse addResponse = conSolr.add(document);

        //By default will block until hard commit is done
        UpdateResponse commit = solr.commit();

        //By default will block until complete
        UpdateResponse optimize = solr.optimize();

        String foo = "bar";

    }
}
