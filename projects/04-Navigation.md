# Navigation

## Description

Solr is used heavily for facetted navigation. The flow is simple.
1. Get a facet
2. Generate a filter query link for each facet value
3. Display the links so a user can click on it and get a new filtered query 

## Tasks
* Facet Navigation
	* Facet on `materials`
	* Create a link for each facet values `<a href="http://localhost:8983/solr/select?fq={facet field}:{facet value}>{facet value}({value count})</a>`
