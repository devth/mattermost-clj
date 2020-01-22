(ns mattermost-clj.api.cluster
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn cluster-status-get-with-http-info
  "Get cluster status
  Get a set of information for each node in the cluster, useful for checking the
   status and health of each node.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/cluster/status" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn cluster-status-get
  "Get cluster status
  Get a set of information for each node in the cluster, useful for checking the status and health of each node.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (cluster-status-get-with-http-info)))

