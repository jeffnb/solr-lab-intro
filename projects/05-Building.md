# Building a Schema

## Description
You have seen what is available in the core now it is time to create a schema for it.  A couple things to note:
* You will be doing a scaled back version as many of the fields were fairly worthless
* If you are confused look at the already built solr core (query only) to try to figure out what should happen

## Fields
These are the field that will need to be in the core assume all are stored
* whenMade
* taxonomyPath
* numFavors
* quantity
* lastModified
* description
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
