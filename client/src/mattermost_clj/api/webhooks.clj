(ns mattermost-clj.api.webhooks
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn hooks-incoming-get-with-http-info
  "List incoming webhooks
  Get a page of a list of incoming webhooks. Optionally filter for a specific team using query parameters.
##### Permissions
`manage_webhooks` for the system or `manage_webhooks` for the specific team."
  ([] (hooks-incoming-get-with-http-info nil))
  ([{:keys [page per-page team-id ]}]
   (call-api "/hooks/incoming" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "team_id" team-id }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn hooks-incoming-get
  "List incoming webhooks
  Get a page of a list of incoming webhooks. Optionally filter for a specific team using query parameters.
##### Permissions
`manage_webhooks` for the system or `manage_webhooks` for the specific team."
  ([] (hooks-incoming-get nil))
  ([optional-params]
   (:data (hooks-incoming-get-with-http-info optional-params))))

(defn hooks-incoming-hook-id-get-with-http-info
  "Get an incoming webhook
  Get an incoming webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (check-required-params hook-id)
  (call-api "/hooks/incoming/{hook_id}" :get
            {:path-params   {"hook_id" hook-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn hooks-incoming-hook-id-get
  "Get an incoming webhook
  Get an incoming webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (:data (hooks-incoming-hook-id-get-with-http-info hook-id)))

(defn hooks-incoming-hook-id-put-with-http-info
  "Update an incoming webhook
  Update an incoming webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  ([hook-id ] (hooks-incoming-hook-id-put-with-http-info hook-id nil))
  ([hook-id {:keys [inline-object-52 ]}]
   (check-required-params hook-id)
   (call-api "/hooks/incoming/{hook_id}" :put
             {:path-params   {"hook_id" hook-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-52
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn hooks-incoming-hook-id-put
  "Update an incoming webhook
  Update an incoming webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  ([hook-id ] (hooks-incoming-hook-id-put hook-id nil))
  ([hook-id optional-params]
   (:data (hooks-incoming-hook-id-put-with-http-info hook-id optional-params))))

(defn hooks-incoming-post-with-http-info
  "Create an incoming webhook
  Create an incoming webhook for a channel.
##### Permissions
`manage_webhooks` for the channel the webhook is in."
  ([] (hooks-incoming-post-with-http-info nil))
  ([{:keys [inline-object-51 ]}]
   (call-api "/hooks/incoming" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-51
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn hooks-incoming-post
  "Create an incoming webhook
  Create an incoming webhook for a channel.
##### Permissions
`manage_webhooks` for the channel the webhook is in."
  ([] (hooks-incoming-post nil))
  ([optional-params]
   (:data (hooks-incoming-post-with-http-info optional-params))))

(defn hooks-outgoing-get-with-http-info
  "List outgoing webhooks
  Get a page of a list of outgoing webhooks. Optionally filter for a specific team or channel using query parameters.
##### Permissions
`manage_webhooks` for the system or `manage_webhooks` for the specific team/channel."
  ([] (hooks-outgoing-get-with-http-info nil))
  ([{:keys [page per-page team-id channel-id ]}]
   (call-api "/hooks/outgoing" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "team_id" team-id "channel_id" channel-id }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn hooks-outgoing-get
  "List outgoing webhooks
  Get a page of a list of outgoing webhooks. Optionally filter for a specific team or channel using query parameters.
##### Permissions
`manage_webhooks` for the system or `manage_webhooks` for the specific team/channel."
  ([] (hooks-outgoing-get nil))
  ([optional-params]
   (:data (hooks-outgoing-get-with-http-info optional-params))))

(defn hooks-outgoing-hook-id-delete-with-http-info
  "Delete an outgoing webhook
  Delete an outgoing webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (check-required-params hook-id)
  (call-api "/hooks/outgoing/{hook_id}" :delete
            {:path-params   {"hook_id" hook-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn hooks-outgoing-hook-id-delete
  "Delete an outgoing webhook
  Delete an outgoing webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (:data (hooks-outgoing-hook-id-delete-with-http-info hook-id)))

(defn hooks-outgoing-hook-id-get-with-http-info
  "Get an outgoing webhook
  Get an outgoing webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (check-required-params hook-id)
  (call-api "/hooks/outgoing/{hook_id}" :get
            {:path-params   {"hook_id" hook-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn hooks-outgoing-hook-id-get
  "Get an outgoing webhook
  Get an outgoing webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (:data (hooks-outgoing-hook-id-get-with-http-info hook-id)))

(defn hooks-outgoing-hook-id-put-with-http-info
  "Update an outgoing webhook
  Update an outgoing webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  ([hook-id ] (hooks-outgoing-hook-id-put-with-http-info hook-id nil))
  ([hook-id {:keys [inline-object-54 ]}]
   (check-required-params hook-id)
   (call-api "/hooks/outgoing/{hook_id}" :put
             {:path-params   {"hook_id" hook-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-54
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn hooks-outgoing-hook-id-put
  "Update an outgoing webhook
  Update an outgoing webhook given the hook id.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  ([hook-id ] (hooks-outgoing-hook-id-put hook-id nil))
  ([hook-id optional-params]
   (:data (hooks-outgoing-hook-id-put-with-http-info hook-id optional-params))))

(defn hooks-outgoing-hook-id-regen-token-post-with-http-info
  "Regenerate the token for the outgoing webhook.
  Regenerate the token for the outgoing webhook.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (check-required-params hook-id)
  (call-api "/hooks/outgoing/{hook_id}/regen_token" :post
            {:path-params   {"hook_id" hook-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn hooks-outgoing-hook-id-regen-token-post
  "Regenerate the token for the outgoing webhook.
  Regenerate the token for the outgoing webhook.
##### Permissions
`manage_webhooks` for system or `manage_webhooks` for the specific team or `manage_webhooks` for the channel."
  [hook-id ]
  (:data (hooks-outgoing-hook-id-regen-token-post-with-http-info hook-id)))

(defn hooks-outgoing-post-with-http-info
  "Create an outgoing webhook
  Create an outgoing webhook for a team.
##### Permissions
`manage_webhooks` for the team the webhook is in."
  ([] (hooks-outgoing-post-with-http-info nil))
  ([{:keys [inline-object-53 ]}]
   (call-api "/hooks/outgoing" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-53
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn hooks-outgoing-post
  "Create an outgoing webhook
  Create an outgoing webhook for a team.
##### Permissions
`manage_webhooks` for the team the webhook is in."
  ([] (hooks-outgoing-post nil))
  ([optional-params]
   (:data (hooks-outgoing-post-with-http-info optional-params))))

