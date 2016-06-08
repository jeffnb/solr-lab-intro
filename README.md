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
* [In class Solr](http://ec2-184-72-110-170.compute-1.amazonaws.com:8983/solr/#/)
* [Download Solr](http://lucene.apache.org/solr/downloads.html)
* [Solr Reference Guide](https://cwiki.apache.org/confluence/display/solr/Apache+Solr+Reference+Guide)


## Solr setup
* Download: http://mirror.sdunix.com/apache/lucene/solr/6.0.0/solr-6.0.0.zip
* Expand the zip file
* Start: `bin/solr start`
* Stop: `bin/solr stop`

## Setup Complete Demo
* Start solr (from the solr directory): `bin/solr start`
* Create a core: `bin/solr -c movies -d <PATH TO THE movies-demo DIRECTORY>`
* Import data: `bin/post -c movies <YOURPATH>/data-files/movie_data_cleaned.json`
