import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, SolrServerException {

        Scanner input = new Scanner(new File("cleaned-listings.json"));

        ObjectMapper mapper = new ObjectMapper();
        List<Listing> listings = new ArrayList<>();
        while(input.hasNext()) {
            listings.add(mapper.readValue(input.nextLine(), Listing.class));
        }

    }
}
