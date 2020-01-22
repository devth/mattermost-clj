(ns mattermost-clj.api.terms-of-service
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn users-user-id-terms-of-service-get-with-http-info
  "Fetches user's latest terms of service action if the latest action was for acceptance.
  Will be deprecated in v6.0
Fetches user's latest terms of service action if the latest action was for acceptance.

__Minimum server version__: 5.6
##### Permissions
Must be logged in as the user being acted on."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/terms_of_service" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-terms-of-service-get
  "Fetches user's latest terms of service action if the latest action was for acceptance.
  Will be deprecated in v6.0
Fetches user's latest terms of service action if the latest action was for acceptance.

__Minimum server version__: 5.6
##### Permissions
Must be logged in as the user being acted on."
  [user-id ]
  (:data (users-user-id-terms-of-service-get-with-http-info user-id)))

(defn users-user-id-terms-of-service-post-with-http-info
  "Records user action when they accept or decline custom terms of service
  Records user action when they accept or decline custom terms of service. Records the action in audit table.
Updates user's last accepted terms of service ID if they accepted it.

__Minimum server version__: 5.4
##### Permissions
Must be logged in as the user being acted on."
  ([user-id ] (users-user-id-terms-of-service-post-with-http-info user-id nil))
  ([user-id {:keys [inline-object-21 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/terms_of_service" :post
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-21
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-terms-of-service-post
  "Records user action when they accept or decline custom terms of service
  Records user action when they accept or decline custom terms of service. Records the action in audit table.
Updates user's last accepted terms of service ID if they accepted it.

__Minimum server version__: 5.4
##### Permissions
Must be logged in as the user being acted on."
  ([user-id ] (users-user-id-terms-of-service-post user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-terms-of-service-post-with-http-info user-id optional-params))))

