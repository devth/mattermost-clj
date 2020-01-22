(ns mattermost-clj.api.system
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn analytics-old-get-with-http-info
  "Get analytics
  Get some analytics data about the system. This endpoint uses the old format, the `/analytics` route is reserved for the new format when it gets implemented.

The returned JSON changes based on the `name` query parameter but is always key/value pairs.

__Minimum server version__: 4.0

##### Permissions
Must have `manage_system` permission."
  ([] (analytics-old-get-with-http-info nil))
  ([{:keys [name team-id ]}]
   (call-api "/analytics/old" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"name" name "team_id" team-id }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn analytics-old-get
  "Get analytics
  Get some analytics data about the system. This endpoint uses the old format, the `/analytics` route is reserved for the new format when it gets implemented.

The returned JSON changes based on the `name` query parameter but is always key/value pairs.

__Minimum server version__: 4.0

##### Permissions
Must have `manage_system` permission."
  ([] (analytics-old-get nil))
  ([optional-params]
   (:data (analytics-old-get-with-http-info optional-params))))

(defn audits-get-with-http-info
  "Get audits
  Get a page of audits for all users on the system, selected with `page` and `per_page` query parameters.
##### Permissions
Must have `manage_system` permission."
  ([] (audits-get-with-http-info nil))
  ([{:keys [page per-page ]}]
   (call-api "/audits" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn audits-get
  "Get audits
  Get a page of audits for all users on the system, selected with `page` and `per_page` query parameters.
##### Permissions
Must have `manage_system` permission."
  ([] (audits-get nil))
  ([optional-params]
   (:data (audits-get-with-http-info optional-params))))

(defn caches-invalidate-post-with-http-info
  "Invalidate all the caches
  Purge all the in-memory caches for the Mattermost server. This can have a temporary negative effect on performance while the caches are re-populated.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/caches/invalidate" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn caches-invalidate-post
  "Invalidate all the caches
  Purge all the in-memory caches for the Mattermost server. This can have a temporary negative effect on performance while the caches are re-populated.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (caches-invalidate-post-with-http-info)))

(defn config-client-get-with-http-info
  "Get client configuration
  Get a subset of the server configuration needed by the client.
##### Permissions
No permission required."
  [format ]
  (check-required-params format)
  (call-api "/config/client" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"format" format }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn config-client-get
  "Get client configuration
  Get a subset of the server configuration needed by the client.
##### Permissions
No permission required."
  [format ]
  (:data (config-client-get-with-http-info format)))

(defn config-environment-get-with-http-info
  "Get configuration made through environment variables
  Retrieve a json object mirroring the server configuration where fields are set to true
if the corresponding config setting is set through an environment variable. Settings
that haven't been set through environment variables will be missing from the object.

__Minimum server version__: 4.10

##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/config/environment" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn config-environment-get
  "Get configuration made through environment variables
  Retrieve a json object mirroring the server configuration where fields are set to true
if the corresponding config setting is set through an environment variable. Settings
that haven't been set through environment variables will be missing from the object.

__Minimum server version__: 4.10

##### Permissions
Must have `manage_system` permission."
  []
  (:data (config-environment-get-with-http-info)))

(defn config-get-with-http-info
  "Get configuration
  Retrieve the current server configuration
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/config" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn config-get
  "Get configuration
  Retrieve the current server configuration
##### Permissions
Must have `manage_system` permission."
  []
  (:data (config-get-with-http-info)))

(defn config-put-with-http-info
  "Update configuration
  Submit a new configuration for the server to use. As of server version 4.8, the `PluginSettings.EnableUploads` setting cannot be modified by this endpoint.
##### Permissions
Must have `manage_system` permission."
  [config ]
  (check-required-params config)
  (call-api "/config" :put
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    config
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn config-put
  "Update configuration
  Submit a new configuration for the server to use. As of server version 4.8, the `PluginSettings.EnableUploads` setting cannot be modified by this endpoint.
##### Permissions
Must have `manage_system` permission."
  [config ]
  (:data (config-put-with-http-info config)))

(defn config-reload-post-with-http-info
  "Reload configuration
  Reload the configuration file to pick up on any changes made to it.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/config/reload" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn config-reload-post
  "Reload configuration
  Reload the configuration file to pick up on any changes made to it.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (config-reload-post-with-http-info)))

(defn database-recycle-post-with-http-info
  "Recycle database connections
  Recycle database connections by closing and reconnecting all connections to master and read replica databases.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/database/recycle" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn database-recycle-post
  "Recycle database connections
  Recycle database connections by closing and reconnecting all connections to master and read replica databases.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (database-recycle-post-with-http-info)))

(defn email-test-post-with-http-info
  "Send a test email
  Send a test email to make sure you have your email settings configured correctly. Optionally provide a configuration in the request body to test. If no valid configuration is present in the request body the current server configuration will be tested.
##### Permissions
Must have `manage_system` permission."
  [config ]
  (check-required-params config)
  (call-api "/email/test" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    config
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn email-test-post
  "Send a test email
  Send a test email to make sure you have your email settings configured correctly. Optionally provide a configuration in the request body to test. If no valid configuration is present in the request body the current server configuration will be tested.
##### Permissions
Must have `manage_system` permission."
  [config ]
  (:data (email-test-post-with-http-info config)))

(defn file-s3-test-post-with-http-info
  "Test AWS S3 connection
  Send a test to validate if can connect to AWS S3. Optionally provide a configuration in the request body to test. If no valid configuration is present in the request body the current server configuration will be tested.
##### Permissions
Must have `manage_system` permission.
__Minimum server version__: 4.8"
  [config ]
  (check-required-params config)
  (call-api "/file/s3_test" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    config
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn file-s3-test-post
  "Test AWS S3 connection
  Send a test to validate if can connect to AWS S3. Optionally provide a configuration in the request body to test. If no valid configuration is present in the request body the current server configuration will be tested.
##### Permissions
Must have `manage_system` permission.
__Minimum server version__: 4.8"
  [config ]
  (:data (file-s3-test-post-with-http-info config)))

(defn license-client-get-with-http-info
  "Get client license
  Get a subset of the server license needed by the client.
##### Permissions
No permission required but having the `manage_system` permission returns more information."
  [format ]
  (check-required-params format)
  (call-api "/license/client" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"format" format }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn license-client-get
  "Get client license
  Get a subset of the server license needed by the client.
##### Permissions
No permission required but having the `manage_system` permission returns more information."
  [format ]
  (:data (license-client-get-with-http-info format)))

(defn license-delete-with-http-info
  "Remove license file
  Remove the license file from the server. This will disable all enterprise features.

__Minimum server version__: 4.0

##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/license" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn license-delete
  "Remove license file
  Remove the license file from the server. This will disable all enterprise features.

__Minimum server version__: 4.0

##### Permissions
Must have `manage_system` permission."
  []
  (:data (license-delete-with-http-info)))

(defn license-post-with-http-info
  "Upload license file
  Upload a license to enable enterprise features.

__Minimum server version__: 4.0

##### Permissions
Must have `manage_system` permission."
  [^File license ]
  (check-required-params license)
  (call-api "/license" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"license" license }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn license-post
  "Upload license file
  Upload a license to enable enterprise features.

__Minimum server version__: 4.0

##### Permissions
Must have `manage_system` permission."
  [^File license ]
  (:data (license-post-with-http-info license)))

(defn logs-get-with-http-info
  "Get logs
  Get a page of server logs, selected with `page` and `logs_per_page` query parameters.
##### Permissions
Must have `manage_system` permission."
  ([] (logs-get-with-http-info nil))
  ([{:keys [page logs-per-page ]}]
   (call-api "/logs" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "logs_per_page" logs-per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn logs-get
  "Get logs
  Get a page of server logs, selected with `page` and `logs_per_page` query parameters.
##### Permissions
Must have `manage_system` permission."
  ([] (logs-get nil))
  ([optional-params]
   (:data (logs-get-with-http-info optional-params))))

(defn logs-post-with-http-info
  "Add log message
  Add log messages to the server logs.
##### Permissions
Users with `manage_system` permission can log ERROR or DEBUG messages.
Logged in users can log ERROR or DEBUG messages when `ServiceSettings.EnableDeveloper` is `true` or just DEBUG messages when `false`.
Non-logged in users can log ERROR or DEBUG messages when `ServiceSettings.EnableDeveloper` is `true` and cannot log when `false`."
  ([] (logs-post-with-http-info nil))
  ([{:keys [inline-object-49 ]}]
   (call-api "/logs" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-49
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn logs-post
  "Add log message
  Add log messages to the server logs.
##### Permissions
Users with `manage_system` permission can log ERROR or DEBUG messages.
Logged in users can log ERROR or DEBUG messages when `ServiceSettings.EnableDeveloper` is `true` or just DEBUG messages when `false`.
Non-logged in users can log ERROR or DEBUG messages when `ServiceSettings.EnableDeveloper` is `true` and cannot log when `false`."
  ([] (logs-post nil))
  ([optional-params]
   (:data (logs-post-with-http-info optional-params))))

(defn site-url-test-post-with-http-info
  "Checks the validity of a Site URL
  Sends a Ping request to the mattermost server using the specified Site URL.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.16"
  ([] (site-url-test-post-with-http-info nil))
  ([{:keys [inline-object-48 ]}]
   (call-api "/site_url/test" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-48
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn site-url-test-post
  "Checks the validity of a Site URL
  Sends a Ping request to the mattermost server using the specified Site URL.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.16"
  ([] (site-url-test-post nil))
  ([optional-params]
   (:data (site-url-test-post-with-http-info optional-params))))

(defn system-ping-get-with-http-info
  "Check system health
  Check if the server is up and healthy based on the configuration setting `GoRoutineHealthThreshold`. If `GoRoutineHealthThreshold` and the number of goroutines on the server exceeds that threshold the server is considered unhealthy. If `GoRoutineHealthThreshold` is not set or the number of goroutines is below the threshold the server is considered healthy.
__Minimum server version__: 3.10
##### Permissions
Must be logged in."
  []
  (call-api "/system/ping" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn system-ping-get
  "Check system health
  Check if the server is up and healthy based on the configuration setting `GoRoutineHealthThreshold`. If `GoRoutineHealthThreshold` and the number of goroutines on the server exceeds that threshold the server is considered unhealthy. If `GoRoutineHealthThreshold` is not set or the number of goroutines is below the threshold the server is considered healthy.
__Minimum server version__: 3.10
##### Permissions
Must be logged in."
  []
  (:data (system-ping-get-with-http-info)))

