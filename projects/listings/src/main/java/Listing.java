import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.solr.common.SolrInputDocument;

import java.util.ArrayList;

/**
 * Created by omni on 4/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Listing {

    public ArrayList<String> style;

    @JsonProperty("when_made")
    public String whenMade;

    @JsonProperty("taxonomy_path")
    public ArrayList<String> taxonomyPath;

    @JsonProperty("is_private")
    public Boolean isPrivate;

    @JsonProperty("is_supply")
    public Boolean isSupply;

    @JsonProperty("item_width")
    public Double itemWidth;

    @JsonProperty("category_path_ids")
    public ArrayList<Integer> categoryPathIds;

    @JsonProperty("original_creation_tsz")
    public Long originalCreation;

    @JsonProperty("category_path")
    public ArrayList<String> categoryPath;

    @JsonProperty("num_favorers")
    public Integer numFavorers;

    @JsonProperty("item_weight_units")
    public String itemWeightUnits;
    public Integer quantity;

    @JsonProperty("last_modified_tsz")
    public Long lastModified;

    @JsonProperty("category_id")
    public Integer categoryId;

    @JsonProperty("featured_rank")
    public Integer featuredRank;

    @JsonProperty("listing_id")
    public Long listingId;
    public String description;

    @JsonProperty("item_height")
    public Double itemHeight;
    public ArrayList<String> tags;

    @JsonProperty("ending_tsz")
    public Long ending;
    public String url;

    @JsonProperty("file_data")
    public String fileData;

    @JsonProperty("used_manufacturer")
    public Boolean usedManufacturer;

    @JsonProperty("is_digital")
    public Boolean isDigital;

    @JsonProperty("item_weight")
    public Double itemWeight;

    @JsonProperty("taxonomy_id")
    public Integer taxonomyId;

    @JsonProperty("currency_code")
    public String currencyCode;

    @JsonProperty("processing_min")
    public Integer processingMin;

    @JsonProperty("user_id")
    public Integer userId;
    public String occasion;
    public String title;
    public String language;

    @JsonProperty("who_made")
    public String whoMade;

    @JsonProperty("item_length")
    public Double itemLength;
    public ArrayList<String> materials;

    @JsonProperty("creation_tsz")
    public Long creation;
    public String recipient;

    @JsonProperty("has_variations")
    public Boolean hasVariations;

    @JsonProperty("processing_max")
    public Integer processingMax;

    @JsonProperty("is_customizable")
    public Boolean isCustomizable;

    @JsonProperty("state_tsz")
    public Long stateTsz;

    @JsonProperty("non_taxable")
    public Boolean nonTaxable;
    public Double price;

    @JsonProperty("item_dimensions_unit")
    public String itemDimensionsUnit;

    @JsonProperty("shop_section_id")
    public Integer shopSectionId;
    public Integer views;
    public String state;

    @JsonProperty("shipping_template_id")
    public Long shippingTemplateId;
    
    public SolrInputDocument createSolrDoc(){
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", listingId);
        doc.addField("whenMade", whenMade);
        doc.addField("taxonomyPath", taxonomyPath);
        doc.addField("isPrivate", isPrivate);
        doc.addField("isSupply", isSupply);
        doc.addField("itemWidth", itemWidth);
        doc.addField("categoryPathId", categoryPathIds);
        doc.addField("numFavors", numFavorers);
        doc.addField("itemWeightUnits", itemWeightUnits);
        doc.addField("quantity", quantity);
        doc.addField("lastModified", lastModified);
        doc.addField("categoryId", categoryId);
        doc.addField("description", description);
        doc.addField("itemHeight", itemHeight);
        doc.addField("tags", tags);
        doc.addField("ending", ending);
        doc.addField("url", url);
        doc.addField("fileData", fileData);
        doc.addField("usedManufacturer", usedManufacturer);
        doc.addField("isDigital", isDigital);
        doc.addField("itemWeight", itemWeight);
        doc.addField("taxonomyId", taxonomyId);
        doc.addField("currencyCode", currencyCode);
        doc.addField("processingMin", processingMin);
        doc.addField("userId", userId);
        doc.addField("occasion", occasion);
        doc.addField("title", title);
        doc.addField("language", language);
        doc.addField("whoMade", whoMade);
        doc.addField("itemLength", itemLength);
        doc.addField("materials", materials);
        doc.addField("creation", creation);
        doc.addField("recipient", recipient);
        doc.addField("hasVariations", hasVariations);
        doc.addField("processingMax", processingMax);
        doc.addField("isCustomizable", isCustomizable);
        doc.addField("stateTsz", stateTsz);
        doc.addField("nonTaxable", nonTaxable);
        doc.addField("price", price);
        doc.addField("itemDimensionUnit", itemDimensionsUnit);
        doc.addField("views", views);
        doc.addField("state", state);
        doc.addField("listingId", listingId);

        return doc;
    }

}
