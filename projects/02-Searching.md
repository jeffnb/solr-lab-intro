# Searching 

## Description

For this part of the project it is time to really dig into solr. We are going to connect to our local servers for this and run some simple queries.

## Setup
* Using the `listingssearch` project open up in your favorite IDE.
* Connect to the solr instance as showing in the class.

## Tasks - 45 to 60 minutes
* Run a query to find necklaces
	* Search in the `title` field for the term
	* Only return `id`, `title`, `description`, `price`, `url`
	* Order by price, ascending
	* Loop through the results and simply print out links in the form of `<a href="{url}">{title}({id}) - {price}</a>`
* Run a query using filter queries
	* Filter on digital orders
	* Filter on the `madeFacet` for 2010 - 2017
	* Return the `id` and the `materials`
	* Print out the data as `{id}: [{materials}]`
* Phrases
	* Use the phrase format `<field>:"<phrase>"~<distance> to search for life planner in the `description`. Words should be within 3 words of each other
	* Filter out all digital orders
	* Order by creation date descending
	* Limit to only 5 newest orders
	* Print out the `id` and `description`
* Ranges
	* Find products with `bracelet` in the `title`
	* Make sure the price is between 5 and 15
	* Order by price asc
	* Print out the title and the price
* Relevancy
	* Look for replica and prop in the default field `text`
	* Boost the term prop by 5
	* If both replica and prop are within 5 terms of each other boost by 10
	* Print out the `id` and `title` 
