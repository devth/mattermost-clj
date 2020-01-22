(ns mattermost-clj.api.elasticsearch
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn elasticsearch-purge-indexes-post-with-http-info
  "Purge all Elasticsearch indexes
  Deletes all Elasticsearch indexes and their contents. After calling this endpoint, it is
necessary to schedule a new Elasticsearch indexing job to repopulate the indexes.
__Minimum server version__: 4.1
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/elasticsearch/purge_indexes" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn elasticsearch-purge-indexes-post
  "Purge all Elasticsearch indexes
  Deletes all Elasticsearch indexes and their contents. After calling this endpoint, it is
necessary to schedule a new Elasticsearch indexing job to repopulate the indexes.
__Minimum server version__: 4.1
##### Permissions
Must have `manage_system` permission."
  []
  (:data (elasticsearch-purge-indexes-post-with-http-info)))

(defn elasticsearch-test-post-with-http-info
  "Test Elasticsearch configuration
  Test the current Elasticsearch configuration to see if the Elasticsearch server can be contacted successfully.
Optionally provide a configuration in the request body to test. If no valid configuration is present in the
request body the current server configuration will be tested.

__Minimum server version__: 4.1
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/elasticsearch/test" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn elasticsearch-test-post
  "Test Elasticsearch configuration
  Test the current Elasticsearch configuration to see if the Elasticsearch server can be contacted successfully.
Optionally provide a configuration in the request body to test. If no valid configuration is present in the
request body the current server configuration will be tested.

__Minimum server version__: 4.1
##### Permissions
Must have `manage_system` permission."
  []
  (:data (elasticsearch-test-post-with-http-info)))

