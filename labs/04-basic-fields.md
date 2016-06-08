# Basic Fields

## Setup
* `bin/solr start`
* `bin/solr -c movies -d <path to start>/movies-start`
* Open file `server/solr/movies/conf/managed_schema`

## Tasks
Find the `id` field and add the following fields with basic types under it
* Country
* Rated
* Language
* imdbVotes
* Type
* Poster
* Metascore
* Year
* actors
* genres
* directors
* writers
* Runtime
* imdbID
* Released
* imdbRating

## Resources
* [Included Field Types](https://cwiki.apache.org/confluence/display/solr/Field+Types+Included+with+Solr)
* [General Field Type Properties](https://cwiki.apache.org/confluence/display/solr/Field+Type+Definitions+and+Properties#FieldTypeDefinitionsandProperties-GeneralProperties)
