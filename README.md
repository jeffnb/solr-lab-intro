# Solr Lab Set

## Introduction

This repo contains sample data sets as well as configuration files to run a core with said data.

## Sections
* data-files: 2 files containing movie data sets.  `movie_data_cleaned.json` is the primary resource to use
* configsets: Contains different configuration sets for various points in the lab
	* movies-start: intro config set
	* movies-demo: fully set up schema and config for the dataset
* labs: All of the labs from the class
* resources: In class resources including presentation

## Important Resources
* [In class Solr](http://solr.omnilabsinc.com:8983/solr/#/)
* [Download Solr](http://lucene.apache.org/solr/downloads.html)
* [Solr Reference Guide](https://cwiki.apache.org/confluence/display/solr/Apache+Solr+Reference+Guide)
* [SolrJ Schema JavaDocs](http://lucene.apache.org/solr/5_5_2/solr-solrj/org/apache/solr/client/solrj/request/schema/package-summary.html)

## Solr setup
* Download:
	* Linux/Mac: http://mirror.cogentco.com/pub/apache/lucene/solr/6.5.0/solr-6.5.0.tgz
	* Windows: http://mirror.cogentco.com/pub/apache/lucene/solr/6.5.0/solr-6.5.0.zip 
* Expand the archive file
* Start: 
	* Linux/Mach: `bin/solr start`
	* Windows: `bin\solr.cmd start`
* Stop:
	* Linux/Mach: `bin/solr start`
	* Windows: `bin\solr.cmd start`

## Setup Complete Movies Demo
### Mac/Linux:
* Start solr (from the solr directory): `bin/solr start`
* Create a core: `bin/solr create_core -c movies -d <PATH TO THE movies-demo DIRECTORY>`
* Import data: `bin/post -c movies <YOURPATH>/data-files/movie_data_cleaned.json`
### Windows
* Start solr (from the solr directory): `bin\solr.cmd start`
* Create a core: `bin\solr.cmd create_core -c movies -d <PATH TO THE movies-demo DIRECTORY>`
* Import data: `java -jar -Dtype=application/json -Dc=movies example\exampledocs\post.jar <YOURPATH>\data-files\movie_data_cleaned.json`
