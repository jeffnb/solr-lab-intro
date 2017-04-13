import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, SolrServerException {

        Scanner input = new Scanner(new File("cleaned-listings.json"));

        ObjectMapper mapper = new ObjectMapper();
        List<Listing> listings = new ArrayList<>();
        while(input.hasNext()) {
            listings.add(mapper.readValue(input.nextLine(), Listing.class));
        }


        //Stand alone server example
        String urlString = "http://localhost:8983/solr/listings";
        SolrClient solr = new HttpSolrClient.Builder(urlString).build();

        // Make a date formatter
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM ).withLocale( Locale.US ).withZone( ZoneId.systemDefault() );


        //Create all the documents
        ArrayList<SolrInputDocument> docs = new ArrayList<>();
        Set<Long> ids = new HashSet<>();
        for(Listing l : listings){
            SolrInputDocument doc = l.createSolrDoc();

            if(l.originalCreation != null){
                Instant instant = Instant.ofEpochSecond(l.originalCreation);
                doc.addField("createdFormatted", formatter.format(instant));
            }

            if(l.lastModified != null){
                Instant instant = Instant.ofEpochSecond(l.lastModified);
                doc.addField("modifiedFormatted", formatter.format(instant));
            }

            if(l.views != null && l.views > 0 && l.numFavorers != null && l.numFavorers > 0){
                double popularity = (double)l.numFavorers / l.views;
                doc.addField("popularity", popularity);
            }


            if(l.whenMade != null){
                String made = "";
                if(l.whenMade.equals("made_to_order")){
                    made = "Made to Order";
                }
                else{
                    made = WordUtils.capitalize(l.whenMade.replace("_", " - "));
                }

                doc.addField("madeFacet", made);
            }

            try {
                solr.add(doc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ids.add(l.listingId);
        }
        solr.commit();
        System.out.println("Total ids:" + ids.size());

    }
}
