(ns mattermost-clj.api.status
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn users-status-ids-post-with-http-info
  "Get user statuses by id
  Get a list of user statuses by id from the server.
##### Permissions
Must be authenticated."
  [string ]
  (check-required-params string)
  (call-api "/users/status/ids" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-status-ids-post
  "Get user statuses by id
  Get a list of user statuses by id from the server.
##### Permissions
Must be authenticated."
  [string ]
  (:data (users-status-ids-post-with-http-info string)))

(defn users-user-id-status-get-with-http-info
  "Get user status
  Get user status by id from the server.
##### Permissions
Must be authenticated."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/status" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-status-get
  "Get user status
  Get user status by id from the server.
##### Permissions
Must be authenticated."
  [user-id ]
  (:data (users-user-id-status-get-with-http-info user-id)))

(defn users-user-id-status-put-with-http-info
  "Update user status
  Manually set a user's status. When setting a user's status, the status will remain that value until set \"online\" again, which will return the status to being automatically updated based on user activity.
##### Permissions
Must have `edit_other_users` permission for the team."
  ([user-id ] (users-user-id-status-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-22 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/status" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-22
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-status-put
  "Update user status
  Manually set a user's status. When setting a user's status, the status will remain that value until set \"online\" again, which will return the status to being automatically updated based on user activity.
##### Permissions
Must have `edit_other_users` permission for the team."
  ([user-id ] (users-user-id-status-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-status-put-with-http-info user-id optional-params))))

