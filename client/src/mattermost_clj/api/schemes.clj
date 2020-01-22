(ns mattermost-clj.api.schemes
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn schemes-get-with-http-info
  "Get the schemes.
  Get a page of schemes. Use the query parameters to modify the behaviour of this endpoint.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  ([] (schemes-get-with-http-info nil))
  ([{:keys [scope page per-page ]}]
   (call-api "/schemes" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"scope" scope "page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn schemes-get
  "Get the schemes.
  Get a page of schemes. Use the query parameters to modify the behaviour of this endpoint.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  ([] (schemes-get nil))
  ([optional-params]
   (:data (schemes-get-with-http-info optional-params))))

(defn schemes-post-with-http-info
  "Create a scheme
  Create a new scheme.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  ([] (schemes-post-with-http-info nil))
  ([{:keys [inline-object-63 ]}]
   (call-api "/schemes" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-63
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn schemes-post
  "Create a scheme
  Create a new scheme.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  ([] (schemes-post nil))
  ([optional-params]
   (:data (schemes-post-with-http-info optional-params))))

(defn schemes-scheme-id-channels-get-with-http-info
  "Get a page of channels which use this scheme.
  Get a page of channels which use this scheme. The provided Scheme ID should be for a Channel-scoped Scheme.
Use the query parameters to modify the behaviour of this endpoint.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 5.0"
  ([scheme-id ] (schemes-scheme-id-channels-get-with-http-info scheme-id nil))
  ([scheme-id {:keys [page per-page ]}]
   (check-required-params scheme-id)
   (call-api "/schemes/{scheme_id}/channels" :get
             {:path-params   {"scheme_id" scheme-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn schemes-scheme-id-channels-get
  "Get a page of channels which use this scheme.
  Get a page of channels which use this scheme. The provided Scheme ID should be for a Channel-scoped Scheme.
Use the query parameters to modify the behaviour of this endpoint.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 5.0"
  ([scheme-id ] (schemes-scheme-id-channels-get scheme-id nil))
  ([scheme-id optional-params]
   (:data (schemes-scheme-id-channels-get-with-http-info scheme-id optional-params))))

(defn schemes-scheme-id-delete-with-http-info
  "Delete a scheme
  Soft deletes a scheme, by marking the scheme as deleted in the database.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  [scheme-id ]
  (check-required-params scheme-id)
  (call-api "/schemes/{scheme_id}" :delete
            {:path-params   {"scheme_id" scheme-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn schemes-scheme-id-delete
  "Delete a scheme
  Soft deletes a scheme, by marking the scheme as deleted in the database.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  [scheme-id ]
  (:data (schemes-scheme-id-delete-with-http-info scheme-id)))

(defn schemes-scheme-id-get-with-http-info
  "Get a scheme
  Get a scheme from the provided scheme id.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  [scheme-id ]
  (check-required-params scheme-id)
  (call-api "/schemes/{scheme_id}" :get
            {:path-params   {"scheme_id" scheme-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn schemes-scheme-id-get
  "Get a scheme
  Get a scheme from the provided scheme id.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  [scheme-id ]
  (:data (schemes-scheme-id-get-with-http-info scheme-id)))

(defn schemes-scheme-id-patch-put-with-http-info
  "Patch a scheme
  Partially update a scheme by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 5.0"
  ([scheme-id ] (schemes-scheme-id-patch-put-with-http-info scheme-id nil))
  ([scheme-id {:keys [inline-object-64 ]}]
   (check-required-params scheme-id)
   (call-api "/schemes/{scheme_id}/patch" :put
             {:path-params   {"scheme_id" scheme-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-64
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn schemes-scheme-id-patch-put
  "Patch a scheme
  Partially update a scheme by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 5.0"
  ([scheme-id ] (schemes-scheme-id-patch-put scheme-id nil))
  ([scheme-id optional-params]
   (:data (schemes-scheme-id-patch-put-with-http-info scheme-id optional-params))))

(defn schemes-scheme-id-teams-get-with-http-info
  "Get a page of teams which use this scheme.
  Get a page of teams which use this scheme. The provided Scheme ID should be for a Team-scoped Scheme.
Use the query parameters to modify the behaviour of this endpoint.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 5.0"
  ([scheme-id ] (schemes-scheme-id-teams-get-with-http-info scheme-id nil))
  ([scheme-id {:keys [page per-page ]}]
   (check-required-params scheme-id)
   (call-api "/schemes/{scheme_id}/teams" :get
             {:path-params   {"scheme_id" scheme-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn schemes-scheme-id-teams-get
  "Get a page of teams which use this scheme.
  Get a page of teams which use this scheme. The provided Scheme ID should be for a Team-scoped Scheme.
Use the query parameters to modify the behaviour of this endpoint.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 5.0"
  ([scheme-id ] (schemes-scheme-id-teams-get scheme-id nil))
  ([scheme-id optional-params]
   (:data (schemes-scheme-id-teams-get-with-http-info scheme-id optional-params))))

