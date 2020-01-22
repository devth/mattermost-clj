(ns mattermost-clj.api.emoji
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn emoji-autocomplete-get-with-http-info
  "Autocomplete custom emoji
  Get a list of custom emoji with names starting with or matching the provided name. Returns a maximum of 100 results.
##### Permissions
Must be authenticated.

__Minimum server version__: 4.7"
  [name ]
  (check-required-params name)
  (call-api "/emoji/autocomplete" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"name" name }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn emoji-autocomplete-get
  "Autocomplete custom emoji
  Get a list of custom emoji with names starting with or matching the provided name. Returns a maximum of 100 results.
##### Permissions
Must be authenticated.

__Minimum server version__: 4.7"
  [name ]
  (:data (emoji-autocomplete-get-with-http-info name)))

(defn emoji-emoji-id-delete-with-http-info
  "Delete a custom emoji
  Delete a custom emoji.
##### Permissions
Must have the `manage_team` or `manage_system` permissions or be the user who created the emoji."
  [emoji-id ]
  (check-required-params emoji-id)
  (call-api "/emoji/{emoji_id}" :delete
            {:path-params   {"emoji_id" emoji-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn emoji-emoji-id-delete
  "Delete a custom emoji
  Delete a custom emoji.
##### Permissions
Must have the `manage_team` or `manage_system` permissions or be the user who created the emoji."
  [emoji-id ]
  (:data (emoji-emoji-id-delete-with-http-info emoji-id)))

(defn emoji-emoji-id-get-with-http-info
  "Get a custom emoji
  Get some metadata for a custom emoji.
##### Permissions
Must be authenticated."
  [emoji-id ]
  (check-required-params emoji-id)
  (call-api "/emoji/{emoji_id}" :get
            {:path-params   {"emoji_id" emoji-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn emoji-emoji-id-get
  "Get a custom emoji
  Get some metadata for a custom emoji.
##### Permissions
Must be authenticated."
  [emoji-id ]
  (:data (emoji-emoji-id-get-with-http-info emoji-id)))

(defn emoji-emoji-id-image-get-with-http-info
  "Get custom emoji image
  Get the image for a custom emoji.
##### Permissions
Must be authenticated."
  [emoji-id ]
  (check-required-params emoji-id)
  (call-api "/emoji/{emoji_id}/image" :get
            {:path-params   {"emoji_id" emoji-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn emoji-emoji-id-image-get
  "Get custom emoji image
  Get the image for a custom emoji.
##### Permissions
Must be authenticated."
  [emoji-id ]
  (:data (emoji-emoji-id-image-get-with-http-info emoji-id)))

(defn emoji-get-with-http-info
  "Get a list of custom emoji
  Get a page of metadata for custom emoji on the system. Since server version 4.7, sort using the `sort` query parameter.
##### Permissions
Must be authenticated."
  ([] (emoji-get-with-http-info nil))
  ([{:keys [page per-page sort ]}]
   (call-api "/emoji" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "sort" sort }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn emoji-get
  "Get a list of custom emoji
  Get a page of metadata for custom emoji on the system. Since server version 4.7, sort using the `sort` query parameter.
##### Permissions
Must be authenticated."
  ([] (emoji-get nil))
  ([optional-params]
   (:data (emoji-get-with-http-info optional-params))))

(defn emoji-name-emoji-name-get-with-http-info
  "Get a custom emoji by name
  Get some metadata for a custom emoji using its name.
##### Permissions
Must be authenticated.

__Minimum server version__: 4.7"
  [emoji-name ]
  (check-required-params emoji-name)
  (call-api "/emoji/name/{emoji_name}" :get
            {:path-params   {"emoji_name" emoji-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn emoji-name-emoji-name-get
  "Get a custom emoji by name
  Get some metadata for a custom emoji using its name.
##### Permissions
Must be authenticated.

__Minimum server version__: 4.7"
  [emoji-name ]
  (:data (emoji-name-emoji-name-get-with-http-info emoji-name)))

(defn emoji-post-with-http-info
  "Create a custom emoji
  Create a custom emoji for the team.
##### Permissions
Must be authenticated."
  [^File image emoji ]
  (check-required-params image emoji)
  (call-api "/emoji" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"image" image "emoji" emoji }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn emoji-post
  "Create a custom emoji
  Create a custom emoji for the team.
##### Permissions
Must be authenticated."
  [^File image emoji ]
  (:data (emoji-post-with-http-info image emoji)))

(defn emoji-search-post-with-http-info
  "Search custom emoji
  Search for custom emoji by name based on search criteria provided in the request body. A maximum of 200 results are returned.
##### Permissions
Must be authenticated.

__Minimum server version__: 4.7"
  ([] (emoji-search-post-with-http-info nil))
  ([{:keys [inline-object-50 ]}]
   (call-api "/emoji/search" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-50
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn emoji-search-post
  "Search custom emoji
  Search for custom emoji by name based on search criteria provided in the request body. A maximum of 200 results are returned.
##### Permissions
Must be authenticated.

__Minimum server version__: 4.7"
  ([] (emoji-search-post nil))
  ([optional-params]
   (:data (emoji-search-post-with-http-info optional-params))))

