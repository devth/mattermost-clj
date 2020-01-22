(ns mattermost-clj.api.bots
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn bots-bot-user-id-assign-user-id-post-with-http-info
  "Assign a bot to a user
  Assign a bot to a specified user.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  [bot-user-id user-id ]
  (check-required-params bot-user-id user-id)
  (call-api "/bots/{bot_user_id}/assign/{user_id}" :post
            {:path-params   {"bot_user_id" bot-user-id "user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn bots-bot-user-id-assign-user-id-post
  "Assign a bot to a user
  Assign a bot to a specified user.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  [bot-user-id user-id ]
  (:data (bots-bot-user-id-assign-user-id-post-with-http-info bot-user-id user-id)))

(defn bots-bot-user-id-disable-post-with-http-info
  "Disable a bot
  Disable a bot.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  [bot-user-id ]
  (check-required-params bot-user-id)
  (call-api "/bots/{bot_user_id}/disable" :post
            {:path-params   {"bot_user_id" bot-user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn bots-bot-user-id-disable-post
  "Disable a bot
  Disable a bot.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  [bot-user-id ]
  (:data (bots-bot-user-id-disable-post-with-http-info bot-user-id)))

(defn bots-bot-user-id-enable-post-with-http-info
  "Enable a bot
  Enable a bot.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  [bot-user-id ]
  (check-required-params bot-user-id)
  (call-api "/bots/{bot_user_id}/enable" :post
            {:path-params   {"bot_user_id" bot-user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn bots-bot-user-id-enable-post
  "Enable a bot
  Enable a bot.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  [bot-user-id ]
  (:data (bots-bot-user-id-enable-post-with-http-info bot-user-id)))

(defn bots-bot-user-id-get-with-http-info
  "Get a bot
  Get a bot specified by its bot id.
##### Permissions
Must have `read_bots` permission for bots you are managing, and `read_others_bots` permission for bots others are managing.
__Minimum server version__: 5.10"
  ([bot-user-id ] (bots-bot-user-id-get-with-http-info bot-user-id nil))
  ([bot-user-id {:keys [include-deleted ]}]
   (check-required-params bot-user-id)
   (call-api "/bots/{bot_user_id}" :get
             {:path-params   {"bot_user_id" bot-user-id }
              :header-params {}
              :query-params  {"include_deleted" include-deleted }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn bots-bot-user-id-get
  "Get a bot
  Get a bot specified by its bot id.
##### Permissions
Must have `read_bots` permission for bots you are managing, and `read_others_bots` permission for bots others are managing.
__Minimum server version__: 5.10"
  ([bot-user-id ] (bots-bot-user-id-get bot-user-id nil))
  ([bot-user-id optional-params]
   (:data (bots-bot-user-id-get-with-http-info bot-user-id optional-params))))

(defn bots-bot-user-id-icon-delete-with-http-info
  "Delete bot's LHS icon image
  Delete bot's LHS icon image based on bot_user_id string parameter.
##### Permissions
Must have `manage_bots` permission.
__Minimum server version__: 5.14"
  [bot-user-id ]
  (check-required-params bot-user-id)
  (call-api "/bots/{bot_user_id}/icon" :delete
            {:path-params   {"bot_user_id" bot-user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn bots-bot-user-id-icon-delete
  "Delete bot's LHS icon image
  Delete bot's LHS icon image based on bot_user_id string parameter.
##### Permissions
Must have `manage_bots` permission.
__Minimum server version__: 5.14"
  [bot-user-id ]
  (:data (bots-bot-user-id-icon-delete-with-http-info bot-user-id)))

(defn bots-bot-user-id-icon-get-with-http-info
  "Get bot's LHS icon
  Get a bot's LHS icon image based on bot_user_id string parameter.
##### Permissions
Must be logged in.
__Minimum server version__: 5.14"
  [bot-user-id ]
  (check-required-params bot-user-id)
  (call-api "/bots/{bot_user_id}/icon" :get
            {:path-params   {"bot_user_id" bot-user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn bots-bot-user-id-icon-get
  "Get bot's LHS icon
  Get a bot's LHS icon image based on bot_user_id string parameter.
##### Permissions
Must be logged in.
__Minimum server version__: 5.14"
  [bot-user-id ]
  (:data (bots-bot-user-id-icon-get-with-http-info bot-user-id)))

(defn bots-bot-user-id-icon-post-with-http-info
  "Set bot's LHS icon image
  Set a bot's LHS icon image based on bot_user_id string parameter. Icon image must be SVG format, all other formats are rejected.
##### Permissions
Must have `manage_bots` permission.
__Minimum server version__: 5.14"
  [bot-user-id ^File image ]
  (check-required-params bot-user-id image)
  (call-api "/bots/{bot_user_id}/icon" :post
            {:path-params   {"bot_user_id" bot-user-id }
             :header-params {}
             :query-params  {}
             :form-params   {"image" image }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn bots-bot-user-id-icon-post
  "Set bot's LHS icon image
  Set a bot's LHS icon image based on bot_user_id string parameter. Icon image must be SVG format, all other formats are rejected.
##### Permissions
Must have `manage_bots` permission.
__Minimum server version__: 5.14"
  [bot-user-id ^File image ]
  (:data (bots-bot-user-id-icon-post-with-http-info bot-user-id image)))

(defn bots-bot-user-id-put-with-http-info
  "Patch a bot
  Partially update a bot by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  ([bot-user-id ] (bots-bot-user-id-put-with-http-info bot-user-id nil))
  ([bot-user-id {:keys [inline-object-69 ]}]
   (check-required-params bot-user-id)
   (call-api "/bots/{bot_user_id}" :put
             {:path-params   {"bot_user_id" bot-user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-69
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn bots-bot-user-id-put
  "Patch a bot
  Partially update a bot by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have `manage_bots` permission. 
__Minimum server version__: 5.10"
  ([bot-user-id ] (bots-bot-user-id-put bot-user-id nil))
  ([bot-user-id optional-params]
   (:data (bots-bot-user-id-put-with-http-info bot-user-id optional-params))))

(defn bots-get-with-http-info
  "Get bots
  Get a page of a list of bots.
##### Permissions
Must have `read_bots` permission for bots you are managing, and `read_others_bots` permission for bots others are managing.
__Minimum server version__: 5.10"
  ([] (bots-get-with-http-info nil))
  ([{:keys [page per-page include-deleted only-orphaned ]}]
   (call-api "/bots" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "include_deleted" include-deleted "only_orphaned" only-orphaned }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn bots-get
  "Get bots
  Get a page of a list of bots.
##### Permissions
Must have `read_bots` permission for bots you are managing, and `read_others_bots` permission for bots others are managing.
__Minimum server version__: 5.10"
  ([] (bots-get nil))
  ([optional-params]
   (:data (bots-get-with-http-info optional-params))))

(defn bots-post-with-http-info
  "Create a bot
  Create a new bot account on the system. Username is required.
##### Permissions
Must have `create_bot` permission.
__Minimum server version__: 5.10"
  ([] (bots-post-with-http-info nil))
  ([{:keys [inline-object-68 ]}]
   (call-api "/bots" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-68
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn bots-post
  "Create a bot
  Create a new bot account on the system. Username is required.
##### Permissions
Must have `create_bot` permission.
__Minimum server version__: 5.10"
  ([] (bots-post nil))
  ([optional-params]
   (:data (bots-post-with-http-info optional-params))))

