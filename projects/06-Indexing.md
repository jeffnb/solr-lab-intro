# Indexing

## Description
We are going to be transformation the data next. To speed up the tedious parts of the process, there is a class that will hold all the data as well as the mapper already provided for you in the `projects/listings` directory.
*IMPORTANT NOTE*: This can take several tries to get right. Mistakes are made. Do not be afraid to make changes, reload your core and ask questions.


## Tasks
The tasks are basically getting the data from the json file into the solr index.  The project provided takes care of pulling the json out of the file and putting it into a nice clean POJO to save on time.

* Loop through each listing
* Create a new solr document (SolrInputDocument)
* Add all of the fields that were added in the previous step to the document
* Either add each solr document to the index with `solr.add()` or create a list and add them all at the same time
* Make sure you take care of the fields that need to be changed
* Commit after all documents are in
* Optimize at the end as well

### Manipulated Fields
* lastModifiedAt: Is a date in the format YYYY-MM-DDThh:mm:ssZ. Base the data on `lastModified` time stamp
* createdAt: Is a date in the format YYYY-MM-DDThh:mm:ssZ. Base on the data in `creation`
* recipientFacet: Uppercase and remove _ from the `recipient` field to make a nice facet
* id: Default primary key. Make sure to populate this with `listingId`

### Optional
If you chose to add the extra fields in solr try to make java populate them correctly.
* rating: This doesn't exist so put in a random number
* yearMade: This is a special field that represents all years that the item could have been made in.

## Hint
Since you have a working solr core running already with similar data, use the query admin and do a facet on fields like whenMade to get a sense of the values
