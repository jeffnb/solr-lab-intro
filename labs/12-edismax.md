# edismax

## Tasks
* Create a new search handler “edismax”
* For search fields:
	* Title and Plot are the highest boosted
	* actors, directors and writers have a lower boost
	* Year and Language are searched but not boosted
* All terms should match
* Boost (pf) Title and plot again 
* Rows should be 30
* Fields returned should be Title, Plot and Year
* Return should be indented json
* defType should be edismax

## Resources
* [Dismax Query Parser](https://cwiki.apache.org/confluence/display/solr/The+DisMax+Query+Parser)
* [Extended Dismax Query Parser](https://cwiki.apache.org/confluence/display/solr/The+Extended+DisMax+Query+Parser)
