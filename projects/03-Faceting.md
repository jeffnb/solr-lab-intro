# Searching - Facets

## Description
Now we will dig into facets with SolrJ including pulling them back and using them.

## Tasks
* Run a query for `ring` in `description`
	* Get a facets for `recipient`, `taxonomyPath`, `madeFacet`, `materials`
	* Make sure they have at count of at least 1
	* Filter on state of active
	* Print out the title of each facet then each facet value with a count
* Get only facets back for this one
	* Facet with `tags`
	* Limit the facets to a minimum of 10
	* Limit how many values are returned to 5
	* Print values out
* Range Facet
	* Range Facet on price
		* 10 and below
		* 10 - 25
		* 25 - 50
		* 50 - 100
		* 100 - 250
		* 250 above
	* Range Facet on `numFavors`
		* 1 to 5
		* 5 to 10
		* 10 to 25
		* 25 to 50
		* 50 to 75
		* 75 to 100
* Interval Facet
