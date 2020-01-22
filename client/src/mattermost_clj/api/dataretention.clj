(ns mattermost-clj.api.dataretention
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn data-retention-policy-get-with-http-info
  "Get the data retention policy details.
  Gets the current data retention policy details from the server, including what data should be purged and the cutoff times for each data type that should be purged.
__Minimum server version__: 4.3
##### Permissions
Requires an active session but no other permissions."
  []
  (call-api "/data_retention/policy" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn data-retention-policy-get
  "Get the data retention policy details.
  Gets the current data retention policy details from the server, including what data should be purged and the cutoff times for each data type that should be purged.
__Minimum server version__: 4.3
##### Permissions
Requires an active session but no other permissions."
  []
  (:data (data-retention-policy-get-with-http-info)))

