(ns mattermost-clj.api.open-graph
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn opengraph-post-with-http-info
  "Get open graph metadata for url
  Get Open Graph Metadata for a specif URL. Use the Open Graph protocol to get some generic metadata about a URL. Used for creating link previews.

__Minimum server version__: 3.10

##### Permissions
No permission required but must be logged in."
  ([] (opengraph-post-with-http-info nil))
  ([{:keys [inline-object-65 ]}]
   (call-api "/opengraph" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-65
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn opengraph-post
  "Get open graph metadata for url
  Get Open Graph Metadata for a specif URL. Use the Open Graph protocol to get some generic metadata about a URL. Used for creating link previews.

__Minimum server version__: 3.10

##### Permissions
No permission required but must be logged in."
  ([] (opengraph-post nil))
  ([optional-params]
   (:data (opengraph-post-with-http-info optional-params))))

