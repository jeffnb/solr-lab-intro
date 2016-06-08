# Commits and Caches

## Tasks
* Set up auto commit in the movies solrconfig file
	* Commit every 5 minutes
	* Soft commit every minute
	* Ensure new searcher is opened on commits
* Experiment tuning the caches
	* Enable a filter cache which auto warms with 200 entries
	* Enable a query cache with 20 entries auto warmed
	* Look at the admin Plugins->Cache and checkout the cache levels.  Try queries and watch them change
* Run 3 queries on startup when searcher is warmed

## Resources
* [Uploading data](https://cwiki.apache.org/confluence/display/solr/Uploading+Data+with+Index+Handlers)
* [Post tool](https://cwiki.apache.org/confluence/display/solr/Post+Tool)
* [Caches](https://cwiki.apache.org/confluence/display/solr/Query+Settings+in+SolrConfig)
