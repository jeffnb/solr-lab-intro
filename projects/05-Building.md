# Building a Schema

## Description
You have seen what is available in the core now it is time to create a schema for it.  A couple things to note:
* You will be doing a scaled back version as many of the fields were fairly worthless
* If you are confused look at the already built solr core (query only) to try to figure out what should happen

## Setting up the Core
* Make sure solr is running
* In the solr directory run `bin/solr create_core -c listingproject -d <path-to-repo>/configsets/listings-start/`
* This gives you basically a blank core
* Make your changes in `server/solr/listingproject/conf/managed-schema`
* As you make your changes reload the core
* If the core fails you may need to restart solr

## Fields
These are the field that will need to be in the core assume all are stored. Take note as to which are required in the list and also pay attention to which are multivalued based on the data from the core.
* whenMade
* taxonomyPath
* numFavors
* quantity - required
* lastModified - required
* description
* listingId - required
* tags
* ending
* url
* fileData
* isDigital
* currencyCode
* userId
* title
* materials
* creation
* price
* views
* state

### Manipulated Fields
These are fields that are going to need to be changed in the java code to work.
* lastModifiedAt: Is a date in the format YYYY-MM-DDThh:mm:ssZ. Base the data on `lastModified` time stamp
* createdAt: Is a date in the format YYYY-MM-DDThh:mm:ssZ. Base on the data in `creation`
* recipientFacet: Uppercase and remove _ from the `recipient` field to make a nice facet

### Copy Fields
Create these fields and make sure that you have the directive to copy them over.  Assume these are going to be searchable so use either the `text_en`, `text_general` or make your own.
* text: This should already exist. Make sure you copy useful filds in
* tagsSearch: source `tags`
* recipientSearch: source `recipient`
* materialsSearch: source `materials`
* taxonomyPathSearch: source `taxonomyPath`

### Optional
* rating: This doesn't exist so put in a random number
* yearMade: This is a special field that represents all years that the item could have been made in.

## Hint
Since you have a working solr core running already with similar data, use the query admin and do a facet on fields like whenMade to get a sense of the values
