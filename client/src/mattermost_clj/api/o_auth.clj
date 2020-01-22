(ns mattermost-clj.api.o-auth
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn oauth-apps-app-id-delete-with-http-info
  "Delete an OAuth app
  Delete and unregister an OAuth 2.0 client application 
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  [app-id ]
  (check-required-params app-id)
  (call-api "/oauth/apps/{app_id}" :delete
            {:path-params   {"app_id" app-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn oauth-apps-app-id-delete
  "Delete an OAuth app
  Delete and unregister an OAuth 2.0 client application 
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  [app-id ]
  (:data (oauth-apps-app-id-delete-with-http-info app-id)))

(defn oauth-apps-app-id-get-with-http-info
  "Get an OAuth app
  Get an OAuth 2.0 client application registered with Mattermost.
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  [app-id ]
  (check-required-params app-id)
  (call-api "/oauth/apps/{app_id}" :get
            {:path-params   {"app_id" app-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn oauth-apps-app-id-get
  "Get an OAuth app
  Get an OAuth 2.0 client application registered with Mattermost.
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  [app-id ]
  (:data (oauth-apps-app-id-get-with-http-info app-id)))

(defn oauth-apps-app-id-info-get-with-http-info
  "Get info on an OAuth app
  Get public information about an OAuth 2.0 client application registered with Mattermost. The application's client secret will be blanked out.
##### Permissions
Must be authenticated."
  [app-id ]
  (check-required-params app-id)
  (call-api "/oauth/apps/{app_id}/info" :get
            {:path-params   {"app_id" app-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn oauth-apps-app-id-info-get
  "Get info on an OAuth app
  Get public information about an OAuth 2.0 client application registered with Mattermost. The application's client secret will be blanked out.
##### Permissions
Must be authenticated."
  [app-id ]
  (:data (oauth-apps-app-id-info-get-with-http-info app-id)))

(defn oauth-apps-app-id-put-with-http-info
  "Update an OAuth app
  Update an OAuth 2.0 client application based on OAuth struct.
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  ([app-id ] (oauth-apps-app-id-put-with-http-info app-id nil))
  ([app-id {:keys [inline-object-61 ]}]
   (check-required-params app-id)
   (call-api "/oauth/apps/{app_id}" :put
             {:path-params   {"app_id" app-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-61
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn oauth-apps-app-id-put
  "Update an OAuth app
  Update an OAuth 2.0 client application based on OAuth struct.
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  ([app-id ] (oauth-apps-app-id-put app-id nil))
  ([app-id optional-params]
   (:data (oauth-apps-app-id-put-with-http-info app-id optional-params))))

(defn oauth-apps-app-id-regen-secret-post-with-http-info
  "Regenerate OAuth app secret
  Regenerate the client secret for an OAuth 2.0 client application registered with Mattermost.
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  [app-id ]
  (check-required-params app-id)
  (call-api "/oauth/apps/{app_id}/regen_secret" :post
            {:path-params   {"app_id" app-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn oauth-apps-app-id-regen-secret-post
  "Regenerate OAuth app secret
  Regenerate the client secret for an OAuth 2.0 client application registered with Mattermost.
##### Permissions
If app creator, must have `mange_oauth` permission otherwise `manage_system_wide_oauth` permission is required."
  [app-id ]
  (:data (oauth-apps-app-id-regen-secret-post-with-http-info app-id)))

(defn oauth-apps-get-with-http-info
  "Get OAuth apps
  Get a page of OAuth 2.0 client applications registered with Mattermost.
##### Permissions
With `manage_oauth` permission, the apps registered by the logged in user are returned. With `manage_system_wide_oauth` permission, all apps regardless of creator are returned."
  ([] (oauth-apps-get-with-http-info nil))
  ([{:keys [page per-page ]}]
   (call-api "/oauth/apps" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn oauth-apps-get
  "Get OAuth apps
  Get a page of OAuth 2.0 client applications registered with Mattermost.
##### Permissions
With `manage_oauth` permission, the apps registered by the logged in user are returned. With `manage_system_wide_oauth` permission, all apps regardless of creator are returned."
  ([] (oauth-apps-get nil))
  ([optional-params]
   (:data (oauth-apps-get-with-http-info optional-params))))

(defn oauth-apps-post-with-http-info
  "Register OAuth app
  Register an OAuth 2.0 client application with Mattermost as the service provider.
##### Permissions
Must have `manage_oauth` permission."
  ([] (oauth-apps-post-with-http-info nil))
  ([{:keys [inline-object-60 ]}]
   (call-api "/oauth/apps" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-60
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn oauth-apps-post
  "Register OAuth app
  Register an OAuth 2.0 client application with Mattermost as the service provider.
##### Permissions
Must have `manage_oauth` permission."
  ([] (oauth-apps-post nil))
  ([optional-params]
   (:data (oauth-apps-post-with-http-info optional-params))))

(defn users-user-id-oauth-apps-authorized-get-with-http-info
  "Get authorized OAuth apps
  Get a page of OAuth 2.0 client applications authorized to access a user's account.
##### Permissions
Must be authenticated as the user or have `edit_other_users` permission."
  ([user-id ] (users-user-id-oauth-apps-authorized-get-with-http-info user-id nil))
  ([user-id {:keys [page per-page ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/oauth/apps/authorized" :get
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-oauth-apps-authorized-get
  "Get authorized OAuth apps
  Get a page of OAuth 2.0 client applications authorized to access a user's account.
##### Permissions
Must be authenticated as the user or have `edit_other_users` permission."
  ([user-id ] (users-user-id-oauth-apps-authorized-get user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-oauth-apps-authorized-get-with-http-info user-id optional-params))))

