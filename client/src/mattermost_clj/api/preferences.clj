(ns mattermost-clj.api.preferences
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn users-user-id-preferences-category-get-with-http-info
  "List a user's preferences by category
  Lists the current user's stored preferences in the given category.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id category ]
  (check-required-params user-id category)
  (call-api "/users/{user_id}/preferences/{category}" :get
            {:path-params   {"user_id" user-id "category" category }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-preferences-category-get
  "List a user's preferences by category
  Lists the current user's stored preferences in the given category.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id category ]
  (:data (users-user-id-preferences-category-get-with-http-info user-id category)))

(defn users-user-id-preferences-category-name-preference-name-get-with-http-info
  "Get a specific user preference
  Gets a single preference for the current user with the given category and name.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id category preference-name ]
  (check-required-params user-id category preference-name)
  (call-api "/users/{user_id}/preferences/{category}/name/{preference_name}" :get
            {:path-params   {"user_id" user-id "category" category "preference_name" preference-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-preferences-category-name-preference-name-get
  "Get a specific user preference
  Gets a single preference for the current user with the given category and name.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id category preference-name ]
  (:data (users-user-id-preferences-category-name-preference-name-get-with-http-info user-id category preference-name)))

(defn users-user-id-preferences-delete-post-with-http-info
  "Delete user's preferences
  Delete a list of the user's preferences.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id preference ]
  (check-required-params user-id preference)
  (call-api "/users/{user_id}/preferences/delete" :post
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    preference
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-preferences-delete-post
  "Delete user's preferences
  Delete a list of the user's preferences.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id preference ]
  (:data (users-user-id-preferences-delete-post-with-http-info user-id preference)))

(defn users-user-id-preferences-get-with-http-info
  "Get the user's preferences
  Get a list of the user's preferences.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/preferences" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-preferences-get
  "Get the user's preferences
  Get a list of the user's preferences.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id ]
  (:data (users-user-id-preferences-get-with-http-info user-id)))

(defn users-user-id-preferences-put-with-http-info
  "Save the user's preferences
  Save a list of the user's preferences.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id preference ]
  (check-required-params user-id preference)
  (call-api "/users/{user_id}/preferences" :put
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    preference
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-preferences-put
  "Save the user's preferences
  Save a list of the user's preferences.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id preference ]
  (:data (users-user-id-preferences-put-with-http-info user-id preference)))

