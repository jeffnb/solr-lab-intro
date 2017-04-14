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
	* Copy the url to make sure that it works in your browser
* Range 
	* Use the same range facet from the last part
	* Figure out how to store the ranges in a way to get the result and match it to a range
	* Convert the range into a facet query
	* Print a link for each facet value to produce `<a href="http://localhost:8983/solr/select?fq={facet field}:{[<from> TO <to>]}>{facet value}({value count})</a>`
* Interval
	* Use one of the interval facets from the previous assignment
	* Figure out how to store the intervals you assigned
	* Match each facet value to the interval (keys make this much easier)
	* Print a link like the one above for ranges
