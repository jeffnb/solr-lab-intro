# Listings core set up

## Description
Instructions to set up the demo version of the listings core

## Instructions

### Setup the core itself
* Ensure solr is running (Usually http://locahost:8983/solr/)
* `bin/solr create_core -c listings -d <path_to_class_repo>/configsets/listings-demo/`
* Ensure the core was created in the admin http://locahost:8983/solr/~cores/

### Add Data
* Unzip the `listings.zip` file
* Make sure the `cleaned_listings.json` is in the same directroy as `listings-1.0-SNAPSHOT-jar-with-dependencies.jar`
* Run the jar file while in the same directory `java -jar listings-1.0-SNAPSHOT-jar-with-dependencies.jar`
* Once the previous step is done check the core http://localhost:8983/solr/#/listings and make sure it has ~39k documents
